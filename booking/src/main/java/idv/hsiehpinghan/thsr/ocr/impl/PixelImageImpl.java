package idv.hsiehpinghan.thsr.ocr.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import idv.hsiehpinghan.thsr.ocr.PixelImage;
import idv.hsiehpinghan.thsr.ocr.PixelImageFilter;
import idv.hsiehpinghan.thsr.ocr.Splitable;

/**
 * 台灣高速鐵路的像素影像物件。
 * @author 謝秉翰
 *
 */
public class PixelImageImpl extends PixelImage implements Splitable<PixelImage> {
	private static final long serialVersionUID = 20130110L;

	/**
	 * 將緩存影像轉換像素影像，並以台灣高速鐵路的過濾器過濾。
	 * @param bufferedImage 欲轉換的緩存影像。
	 */
	public PixelImageImpl(BufferedImage bufferedImage) {
		init(bufferedImage);
	}
	
	/**
	 * 將影像檔案轉換像素影像，並以台灣高速鐵路的過濾器過濾。
	 * @param imageFile 欲轉換的影像檔案。
	 */
	public PixelImageImpl(File imageFile) {
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
	 * 將影像InputStream轉換像素影像，並以台灣高速鐵路的過濾器過濾。
	 * @param imageInputStream 欲轉換的影像InputStream。
	 */
	public PixelImageImpl(InputStream imageInputStream) {
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(imageInputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		init(bufferedImage);
	}
	
	/**
	 * 設定本物件。
	 * @param bufferedImage 欲轉換的緩存影像。
	 */
	private void init(BufferedImage bufferedImage) {
		PixelImage pixelImage = new PixelImage(bufferedImage);
		PixelImageFilter PixelImageFilter = new PixelImageFilterImpl(pixelImage);
		PixelImage filteredPixelImage = PixelImageFilter.filter();
		this.width = filteredPixelImage.getWidth();
		this.height = filteredPixelImage.getHeight();
		this.imagePixels = filteredPixelImage.getImagePixels();
	}

	/**
	 * 取得像素影像下一個符合條件的column位置。
	 * @param startColumn 開始搜尋的column。
	 * @param startRow 開始搜尋的row。
	 * @param width 掃瞄幾個column。
	 * @param height 掃瞄幾個row。
	 * @param isAllElementsZero 是否搜尋元素全為0的column，若為true則至少需與開始搜尋的column間格5行。
	 * @return 符合條件的column位置。
	 */
	private int getNextColumn(int startColumn, int startRow, int width, int height, boolean isAllElementsZero) {
		int endColumn = startColumn + width;
		for(int col = startColumn , col_count = 0; col < endColumn; ++col, ++col_count) {
			int colSum = 0;
			for(int row = startRow, endRow = startRow + height; row < endRow; ++row) {
				colSum |= this.imagePixels[row * this.width + col];
			}
			
			if(isAllElementsZero) {
				if(colSum == 0 && col_count >= 5) {
					return col;
				}
			} else {
				if(colSum != 0) {
					return col;
				}
			}
		}
		return endColumn;
	}
 
	/**
	 * 取得像素影像下一個元素全為0的column，至少需與開始搜尋的column間格5行。
	 * @param startColumn 開始搜尋的column。
	 * @param startRow 開始搜尋的row。
	 * @param width 掃瞄幾個column。
	 * @param height 掃瞄幾個row。
	 * @return 下一個元素全為0的column。
	 */
	protected int getNextAllElementsZeroColumn(int startColumn, int startRow, int width, int height) {
		return getNextColumn(startColumn, startRow, width, height, true);
	}
	
	/**
	 * 取得像素影像下一個元素非全為0的column。
	 * @param startColumn 開始搜尋的column。
	 * @param startRow 開始搜尋的row。
	 * @param width 掃瞄幾個column。
	 * @param height 掃瞄幾個row。
	 * @return 下一個元素非全為0的column。
	 */
	protected int getNextNotAllElementsZeroColumn(int startColumn, int startRow, int width, int height) {
		return getNextColumn(startColumn, startRow, width, height, false);
	}
	
	/**
	 * 取得像素影像下一個符合條件的row位置。
	 * @param startColumn 開始搜尋的column。
	 * @param startRow 開始搜尋的row。
	 * @param width 掃瞄幾個column。
	 * @param height 掃瞄幾個row。
	 * @param isAllElementsZero 是否搜尋元素全為0的row，若為true則至少需與開始搜尋的row間格5行。
	 * @return 符合條件的row位置。
	 */
	private int getNextRow(int startColumn, int startRow, int width, int height, boolean isAllElementsZero) {
		int endRow = startRow + height;
		for(int row = startRow, row_count = 0; row < endRow; ++row, ++row_count) {
			int rowSum = 0;
			for(int col = startColumn, endColumn = startColumn + width; col < endColumn; ++col) {
				rowSum |= this.imagePixels[row * this.width + col];
			}
			
			if(isAllElementsZero) {
				if(rowSum == 0 && row_count >= 10) {
					return row;
				}
			} else {
				if(rowSum != 0) {
					return row;
				}
			}
		}
		return endRow;
	}
	
	/**
	 * 取得像素影像下一個元素全為0的row，至少需與開始搜尋的row間格5行。
	 * @param startColumn 開始搜尋的column。
	 * @param startRow 開始搜尋的row。
	 * @param width 掃瞄幾個column。
	 * @param height 掃瞄幾個row。
	 * @return 下一個元素全為0的row。
	 */
	protected int getNextAllElementsZeroRow(int startColumn, int startRow, int width, int height) {
		return getNextRow(startColumn, startRow, width, height, true);
	}

	/**
	 * 取得像素影像下一個元素非全為0的row。
	 * @param startColumn 開始搜尋的column。
	 * @param startRow 開始搜尋的row。
	 * @param width 掃瞄幾個column。
	 * @param height 掃瞄幾個row。
	 * @return 下一個元素非全為0的row。
	 */
	protected int getNextNotAllElementsZeroRow(int startColumn, int startRow, int width, int height) {
		return getNextRow(startColumn, startRow, width, height, false);
	}
	
	/**
	 * 將像素影像切割，回傳子像素影像的ArrayList<PixelImage>。
	 * @return 子像素影像，若切割失敗則回傳空的ArrayList<PixelImage>物件。
	 */
	public ArrayList<PixelImage> splitToArrayList() {
		ArrayList<PixelImage> pixelImages = new ArrayList<PixelImage>();
		int startXAxis = 15;
		int endXAxis = 70;
		int startYAxis = 10;
		int endYAxis = 25;
		int notZeroColumn = 0;
		int ZeroColumn = 0;
		int notZeroRow = 0;
		int ZeroRow = 0;
		
		int col = startXAxis;
		while(true) {
			notZeroColumn = getNextNotAllElementsZeroColumn(col, startYAxis, endXAxis - col, endYAxis - startYAxis);
			ZeroColumn = getNextAllElementsZeroColumn(notZeroColumn, startYAxis, endXAxis - notZeroColumn, endYAxis - startYAxis);
			col = ZeroColumn;

			if(col == endXAxis) {
				break;
			} else {
				notZeroRow = getNextRow(notZeroColumn, startYAxis, ZeroColumn - notZeroColumn, endYAxis - startYAxis, false);
				ZeroRow = getNextRow(notZeroColumn, notZeroRow, ZeroColumn - notZeroColumn, endYAxis - notZeroRow, true);
				pixelImages.add(getSubPixelImage(notZeroColumn, notZeroRow, ZeroColumn - notZeroColumn, ZeroRow - notZeroRow));	
			}
		}
		return pixelImages;
	}
}
