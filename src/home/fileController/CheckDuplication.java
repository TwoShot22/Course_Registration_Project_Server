package home.fileController;

import home.daos.CheckDuplicationDao;
import home.frameworks.CheckDuplicationInterface;

public class CheckDuplication implements CheckDuplicationInterface{
	
	CheckDuplicationDao checkDuplicationDao = new CheckDuplicationDao();

	public boolean checkOverLapData(String str1, String str2) {
		return checkDuplicationDao.checkOverLapData(str2, str2);
	}
	
	public void manageLectureFile(String selectedLectures, String targetFileName, String mode) {
		checkDuplicationDao.manageLectureFile(selectedLectures, targetFileName, mode);
	}
	
	public void manageUserFile(String userInfo, String TargetFileName) {
		checkDuplicationDao.manageUserFile(userInfo, TargetFileName);
	}
	
	public void manageCurrentUser(String userInfo, String TargetFileName) {		
		checkDuplicationDao.manageCurrentUser(userInfo, TargetFileName);
	}
}
