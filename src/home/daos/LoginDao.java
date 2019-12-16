package home.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import home.model.UserModel;

public class LoginDao {

	UserModel user = new UserModel();
	
	public UserModel getUser() {
		return user;
	}
	
	// Login DB 읽기 전용 메소드
	public void read(Scanner scanner) {
		user.setUserID(scanner.next());
		user.setUserPassword(scanner.next());
		user.setUserName(scanner.next());
		user.setUserCollege(scanner.next());
		user.setUserDepartment(scanner.next());
		user.setUserNumber(scanner.next());
	}
	
	// Login DB와 사용자 입력값 비교 메소드
	public boolean authenticate(String inputID, String inputPassword) throws FileNotFoundException{
		Scanner scanner;
		scanner = new Scanner(new File("data/user/Login"));
			
		while(scanner.hasNext()) {
			this.read(scanner);

			if(user.getUserID().equals(inputID)&&user.getUserPassword().equals(inputPassword)) {
				scanner.close();
				return true;
			}
		}
		scanner.close();
		return false;
	}

}
