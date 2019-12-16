package home.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import home.model.UserModel;

public class SignUpDao {
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
	
	public boolean idAuthenticate(String inputID) throws FileNotFoundException {
		Scanner scanner;
		scanner = new Scanner(new File("data/user/Login"));
		
		while(scanner.hasNext()) {
			this.read(scanner);
			
			if(user.getUserID().equals(inputID)) {
				scanner.close();
				return true;
			}
		}
		
		scanner.close();
		return false;
	}
	
	public boolean personAuthenticate(String inputNumber) throws FileNotFoundException {
		Scanner scanner;
		scanner = new Scanner(new File("data/user/Login"));
		
		while(scanner.hasNext()) {
			this.read(scanner);
			
			if(user.getUserNumber().equals(inputNumber)) {
				scanner.close();
				return true;
			}
		}
		
		scanner.close();
		return false;
	}

	public void createUserData(String id) {
		// TODO Auto-generated method stub
		
		// 회원가입한 사용자의 파일 생성
		try {
			File basket = new File("data/user/" + id + "_Basket");
			basket.createNewFile();
			File register = new File("data/user/" + id + "_Register");
			register.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
