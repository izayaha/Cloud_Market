package com.iza.pay.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/7 16:04
 * description:
 */
public class QrcodeUtil {
    public static void createQrcode(String msg, int size, OutputStream os){
        //1.初始化参数
        Map<EncodeHintType, Object> map = new LinkedHashMap<>();
        map.put(EncodeHintType.CHARACTER_SET,"UTF-8");  //编码格式
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); //容错率
        map.put(EncodeHintType.MARGIN,1); //设置外边距
        //2.构建位图
        /**
         * 1.二维码的 内容
         * 2.格式 ： 二维码
         * 3.宽
         * 4.高
         * 5.参数  设置
         */

        try {
            BitMatrix bitMatrix = new MultiFormatWriter().encode(msg, BarcodeFormat.QR_CODE,size,size,map);
            //设置颜色
            MatrixToImageConfig config = new MatrixToImageConfig(0xFF000000,0xFFFFFFFF);
            MatrixToImageWriter.writeToStream(bitMatrix,"png",os,config);
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
