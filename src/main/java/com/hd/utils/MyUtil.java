package com.hd.utils;

import org.junit.Test;

import java.security.MessageDigest;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 赵传昊 on 2018/7/23.
 */
public class MyUtil {

    public static String DateToString(Date date){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String string = formatter.format(date);
        return string;
    }

    public static Date StringToDate(String string){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        ParsePosition pos = new ParsePosition(0);
        Date date = formatter.parse(string, pos);
        System.out.println(date);
        return date;
    }

    /*public static String md5ForPassword(){

        MessageDigest md;
            try {
            md = MessageDigest.getInstance("MD5");//利用哈希算法，MD5
            //面向字节处理，所以可以处理字节的东西，如图片，压缩包。。
            byte[] input = password.getBytes();
            byte[] output = md.digest(input);
            //将md5处理后的output结果利用Base64转成原有的字符串,不会乱码
            String str = Base64.encodeBase64String(output);
    //			String str = new String(output); //原有转换
            return str;
        } catch (Exception e) {
            System.out.println("密码加密失败");
            return "";
        }

    }*/

}
