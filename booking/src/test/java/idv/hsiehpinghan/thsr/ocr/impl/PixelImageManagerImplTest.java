package idv.hsiehpinghan.thsr.ocr.impl;

import idv.hsiehpinghan.thsr.ocr.PixelImage;
import idv.hsiehpinghan.thsr.ocr.Splitable;
import idv.hsiehpinghan.thsr.pojo.ImageNameAndSplitable;
import idv.hsiehpinghan.thsr.utility.FileUtility;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PixelImageManagerImplTest {
	@DataProvider
	public Object[][] serializePixelImageToTrainingImageFolder() {
		String imageName = "2NG6";
		
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(".\\src\\test\\resources\\png images\\FCT4.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Splitable<PixelImage> splitable = new PixelImageImpl(bufferedImage);
		
		ImageNameAndSplitable<PixelImage> imageNameAndSplitable = new ImageNameAndSplitable<PixelImage>(imageName, splitable);
		
		return new Object[][] {
				{ imageNameAndSplitable, true } };
	}

	@Test(dataProvider = "serializePixelImageToTrainingImageFolder", enabled = false)
	public void serializePixelImageToTrainingImageFolder(ImageNameAndSplitable<PixelImage> imageNameAndSplitable, boolean expectedResult) {
		File file = FileUtility.getFile(new File(".\\src\\test\\resources\\HsiehPingHanTestFolder\\serializePixelImageToTrainingImageFolderTest"));
		PixelImageManagerImpl thsrixelImageManager = new PixelImageManagerImpl(file);
		boolean isSuccess = thsrixelImageManager.serializePixelImageToTrainingImageFolder(imageNameAndSplitable.getImageName(), imageNameAndSplitable.getSplitable());
		Assert.assertEquals(isSuccess, expectedResult);
	}
}
