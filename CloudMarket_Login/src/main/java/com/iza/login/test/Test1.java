package com.iza.login.test;

import com.iza.login.util.EncryptUtil;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/5 20:43
 * description:
 */
public class Test1 {
    public static void main(String[] args) {
        String a = EncryptUtil.sha(EncryptUtil.SHA256, "111");
        System.out.println("a = " + a);
    }
}
