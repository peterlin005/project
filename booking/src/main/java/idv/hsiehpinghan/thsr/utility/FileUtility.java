package idv.hsiehpinghan.thsr.utility;

import java.io.File;
import java.io.IOException;

/**
 * 檔案相關的工具類別。
 * @author 謝秉翰
 *
 */
public class FileUtility {
//	 /**
//	 * 取得某目錄下不包括目錄的所有檔案。
//	 * @param directoryFile 目錄檔案。
//	 * @return
//	 * 回傳File[]：
//	 * <ol> 
//	 * <li>取得檔案成功。</li>
//	 * </ol>
//	 * 回傳null：
//	 * <ol>
//	 * <li>不存在directoryFile這個檔案。</li>
//	 * <li>directoryFile不是目錄檔案。</li>
//	 * </ol>
//	 */
//	public static File[] getFiles(File directoryFile) {
//		if(!directoryFile.exists()) {
//			return null;
//		}
//		
//		if(!directoryFile.isDirectory()) {
//			return null;
//		}
//		
//		return directoryFile.listFiles();
//	}

	/**
	 * 取得檔案的附檔名。
	 * @param fileName 檔案名。
	 * @return 檔案的附檔名。
	 */
	private static String getFileNameExtension(String fileName) {
		int punchIndex = fileName.lastIndexOf('.');
		if(punchIndex == -1) {
			return "";
		} else {
			return fileName.substring(punchIndex + 1);
		}
	}
	
	/**
	 * 取得檔案的附檔名。
	 * @param file 檔案。
	 * @return 檔案的附檔名。
	 */
	public static String getFileNameExtension(File file) {
		String fileName = file.getName();
		return getFileNameExtension(fileName);
	}

	/**
	 * 取得無附檔名的檔案名。
	 * @param fileName 檔案名。
	 * @return 無附檔名的檔案名。
	 */
	private static String getFileNameWithoutExtension(String fileName) {
		int punchIndex = fileName.lastIndexOf('.');
		if(punchIndex == -1) {
			return fileName;
		} else {
			return fileName.substring(0, punchIndex);
		}
	}
	
	public static String getFileNameWithoutExtension(File file) {
		String fileName = file.getName();
		return getFileNameWithoutExtension(fileName);
	}

	/**
	 * 建立目錄。
	 * @param directoryFile 目錄檔案。
	 * @return
	 * 回傳目錄的File物件：
	 * <ol>
	 * <li>建立目錄成功。
	 * <li>該目錄已存在。
	 * </ol>
	 * 回傳null：
	 * <ol>
	 * <li>建立目錄失敗。
	 * <li>directoryFile參數非目錄。
	 * </ol>
	 */
	public static File getDirectory(File directoryFile) {
		if(directoryFile.exists() && directoryFile.isDirectory()) {
			return directoryFile;
		}
		boolean isSuccess = directoryFile.mkdirs();
		if(isSuccess) {
			return directoryFile;
		} else {
			return null;
		}
	}
	
	/**
	 * 建立新檔案。
	 * @param file 檔案。
	 * @return
	 * 回傳File物件：
	 * <ol>
	 * <li>建立檔案成功。
	 * </ol>
	 * 回傳null：
	 * <ol>
	 * <li>建立檔案失敗。
	 * <li>該檔案已存在。
	 * </ol>
	 */
	public static File createFile(File file) {
		if(file.exists()) {
			return null;
		} 		

		File directoryfile = getDirectory(file.getParentFile());
		if(directoryfile == null) {
			return null;
		}

		boolean isCreateNewFileSuccess;
		try {
			isCreateNewFileSuccess = file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.printStackTrace();
			return null;
		}
		if(!isCreateNewFileSuccess) {
			return null;
		}

		return file;
	}
	
	/**
	 * 刪除檔案。
	 * @param file 欲刪除的檔案。
	 * @return
	 * 回傳true：
	 * <ol>
	 * <li>成功刪除檔案。</li>
	 * <li>無該檔案。</li>
	 * </ol>
	 * 回傳false：
	 * <ol>
	 * <li>刪除檔案失敗。</li>
	 * <li>傳入參數非檔案格式。</li>
	 * </ol>
	 */
	public static boolean deleteFile(File file) {
		if(!file.exists()) {
			return true;
		}
		
		if(!file.isFile()) {
			return false;
		}
		
		boolean isDeleteSuccess = file.delete();
		if(!isDeleteSuccess) {
			return false;
		}

		return true;
	}
	
	/**
	 * 取得檔案。
	 * @param file 檔案。
	 * @return
	 * 回傳File：
	 * <ol>
	 * <li>檔案已存在則回傳參數檔案。
	 * <li>檔案不存在則新建檔案並回傳。
	 * </ol>
	 * 回傳null：
	 * <ol>
	 * <li>建立檔案失敗。
	 * </ol>
	 */
	public static File getFile(File file) {
		if(file.exists()) {
			return file;
		}
		
		File createdFile = createFile(file);
		return createdFile;
	}
}
