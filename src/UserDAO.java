import java.sql.*;

class UserDAO{
	public String getUserType(String userID){
		DBConnection connec = new DBConnection();
		Connection con;
		String userType = null;
		try {
			con = connec.getConnection();
			String query = "SELECT * FROM usertb WHERE UserID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userID);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				 userType = rs.getString("UserType");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userType;
	}
	
	public String getIncorrectAttempts(String userID) {
		DBConnection connec = new DBConnection();
		Connection con;
		String message = null;
		try {
			con = connec.getConnection();
			String query = "SELECT * FROM usertb WHERE UserID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userID);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				int incorrectAttempts = rs.getInt("IncorrectAttempts");
				if(incorrectAttempts == 0) {
					message = "No Incorrect Attempt";
				}else if(incorrectAttempts == 1) {
					message = "One Time";
				}else {
					message = "Incorrect Attempt Exceeded";
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public String changeUserType(String userID) {
		DBConnection connec = new DBConnection();
		Connection con;
		String message = null;
		try {
			con = connec.getConnection();
			String query = "UPDATE usertb SET UserType=? WHERE UserID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, "Admin");
			pst.setString(2, userID);
			int row = pst.executeUpdate();
			if(row == 1) {
				message = "Update Success";
			}else {
				message = "Update Failed";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public int getLockStatus() {
		DBConnection connec = new DBConnection();
		Connection con;
		int count = 0;
		try {
			con = connec.getConnection();
			String query = "SELECT * FROM usertb";
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				 if(rs.getInt("LockStatus") == 0) {
					 count = count + 1;
				 }
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public String changeName(String id, String name) {
		DBConnection connec = new DBConnection();
		Connection con;
		String message = null;
		try {
			con = connec.getConnection();
			String query = "UPDATE usertb SET Name=? WHERE UserID=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, name);
			pst.setString(2, id);
			int row = pst.executeUpdate();
			if(row == 1) {
				message = "Success";
			}else {
				message = "Failed";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public String changePassword(String password) {
		DBConnection connec = new DBConnection();
		Connection con;
		String message = null;
		try {
			con = connec.getConnection();
			String query = "UPDATE usertb SET Password=? WHERE UserType=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, password);
			pst.setString(2, "Admin");
			int row = pst.executeUpdate();
			if(row > 0) {
				message = "Success";
			}else {
				message = "Failed";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	public String addUser_1(UserBean bean) {
		DBConnection connec = new DBConnection();
		Connection con;
		String message = null;
		try {
			con = connec.getConnection();
			String query = "INSERT INTO usertb VALUES(?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, bean.getUserId());
			pst.setString(2, bean.getPassword());
			pst.setString(3, bean.getName());
			pst.setInt(4, bean.getIncorrectAttempts());
			pst.setInt(5, bean.getLockStatus());
			pst.setString(6, bean.getUserType());
			int row = pst.executeUpdate();
			if(row > 0) {
				message = "Success";
			}else {
				message = "Fail";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			message = "Fail";
		}
		return message;
	}
	
	public String addUser_2(UserBean bean) {
		DBConnection connec = new DBConnection();
		Connection con;
		String message = null;
		try {
			if(bean.getLockStatus() != 0) {
				message = "Fail";
			} 
			else {
				con = connec.getConnection();
				String query = "INSERT INTO usertb VALUES(?,?,?,?,?,?)";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setString(1, bean.getUserId());
				pst.setString(2, bean.getPassword());
				pst.setString(3, bean.getName());
				pst.setInt(4, bean.getIncorrectAttempts());
				pst.setInt(5, bean.getLockStatus());
				pst.setString(6, bean.getUserType());
				int row = pst.executeUpdate();
				if(row > 0) {
					message = "Success";
				}else {
					message = "Fail";
				}
			}	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			message = "Fail";
		}
		return message;
	}
}