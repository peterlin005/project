package idv.hsiehpinghan.thsr.service.impl;

import idv.hsiehpinghan.thsr.html.OrderInputPage;
import idv.hsiehpinghan.thsr.html.UserInfoInputPage;
import idv.hsiehpinghan.thsr.model.Order;
import idv.hsiehpinghan.thsr.model.User;
import idv.hsiehpinghan.thsr.repository.OrderRepository;
import idv.hsiehpinghan.thsr.service.OrderService;
import idv.hsiehpinghan.thsr.utility.HtmlUtility;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderRepository orderRepository;

	@Override
	public <S extends Order> S save(S entity) {
		return orderRepository.save(entity);
	}
	
	@Override
	public boolean orderTicket(Order order) {
		boolean result = processOrder(order);
	    return result;
	}
	
//	@Scheduled(cron="0 * 12 * * ?")	// 開發中，暫時註解掉
	@Override
	public void scheduledOrderTicket() {
		List<Order> listOrder = findWorkingOrder();
		WebClient webClient = new WebClient();
		
		for(Order order : listOrder) {
			processOrder(order);
		}
		
	    webClient.closeAllWindows();
	}
	
	@Override
	public Order findOne(Long id) {
		return orderRepository.findOne(id);
	}
	
	public List<Order> findWorkingOrder() {

		return orderRepository.findWorkingOrder();
	}
	
	private boolean processOrder(Order order) {
		HtmlPage htmlPage = null;
		
		OrderInputPage orderInputPage = new OrderInputPage();
		try {
			htmlPage = orderInputPage.processOrderInputPage(order);

			
			System.out.println("11111~~~~");
			System.out.println(htmlPage.asXml());


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		for(int i = 0; i < 10; ++i) {
			UserInfoInputPage userInfoInputPage = new UserInfoInputPage(htmlPage);
			User user = order.getUser();
			try {
				htmlPage = userInfoInputPage.processUserInfoInputPage(user);
	
				
				System.out.println("22222~~~~");
				System.out.println(htmlPage.asXml());
	
	
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e.getMessage());
			}
	
			if(checkResultPage(htmlPage) == true) {
				
				System.out.println("true~~~~");
				
				order.setGotTimestamp(new Date());
				orderRepository.save(order);
				return true;
			} else {
				try {
					htmlPage = HtmlUtility.clickHtmlAnchor(htmlPage, "//*[@id='BookingS3Form_reCodeLink']");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("false~~~~");
		
		return false;
	}

	private boolean checkResultPage(HtmlPage resultPage) {
		boolean reasult = false;
		try {
			reasult = HtmlUtility.check(resultPage, "//*[@id='steps']/strong", "4. 完成訂位");;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			throw new RuntimeException(e.getMessage());
		}
		return reasult;
	}
	
}
