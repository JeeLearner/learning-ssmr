package com.ssmr.chapter04.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

public class CodeUtils {

    public static String encode(String src) {
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(src.getBytes());
    }

    public static String decode(String des) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            return new String(decoder.decodeBuffer(des));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String target = encode("root");

        System.out.println("root加密后：" + target);
    }
}
