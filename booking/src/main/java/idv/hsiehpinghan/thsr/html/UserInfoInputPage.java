package idv.hsiehpinghan.thsr.html;

import idv.hsiehpinghan.thsr.model.User;
import idv.hsiehpinghan.thsr.ocr.CharacterRecognizer;
import idv.hsiehpinghan.thsr.ocr.impl.CharacterRecognizerImpl;
import idv.hsiehpinghan.thsr.utility.HtmlUtility;

import java.io.File;
import java.io.IOException;

import org.joda.time.DateTime;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class UserInfoInputPage {
	private HtmlPage htmlPage;
	
	public UserInfoInputPage( HtmlPage htmlPage) {
		this.htmlPage = htmlPage;
		
		if(!validate(htmlPage)) {
			throw new RuntimeException("檢核失敗");
		}
	}
	
	public HtmlPage processUserInfoInputPage(User user) throws IOException {	
	    // 身份證字號
		String personalId = user.getPersonalId();
		HtmlUtility.inputHtmlTextInput(htmlPage, "//*[@id='idNumber']", personalId);

	    // 行動電話
		HtmlUtility.clicktHtmlRadioButtonInput(htmlPage, "//*[@id='mobileInputRadio']");
	    String mobilePhoneNumber = user.getMobilePhoneNumber();
	    
	    
	    System.out.println(mobilePhoneNumber);
	    
	    
	   HtmlUtility.inputHtmlTextInput(htmlPage, "//*[@id='mobilePhone']", mobilePhoneNumber);
	    // 電子郵件
	    String email = user.getEmail();
	   HtmlUtility.inputHtmlTextInput(htmlPage, "//*[@id='name2622']", email);

	    // checkbox
		HtmlUtility.clickHtmlCheckBoxInput(htmlPage, "//*[@id='content']/table[2]/tbody/tr/td/p[1]/input");
		
	    // png檔
//		String path = this.getClass().getClassLoader().getResource("\\").getPath();
		String path = this.getClass().getClassLoader().getResource("").getPath();
		
		
		System.out.println("path=" + path);
		

		File directoryFile =  new File(path);
		File file =  new File(directoryFile + "/" + personalId + "_" + DateTime.now().getMillis() + ".png");
		
		
		System.out.println("file=" + file.getAbsolutePath());
		

		HtmlUtility.saveHtmlImage(htmlPage, "//*[@id='BookingS3Form_passCode']", file);		

		CharacterRecognizer characterRecognizer = new CharacterRecognizerImpl();
		String imgCode = characterRecognizer.recognize(file);
		
		
		System.out.println("imgCode=" + imgCode);
		

	    // 認證碼
		HtmlUtility.inputHtmlTextInput(htmlPage,  "//*[@id='content']/table[3]/tbody/tr/td/span[3]/input", imgCode);

		// submit
		HtmlPage resultHtmlPage = HtmlUtility.clickHtmlSubmitInput(htmlPage, "//*[@id='action']/table/tbody/tr/td[2]/input");
		
		return resultHtmlPage;
	}
	
	private boolean validate(HtmlPage htmlPage) {
		return HtmlUtility.check(htmlPage, "//*[@id='steps']/span[4]/strong", "3. 取票資訊");
	}
}
