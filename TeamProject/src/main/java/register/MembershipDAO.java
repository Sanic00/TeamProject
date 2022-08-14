package register;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;
import java.util.*;

public class MembershipDAO {
	
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
		 System.out.println("연결이 왜 안되니 시발련아");
		
	} finally {
		if(rs != null) try{rs.close();}catch(SQLException s1){}
		if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
		if(conn != null) try{conn.close();}catch(SQLException s3){}		
	}
	
	return result;
	
} // end of idCheck
	
	public boolean nickCheck(String nick) {
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			//위에 연결 메소드 호출 한거임
				conn = getConnection();
														
				pstmt = conn.prepareStatement("select * from member where nick = ?");
				
				//String 타입으로 저장
				pstmt.setString(3, nick);
				 	
				rs = pstmt.executeQuery();
				if(!rs.next()) result = false;
				
				
		} catch (SQLException s1) {
			s1.printStackTrace();
			System.out.println("진짜 지랄 하지마 연결좀 제발");
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return result;
	}//end of nickCheck 
	
	//DB에 회원데이터 저장
	public boolean memberInsert(MembershipVO vo) {
		
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String strQuery = "insert into member values(?,?,?,?)";
			
			pstmt = conn.prepareStatement(strQuery);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getNick());
			pstmt.setString(4, vo.getEmail());
		
			int count = pstmt.executeUpdate();
			if(count > 0) flag = true;
		
		}catch(SQLException s1) {	
			s1.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return flag;
	}
}
