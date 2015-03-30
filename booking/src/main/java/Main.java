import idv.hsiehpinghan.thsr.ocr.CharacterRecognizer;
import idv.hsiehpinghan.thsr.ocr.PixelImage;
import idv.hsiehpinghan.thsr.ocr.impl.CharacterRecognizerImpl;
import idv.hsiehpinghan.thsr.ocr.impl.PixelImageImpl;

import java.io.File;
import java.io.IOException;

import org.springframework.context.support.GenericXmlApplicationContext;



public class Main {
	public static void main(String[] args) throws IOException {	
		File file = new File("C:/workspace/booking/src/test/resources/png images/5V8Z.png");
		CharacterRecognizer characterRecognizer = new CharacterRecognizerImpl();
		String recongnizeCode = characterRecognizer.recognize(file);
		System.out.println(recongnizeCode);
		
		
		PixelImage pixelImage = new PixelImageImpl(file);
		System.out.println(pixelImage);
		
		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//		ctx.load("classpath:applicationContext.xml");
//		ctx.refresh();
//		while (true) {
//		}
		

	}

}
