import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		System.out.print("Enter UserID present in DB : ");
		String userId = br.readLine();
		
		System.out.println("");
		
		UserDAO dao = new UserDAO();
		
		String userType = dao.getUserType(userId);
		System.out.println("User Type of " + userId + " : " + userType);
		
		String message01 = dao.getIncorrectAttempts(userId);
		System.out.println("Incorrect Attempts of " + userId + " : " + message01);
		
		String message02 = dao.changeUserType(userId);
		System.out.println("UserType of " + userId + " : " + message02);
		
		System.out.println("");
		
		int count = dao.getLockStatus();
		System.out.println("Total Number of Lock Status equal to ZERO : " + count);
		
		System.out.println("");
		
		System.out.print("Enter Any Desired Name : ");
		String name = br.readLine();
		
		System.out.println("");
		
		String message03 = dao.changeName(userId, name);
		System.out.println("Name of UserID " + userId + " Updated : " + message03);
		
		System.out.println("");
		
		System.out.print("Enter New Password for Admin : ");
		String password = br.readLine();
		
		System.out.println("");
		
		String message04 = dao.changePassword(password);
		System.out.println("Admin Password Updated : " + message04);
		
		System.out.println("");
		
		System.out.println("Add New User");
		System.out.println("************");
		
		System.out.println("");
		
		System.out.print("Enter UserID                     : ");
		String newUserId = br.readLine();
		System.out.print("Enter Password                   : ");
		String newPassword = br.readLine();
		System.out.print("Enter Name                       : ");
		String newName = br.readLine();
		System.out.print("Enter Incorrect Attempts         : ");
		int newIncorrectAttempts = Integer.parseInt(br.readLine());
		System.out.print("Enter Lock Status                : ");
		int newLockStatus = Integer.parseInt(br.readLine());
		String newUserType = "";
		while(true) {
			System.out.print("Enter User Type (Admin/Employee) : ");
			newUserType = br.readLine();
			if(newUserType.equalsIgnoreCase("Admin") || newUserType.equalsIgnoreCase("Employee")) {
				break;
			}
		}
		
		System.out.println("");
		
		UserBean newUser = new UserBean(newUserId, newPassword, newName, newIncorrectAttempts, newLockStatus, newUserType);
		String message05 = dao.addUser_1(newUser);
		System.out.println("New User Added : " + message05);
	}
}
