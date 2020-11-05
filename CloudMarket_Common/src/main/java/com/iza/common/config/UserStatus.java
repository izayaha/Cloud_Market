package com.iza.common.config;

public enum UserStatus {
    已登录(1),锁定(2),已解锁(3);
    private int val;
    private   UserStatus(int v){
        val = v;
    }
    public int getVal(){
        return val;
    }
}
