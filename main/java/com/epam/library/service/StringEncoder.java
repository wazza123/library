package com.epam.library.service;


import org.apache.commons.codec.digest.DigestUtils;

public class StringEncoder {

    public static String encodeString(String str) {

        String shaHexString = DigestUtils.shaHex(str);

        return shaHexString;
    }
}
