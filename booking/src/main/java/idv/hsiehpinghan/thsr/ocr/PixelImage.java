package idv.hsiehpinghan.thsr.ocr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

import javax.imageio.ImageIO;

/**
 * 像素影像物件。
 * @author 謝秉翰
 *
 */
public class PixelImage implements Serializable {
	private static final long serialVersionUID = 20130110L;
	protected int width = 0;
	protected int height = 0;
	protected int[] imagePixels = null;

	/**
	 * 預設的建構式。
	 */
	public PixelImage() {
	}

	/**
	 * 將影像檔案轉換成像素影像。
	 * @param imageFile 影像檔案。
	 */
	public PixelImage(File imageFile) {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(imageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init(bufferedImage);
	}
	
	/**
	 * 將緩存影像轉換成像素影像。
	 * @param bufferedImage 緩存影像。
	 */
	public PixelImage(BufferedImage bufferedImage) {
		init(bufferedImage);
	}

	/**
	 * 設定本物件的寬、高及像素影像。
	 * @param width 像素影像的寬。
	 * @param height 像素影像的高。
	 * @param imagePixels 像素影像。
	 */
	public PixelImage(int width, int height, int[] imagePixels) {
		init(width, height, imagePixels);
	}

	/**
	 * 複製像素影像。
	 * @param pixelImage 像素影像。
	 */
	public PixelImage(PixelImage pixelImage) {
		int width = pixelImage.getWidth();
		int height = pixelImage.getHeight();
		int[] imagePixels = pixelImage.getImagePixels();
		init(width, height, imagePixels);
	}

	/**
	 * 取得特定區域的像素影像。
	 * @param startXAxis 回傳像素影像在原始像素影像的x輸開始位置。
	 * @param startYAxis 回傳像素影像在原始像素影像的y軸開始位置。
	 * @param width 回傳像素影像的寬。
	 * @param height 回傳像素影像的高。
	 * @return 特定區域的像素影像。
	 */
	public PixelImage getSubPixelImage(int startXAxis, int startYAxis, int width, int height) {
		int[] imagePixels = new int[width * height];
		
		for(int i = 0, sourcePosition = startYAxis * this.width + startXAxis, destinationPosition = 0; i < height; ++i, sourcePosition += this.width, destinationPosition += width) {
			System.arraycopy(this.imagePixels, sourcePosition, imagePixels, destinationPosition, width);			
		}
		return new PixelImage(width, height, imagePixels);
	}

	/**
	 * 回傳像素影像格式化後的字串。
	 */
	@Override
	public String toString() {
		StringBuilder stringBuffer = new StringBuilder();
		for (int row = 0; row < this.height; ++row) {
			for (int col = 0; col < this.width; ++col) {
				stringBuffer.append(this.imagePixels[row * this.width + col]);
			}
			stringBuffer.append('\n');
		}
		return stringBuffer.toString();
	}
	
	/**
	 * 比較兩像素影像的寬、高及像素是否皆相同。
	 */
	@Override
	public boolean equals(Object object) {
		PixelImage pixelImage = null;
		if(!(object instanceof PixelImage)) {
			return false;
		} else {
			pixelImage = (PixelImage)object;
		}
		
		if(this.width != pixelImage.getWidth() || this.height != pixelImage.getHeight()) {
			return false;
		}
		
		return Arrays.equals(this.imagePixels, pixelImage.getImagePixels());
	}
	
	/**
	 * 將bufferedImage轉換成本物件。
	 * @param bufferedImage 緩存影像。
	 */
	private void init(BufferedImage bufferedImage) {
		int width = bufferedImage.getWidth();
		int height = bufferedImage.getHeight();
		int[] imagePixels = new int[width * height];
		bufferedImage.getRGB(0, 0, width, height, imagePixels, 0, width);
		init(width, height, imagePixels);
	}
	
	/**
	 * 設定本物件的寬、高及像素影像。
	 * @param width 像素影像的寬。
	 * @param height 像素影像的高。
	 * @param imagePixels 像素影像。
	 */
	private void init(int width, int height, int[] imagePixels) {
		this.width = width;
		this.height = height;
		this.imagePixels = imagePixels;
	}
	
	/**
	 * getter。
	 * @return 像素影像的寬。
	 */
	public int getWidth() {
		return this.width;
	}
	
	/**
	 * getter。
	 * @return 像素影像的高。
	 */
	public int getHeight() {
		return this.height;
	}
	
	/**
	 * getter。
	 * @return 像素影像。
	 */
	public int[] getImagePixels() {
		return this.imagePixels;
	}
}
