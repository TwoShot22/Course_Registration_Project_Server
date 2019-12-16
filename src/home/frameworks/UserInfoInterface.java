package home.frameworks;

import java.rmi.Remote;
import java.rmi.RemoteException;

import home.model.UserModel;

public interface UserInfoInterface extends Stub {
	
	public UserModel checkCurrentUser();
}
