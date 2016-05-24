package com.web.crawler;

import java.security.MessageDigest;

public class Hasher {
	
	public static String toSha256(String string){
		try{
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			String text = string.toLowerCase();
			md.update(text.getBytes("ASCII"));
			byte[] hash = md.digest();
			
			StringBuilder sb = new StringBuilder();
			for(byte b : hash){
				sb.append(String.format("%02x", b));
			}
			return "";
		}catch(Exception e){
			return e.toString();
		}
		
	}
}
