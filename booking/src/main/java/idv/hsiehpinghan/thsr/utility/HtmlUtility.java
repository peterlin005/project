package idv.hsiehpinghan.thsr.utility;

import java.io.File;
import java.io.IOException;

import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlCheckBoxInput;
import com.gargoylesoftware.htmlunit.html.HtmlImage;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlRadioButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

public class HtmlUtility {
	public static HtmlPage clickHtmlAnchor(HtmlPage htmlPage, String XPath) throws IOException {
		HtmlAnchor  htmlAnchor  = (HtmlAnchor )htmlPage.getByXPath(XPath).get(0);
		return htmlAnchor.click();
	}
	
	public static HtmlTextInput inputHtmlTextInput(HtmlPage htmlPage, String XPath, String value) throws IOException {
	    HtmlTextInput htmlTextInput = (HtmlTextInput)htmlPage.getByXPath(XPath).get(0);
		htmlTextInput.click();
	    htmlTextInput.setText(value);

	    return htmlTextInput;
	}
	
	public static HtmlCheckBoxInput clickHtmlCheckBoxInput(HtmlPage htmlPage, String XPath) throws IOException {
		HtmlCheckBoxInput  htmlCheckBoxInput  = (HtmlCheckBoxInput )htmlPage.getByXPath(XPath).get(0);
		htmlCheckBoxInput.click();

		return htmlCheckBoxInput;
	}
	
	public static HtmlImage saveHtmlImage(HtmlPage htmlPage, String XPath, File targetFile) throws IOException {
		HtmlImage htmlImage = (HtmlImage)htmlPage.getByXPath(XPath).get(0);
		htmlImage.saveAs(targetFile);
	    
		return htmlImage;
	}
	
	public static HtmlOption selectHtmlOption(HtmlPage htmlPage, String htmlSelectXPath, String htmlOptionValue) throws IOException {
		HtmlSelect htmlSelect = (HtmlSelect)htmlPage.getByXPath(htmlSelectXPath).get(0);
		htmlSelect.click();
		HtmlOption htmlOption =  htmlSelect.getOptionByText(htmlOptionValue);
		htmlOption.click();

		return htmlOption;
	}
	
	public static HtmlRadioButtonInput clicktHtmlRadioButtonInput(HtmlPage htmlPage, String XPath) throws IOException {
		HtmlRadioButtonInput htmlRadioButtonInput = (HtmlRadioButtonInput)htmlPage.getByXPath(XPath).get(0);
		htmlRadioButtonInput.click();

		return htmlRadioButtonInput;
	}
	
	public static HtmlPage clickHtmlSubmitInput(HtmlPage htmlPage, String XPath) throws IOException {
		HtmlSubmitInput  htmlSubmitInput = (HtmlSubmitInput)htmlPage.getByXPath(XPath).get(0);
		HtmlPage resultHtmlPage = htmlSubmitInput.click();
	    
		return resultHtmlPage;
	}
	
	public static boolean check(HtmlPage htmlPage, String XPath, String expectedText) {
		DomNode domNode = (DomNode)htmlPage.getByXPath(XPath).get(0);
		String text = domNode.asText();

		if(!text.equals(expectedText)) {
			return false;
		}
		
	    return true;
	}
}
