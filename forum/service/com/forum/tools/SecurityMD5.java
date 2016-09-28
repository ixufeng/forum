package com.forum.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;


public class SecurityMD5  {

	
	public static String encode(String str){
	
		 String encode = "";
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] ss = md.digest(str.getBytes());
			char temp[] = Hex.encodeHex(ss);
			
			for(int i=0;i<temp.length;i++){
				encode+=temp[i];
			}
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
		
		
		return encode;
	}
	
	
	
}
