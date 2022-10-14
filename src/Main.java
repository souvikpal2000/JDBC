import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		System.out.print("Enter UserID : ");
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
		
	}
}
