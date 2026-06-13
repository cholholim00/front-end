package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;

public class JDBConnect {
	private Connection conn;
	protected PreparedStatement pstmt;
	protected ResultSet rs;
	public Connection getConnection() {
		return conn;
	}
	public JDBConnect() {		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "musthave";
			String pwd = "1234";
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공(기본 생성자)");
		} catch(Exception e) {
			System.out.println("Exception[JDBConnect]: " + e.getMessage());
		}
	}
	public JDBConnect(ServletContext application) {
		try {
			Class.forName(application.getInitParameter("oracleDriver"));
			String url = application.getInitParameter("oracleUrl");
			String id = application.getInitParameter("oracleId");
			String pwd = application.getInitParameter("oraclePwd");
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공(web.xml)");
		} catch(Exception e) {
			System.out.println("Exception[JDBConnect2]: " + e.getMessage());
		}
	}
	public JDBConnect(String driver, String url, String id, String pwd) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공(인수 생성자)");
		} catch(Exception e) {
			System.out.println("Exception[JDBConnect3]: " + e.getMessage());
		}
	}
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null)	conn.close();			
		}catch(Exception e) {
			System.out.println("Exception[close]: " + e.getMessage());
		}
	}
}



