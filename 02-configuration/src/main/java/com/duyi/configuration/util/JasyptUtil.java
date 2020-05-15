package com.duyi.configuration.util;

import org.jasypt.util.text.BasicTextEncryptor;

public class JasyptUtil {
    public static void main(String[] args) {
        String str = new String("");

        // 获取加密器
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        encryptor.setPassword("salt");// 设置盐
        String username = "root";
        String password = "rootroot";
        System.out.println(encryptor.encrypt(username));
        System.out.println(encryptor.encrypt(password));
        // 每次执行的都不一样
        // Pj+AT7xPLs62xXDOWiWZkA==
        // do729amqnqfNlNU43jikJg==

        // A93Kd6mwh11ihh57n8msMA==
        // FAQ8/+7g+KLwod0XxKcN9A==

        // 但是不同的密文却可以还原为同一个正确的明文
        System.out.println(encryptor.decrypt("F3CoSa8E9CPj0CGI1R+PfQ=="));
        System.out.println(encryptor.decrypt("lnbscDwJCU8SODKtPS91O+VZDBpHYsW6"));
    }
}
