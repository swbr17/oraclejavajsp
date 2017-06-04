package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kr.or.ksmart.driverdb.DriverDB;
import kr.or.ksmart.dto.Goods;

public class Gdao {
	
	//09 gSearchSelect메서드선언
	public ArrayList<Goods> gSearchSelect(String search) throws ClassNotFoundException, SQLException{
		System.out.println("06 gSearchSelect Gdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		pstmt = conn.prepareStatement("select * from oracle_goods where ora_g_code=? or ora_id=? or ora_g_name=? or ora_g_cate=?");
		System.out.println(pstmt+"<-- pstmt1");
		
		pstmt.setString(1, search);
		pstmt.setString(2, search);
		pstmt.setString(3, search);
		pstmt.setString(4, search);
		System.out.println(pstmt+"<-- pstmt2");
		
		rs = pstmt.executeQuery();
		ArrayList<Goods> searcharr = new ArrayList<Goods>();
		while(rs.next()){
			Goods g = new Goods();
			g.setG_code(rs.getString("ora_g_code"));
			g.setM_id(rs.getString("ora_id"));
			g.setG_name(rs.getString("ora_g_name"));
			g.setG_cate(rs.getString("ora_g_cate"));
			g.setG_price(rs.getString("ora_g_price"));
			g.setG_color(rs.getString("ora_g_color"));
			g.setG_size(rs.getString("ora_g_size"));
			g.setG_date(rs.getString("ora_g_date"));
			g.setG_detail(rs.getString("ora_g_detail"));
			searcharr.add(g);
		}
		return searcharr;
	}
	
	//08 gDateSearch 메서드 선언
	public ArrayList<Goods> gDateSearch(String searchprostartdate, String searchproenddate) throws ClassNotFoundException, SQLException{
		System.out.println("06 gDateSearch Gdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		pstmt = conn.prepareStatement("SELECT * FROM oracle_goods WHERE ora_g_date BETWEEN ? and ? ORDER BY ora_g_date ASC");
		System.out.println(pstmt+" <-- pstmt1");
		
		pstmt.setString(1, searchprostartdate);
		pstmt.setString(2, searchproenddate);
		System.out.println(pstmt+"<-- pstmt2");
		
		rs = pstmt.executeQuery();
		ArrayList<Goods> searchdatearr = new ArrayList<Goods>();
		while(rs.next()){
			Goods g = new Goods();
			g.setG_code(rs.getString("ora_g_code"));
			g.setM_id(rs.getString("ora_id"));
			g.setG_name(rs.getString("ora_g_name"));
			g.setG_cate(rs.getString("ora_g_cate"));
			g.setG_price(rs.getString("ora_g_price"));
			g.setG_color(rs.getString("ora_g_color"));
			g.setG_size(rs.getString("ora_g_size"));
			g.setG_date(rs.getString("ora_g_date"));
			g.setG_detail(rs.getString("ora_g_detail"));
			searchdatearr.add(g);
		}
		return searchdatearr;
	}
	//07 gPriceSearch 메서드 선언
	public ArrayList<Goods> gPriceSearch(int searchprostartprice, int searchproendprice) throws ClassNotFoundException, SQLException{
		System.out.println("06 gPriceSearch Gdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
			
		pstmt = conn.prepareStatement("SELECT * FROM oracle_goods WHERE ora_g_price BETWEEN ? and ? ORDER BY ora_g_price ASC");
		System.out.println(pstmt+" <-- pstmt1");
		
		pstmt.setInt(1, searchprostartprice);
		pstmt.setInt(2, searchproendprice);
		System.out.println(pstmt+"<-- pstmt2");
		
		rs = pstmt.executeQuery();
		ArrayList<Goods> searchpricearr = new ArrayList<Goods>();
		while(rs.next()){
			Goods g = new Goods();
			g.setG_code(rs.getString("ora_g_code"));
			g.setM_id(rs.getString("ora_id"));
			g.setG_name(rs.getString("ora_g_name"));
			g.setG_cate(rs.getString("ora_g_cate"));
			g.setG_price(rs.getString("ora_g_price"));
			g.setG_color(rs.getString("ora_g_color"));
			g.setG_size(rs.getString("ora_g_size"));
			g.setG_date(rs.getString("ora_g_date"));
			g.setG_detail(rs.getString("ora_g_detail"));
			searchpricearr.add(g);
		}
		return searchpricearr;
	}

	//06 gAllSelectadm 메서드 선언
	public ArrayList<Goods> gAllSelectadm() throws ClassNotFoundException, SQLException{
		System.out.println("05 gAllSelectadm Gdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		Statement stmt = null;
		ResultSet rs = null;

		stmt = conn.createStatement();
		String query = "select * from oracle_goods";
		rs = stmt.executeQuery(query);
		
		ArrayList<Goods> get_alg1 = new ArrayList<Goods>();
		
		while(rs.next()){
			Goods g = new Goods();
			g.setG_code(rs.getString("ora_g_code"));
			g.setM_id(rs.getString("ora_id"));
			g.setG_name(rs.getString("ora_g_name"));
			g.setG_cate(rs.getString("ora_g_cate"));
			g.setG_price(rs.getString("ora_g_price"));
			g.setG_color(rs.getString("ora_g_color"));
			g.setG_size(rs.getString("ora_g_size"));
			g.setG_date(rs.getString("ora_g_date"));
			g.setG_detail(rs.getString("ora_g_detail"));
			
			get_alg1.add(g);
		}
		
		return get_alg1;
	}
	//05 gAllSelectSell 메서드 선언
	public ArrayList<Goods> gAllSelectSell(String SID) throws ClassNotFoundException, SQLException{
		System.out.println("05 gAllSelectSell Gdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	
		pstmt = conn.prepareStatement("select * from oracle_goods where ora_id=?");
		System.out.println(pstmt+" <-- pstmt1");
		
		pstmt.setString(1, SID);
		System.out.println(pstmt+" <-- pstmt2");
		
		rs = pstmt.executeQuery();
		ArrayList<Goods> get_alg2 = new ArrayList<Goods>();
		
		while(rs.next()){
			Goods g = new Goods();
			g.setG_code(rs.getString("ora_g_code"));
			g.setM_id(rs.getString("ora_id"));
			g.setG_name(rs.getString("ora_g_name"));
			g.setG_cate(rs.getString("ora_g_cate"));
			g.setG_price(rs.getString("ora_g_price"));
			g.setG_color(rs.getString("ora_g_color"));
			g.setG_size(rs.getString("ora_g_size"));
			g.setG_date(rs.getString("ora_g_date"));
			g.setG_detail(rs.getString("ora_g_detail"));
			get_alg2.add(g);
		}
			
		return get_alg2;
		}
	
	//04 gSelectforUpdate 메서드 선언
	public Goods gSelectforUpdate(String g_code) throws ClassNotFoundException, SQLException{
		System.out.println("04 gSelectforUpdate Gdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods g = new Goods();
		
		pstmt = conn.prepareStatement("select * from oracle_goods where ora_g_code=?");
		System.out.println(pstmt +"<-- pstmt1");
		
		pstmt.setString(1, g_code);
		System.out.println(pstmt +"<-- pstmt2");
		
		rs = pstmt.executeQuery();
		if(rs.next()){
			g.setG_code(rs.getString("ora_g_code"));
			g.setM_id(rs.getString("ora_id"));
			g.setG_name(rs.getString("ora_g_name"));
			g.setG_cate(rs.getString("ora_g_cate"));
			g.setG_price(rs.getString("ora_g_price"));
			g.setG_color(rs.getString("ora_g_color"));
			g.setG_size(rs.getString("ora_g_size"));
			g.setG_date(rs.getString("ora_g_date"));
			g.setG_detail(rs.getString("ora_g_detail"));
		}
		return g;
	}
	
	//03 gDelete 메서드선언
	public void gDelete(String g_code) throws ClassNotFoundException, SQLException{
		System.out.println("03 gDelete Gdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		PreparedStatement pstmt = null;
		
		pstmt = conn.prepareStatement("DELETE FROM oracle_goods WHERE ora_g_code=?");
		System.out.println(pstmt +"<-- pstmt1");
		
		pstmt.setString(1, g_code);
		System.out.println(pstmt +"<-- pstmt2");
		
		int result = pstmt.executeUpdate();
		System.out.println(result +"<-- result");
	}
	
	//02 gUpdate 메서드 선언
	public void gUpdate(Goods g) throws ClassNotFoundException, SQLException{
		System.out.println("02 gUpdate Gdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		PreparedStatement pstmt = null;
		
		pstmt = conn.prepareStatement("UPDATE oracle_goods SET ora_id=?, ora_g_name=?, ora_g_cate=?, ora_g_price=?, ora_g_color=?, ora_g_size=?, ora_g_date = now(), ora_g_detail=? WHERE ora_g_code = ?");
		System.out.println(pstmt +"<-- pstmt1");
		
		pstmt.setString(1, g.getM_id());
		pstmt.setString(2, g.getG_name());
		pstmt.setString(3, g.getG_cate());
		pstmt.setString(4, g.getG_price());
		pstmt.setString(5, g.getG_color());
		pstmt.setString(6, g.getG_size());
		pstmt.setString(7, g.getG_detail());
		pstmt.setString(8, g.getG_code());
		System.out.println(pstmt +"<-- pstmt2");

		int result = pstmt.executeUpdate();
		System.out.println(result +"<-- result");
		
		pstmt.close();
		conn.close();
	}
	
	//01 gInsert 메서드 선언
	public void gInsert(Goods g) throws SQLException, ClassNotFoundException{
		System.out.println("01 gInsert Gdao.java");
		DriverDB driverdb = new DriverDB();
		Connection conn = driverdb.driverDbcon();
		System.out.println(conn+" <-- conn");
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String maxquery = "select max(CAST(substr(ora_g_code,7) AS DECIMAL)) from oracle_goods";
		pstmt = conn.prepareStatement(maxquery);
		System.out.println(pstmt + "<-- pstmt 1");
		rs = pstmt.executeQuery();
		int nextcodenum = 0;
		
		if(rs.next()){
			nextcodenum = rs.getInt(1) + 1;
			System.out.println(nextcodenum +" <-- nextcodenum");
		}

		String thequery = "INSERT INTO oracle_goods VALUES (?, ?, ?, ?, ?, ?, ?, now(), ?)";
		pstmt = conn.prepareStatement(thequery);
		System.out.println(pstmt + "<-- pstmt 2");
		
		pstmt.setString(1, "goods_"+nextcodenum);
		pstmt.setString(2, g.getM_id());
		pstmt.setString(3, g.getG_name());
		pstmt.setString(4, g.getG_cate());
		pstmt.setString(5, g.getG_price());
		pstmt.setString(6, g.getG_color());
		pstmt.setString(7, g.getG_size());
		pstmt.setString(8, g.getG_detail());
		System.out.println(pstmt + "<-- pstmt 3");
		
		int result = pstmt.executeUpdate();
		System.out.println(result+" <-- result gUpdate Gdao.java");
		
		rs.close();
		pstmt.close();
		conn.close();
	}
	 
}
