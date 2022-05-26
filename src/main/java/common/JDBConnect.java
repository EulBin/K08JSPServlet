package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JDBConnect {
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBConnect() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String id = "musthave";
			String pwd = "1234";
			con = DriverManager.getConnection(url,id,pwd);
			
			System.out.println("DB 연결 성공(기본생성자)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			if(rs!=null)rs.close();
			if(stmt !=null) stmt.close();
			if(psmt !=null) psmt.close();
			if(con != null) con.close();
			
			System.out.println("JDBC 자원 해제");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public JDBConnect(String driver, String url, String id, String pwd) {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,id,pwd);
			System.out.println("DB 연결 성공(기본생성자)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}//인자 생성자2
	public JDBConnect(ServletContext application) {
		try {
			/*
			 JSP에서는 내장객체를 즉시 사용할수 있지만 Java에서는 매개변수를 통해
			 전달받은 후 사용할 수 있다. DB연결은 매우 빈번히 발생되는 업무로
			 컨텍스트 초기화 마라미터를 JSP에서 가져오는것보다는 훨씬 효율적이다. 
			 */
			String driver = application.getInitParameter("OracleDriver");
			Class.forName(driver);
			String url = application.getInitParameter("OracleURL");
			String id = application.getInitParameter("OracleId");
			String pwd = application.getInitParameter("OraclePwd");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("DB 연결 성공(기본생성자)");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
