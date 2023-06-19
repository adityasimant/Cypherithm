package com.example.cypherinth;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AESUtils {

    private static final String AES_ALGORITHM = "AES";

    // Encrypts the input text using AES
    public static String encrypt(Context context, String input, String key) throws Exception {
        SecretKeySpec secretKey = generateKey(key);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }
        Toast.makeText(context, "Build.VERSION.SDK_INT >= Build.VERSION_CODES", Toast.LENGTH_SHORT).show();
        return null;
    }

    // Decrypts the AES encrypted text and returns the original input
    public static String decrypt(Context context, String encryptedText, String key) throws Exception {
        SecretKeySpec secretKey = generateKey(key);
        Cipher cipher = Cipher.getInstance(AES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = new byte[0];
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encryptedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        }

        Toast.makeText(context, "Build.VERSION.SDK_INT >= Build.VERSION_CODES", Toast.LENGTH_SHORT).show();
        return null;
    }

    private static SecretKeySpec generateKey(String key) throws Exception {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(keyBytes, AES_ALGORITHM);
    }

}
