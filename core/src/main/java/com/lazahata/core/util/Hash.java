package com.lazahata.core.util;

import androidx.annotation.NonNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by dalizhang on 26/10/2016.
 * E-mail: dalizhang@foxmail.com
 */

public class Hash {

    public static String md5(@NonNull byte[] input) {
        String strDes ;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(input);
            strDes = bytes2Hex(md5.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    private static String bytes2Hex(@NonNull byte[] input) {

        StringBuilder sb = new StringBuilder();
        for (byte b : input) {
            if (b >= 0 && b < 16) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(b & 0xFF));
        }
        return sb.toString();
    }
}
