package com.sweetzpot.tcxzpot.builders;

public class StringUtil {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().equalsIgnoreCase("");
    }
}
