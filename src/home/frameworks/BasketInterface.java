package home.frameworks;

import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import home.model.LectureModel;
import home.model.UserModel;

public interface BasketInterface extends Stub{
	
	public UserModel checkCurrentUser();
	// Load Data Method
	public Vector<LectureModel> getBasketData(String fileName) throws FileNotFoundException;
	
	public Vector<LectureModel> getRegisterData(String fileName) throws FileNotFoundException;
}