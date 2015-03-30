package idv.hsiehpinghan.thsr.ocr.impl;

import idv.hsiehpinghan.thsr.ocr.PixelImage;
import idv.hsiehpinghan.thsr.ocr.PixelImageManager;
import idv.hsiehpinghan.thsr.ocr.Splitable;
import idv.hsiehpinghan.thsr.utility.ConsoleUtility;
import idv.hsiehpinghan.thsr.utility.FileUtility;
import idv.hsiehpinghan.thsr.utility.SerializeUtility;
import idv.hsiehpinghan.thsr.utility.StringUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 負責台灣高速鐵路serialized image像素影像的儲存與提取。
 * @author 謝秉翰
 *
 */
public class PixelImageManagerImpl extends PixelImageManager {
	private File serializedImageDirectoryFile;

	/**
	 * 設定serialized Images的資料夾。
	 * @param serializedImageDirectoryFile 存放serialized Images的資料夾。
	 */
	public PixelImageManagerImpl(File serializedImageDirectoryFile) {
		this.serializedImageDirectoryFile = serializedImageDirectoryFile;
	}

	/**
	 * 將directoryFile資料夾下的檔案序列化到serialized image資料夾。
	 * @param directoryFile 欲序列化檔案的資料夾。
	 */
	@Override
	public void serializePixelImagesToTrainingImageFolder(File directoryFile) {
		File[] files = directoryFile.listFiles();
		for(File file : files) {
			String imageName = FileUtility.getFileNameWithoutExtension(file);
			PixelImageImpl pixelImageImpl = new PixelImageImpl(file);
			
			boolean isSuccess = serializePixelImageToTrainingImageFolder(imageName, pixelImageImpl );
			if(!isSuccess) {
				Logger logger = Logger.getLogger(PixelImageManagerImpl.class.getName());
				logger.log(Level.WARNING, "!isSuccess");
			}
		}
	}
	
	/**
	 * 將splitablePixelImage切割後存入serialized image資料夾，檔名以imageName的字元命名，附檔名為ser。
	 * @param imageName splitablePixelImage的名稱，長度需與splitablePixelImage切割後的長度相等，否則將不會被儲存。
	 * @param splitablePixelImage 欲切割後序列化儲存的物件。
	 * @return
	 * 回傳true：
	 * <ol>
	 * <li>序列化成功。</li>
	 * </ol>
	 * 回傳false：
	 * <ol>
	 * <li>序列化失敗。</li>
	 * </ol>
	 */
	@Override
	protected boolean serializePixelImageToTrainingImageFolder(String imageName, Splitable<PixelImage> splitablePixelImage) {
		ArrayList<PixelImage> pixelImages = splitablePixelImage.splitToArrayList();
		int pixelImageLength = pixelImages.size();
		ArrayList<String> subImageNames = StringUtility.getCharacterStringArray(imageName);
		int subImageNamesLength = subImageNames.size();

		if(pixelImageLength != subImageNamesLength) {
			subImageNames = getImageNamesFromConsoleInput(pixelImages);
		}
		
		for(int i = 0; i < pixelImageLength; ++i) {
			File file = new File(this.serializedImageDirectoryFile.getAbsolutePath(), subImageNames.get(i) + ".ser");
			SerializeUtility.serializeObject(file, pixelImages.get(i));
		}
		return true;
	}
	
	/**
	 * 請使用者由終端機輸入檔名。
	 * @param pixelImages 欲取名的像素影像ArrayList。
	 * @return 命名完成後的ArrayList。
	 */
	private ArrayList<String> getImageNamesFromConsoleInput(ArrayList<PixelImage> pixelImages) {
		ArrayList<String>arrayList = new ArrayList<String>();
		for(PixelImage pixelImage : pixelImages) {
			System.out.println(pixelImage);
			arrayList.add(ConsoleUtility.getConsoleInput("Please input file name"));
		}
		return arrayList;
	}
	
	/**
	 * 反序列化像素影像檔案。
	 * @return 回傳Key為無附檔名的檔名，value為像素影像物件的Map：
	 */
	@Override
	protected Map<String, PixelImage>deserializePixelImagesFromTrainingImageFolder() {
		Map<String, Object> map_source = SerializeUtility.deserializeObjects(serializedImageDirectoryFile);
		Map<String, PixelImage> map_result = new HashMap<String, PixelImage>();

		Iterator<Entry<String, Object>> iterator = map_source.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next(); 
			map_result.put(entry.getKey(), (PixelImage)entry.getValue());
			
//			if(entry.getKey().equals("8")) {
//				System.out.println(entry.getKey());
//				System.out.println((PixelImage)entry.getValue());
//			}
			
			
		}

		return map_result;
	}
	
	/**
	 * 手動執行serialized image序列化。
	 * @param args
	 */
//	public static void main(String[] args) {
//		File traningImageDirectoryFile = FileUtility.getDirectory(new File(".\\src\\main\\resources\\THSRSerializedImages\\"));
//		PixelImageManager pixelImageManager = new PixelImageManagerImpl(traningImageDirectoryFile);
//		File srcDirectoryFile = new File(".\\src\\test\\resources\\png images\\");
//		pixelImageManager.serializePixelImagesToTrainingImageFolder(srcDirectoryFile);
//	}
}
