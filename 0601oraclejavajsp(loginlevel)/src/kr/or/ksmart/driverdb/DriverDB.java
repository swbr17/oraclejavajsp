package kr.or.ksmart.driverdb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DriverDB {
	public Connection driverDbcon() throws ClassNotFoundException, SQLException{
		System.out.println("01 DriverDB클래스 driverDbcon()메서드 실행");
		Connection reconn = null;
		Class.forName("oracle.jdbc.OracleDriver");
		String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:XE";
		String dbUser = "dev24id";
		String dbPass = "dev24pw";
		reconn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		
		return reconn;
	}
	
}
