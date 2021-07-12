package com.cosmax.apktool;


import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * @program: apktool
 * @description:
 * @author: Cosmax
 * @create: 2020/12/13 10:17
 */
public class DecryptTest {

//    public static final String ALGORITHM = "RC4";
//    public static final String TAG = "RC4Utils";
//
//    public static String decryptData(String paramString1, String paramString2)
//    {
//        try
//        {
//            paramString1 = new String(decryptData(Base64Utils.decode(paramString1), paramString2), StandardCharsets.UTF_8);
//            return paramString1;
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    public static byte[] decryptData(byte[] paramArrayOfByte, String paramString)
//    {
//        if (paramArrayOfByte != null)
//        {
//            try
//            {
//                Cipher localCipher = Cipher.getInstance("RC4");
//                SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes("UTF-8"), "RC4");
//                localCipher.init(2, localSecretKeySpec);
//                paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
//            }
//            catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException | NoSuchPaddingException | UnsupportedEncodingException | NoSuchAlgorithmException ignored) {}
//            System.out.println("RC4Utils" + paramArrayOfByte.toString());
//        }
//        return paramArrayOfByte;
//    }
//
//    public static String encryptData(String paramString1, String paramString2)
//    {
//        return Base64Utils.encode(encryptData(paramString1.getBytes(), paramString2));
//    }
//
//    public static byte[] encryptData(byte[] paramArrayOfByte, String paramString)
//    {
//        if (paramArrayOfByte != null)
//        {
//            try
//            {
//                Cipher localCipher = Cipher.getInstance("RC4");
//                SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString.getBytes("UTF-8"), "RC4");
//                localCipher.init(1, localSecretKeySpec);
//                paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
//            }
//            catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException | UnsupportedEncodingException ignored) {}
//            System.out.println("RC4Utils" + paramArrayOfByte.toString());
//        }
//        return paramArrayOfByte;
//    }

    @Test
    public void Test() {
        System.out.println(decode("653aee9b2eac775cb4f0b54dd9cd6bc4", "179df8a3444306cb"));
        System.out.println(decode("1bb1886b1485bed34edc47e183a9acef", "179df8a3444306cb"));
        System.out.println(decode("15864bf49e2d375a71a8054b540696bd34433d088b10221ed57ff26f5be1e5313a2ef9989cd6c42b2bec87c98f0403f7", "0849da515f1573d3"));
        System.out.println(decode("e43ade427fc567e2b449ee7461239032", "5029d5ea2be93328"));
        System.out.println(decode("cc2e97a38ec6e91115cddd8fdac2274ccba60976ad4ed00662f58169c1b2ab29023785072119be85f726521db4722edb", "5029d5ea2be93328"));
        System.out.println(decode("ffbc0eb3bbfabaf719f71828f04491b219a3592b37d6f032f63599d6ebdde58a", "b8dd17c700631758"));
//        System.out.println(decode("7c9b3d037771a780f41f8c31ced798beb1f7763ca8c118c1726a1f5c402ed18dcabe485d61220403536443b329113068c61cbd54f1d98cc8543e236540732f87", "61999dbeab7df9dd"));

    }

    public static String decode(String paramString1, String paramString2) {
        byte[] arrayOfByte1 = new byte[0];
        byte[] arrayOfByte2;
        int i = paramString1.length();
        if (i % 2 == 1) {
            arrayOfByte2 = new byte[++i / 2];
            paramString1 = "0" + paramString1;
        } else {
            arrayOfByte2 = new byte[i / 2];
        }
        byte b1 = 0;
        for (byte b2 = 0; b2 < i; b2 += 2) {
            arrayOfByte2[b1] = (byte)(byte)Integer.parseInt(paramString1.substring(b2, b2 + 2), 16);
            b1++;
        }
        paramString1 = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(paramString2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            arrayOfByte1 = cipher.doFinal(arrayOfByte2);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new String(arrayOfByte1);
    }
}
