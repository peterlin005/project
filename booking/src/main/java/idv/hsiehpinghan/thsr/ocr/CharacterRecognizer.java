package idv.hsiehpinghan.thsr.ocr;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

/**
 * 負責圖檔字元辨識的類別。
 * @author 謝秉翰
 *
 */
public abstract class CharacterRecognizer {
	/**
	 * 供比對的training image。
	 */
	protected Map<String, PixelImage> trainingPixelImages = null;

	/**
	 * 辨識imageFile中的字串。
	 * @param imageFile 欲辨識的圖檔。
	 * @return 辨識結果字串。
	 */
	public abstract String recognize(File imageFile);
	
	/**
	 * 辨識imageInputStream中的字串。
	 * @param imageInputStream 欲辨識的影像InputStream。
	 * @return 辨識結果字串。
	 */
	public abstract String recognize(InputStream imageInputStream);
}
