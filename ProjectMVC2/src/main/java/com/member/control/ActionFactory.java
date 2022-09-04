package com.member.control;

import com.member.action.Action;

//ActionFactory : 사용자의 요청을 처리할 비즈니스 로직이 구현된 XXXAction 객체의 생성을 담당함
public class ActionFactory {
	
	//싱글톤 객체 생성
	private static ActionFactory factory; 
	
	private ActionFactory() {
		
	}
	
	public static synchronized ActionFactory getInstance() {
		if(factory == null) {
			factory = new ActionFactory();
		}
		return factory;
	}
	//매개변수로 명령이 들어오면 
	public Action getAction(String cmd) {
		Action action = null;
		
		switch(cmd) {
		
		case"login":
			action = new LoginFormAction();
			break;
		}
		
	}
}
