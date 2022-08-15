package util;

import java.security.MessageDigest;

import oracle.jdbc.driver.Message;
//dao, vo를 이용해서 이메일 인증

public class SHA256 {
	//특정한 입력(값)을 넣었을때  값이 SHA256으로 해쉬 값을 구하는 함수 
	public static String getSHA256(String input) {
		StringBuffer result = new StringBuffer();
		try {
			//실제로 사용자가 받은 값을 SHA-256 알고리즘 이용
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte [] salt = "hello! This is Salt.".getBytes(); //salt는 해커에 의해서 해킹당할 가능성낮추기위해
			digest.reset();
			digest.update(salt);
			//실제로 받은 해쉬 값을 chars 배열에 담아준다.
			byte [] chars = digest.digest(input.getBytes("UTF-8"));
			for(int i=0; i < chars.length; i++) {
				String hex = Integer.toHexString(0xff & chars[i]);
				if(hex.length() == 1) result.append("0"); //16진수 형태로 출력하게
				result.append(hex);			
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return result.toString(); //결과 반환
	}
}
