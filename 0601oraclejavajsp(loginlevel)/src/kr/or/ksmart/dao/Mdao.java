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
	
	//07 �α��� �޼��� ����
	public String mLoginPro(String input_id, String input_pw) throws SQLException, ClassNotFoundException{
		String login = null;
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		System.out.println(conn + "<-- conn ora_m_list.jsp");	
		
		String dbid = null;
		String dbpw = null;
		String dblevel = null;
		String dbname = null;
		String dbemail = null;
		
		pstmt = conn.prepareStatement("select * from oracle_member where ora_id=?");
		pstmt.setString(1, input_id);
		rs = pstmt.executeQuery();		
		if(rs.next()){
			System.out.println("01���̵� ��ġ");
			login = "01���̵� ��ġ";
			dbid = rs.getString("ora_id");
			dbpw = rs.getString("ora_pw");
			dblevel = rs.getString("ora_level");
			dbname = rs.getString("ora_name");
			if(input_pw.equals(dbpw)){
				System.out.println("03�α��� ����");
				login = "03�α��� ����";
			
			}else{
				System.out.println("04��� ����ġ");
				login = "04��� ����ġ";
			}
		}else{
			System.out.println("02���̵� ����ġ");
			login = "02���̵� ����ġ";
		}
		return login;
	}
	
	//06 �˻� ��ȸ �޼��� ����
	public ArrayList<Member> mSearch(String search) throws ClassNotFoundException, SQLException{
		System.out.println("06 ȸ�� �˻� �޼��� ����");
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
	
	//05 ����ó�� �޼��� ����
	public void mDelete(String ora_id) throws ClassNotFoundException, SQLException{
		System.out.println("05 ����ó�� �޼��� ���� Mdao.java");
		DriverDB db = new DriverDB();
		conn = db.driverDbcon();
		pstmt = conn.prepareStatement("DELETE FROM oracle_member WHERE ora_id=?");
		pstmt.setString(1, ora_id);
		pstmt.executeUpdate();
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
	
	//04 ���� �޼��� ����
	public void mUpdate(Member m) throws SQLException, ClassNotFoundException{
		System.out.println("04 ���� �޼��� ���� Mdao.java");
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
	
	//03 �Ѹ��� ȸ������ ��ȸ �޼��� ����(����ȭ�鿡 �����ֱ�����)
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
	
	//02 ��üȸ�� ��ȸ �޼��� ����
	public ArrayList<Member> mAllSelect() throws ClassNotFoundException, SQLException{
		System.out.println("02 ��üȸ�� ��ȸ �޼��� ���� Mdao.java");
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
	//01 mInsert �޼��� ����
	public void mInsert(Member m,Connection conn) throws SQLException{
		System.out.println("01_01�Է�ó���޼��� ���� Mdao.java");
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
