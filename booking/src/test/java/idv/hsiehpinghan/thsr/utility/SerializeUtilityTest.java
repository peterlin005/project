package idv.hsiehpinghan.thsr.utility;

import idv.hsiehpinghan.thsr.ocr.PixelImage;
import idv.hsiehpinghan.thsr.pojo.FileAndObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SerializeUtilityTest {
	@DataProvider
	public Object[][] serializeObject() {
		File file = new File(".\\src\\test\\resources\\HsiehPingHanTestFolder\\2NG6.ser");
		
		BufferedImage bufferedImage = null;
		try {
			bufferedImage = ImageIO.read(new File(".\\src\\test\\resources\\png images\\2NG6.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PixelImage pixelImage = new PixelImage(bufferedImage);

		FileAndObject FileAndObject = new FileAndObject(file, pixelImage);
		
		return new Object[][] {
				{FileAndObject, true} };
	}

	@Test(groups = "ObjectSerializeDeserialize", dataProvider = "serializeObject", enabled = false)
	public void serializeObject(FileAndObject fileAndObject, boolean expectedResult) {
		boolean result = SerializeUtility.serializeObject(fileAndObject.getFile(), fileAndObject.getObject());
		Assert.assertEquals(result, expectedResult);
	}
	
	@DataProvider
	public Object[][] deserializeObject() {
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(".\\src\\test\\resources\\png images\\2NG6.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PixelImage pixelImage = new PixelImage(image);
		
		return new Object[][] {
				{ new File(".\\src\\test\\resources\\HsiehPingHanTestFolder\\2NG6.ser"), pixelImage } };
	}

	@Test(groups = "ObjectSerializeDeserialize", dataProvider = "deserializeObject", dependsOnMethods = {"serializeObject"}, enabled = false)
	public void deserializeObject(File file, Object expectedResult) {
		Object result = SerializeUtility.deserializeObject(file);
		Assert.assertEquals(result, expectedResult);
	}
}