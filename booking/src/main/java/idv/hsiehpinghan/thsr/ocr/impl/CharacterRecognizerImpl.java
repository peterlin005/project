package idv.hsiehpinghan.thsr.ocr.impl;

import idv.hsiehpinghan.thsr.ocr.CharacterRecognizer;
import idv.hsiehpinghan.thsr.ocr.PixelImage;
import idv.hsiehpinghan.thsr.utility.FileUtility;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * 負責台灣高速鐵路圖檔字元辨識的類別。
 * @author 謝秉翰
 *
 */
public class CharacterRecognizerImpl extends CharacterRecognizer {
	public CharacterRecognizerImpl() {
		String serializedImageDirectory = this.getClass().getClassLoader().getResource("THSRSerializedImages").getPath();
		File serializedImageDirectoryFile =  new File(serializedImageDirectory);;
		serializedImageDirectoryFile = FileUtility.getDirectory(serializedImageDirectoryFile);

		PixelImageManagerImpl pixelImageManagerImpl = new PixelImageManagerImpl(serializedImageDirectoryFile);
		this.trainingPixelImages = pixelImageManagerImpl.deserializePixelImagesFromTrainingImageFolder();
	}

	/**
	 * 辨識imageFile中的字串。
	 * @param imageFile 欲辨識的圖檔。
	 * @return 辨識結果字串。
	 */
	@Override
	public String recognize(File imageFile) {
		PixelImageImpl pixelImageImpl = new PixelImageImpl(imageFile);
		return getImageString(pixelImageImpl);
	}

	/**
	 * 辨識imageInputStream中的字串。
	 * @param imageInputStream 欲辨識的影像InputStream。
	 * @return 辨識結果字串。
	 */
	@Override
	public String recognize(InputStream imageInputStream) {
		PixelImageImpl pixelImageImpl = new PixelImageImpl(imageInputStream);
		return getImageString(pixelImageImpl);
	}
	
	/**
	 * 辦識台灣高速鐵路像素影像物件中的字串。
	 * @param thsrPixelImage 台灣高速鐵路像素影像物件。
	 * @return 台灣高速鐵路像素影像物件中的字串。
	 */
	private String getImageString(PixelImageImpl pixelImageImpl) {
		StringBuilder recognizedCharacters = new StringBuilder();
		ArrayList<PixelImage> subPixelImages = pixelImageImpl.splitToArrayList();

		for(PixelImage subPixelImage : subPixelImages) {
			Iterator<Entry<String, PixelImage>> iterator = this.trainingPixelImages.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<String, PixelImage> entry = iterator.next();
				if(subPixelImage.equals(entry.getValue())) {
					recognizedCharacters.append(entry.getKey());
				}
			}
		}
		return recognizedCharacters.toString();
	}
}
