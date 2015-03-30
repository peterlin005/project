package idv.hsiehpinghan.thsr.html;

import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.enumeration.TrainCompartmentClassEnum;
import idv.hsiehpinghan.thsr.model.Order;
import idv.hsiehpinghan.thsr.utility.HtmlUtility;
import idv.hsiehpinghan.thsr.utility.SpringUtility;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class OrderInputPage {
	private String url = "https://irs.thsrc.com.tw/IMINT/";
	private HtmlPage htmlPage;
	
	public OrderInputPage() {
		GenericXmlApplicationContext genericXmlApplicationContext = SpringUtility.getGenericXmlApplicationContext();
		WebClient webClient = genericXmlApplicationContext.getBean("webClient", WebClient.class);
		try {
			htmlPage =webClient.getPage(url);
		} catch (FailingHttpStatusCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		if(!validate(htmlPage)) {
			throw new RuntimeException("檢核失敗");
		}
	}
	
	public HtmlPage processOrderInputPage(Order order) throws IOException {	
		// 起程站
		String startStation = StationEnum.getEnumMap().get(order.getStartStation());
		HtmlUtility.selectHtmlOption(htmlPage, "//*[@id='content']/tbody/tr[1]/td[2]/span/select", startStation);

		// 到達站
		String destinationStation = StationEnum.getEnumMap().get(order.getDestinationStation());
		HtmlUtility.selectHtmlOption(htmlPage, "//*[@id='content']/tbody/tr[1]/td[2]/select", destinationStation);

		// 車廂種類
		TrainCompartmentClassEnum trainCompartmentClassEnum = order.getTrainCompartmentClass();
		switch (trainCompartmentClassEnum) {
		case STANDARD:
			HtmlUtility.clicktHtmlRadioButtonInput(htmlPage, "//*[@id='trainCon:trainRadioGroup_0']");
			break;
		case BUSINESS:
			HtmlUtility.clicktHtmlRadioButtonInput(htmlPage, "//*[@id='trainCon:trainRadioGroup_1']");
			break;
		default:
			break;
		}

		// 訂位方式
		HtmlUtility.clicktHtmlRadioButtonInput(htmlPage, "//*[@id='bookingMethod2']");

		// 時間
		Date date = order.getDate();
		DateTime datetime = new DateTime(date);
		HtmlUtility.inputHtmlTextInput(htmlPage, "//*[@id='toTimeInputField']", datetime.toString("yyyy/MM/dd"));
		
	    // 車次號碼
		String trainId = order.getTrainId();
		HtmlUtility.inputHtmlTextInput(htmlPage, "//*[@id='toTrainID']/input", trainId);

	    // 全票
		Integer adultTicketAmount = order.getAdultTicketAmount();
		HtmlUtility.selectHtmlOption(htmlPage, "//*[@id='content']/tbody/tr[5]/td[2]/span/span[1]/span/select", adultTicketAmount.toString());

		// 孩童票
		Integer childTickenAmount = order.getChildTickenAmount();
		HtmlUtility.selectHtmlOption(htmlPage, "//*[@id='content']/tbody/tr[5]/td[2]/span/span[2]/span/select", childTickenAmount.toString());

	    // 愛心票
		Integer disabledTicketAmount = order.getDisabledTicketAmount();
		HtmlUtility.selectHtmlOption(htmlPage, "//*[@id='content']/tbody/tr[5]/td[2]/span/span[3]/span/select", disabledTicketAmount.toString());

	    // 敬老票
		Integer seniorTicketAmount = order.getSeniorTicketAmount();
		HtmlUtility.selectHtmlOption(htmlPage, "//*[@id='content']/tbody/tr[5]/td[2]/span/span[4]/span/select", seniorTicketAmount.toString());

		// submit
		HtmlPage resultHtmlPage = HtmlUtility.clickHtmlSubmitInput(htmlPage, "//*[@id='SubmitButton']");
		
		return resultHtmlPage;
	}
	
	private boolean validate(HtmlPage htmlPage) {
		return HtmlUtility.check(htmlPage, "//*[@id='steps']/span[2]/strong", "1. 查詢車次");
	}
}
