package com.example.comichub.model.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Utils {

    private static final String TS = "2";
    private static final String API_KEY = "9df320194bf2effa82fb84d481e50adb";
    private static final String PRIVATE_KEY = "59f0c1babc231e3885d365bd4976d5b018a3abb1";

    public static String getMd5(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            StringBuilder hashText = new StringBuilder(no.toString(16));

            while (hashText.length() < 32) {
                hashText.insert(0, "0");
            }

            return hashText.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, String> getQueryParam() {
        Map<String, String> options = new HashMap<>();
        String params = TS + PRIVATE_KEY + API_KEY;
        String hash = getMd5(params);
        options.put("ts", TS);
        options.put("apikey", API_KEY);
        options.put("hash", hash);

        return options;
    }
}
