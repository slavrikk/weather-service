package ru.weather.util;

import org.apache.tomcat.util.codec.binary.Base64;

public class Decoder {

    public static String decodeKey(String pass) {
        byte[] decodedBytes = Base64.decodeBase64(pass);
        return new String(decodedBytes);
    }
}
