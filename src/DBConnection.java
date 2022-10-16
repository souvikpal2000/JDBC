import java.sql.*;

class DBConnection{
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		String driver = "com.mysql.cj.jdbc.Driver";
		// Change username & password according to your MySQL Server
		String username = "root";
		String password = "";
		
		Class.forName(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro",username,password);
		return con;  
	}
}