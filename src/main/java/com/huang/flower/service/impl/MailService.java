package com.huang.flower.service.impl;

import com.huang.flower.entity.Flower;
import com.huang.flower.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import java.util.Arrays;
import java.util.List;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserService userService;

    public void sendMail(String patname, String docname, String mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("医院系统预约提醒");
        message.setText("尊敬的" + docname + "医生," + patname + "已预约您，请登录系统查看具体信息");
        message.setFrom("1154458742@qq.com");
        message.setTo(mail);
        mailSender.send(message);
    }

    public void changePwdSuccess(String username, String mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("医院系统预约提醒");
        message.setText("尊敬的" + username + "医生,您修改密码成功！如果不是您本人操作，请及时修改密码");
        message.setFrom("1154458742@qq.com");
        message.setTo(mail);
        mailSender.send(message);
        System.out.println("我是普通发邮件在发邮件");
    }

    public void userLoginMail(String username, String mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("蜜语花店登录提醒");
        message.setText("尊敬的" + username + "您好！您已成功登录蜜语花店，小蜜感谢您的选择和信任！");
        message.setFrom("1154458742@qq.com");
        message.setTo(mail);
        mailSender.send(message);
    }

    public void adminLoginMail(String username, String mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("蜜语花店后台登录提醒");
        message.setText("尊敬的" + username + "花店管理员您好！您已成功登录蜜语花店后台，如果不是您本人操作，请及时修改密码！");
        message.setFrom("1154458742@qq.com");
        message.setTo(mail);
        mailSender.send(message);
    }

    public void FlowerLess(String[] mails, String[] flowers) {
        String allflower = Arrays.toString(flowers);
        for (String mail : mails) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("1154458742@qq.com");
            message.setTo(mail);
            message.setSubject("蜜语花店花蕊库存不足提醒");
            message.setText("尊敬的花店管理员您好！" + allflower + "不够了");
            new Thread(() -> mailSender.send(message)).start();
        }

    }


    public void refreshFlower(String name, double price, String remark) {
        String[] mails = userService.getUserEmails();

        for (String mail : mails) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("1154458742@qq.com");
            message.setSubject("蜜语花店花蕊上新提醒");
            message.setText("亲爱的的蜜语用户您好！" + name + "上新了，价格" + price + "花语：" + remark);
            message.setTo(mail);
            new Thread(() -> mailSender.send(message)).start();
        }
    }


    //发送验证码
    public void sendCode(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("1154458742@qq.com");
        message.setSubject("蜜语花店验证码提醒");
        message.setText("亲爱的的蜜语用户您好！您的登录验证码是" +code +"请勿泄露给他人！");
        message.setTo(email);
        mailSender.send(message);
    }


}

