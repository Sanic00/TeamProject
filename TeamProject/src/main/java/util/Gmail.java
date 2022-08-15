package util;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;

public class Gmail extends Authenticator  {
	
	@Override
	protected  PasswordAuthentication getPasswordAuthentication() {
		//자신의 구글아이디와 비밀번호를 매개변수안에 넣는다.
		//실제로 사용자한테 메일을 전송할 그 메일을 보내는 사람 
		//즉 관리자 자신 아이디와 비밀번호를 작성
	
		return new PasswordAuthentication("구글id", "구글password");
		
	}

}
