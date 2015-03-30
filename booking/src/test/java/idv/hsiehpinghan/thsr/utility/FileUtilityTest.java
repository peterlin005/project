package idv.hsiehpinghan.thsr.utility;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileUtilityTest {
	@DataProvider
	public Object[][] getFileNameExtension() {
		return new Object[][] {
				{ new File(".\\src\\test\\resources\\HsiehPingHanTestFolder\\fileNameNoExtension.Extension"), "Extension" } };
	}

	@Test(dataProvider = "getFileNameExtension")
	public void getFileNameExtension(File file, String expectedResult) {
		String result = FileUtility.getFileNameExtension(file);
		Assert.assertEquals(result, expectedResult);
	}
	
	@DataProvider
	public Object[][] getFileNameWithoutExtension() {
		return new Object[][] {
				{ new File(".\\src\\test\\resources\\HsiehPingHanTestFolder\\fileNameNoExtension.Extension"), "fileNameNoExtension" } };
	}

	@Test(dataProvider = "getFileNameWithoutExtension",enabled = false)
	public void getFileNameWithoutExtension(File file, String expectedResult) {
		String result = FileUtility.getFileNameWithoutExtension(file);
		Assert.assertEquals(result, expectedResult);
	}
}
