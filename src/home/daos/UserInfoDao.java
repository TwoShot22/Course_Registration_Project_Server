package home.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import home.model.UserModel;

public class UserInfoDao {
	
	public UserModel checkCurrentUser() {
		Scanner scanner;
		UserModel user = new UserModel();
		try {
			scanner = new Scanner(new File("data/user/CurrentUser"));
	
			while(scanner.hasNext()) {
				user.setUserID(scanner.next());
				user.setUserName(scanner.next());
				user.setUserCollege(scanner.next());
				user.setUserDepartment(scanner.next());
				user.setUserNumber(scanner.next());		
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return user;
	}
}
