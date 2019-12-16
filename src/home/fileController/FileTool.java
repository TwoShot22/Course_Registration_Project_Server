package home.fileController;

import java.util.Vector;

import home.daos.FileToolDao;
import home.frameworks.FileToolInterface;

public class FileTool implements FileToolInterface {
	
	FileToolDao fileToolDao = new FileToolDao();

	public void writeOnTxtFile(Vector<String> selectedItem, String fileName) {
		fileToolDao.writeOnTxtFile(selectedItem, fileName);
	}
	
}
