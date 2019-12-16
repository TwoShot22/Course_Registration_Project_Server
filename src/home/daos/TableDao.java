package home.daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import home.model.DirectoryModel;
import home.model.LectureModel;
import home.model.UserModel;

public class TableDao {

	private Vector<DirectoryModel> campusModels;
    private Vector<DirectoryModel> collegeModels;
    private Vector<DirectoryModel> departmentModels;
    private Vector<LectureModel> lectureModels;

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
    
    // Directory Methods

    // [Campus] File Read and Add Items
    public Vector<DirectoryModel> getCampusData(String fileName) throws FileNotFoundException {
        campusModels = new Vector<DirectoryModel>();

        Scanner scanner = new Scanner(new File(fileName));

        while(scanner.hasNext()) {
            DirectoryModel campusModel = new DirectoryModel();
            campusModel.read(scanner);
            campusModels.add(campusModel);
        }
        scanner.close();
        return campusModels;
    }

    
    // [College] File Read and Add Items
    public Vector<DirectoryModel> getCollegeData(String fileName) throws FileNotFoundException {
        collegeModels = new Vector<DirectoryModel>();

        Scanner scanner = new Scanner(new File(fileName));

        while(scanner.hasNext()) {
            DirectoryModel collegeModel = new DirectoryModel();
            collegeModel.read(scanner);
            collegeModels.add(collegeModel);
        }
        scanner.close();
        return collegeModels;
    }

    // [Department] File Read and Add Items
    public Vector<DirectoryModel> getDepartmentData(String fileName) throws FileNotFoundException {
        departmentModels = new Vector<DirectoryModel>();

        Scanner scanner = new Scanner(new File(fileName));

        while(scanner.hasNext()) {
            DirectoryModel departmentModel = new DirectoryModel();
            departmentModel.read(scanner);
            departmentModels.add(departmentModel);
        }
        scanner.close();
        return departmentModels;
    }

    // Lecture Methods

    public Vector<LectureModel> getLectureData(String fileName) throws FileNotFoundException{
        lectureModels = new Vector<LectureModel>();

        Scanner scanner = new Scanner(new File(fileName));

        while(scanner.hasNext()) {
            LectureModel lectureModel = new LectureModel();
            lectureModel.read(scanner);
            lectureModels.add(lectureModel);
        }
        scanner.close();
        return lectureModels;
    }
	
}
