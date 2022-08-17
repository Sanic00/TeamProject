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
		
		
	} finally {
		if(rs != null) try{rs.close();}catch(SQLException s1){}
		if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
		if(conn != null) try{conn.close();}catch(SQLException s3){}		
	}
	
	return result;
	
} // end of idCheck
	
//	닉네임 중복체크 하기 위해 DB안에 있는지 비교
	public boolean nickCheck(String nick) {
		
		boolean result = true;
		Connection conn = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		
		try {
			
				conn = getConnection();
														
				pstmt = conn.prepareStatement("select * from member where nick = ?");
				
				pstmt.setString(1, nick);
				 	
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
	
	//DB에 회원데이터 저장
	public boolean memberInsert(MembershipVO vo) {
		
		boolean flag = false; //true과 되면 성공
		
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
			System.out.println("????");
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return flag;
	}// end of memberInsert
	
	public int loginCheck(String id, String pass) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int check = -1; //초기는 아이디 없음으로 설정
		
		try {
			conn = getConnection();
			
			String strQuery = "select pass from member where id =?";
			pstmt = conn.prepareStatement(strQuery);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPass = rs.getString("pass"); //비밀번호를 가져와 dbpass에 저장
				if(pass.equals(dbPass)) check =1; // 파라미터값과 동일 하면 로그인 성공
				else check = 0; // 아닐 경우 아이디는 맞지만 비번이 맞지 않으니 실패
			}
		}catch(SQLException s1) {	
			s1.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(SQLException s1){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException s2){}
			if(conn != null) try{conn.close();}catch(SQLException s3){}		
		}
		
		return check;
	} // end of loginCheck
	
	
	
	
	
	
}
