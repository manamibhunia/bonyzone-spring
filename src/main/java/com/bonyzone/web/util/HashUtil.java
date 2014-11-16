package com.bonyzone.web.util;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import java.security.SecureRandom;

import org.apache.commons.codec.binary.Base64;

/*
 * Inspired from http://stackoverflow.com/questions/2860943/suggestions-for-library-to-hash-passwords-in-java
 */

public class HashUtil {

	private static final int iterations = 10 * 1024;
	private static final int saltLen = 32;
	private static final int desiredKeyLen = 256;

	public static String getSaltedHash(String password) throws Exception {
		byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
		return Base64.encodeBase64String(salt) + "#$#" + hash(password, salt);
	}

	public static boolean check(String password, String stored) throws Exception {
		String[] saltAndPass = stored.split("#\\$#");
		if (saltAndPass.length != 2) {
			return false;
		}
		String hashOfInput = hash(password, Base64.decodeBase64(saltAndPass[0]));
		return hashOfInput.equals(saltAndPass[1]);
	}

	private static String hash(String password, byte[] salt) throws Exception {
		if (password == null || password.length() == 0) {
			throw new IllegalArgumentException("Empty passwords are not supported.");
		}
		SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		SecretKey key = f.generateSecret(new PBEKeySpec(password.toCharArray(), salt, iterations, desiredKeyLen));
		return Base64.encodeBase64String(key.getEncoded());
	}

	public static void main(String[] a) {
		
		try {
			System.out.println(HashUtil.getSaltedHash("password"));
//			System.out.println(HashUtil.check("Password123", "PIVJfzuXss+WKhaJAqGCeYUSdTJZxf3rhao4R0dHYYQ=#$#6pTTjs5LC0B6XQ5gyZo4BtNcykMDi3JYfmkfdNslhoc="));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
