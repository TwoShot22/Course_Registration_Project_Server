package home.controls;

import home.daos.UserInfoDao;
import home.frameworks.UserInfoInterface;
import home.model.UserModel;

public class UserInfoControl implements UserInfoInterface {	
	UserInfoDao userInfoDao = new UserInfoDao();
	
	public UserModel checkCurrentUser() {
		return userInfoDao.checkCurrentUser();
	}
	
}
