package idv.hsiehpinghan.thsr.ocr;

/**
 * 負責像素影像的過濾。
 * @author 謝秉翰
 *
 */
public abstract class PixelImageFilter {
	protected PixelImage pixelImage;
	
	/**
	 * 設定所欲過濾的像素影像。
	 * @param pixelImage 所欲過濾的像素影像。
	 */
	protected PixelImageFilter(PixelImage pixelImage) {
		this.pixelImage = pixelImage;
	}
	
	/**
	 * 過濾像素影像。
	 * @return 過濾後的像素影像。
	 */
	public abstract PixelImage filter();
}
