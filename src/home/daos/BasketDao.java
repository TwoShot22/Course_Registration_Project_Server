package home.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import home.model.LectureModel;
import home.model.UserModel;

public class BasketDao {
	private Vector<LectureModel> basketModels;
	private Vector<LectureModel> registerModels;
	
	// Check Login User
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
	
	// Load Data Method
	public Vector<LectureModel> getBasketData(String fileName) throws FileNotFoundException{
		basketModels = new Vector<LectureModel>();

		Scanner scanner = new Scanner(new File(fileName));

		while(scanner.hasNext()) {
			LectureModel lectureModel = new LectureModel();
			lectureModel.read(scanner);
			basketModels.add(lectureModel);
		}
		scanner.close();
		return basketModels;
	} 
	
	public Vector<LectureModel> getRegisterData(String fileName) throws FileNotFoundException{
		registerModels = new Vector<LectureModel>();

		Scanner scanner = new Scanner(new File(fileName));

		while(scanner.hasNext()) {
			LectureModel registerModel = new LectureModel();
			registerModel.read(scanner);
			registerModels.add(registerModel);
		}
		scanner.close();
		return registerModels;
	} 
}
