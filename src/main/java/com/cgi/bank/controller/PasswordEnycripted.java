package com.cgi.bank.controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class PasswordEnycripted {
	static Cipher cipher; 
	public static String encryptPassword(String inputPassword) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		
		  KeyGenerator keyGenerator = KeyGenerator.getInstance("DES"); //
		  //keyGenerator.init(112); // block size is 128bits
		  SecretKey secretKey =keyGenerator.generateKey(); cipher = cipher.getInstance("DES");
		  cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		  String secKeyEncoded = new String(secretKey.getEncoded());
		  byte[] encrypted =cipher.doFinal(secKeyEncoded.getBytes());
		 
	    StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
	    return encryptor.encryptPassword(inputPassword);
	}

	public static boolean checkPassword(String inputPassword, String encryptedStoredPassword) {
	    StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
	    return encryptor.checkPassword(inputPassword, encryptedStoredPassword);
	}

}
