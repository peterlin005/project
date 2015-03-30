package idv.hsiehpinghan.thsr.ocr;

import java.io.File;
import java.util.Map;

/**
 * 負積serialized image的儲存與取得。
 * @author 謝秉翰
 *
 */
public abstract class PixelImageManager {
	/**
	 * 將directoryFile資料夾下的檔案序列化到serialized image資料夾。
	 * @param directoryFile 欲序列化檔案的資料夾。
	 */
	public abstract void serializePixelImagesToTrainingImageFolder(File directoryFile);	
	
	/**
	 * 將splitablePixelImage切割後存入serialized image資料夾，檔名參考imageName命名。
	 * @param imageName 供序列化後的檔案命名的參考。
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
	protected abstract boolean serializePixelImageToTrainingImageFolder(String imageName, Splitable<PixelImage> splitablePixelImage);

	/**
	 * 反序列化像素影像檔案。
	 * @return 回傳Key為無附檔名的檔名，value為像素影像物件的Map。
	 */
	protected abstract Map<String, PixelImage> deserializePixelImagesFromTrainingImageFolder();
}
