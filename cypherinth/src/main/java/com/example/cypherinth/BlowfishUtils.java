package com.example.cypherinth;

import android.content.Context;
import android.os.Build;
import android.widget.Toast;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;
import java.util.Base64;



public class BlowfishUtils {

    private static final String BLOWFISH_ALGORITHM = "PBEWithMD5AndDES";
    private static final int ITERATIONS = 1000; // Number of iterations for key generation

    // Encrypts the input text using Blowfish with the provided password
    public static String encrypt(Context context, String input, String password) throws Exception {
        SecretKey secretKey = generateKey(password);
        Cipher cipher = Cipher.getInstance(BLOWFISH_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Base64.getEncoder().encodeToString(encryptedBytes);
        }
        Toast.makeText(context, "Build version is low to use this operation", Toast.LENGTH_SHORT).show();
        return null;
    }

    // Decrypts the Blowfish encrypted text using the provided password and returns the original input
    public static String decrypt(Context context, String encryptedText, String password) throws Exception {
        SecretKey secretKey = generateKey(password);
        Cipher cipher = Cipher.getInstance(BLOWFISH_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = new byte[0];
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encryptedBytes = Base64.getDecoder().decode(encryptedText);
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
            return new String(decryptedBytes, StandardCharsets.UTF_8);
        }
        Toast.makeText(context, "Build version is low to use this operation", Toast.LENGTH_SHORT).show();
        return null;
    }

    private static SecretKey generateKey(String password) throws Exception {
        byte[] salt = {0x4B, 0x72, 0x69, 0x73, 0x74, 0x65, 0x6E}; // Salt for key generation
        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), salt, ITERATIONS);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(BLOWFISH_ALGORITHM);
        return keyFactory.generateSecret(keySpec);
    }

}
