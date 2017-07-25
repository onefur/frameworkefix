package com.alibaba.druid.pool;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import com.alibaba.druid.util.Base64;
import com.alibaba.druid.util.StringUtils;

/**
 * Description:数据库密钥生成工具类 
 * Copyright (c) Department of Research and Development/Beijing
 * All Rights Reserved.
 * @version 1.0  2017年2月22日 下午5:16:17  by 杨雷（yanglei@cloud-young.com）创建
 */
@SuppressWarnings("unused")
public class encryptUtil {
	private final static String 					   DES 										 = "DES";
  	private final static String 					   CODE 									 = "UTF-8";

	public static String 							   KEY										 = "cloudyoung";
	    

	private static String decrypt(String data){
		if (data == null)
		    return null;
		if(StringUtils.isEmpty(KEY)){
			KEY = "cloudyoung";
		}
		byte[] buf = Base64.altBase64ToByteArray(data);
		try {
			byte[] bt = decrypt(buf, KEY.getBytes(CODE));
			return new String(bt,CODE);
		} catch (Exception e) {
			System.out.println("password decrypt failed");
			e.printStackTrace();
		    return null;
		}
	}
    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }
    
    /**
     * @Description:加密转BASE64
     * @param:
     * @return: String
     * @throws:
     */
	private static String encrypt(String data) throws Exception {
        byte[] bt = encrypt(data.getBytes(CODE), KEY.getBytes(CODE));
        String strs = Base64.byteArrayToAltBase64(bt);
        return strs;
    }
    
    /**
     * @Description: DES加密
     * @param:
     * @return: byte[]
     * @throws:
     */
    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        // 生成一个可信任的随机数源
        SecureRandom sr = new SecureRandom();
        // 从原始密钥数据创建DESKeySpec对象
        DESKeySpec dks = new DESKeySpec(key);
        // 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
        SecretKey securekey = keyFactory.generateSecret(dks);
        // Cipher对象实际完成加密操作
        Cipher cipher = Cipher.getInstance(DES);
        // 用密钥初始化Cipher对象
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }
    
    public static void main(String[] args) {
    	try {
    		
    		String ciphertext = encrypt("cy@5408");
			System.out.println(ciphertext);
			System.out.println(decrypt(ciphertext));
		} catch (Exception e) {
		}
	}
    
}
