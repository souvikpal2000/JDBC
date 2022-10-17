import java.sql.*;
import java.util.ArrayList;

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
	
	public ArrayList<UserBean> getUsers(String userType) {
		DBConnection connec = new DBConnection();
		Connection con;
		ArrayList<UserBean> list = new ArrayList<>();
		try {
			con = connec.getConnection();
			String query = "SELECT * FROM usertb WHERE UserType=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, userType);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				UserBean bean = new UserBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
				list.add(bean);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<UserBean> storeAllRecords() {
		DBConnection connec = new DBConnection();
		Connection con;
		ArrayList<UserBean> list = new ArrayList<>();
		try {
			con = connec.getConnection();
			String query = "SELECT * FROM usertb";
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				UserBean bean = new UserBean(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
				list.add(bean);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String[] getNames() {
		DBConnection connec = new DBConnection();
		Connection con;
		ArrayList<String> list = new ArrayList<>();
		String[] arr = {};
		try {
			con = connec.getConnection();
			String query = "SELECT Name FROM usertb";
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
	        arr = new String[list.size()]; 
	        arr = list.toArray(arr); 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}