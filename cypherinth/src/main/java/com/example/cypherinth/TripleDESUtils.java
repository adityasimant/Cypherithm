package com.example.cypherinth;
import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

public class TripleDESUtils {

    private static final String TRIPLE_DES_ALGORITHM = "DESede";

    // Encrypts the input text using Triple DES and a provided key
    public static String encrypt(Context context, String input, String key) throws Exception {
        SecretKey secretKey = generateKey(key);
        Cipher cipher = Cipher.getInstance(TRIPLE_DES_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }
        Toast.makeText(context, "Build.VERSION.SDK_INT too low ", Toast.LENGTH_SHORT).show();
        return null;
    }

    // Decrypts the Triple DES encrypted text using a provided key and returns the original input
    public static String decrypt(Context context, String encryptedText, String key) throws Exception {
        SecretKey secretKey = generateKey(key);
        Cipher cipher = Cipher.getInstance(TRIPLE_DES_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = new byte[0];
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encryptedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        }
        Toast.makeText(context, "android.os.Build.VERSION.SDK_INT is low for this function", Toast.LENGTH_SHORT).show();
        return null;

    }

    private static SecretKey generateKey(String key) throws Exception {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        KeySpec keySpec = new DESedeKeySpec(keyBytes);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(TRIPLE_DES_ALGORITHM);
        return keyFactory.generateSecret(keySpec);
    }
}

