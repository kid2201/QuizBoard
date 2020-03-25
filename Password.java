package quizboard.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
	
	public static String toMD5(String password) {		
		try {
			MessageDigest md;
			md = MessageDigest.getInstance("MD5");
			byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
			
			StringBuilder sb = new StringBuilder();
			for(byte b : hashInBytes) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
