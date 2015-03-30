package idv.hsiehpinghan.thsr.ocr.impl;

import idv.hsiehpinghan.thsr.ocr.PixelImage;
import idv.hsiehpinghan.thsr.ocr.PixelImageFilter;

/**
 * 負責台灣高速鐵路像素影像的過濾。
 * @author 謝秉翰
 *
 */
public class PixelImageFilterImpl extends PixelImageFilter {
	/**
	 * 設定所欲過濾的像素影像。
	 * @param pixelImage 所欲過濾的像素影像。
	 */
	public PixelImageFilterImpl(PixelImage pixelImage) {
		super(pixelImage);
	}

	/**
	 * 依台灣高速鐵路的方式過濾像素影像。
	 * @return 過濾後的像素影像。
	 */
	@Override
	public PixelImage filter() {
		int width = this.pixelImage.getWidth();
		int height = this.pixelImage.getHeight();
		int[] imagePixels = this.pixelImage.getImagePixels();
		int[] result = new int[width * height];
		int red = 0;
		int green = 0;
		int blue = 0;
		for (int i = 0, length = imagePixels.length; i < length; ++i) {
			red = (imagePixels[i] >> 16) & 0xff;
			green = (imagePixels[i] >> 8) & 0xff;
			blue = (imagePixels[i]) & 0xff;

			if(red > 250 && green > 250 && blue > 250) {
				result[i] = 1;
			} else {
				result[i] = 0;
			}

		}	
		return new PixelImage(width, height, result);
	}
}
