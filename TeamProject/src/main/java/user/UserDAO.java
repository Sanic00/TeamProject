package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {
	
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
	
	//아이디와 비밀번호를 받아 로그인 시키는 함수
	public int login(String userid, String userpassword) {
	String SQL = "select userpassword from user1  where userid = ?"; 
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		conn = getConnection();
		pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		if(rs.next()) {
			if(rs.getString(1).equals(userpassword)) {
				return 1; //로그인 성공
			} 
			else {
				return 0; // 아이디는 존재 비밀번호가 x
			}
		}
		return -1; //아이디 없음
	}catch (Exception e) {
		e.printStackTrace();
	} finally {
		if(rs != null) try{rs.close();}catch(Exception s1){s1.printStackTrace();}
		if(pstmt != null) try{pstmt.close();}catch(Exception s2){s2.printStackTrace();}
		if(conn != null) try{conn.close();}catch(Exception s3){s3.printStackTrace();}		
	}
	return -2; // 데이터베이스 오류
	
}
	//사용자가 정보를 입력받아서 회원가입을 수행해주는 함수 정수형태로 리턴
	public int join(UserDTO user) {
		String SQL = "insert into user values(?,?,?,?, false)"; 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			
			pstmt.setString(1, user.getUserid());
			pstmt.setString(2, user.getUserpassword());
			pstmt.setString(3, user.getUseremail());
			pstmt.setString(4, user.getUseremailhash());
			
			return pstmt.executeUpdate();
		 
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();}catch(Exception s1){s1.printStackTrace();}
			if(pstmt != null) try{pstmt.close();}catch(Exception s2){s2.printStackTrace();}
			if(conn != null) try{conn.close();}catch(Exception s3){s3.printStackTrace();}		
		}
		return -1; // 회원가입 실패 
		
	}
	
	//특정회원 이메일 자체를 반환 하는 함수
	public String getUserEmail(String userid){
	String SQL = "select userEmail from user1 where userid = ?"; 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			}catch (Exception e) {
			e.printStackTrace();
			} finally {
			if(rs != null) try{rs.close();}catch(Exception s1){s1.printStackTrace();}
			if(pstmt != null) try{pstmt.close();}catch(Exception s2){s2.printStackTrace();}
			if(conn != null) try{conn.close();}catch(Exception s3){s3.printStackTrace();}		
			}
		return null; // 데이터베이스 오류
	}
	
	
	//사용한테서 id값을 받아서 사용자가 이메일 검증이 됬는지
	public boolean getuserEmailChecked(String userid) {
		String SQL = "select userEmailChecked from user1 where userid = ?"; 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getBoolean(1);
			}
			}catch (Exception e) {
			e.printStackTrace();
			} finally {
			if(rs != null) try{rs.close();}catch(Exception s1){s1.printStackTrace();}
			if(pstmt != null) try{pstmt.close();}catch(Exception s2){s2.printStackTrace();}
			if(conn != null) try{conn.close();}catch(Exception s3){s3.printStackTrace();}		
			}
		return false; // 데이터베이스 오류
		
	}
	
	//특정한 사용자가 이메일 검증을 통해서 인증 완료가 되도록 담당 함수
	public boolean setuserEmailChecked(String userid) {
		String SQL = "update user1 set  useremailchecked = true where userid =?"; 
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userid);
			//기본적으로 인증이 되어있지만 한번더 인증시키게
			pstmt.executeUpdate();
			return true;
			
			}catch (Exception e) {
			e.printStackTrace();
			} finally {
			if(rs != null) try{rs.close();}catch(Exception s1){s1.printStackTrace();}
			if(pstmt != null) try{pstmt.close();}catch(Exception s2){s2.printStackTrace();}
			if(conn != null) try{conn.close();}catch(Exception s3){s3.printStackTrace();}		
			}
		return false; // 데이터베이스 오류
		
	}
}