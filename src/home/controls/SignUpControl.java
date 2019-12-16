package home.controls;

import java.io.FileNotFoundException;

import home.daos.SignUpDao;
import home.frameworks.SignUpInterface;

public class SignUpControl implements SignUpInterface {	
	SignUpDao signUpDao = new SignUpDao();
	
	public boolean idAuthenticate(String inputID) throws FileNotFoundException {
		return signUpDao.idAuthenticate(inputID);
	}
	
	public boolean personAuthenticate(String inputNumber) throws FileNotFoundException {
		return signUpDao.personAuthenticate(inputNumber);
	}
	
	public void createUserData(String id) {
		signUpDao.createUserData(id);
	}
}