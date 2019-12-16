package home.controls;

import java.io.FileNotFoundException;

import home.daos.LoginDao;
import home.frameworks.LoginInterface;
import home.model.UserModel;

public class LoginControl implements LoginInterface {	
	LoginDao loginDao = new LoginDao();
	
	public UserModel getUser() {
		return loginDao.getUser();
	}
	
	// Login DB와 사용자 입력값 비교 메소드
		public boolean authenticate(String inputID, String inputPassword) throws FileNotFoundException{
			return loginDao.authenticate(inputID, inputPassword);
		}
	
}