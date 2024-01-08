package com.patech.utils;

/**
 * Created by pagrawal on 02-02-2018.
 */

public class AppUtils {
    private static final String HTML = ".HTML";

    public static String getSharableText(String shareTxt, String packageName) {
        return shareTxt + packageName;
    }
    public static boolean isEmpty(String text) {
        if (text == null || text.isEmpty() || text.trim().isEmpty())
            return true;
        return false;
    }

    public static String cleanup(String txt) {
        if (AppUtils.isEmpty(txt))
            return txt;
        txt = txt.trim();

        int lastIdx = txt.toUpperCase().lastIndexOf(HTML);
        if (lastIdx >= 0) {
            txt = txt.substring(0, lastIdx);
        }
        int spaceIdx = txt.indexOf(" ");
        if (spaceIdx >= 0) {
            txt = txt.substring(spaceIdx+1, txt.length());
        }
        return txt;
    }
    public static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = bytes.length - 1; i >= 0; --i) {
            int b = bytes[i] & 0xff;
            if (b < 0x10)
                sb.append('0');
            sb.append(Integer.toHexString(b));
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String toReversedHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; ++i) {
            if (i > 0) {
                sb.append(" ");
            }
            int b = bytes[i] & 0xff;
            if (b < 0x10)
                sb.append('0');
            sb.append(Integer.toHexString(b));
        }
        return sb.toString();
    }

    public static long toDec(byte[] bytes) {
        long result = 0;
        long factor = 1;
        for (int i = 0; i < bytes.length; ++i) {
            long value = bytes[i] & 0xffl;
            result += value * factor;
            factor *= 256l;
        }
        return result;
    }

    public static long toReversedDec(byte[] bytes) {
        long result = 0;
        long factor = 1;
        for (int i = bytes.length - 1; i >= 0; --i) {
            long value = bytes[i] & 0xffl;
            result += value * factor;
            factor *= 256l;
        }
        return result;
    }

    // Ad starts
    public static final String KEY_ADMOB_USER_ID = "nfc_app_userid";
    public static final String KEY_ADMOB_BANNER_ID = "nfc_app_bannerid";

    // Ad ends
    public static String PATH = "FILE_PATH";
}
