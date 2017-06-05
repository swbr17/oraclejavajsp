package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.ksmart.driverdb.DriverDB;
import kr.or.ksmart.dto.Member;

public class Mdao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ArrayList<Member> alm = null;
	ResultSet rs = null;
	
	//08 로그인 세션(한명회원의 아이디,이름,권한 조회) 메서드 선언
	public Member mGetSession(String id) throws SQLException, ClassNotFoundException{
		System.out.println("09 mGetSession Mdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		String sql = "select ora_id, ora_name, ora_level from oracle_member where ora_id=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		Member session = new Member();
		while(rs.next()){
			session.setOra_id(rs.getString("ora_id"));
			session.setOra_level(rs.getString("ora_level"));
			session.setOra_name(rs.getString("ora_name"));
		}
		return session;
	}
	
	//07 로그인체크 메서드 선언
	public String mLoginCheck(String id, String pw) throws ClassNotFoundException, SQLException{
		System.out.println("08 mLoginCheck Mdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String login = null;

		String sql = "select ora_id, ora_pw, ora_level, ora_name from oracle_member where ora_id=? and ora_pw=?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		rs = pstmt.executeQuery();
		if(rs.next()){
			if(id.equals(rs.getString("ora_id"))){
				System.out.println("01아이디일치");
				login = "아이디일치";
				if(pw.equals(rs.getString("ora_pw"))){
					System.out.println("03로그인성공");
					login = "로그인성공";
				}else{
					System.out.println("04비번불일치");
					login = "비번불일치";
				}
			}else{
				System.out.println("02아이디불일치");
				login = "아이디불일치";
			}
		}
		return login;
	}
	//06 검색 조회 메서드 선언
	public ArrayList<Member> mSearch(String search) throws ClassNotFoundException, SQLException{
		System.out.println("06 회원 검색 메서드 선언");
		alm = new ArrayList<Member>();
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();		
		String query = "select * from oracle_member where ora_id=? or ora_name=? or ora_level=? or ora_email=?";
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, search);
		pstmt.setString(2, search);
		pstmt.setString(3, search);
		pstmt.setString(4, search);
		rs = pstmt.executeQuery();	
		while(rs.next()){
			Member m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
			alm.add(m);		
		}
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		return alm;

	}
	
	//05 삭제처리 메서드 선언
	public void mDelete(String ora_id) throws ClassNotFoundException, SQLException{
		System.out.println("05 삭제처리 메서드 선언 Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("DELETE FROM oracle_member WHERE ora_id=?");
		pstmt.setString(1, ora_id);
		pstmt.executeUpdate();
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
	
	//04 수정 메서드 선언
	public void mUpdate(Member m) throws SQLException, ClassNotFoundException{
		System.out.println("04 수정 메서드 선언 Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();	
		pstmt = conn.prepareStatement(
				"UPDATE oracle_member SET ora_pw=?,ora_level=?,ora_name=?,ora_email=? WHERE ora_id=?");
		System.out.println(pstmt + "<-- pstmt 1");
		
		pstmt.setString(1, m.getOra_pw());
		pstmt.setString(2, m.getOra_level());
		pstmt.setString(3, m.getOra_name());
		pstmt.setString(4, m.getOra_email());
		pstmt.setString(5, m.getOra_id());
		System.out.println(pstmt + "<-- pstmt 2");
	
		pstmt.executeUpdate();
	}
	
	//03 한명의 회원정보 조회 메서드 선언(수정화면에 보여주기위해)
	public Member mSelectforUpdate(String ora_id) throws ClassNotFoundException, SQLException{
		System.out.println("03 mSelectforUpdate Mdao.java");
		Member m = null;
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();		
		pstmt = conn.prepareStatement("select * from oracle_member where ora_id=?");
		pstmt.setString(1, ora_id);
		rs = pstmt.executeQuery();	
		if(rs.next()){
			m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
		}
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		return m;
	}
	
	//02 전체회원 조회 메서드 선언
	public ArrayList<Member> mAllSelect() throws ClassNotFoundException, SQLException{
		System.out.println("02 전체회원 조회 메서드 선언 Mdao.java");
		alm = new ArrayList<Member>();
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();		
		pstmt = conn.prepareStatement("select * from oracle_member");
		rs = pstmt.executeQuery();	
		while(rs.next()){
			Member m = new Member();
			m.setOra_id(rs.getString("ora_id"));
			m.setOra_pw(rs.getString("ora_pw"));
			m.setOra_level(rs.getString("ora_level"));
			m.setOra_name(rs.getString("ora_name"));
			m.setOra_email(rs.getString("ora_email"));
			alm.add(m);		
		}
		if (rs != null) try { rs.close(); } catch(SQLException ex) {}
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
		return alm;
	}
	//01 mInsert 메서드 선언
	public void mInsert(Member m) throws SQLException, ClassNotFoundException{
		System.out.println("01_01입력처리메서드 선언 Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();	
		String query = "INSERT INTO ORACLE_MEMBER (ora_id, ora_pw, ora_level, ora_name, ora_email) VALUES (?, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(query);
		System.out.println(pstmt + "<-- pstmt 1");
		pstmt.setString(1, m.getOra_id());
		pstmt.setString(2, m.getOra_pw());
		pstmt.setString(3, m.getOra_level());
		pstmt.setString(4, m.getOra_name());
		pstmt.setString(5, m.getOra_email());
		System.out.println(pstmt + "<-- pstmt 2");
		pstmt.executeUpdate();
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
}