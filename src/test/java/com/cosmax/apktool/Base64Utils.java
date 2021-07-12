//package com.cosmax.apktool;
//
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//public class Base64Utils
//{
//  public static final int CACHE_SIZE = 1024;
//  public static final String TAG = "Base64Utils";
//
//  public static byte[] decode(String paramString)
//  {
//    try
//    {
//      Base64.getDecoder()
//      paramString = new String(Base64.getDecoder(paramString.getBytes(), 2), StandardCharsets.UTF_8);
//    }
//    catch (Exception paramString1)
//    {
//      System.out.println("Base64Utils" + paramString1.toString());
//    }
//    return paramString.getBytes();
//  }
//
//  public static String encode(byte[] paramArrayOfByte)
//  {
//    if (paramArrayOfByte != null) {
//      try
//      {
//        String str = "";
//        str = Base64.getEncoder(paramArrayOfByte, 2)
////        str.<init>(Base64.encode(paramArrayOfByte, 2));
//        paramArrayOfByte = str;
//      }
//      catch (Exception paramArrayOfByte)
//      {
//        System.out.println("Base64Utils", paramArrayOfByte.toString());
//      }
//    } else {
//      paramArrayOfByte = null;
//    }
//    return paramArrayOfByte;
//  }
//
//  public static String encodeFile(String paramString)
//  {
//    return encode(fileToByte(paramString));
//  }
//
//  public static byte[] fileToByte(String paramString)
//  {
//    byte[] arrayOfByte = new byte[0];
//    Object localObject = new File(paramString);
//    paramString = arrayOfByte;
//    if (((File)localObject).exists()) {
//      try
//      {
//        paramString = new java/io/FileInputStream;
//        paramString.<init>((File)localObject);
//        ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
//        localByteArrayOutputStream.<init>(2018);
//        localObject = new byte[1024];
//        for (;;)
//        {
//          int i = paramString.read((byte[])localObject);
//          if (i == -1) {
//            break;
//          }
//          localByteArrayOutputStream.write((byte[])localObject, 0, i);
//          localByteArrayOutputStream.flush();
//        }
//        localByteArrayOutputStream.close();
//        paramString.close();
//        paramString = localByteArrayOutputStream.toByteArray();
//      }
//      catch (IOException paramString)
//      {
//        paramString.printStackTrace();
//        paramString = arrayOfByte;
//      }
//      catch (FileNotFoundException paramString)
//      {
//        paramString.printStackTrace();
//        paramString = arrayOfByte;
//      }
//    }
//    return paramString;
//  }
//}
