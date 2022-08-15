package util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DataBaseUtil {

private Connection getConnection() {
		
		DataSource ds;
		Connection conn = null; //연결을 해주는 객체 생성, 초기값 null로 
		
		try {
			
			Context initContext = new InitialContext();
			ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			System.out.println("DB연결 실패!!!");
		}
		return conn;
	}

	

}
