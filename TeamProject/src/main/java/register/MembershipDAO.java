package register;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class MembershipDAO {
	
	private Connection getConnection() {
		
		DataSource ds;
		Connection conn = null;
		
		try {
			
			Context initContext = new InitialContext();
			ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
			
		} catch (Exception e) {
			System.out.println("DB연결 실패!!!");
		}
		return conn;
	}// 기본 DB연결

public boolean idCheck(String id) {
	boolean result = true;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		
		conn = getConnection();
			                //쿼리문 바인딩 함수 사용
		pstmt = conn.prepareStatement("select * from member where id = ?");
		
		pstmt.setString(1, id);
		
		rs = pstmt.executeQuery();
		if(!rs.next()) result = false;
		
		
	} catch (SQLException s1) {
		s1.printStackTrace();
	} finally {
		if(rs != null) try{rs.close();}catch(SQLException s1){}
		if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
		if(conn != null) try{conn.close();}catch(SQLException s3){}		
	}
	
	return result;
	
} // end of idCheck
	
	public boolean nickCheck(String nick) {
		boolean result = true;
		Connection conn = null;PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			//위에 연결 메소드 호출 한거임
				conn = getConnection();
												//아이디가 뭔지 모르니 바인딩으로 		
				pstmt = conn.prepareStatement("select * from member where nick = ?");
				
				//String 타입으로 저장
				pstmt.setString(3, nick);
				 
				//DB 변동에 있을떄는 excuteUpdate 메소드를 써야함 조회만 할때는 쿼리만 씀	
				rs = pstmt.executeQuery();
				if(!rs.next()) result = false;
				
				
		} catch (SQLException s1) {
			s1.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return result;
	}//end of nickCheck 
	
	
}
