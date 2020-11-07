package com.iza.pay.wxpay;

import com.iza.pay.util.HttpUtil;
import com.iza.pay.util.MD5Util;
import com.iza.pay.util.XmlUtil;

import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/7 16:32
 * description:
 */
public class WxPayUtil {

    public static String APP_ID = "wx632c8f211f8122c6";
    public static String MCH_ID = "1497984412";
    public static String API_KEY = "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnC";

    //支付的url地址
    public static final String WX_PAY="https://api.mch.weixin.qq.com/pay/unifiedorder";
    public static final String WX_QUERY="https://api.mch.weixin.qq.com/pay/orderquery";
    public static final String WX_CANCEL="https://api.mch.weixin.qq.com/pay/closeorder";
    //CV

    //签名算法 https://pay.weixin.qq.com/wiki/doc/api/native.php?chapter=4_3
    public static String createSign(TreeMap<String,Object> map){
        //1.排序
        //2.拼接键值对
        StringBuffer buffer = new StringBuffer();
        for (String k : map.keySet()) {
            buffer.append(k+"="+map.get(k)+"&");
        }
        //3.拼接上  密钥
        buffer.append("key="+API_KEY);
        //4、摘要  5.转换为大写
        return MD5Util.MD5Encode(buffer.toString(),"UTF-8").toUpperCase();

    }
    //生成预支付链接
    public static String createWxPay(String oid,int money,String title){
        //排序  ，Map可排序 key的底层  红黑二叉树
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("appid",APP_ID);
        map.put("mch_id",MCH_ID);
        map.put("nonce_str", UUID.randomUUID().toString().replaceAll("-",""));
        map.put("body",title);
        map.put("out_trade_no",oid);
        map.put("total_fee",money);
        map.put("trade_type","NATIVE");
        map.put("notity_url","http://127.0.0.1");
        map.put("spbill_create_ip","127.0.0.1");
        String s =createSign(map);
        //sign
        map.put("sign",s);
        //转换xml
        String  xml = XmlUtil.createXml(map);
        System.out.println(xml);
        //发起请求
        String resXml = HttpUtil.post(WX_PAY,xml,HttpUtil.TYPE_XML);
        System.out.println(resXml);
        if (resXml!=null&&resXml.length()>0) {
            Map<String ,Object> resMap = XmlUtil.parseXml(resXml);
            return resMap.get("code_url").toString();
         }
        return null;
    }


    //查询支付状态
    //生成预支付链接
    /**
     * SUCCESS—支付成功
     *
     * REFUND—转入退款
     *
     * NOTPAY—未支付
     *
     * CLOSED—已关闭
     *
     * REVOKED—已撤销（付款码支付）
     *
     * USERPAYING--用户支付中（付款码支付）
     *
     * PAYERROR--支付失败(其他原因，如银行返回失败)*/

    public static String qureyWxPay(String oid){
        //排序  ，Map可排序  Key的底层 红黑二叉树
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("appid",APP_ID);
        map.put("mch_id",MCH_ID);
        map.put("nonce_str",UUID.randomUUID().toString().replaceAll("-",""));
        map.put("out_trade_no",oid);
        map.put("sign",createSign(map));
        //转换xml
        String xml = XmlUtil.createXml(map);
        //发起请求
        String resXml = HttpUtil.post(WX_QUERY,xml,HttpUtil.TYPE_XML);
        if (resXml!=null && resXml.length()>0) {
            Map<String ,Object> resMap = XmlUtil.parseXml(resXml);
            return resMap.get("trade_state").toString();
        }
        return null;
    }

    //取消支付
    public static  String qcancelWxPay(String oid){
        //排序 ，Map 可排序 Key的底层 红黑二叉树
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("appid",APP_ID);
        map.put("mch_id",MCH_ID);
        map.put("nonce_str",UUID.randomUUID().toString().replaceAll("-",""));
        map.put("out_trade_no",oid);
        //sign
        map.put("sign",createSign(map));
        //转换xml
        String xml= XmlUtil.createXml(map);
        //发起请求
        String resXml = HttpUtil.post(WX_CANCEL,xml,HttpUtil.TYPE_XML);
        if (resXml!=null&& resXml.length()>0) {
            Map<String ,Object> resMap = XmlUtil.parseXml(resXml);
            return resMap.get("result_code").toString();
        }
        return null;
    }





}
