package com.zyj.chess.ai.tool;

import org.springframework.stereotype.Component;

/**
 * 快速混淆编解码
 */
@Component
public final class Codec {
    public static String complex(String str, int offset) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; ++i) {
            chars[i] = (char) (((-chars[i] & 0xffff) + ((offset + i) % 0x20)) & 0xffff);
        }
        return new String(chars, 0, len);
    }

    public static byte[] simple(byte[] bytes, int offset) {
        for (int i = 0; i < bytes.length; ++i) {
            bytes[i] = (byte) ((-bytes[i] & 0xff) + ((offset + i) % 0x10) & 0xff);
        }
        return bytes;
    }
}