package idv.hsiehpinghan.thsr.ocr.impl;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import idv.hsiehpinghan.thsr.pojo.PixelImageArea;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PixelImageImplTest {
	@DataProvider
	public Object[][] getNextNotAllElementsZeroColumn() {
		return new Object[][] {
				{new PixelImageArea(15, 10, 55, 15), 20} };
	}

	@Test(dataProvider = "getNextNotAllElementsZeroColumn", enabled = false)
	public void getNextNotAllElementsZeroColumn(PixelImageArea pixelImageArea, int expectedResult) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(".\\src\\test\\resources\\png images\\2NG6.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PixelImageImpl thsrPixelImage = new PixelImageImpl(image);
		
		int startColumn = pixelImageArea.getStartColumn();
		int startRow = pixelImageArea.getStartRow();
		int width = pixelImageArea.getWidth();
		int height = pixelImageArea.getHeight();
		int result = thsrPixelImage.getNextNotAllElementsZeroColumn(startColumn, startRow, width, height);
		Assert.assertEquals(result, expectedResult);
	}
	
	@DataProvider
	public Object[][] getNextAllElementsZeroColumn() {
		return new Object[][] {
				{new PixelImageArea(20, 10, 55, 15), 28} };
	}

	@Test(dataProvider = "getNextAllElementsZeroColumn", enabled = false)
	public void getNextAllElementsZeroColumn(PixelImageArea pixelImageArea, int expectedResult) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(".\\src\\test\\resources\\png images\\2NG6.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PixelImageImpl thsrPixelImage = new PixelImageImpl(image);
		
		int startColumn = pixelImageArea.getStartColumn();
		int startRow = pixelImageArea.getStartRow();
		int width = pixelImageArea.getWidth();
		int height = pixelImageArea.getHeight();
		int result = thsrPixelImage.getNextAllElementsZeroColumn(startColumn, startRow, width, height);
		Assert.assertEquals(result, expectedResult);
	}
	
	@DataProvider
	public Object[][] getNextNotAllElementsZeroRow() {
		return new Object[][] {
				{new PixelImageArea(20, 10, 28, 15), 11} };
	}

	@Test(dataProvider = "getNextNotAllElementsZeroRow", enabled = false)
	public void getNextNotAllElementsZeroRow(PixelImageArea pixelImageArea, int expectedResult) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(".\\src\\test\\resources\\png images\\2NG6.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PixelImageImpl thsrPixelImage = new PixelImageImpl(image);
		
		int startColumn = pixelImageArea.getStartColumn();
		int startRow = pixelImageArea.getStartRow();
		int width = pixelImageArea.getWidth();
		int height = pixelImageArea.getHeight();

		int result = thsrPixelImage.getNextNotAllElementsZeroRow(startColumn, startRow, width, height);
		Assert.assertEquals(result, expectedResult);
	}
	
	@DataProvider
	public Object[][] getNextAllElementsZeroRow() {
		return new Object[][] {
				{new PixelImageArea(20, 11, 28, 15), 23} };
	}

	@Test(dataProvider = "getNextAllElementsZeroRow", enabled = false)
	public void getNextAllElementsZeroRow(PixelImageArea pixelImageArea, int expectedResult) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(".\\src\\test\\resources\\png images\\2NG6.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PixelImageImpl thsrPixelImage = new PixelImageImpl(image);
		
		int startColumn = pixelImageArea.getStartColumn();
		int startRow = pixelImageArea.getStartRow();
		int width = pixelImageArea.getWidth();
		int height = pixelImageArea.getHeight();

		int result = thsrPixelImage.getNextAllElementsZeroRow(startColumn, startRow, width, height);
		Assert.assertEquals(result, expectedResult);
	}
	
//	public static void main(String[] args ) {
//		BufferedImage image = null;
//		try {
//			image = ImageIO.read(new File(".\\src\\test\\resources\\png images\\2NG6.png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		THSRPixelImage thsrPixelImage = new THSRPixelImage(image);
//		System.out.println(thsrPixelImage);
//	}
}
