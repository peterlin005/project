package idv.hsiehpinghan.thsr.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class SerializeUtility {
	/**
	 * 將物件序列化存入檔案中。
	 * @param file 檔案
	 * @param object 欲序列化存入的物件。
	 * @return 成功存入與否。
	 */
	public static boolean serializeObject(File file, Object object) {
		File gottenFile = FileUtility.getFile(file);
		if(gottenFile == null) {
			return false;
		}

		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(gottenFile);
			objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(object);
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			StreamUtility.closeOutputStream(objectOutputStream);
			StreamUtility.closeOutputStream(fileOutputStream);
		}
		return false;
	}

	/**
	 * 從file中取得反序列化物件。
	 * @param file 檔案。
	 * @return
	 * 回傳Object物件：
	 * <ol>
	 * <li>反序列化成功。
	 * </ol>
	 * 回傳null：
	 * <ol>
	 * <li>反序列化失敗。
	 * </ol>
	 */
	public static Object deserializeObject(File file) {
		FileInputStream fileInputStream = null;
		ObjectInputStream ObjectInputStream = null;
		Object object = null;
		try {
			fileInputStream = new FileInputStream(file);
			ObjectInputStream = new ObjectInputStream(fileInputStream);
			object = ObjectInputStream.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			StreamUtility.closeInputStream(ObjectInputStream);
			StreamUtility.closeInputStream(fileInputStream);
		}
		return object;
	}

	/**
	 * 將某目錄路徑下的檔案反序列化。
	 * @param directoryFile 目錄檔案。
	 * @return
	 * 回傳key為無附檔名的檔案名稱，value為反列序化物件的Map：
	 * <ol>
	 *  <li>反序列化成功。</li>
	 *  </ol>
	 *  回傳null：
	 *  <ol>
	 *  <li>directoryFile不是目錄檔案。
	 *  </ol>
	 */
	public static Map<String, Object> deserializeObjects(File directoryFile) {
		if(!directoryFile.isDirectory()) {
			return null;
		}
		File[] files = directoryFile.listFiles();
		Map<String, Object> map = new HashMap<String, Object>();
		for (File file : files) {
			String key = FileUtility.getFileNameWithoutExtension(file);
			Object object = deserializeObject(file);
			if(object != null) {
				map.put(key, object);
			}
		}
		return map;
	}
}
