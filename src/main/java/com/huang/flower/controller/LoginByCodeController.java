package com.huang.flower.controller;


import com.huang.flower.commons.utils.CodeUtils;
import com.huang.flower.commons.utils.CookieUtils;
import com.huang.flower.commons.utils.JedisUtil;
import com.huang.flower.entity.Admin;
import com.huang.flower.entity.User;
import com.huang.flower.service.UserService;
import com.huang.flower.service.impl.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;
import redis.clients.jedis.Jedis;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Controller
public class LoginByCodeController {
    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    private MailService mailService;
    @Autowired
    private UserService userService;

    private static Logger logger = LoggerFactory.getLogger(BouquetController.class);

    private static int captchaExpires =  15*60; //超时时间5min

    private static String CODEKEY = "flower:code:";


    private final static int TIME_LIMIT = 60*15;                    //一个周期，这里为了测试方便，我将周期设置的比较小
    private static Jedis jedis;
    private static int next = 0;                                //为了避免key相互覆盖，我们加上一个自增后缀，使得key不会一样
    private final static int MOST_TIMES_IN_TIME_LIMIT = 8;        //一个周期内最多的操作次数
    private final static String SEPERATOR = "~~";                //为了为了避免next后缀和原来的key互相影响，加上一个分隔字符串

    static {
        jedis = new Jedis("101.201.233.210", 6379);
        //设置密码
        jedis.auth("h123456");
        logger.info("连接成功");
        //查看服务是否运行
        logger.info("服务正在运行: " + jedis.ping());
    }


    private boolean simpleValidation(String test) {
        return test != null && test.length() > 5;
    }

    private String getCurTimeAsStr() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }


    @ResponseBody
    @GetMapping("/login/sendCode")
    public Boolean sendCode(String email) {
        if (!simpleValidation(email)) return false;        //进行一下简单的格式拦截
        System.out.println(getCurTimeAsStr());                    //当前操作时间

        Set<String> keys = jedis.keys(CODEKEY + email + ":times" + "*");            //为了搜索出当前操作用户的周期内(也就是没有过期的)记录
        if (keys != null && keys.size() >= MOST_TIMES_IN_TIME_LIMIT) {
            //周期内的操作次数为容许次数
            logger.info(TIME_LIMIT + " 秒内只能操作" + MOST_TIMES_IN_TIME_LIMIT + " 次");
            return false;
        }

        /**
         * 生成一个包含有操作用户标识的唯一key
         * 每次操作的next都会自增1，防止key相同
         */
        String strengthenStr = CODEKEY + email + ":times:" + (next++);
        jedis.setex(strengthenStr, TIME_LIMIT, email);            //给key设置过期时间
        logger.info(strengthenStr + "   操作成功");
        String onlyCode = CodeUtils.getOnlyCode();

        try {
            //将验证码通过邮箱发送给用户
            new Thread(() -> mailService.sendCode(email, onlyCode)).start();
            //将验证码以<key,value>形式缓存到redis

        } catch (Exception e) {
            e.printStackTrace();
        }

        redisTemplate.opsForValue().set(CODEKEY + email, onlyCode, captchaExpires, TimeUnit.SECONDS);
        return true;
    }


    @PostMapping("/user/login/byEmail")
    public String login(@PathParam("email")String email, @PathParam("code") String code,
                        HttpSession session,
                        Map<String, Object> map) throws Exception {

        String onlyCode = null;
        try {
            onlyCode = (String) redisTemplate.opsForValue().get(CODEKEY + email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = null;
        try {
            user = userService.getUserByEmail(email);
        }catch (Exception e){
            map.put("msg","该邮箱还未注册");
            return "loginByCode";
        }
        if (onlyCode.equals(code)) {  //验证码正确
            //删除验证码
            redisTemplate.delete(CODEKEY + email);
        }else{  //输入的验证码错误
            map.put("msg","验证码错误，请重新输入");
            return "loginByCode";
        }

        if (user != null) {
            String username = user.getUsername();
            session.setAttribute("username", username);
            session.setAttribute("user_id", user.getId());
            map.put("username", username);
            map.put("usertype", "user");
            map.put("msg", "登录成功");
            //用户登录成功，发送邮件提示
            new Thread(() -> mailService.userLoginMail(username, email)).start();
            return "redirect:/";
        } else {
            return "loginByCode";
        }
    }

}
