package com.iza.common.vo;

import lombok.Data;

/**
 * @program: Kataba
 * @description: 统一结果返回 整个系统的 接口的统一返回格式
 * @author: Feri(邢朋辉)
 * @create: 2020-10-19 15:52
 */
@Data
public class R<T> {
    private int code;//返回码
    private String msg;//返回码的字符串信息
    private T data;//返回的数据

    public static <T> R setR(int c,String m,T obj){
        R r=new R();
        r.setCode(c);
        r.setData(obj);
        r.setMsg(m);
        return r;
    }
    //成功
    public static R ok(){
        return setR(1,"OK",null);
    }
    //成功
    public static <T> R ok(T t){
        return setR(1,"OK",t);
    }
    //失败
    public static R fail(){
        return setR(2,"Fail",null);
    }
    public static R fail(String msg){
        return setR(2,msg,null);
    }
}