package idv.hsiehpinghan.thsr.ocr.exception;

public class ImageUnrecongnizeException extends Exception {
	private static final long serialVersionUID = 20130109L;

	/**
	 * 無法辦識圖檔文字的例外。
	 * @param message 欲輸出的訊息。
	 */
	public ImageUnrecongnizeException(String message) {
		super(message);
	}
}
