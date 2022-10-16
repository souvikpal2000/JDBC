import java.io.*;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		UserDAO dao = new UserDAO();
		
		System.out.println("Display UserType");
		System.out.println("****************");
		System.out.println("");
		
		System.out.print("Enter UserID present in DB : ");
		String userId01 = br.readLine();
		String userType = dao.getUserType(userId01);
		System.out.println("User Type of " + userId01 + " : " + userType);
		
		System.out.println("");
		
		System.out.println("Display Incorrect Attempts");
		System.out.println("**************************");
		System.out.println("");
		
		System.out.print("Enter UserID present in DB : ");
		String userId02 = br.readLine();
		String message01 = dao.getIncorrectAttempts(userId02);
		System.out.println("Incorrect Attempts of " + userId02 + " : " + message01);
		
		System.out.println("");
		
		System.out.println("Change UserType to Admin");
		System.out.println("************************");
		System.out.println("");
		
		System.out.print("Enter UserID present in DB : ");
		String userId03 = br.readLine();
		String message02 = dao.changeUserType(userId03);
		System.out.println("Changed UserType of " + userId03 + " : " + message02);
		
		System.out.println("");
		
		int count = dao.getLockStatus();
		System.out.println("Total Number of Lock Status equal to ZERO : " + count);
		
		System.out.println("");
		
		System.out.println("Change Name");
		System.out.println("***********");
		System.out.println("");
		
		System.out.print("Enter UserID present in DB : ");
		String userId04 = br.readLine();
		System.out.print("Enter Any Name to Update Name of UserID " + userId04 + " : ");
		String name = br.readLine();
		String message03 = dao.changeName(userId04, name);
		System.out.println("Name of UserID " + userId04 + " Updated : " + message03);
		
		System.out.println("");
		
		System.out.println("Change Admin Password");
		System.out.println("*********************");
		System.out.println("");
		
		System.out.print("Enter New Password for Admins : ");
		String password = br.readLine();
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
		
		System.out.println("");
		
		System.out.println("Add New User with Lock Status 0");
		System.out.println("*******************************");
		System.out.println("");
		
		System.out.print("Enter UserID                     : ");
		String newUserId02 = br.readLine();
		System.out.print("Enter Password                   : ");
		String newPassword02 = br.readLine();
		System.out.print("Enter Name                       : ");
		String newName02 = br.readLine();
		System.out.print("Enter Incorrect Attempts         : ");
		int newIncorrectAttempts02 = Integer.parseInt(br.readLine());
		System.out.print("Enter Lock Status                : ");
		int newLockStatus02 = Integer.parseInt(br.readLine());
		String newUserType02 = "";
		while(true) {
			System.out.print("Enter User Type (Admin/Employee) : ");
			newUserType02 = br.readLine();
			if(newUserType02.equalsIgnoreCase("Admin") || newUserType02.equalsIgnoreCase("Employee")) {
				break;
			}
		}
		
		System.out.println("");
		
		UserBean newUser02 = new UserBean(newUserId02, newPassword02, newName02, newIncorrectAttempts02, newLockStatus02, newUserType02);
		String message06 = dao.addUser_2(newUser02);
		System.out.println("New User Added : " + message06);
		
		System.out.println("");
		
		System.out.println("Display Users by UserType");
		System.out.println("*************************");
		System.out.println("");
		
		System.out.print("Enter UserType : ");
		String searchByUserType = br.readLine();
		System.out.println("");
		
		ArrayList<UserBean> list = dao.getUsers(searchByUserType);
		for(UserBean bean : list) {
			System.out.println(bean);
		}
		
		System.out.println("");
		
		System.out.println("Display All Users");
		System.out.println("*****************");
		System.out.println("");
		
		ArrayList<UserBean> l = dao.storeAllRecords();
		for(UserBean bean : l) {
			System.out.println(bean);
		}
	}
}
