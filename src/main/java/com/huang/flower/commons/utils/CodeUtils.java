package com.huang.flower.commons.utils;

public class CodeUtils {


    /**
     * 返回一个随机数
     * @return
     */
    public static  String getOnlyCode(){
        String random=(int)((Math.random()*9+1)*100000)+"";
        System.out.println("创建的验证码为："+random);
        return random;
    }
}
