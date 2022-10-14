import java.sql.*;

class DBConnection{
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro","root","");
		return con;  
	}
}