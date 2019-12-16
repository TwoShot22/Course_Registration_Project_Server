package home.controls;

import java.io.FileNotFoundException;
import java.util.Vector;

import home.daos.TableDao;
import home.frameworks.TableInterface;
import home.model.DirectoryModel;
import home.model.LectureModel;
import home.model.UserModel;

public class TableControl implements TableInterface {	
	TableDao tableDao = new TableDao();

    public UserModel checkCurrentUser() {
		return tableDao.checkCurrentUser();
    }
    
    // Directory Methods

    // [Campus] File Read and Add Items
    public Vector<DirectoryModel> getCampusData(String fileName) throws FileNotFoundException {
        return tableDao.getCampusData(fileName);
    }

    // [College] File Read and Add Items
    public Vector<DirectoryModel> getCollegeData(String fileName) throws FileNotFoundException {
        return tableDao.getCollegeData(fileName);
    }

    // [Department] File Read and Add Items
    public Vector<DirectoryModel> getDepartmentData(String fileName) throws FileNotFoundException {
        return tableDao.getDepartmentData(fileName);
    }

    // Lecture Methods
    public Vector<LectureModel> getLectureData(String fileName) throws FileNotFoundException{
        return tableDao.getLectureData(fileName);
    }
}