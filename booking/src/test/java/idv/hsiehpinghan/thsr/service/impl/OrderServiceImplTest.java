package idv.hsiehpinghan.thsr.service.impl;

import java.util.List;

import idv.hsiehpinghan.thsr.model.Order;
import idv.hsiehpinghan.thsr.model.User;
import idv.hsiehpinghan.thsr.service.OrderService;
import idv.hsiehpinghan.thsr.service.UserService;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderServiceImplTest {
	private GenericXmlApplicationContext genericXmlApplicationContext = null;
	private OrderServiceImpl orderServiceImpl = null;
	
	@BeforeClass
	public void beforeClass() {
		genericXmlApplicationContext = new GenericXmlApplicationContext();
		genericXmlApplicationContext.load("classpath:applicationContext.xml");
		genericXmlApplicationContext.refresh();

		orderServiceImpl = genericXmlApplicationContext.getBean("orderServiceImpl", OrderServiceImpl.class);

		// 清除所有資料
//		 orderService.deleteAll();
	}

	@AfterClass
	public void afterClass() {
		genericXmlApplicationContext.close();
	}
	
  @Test(enabled=false)
  public void findWorkingOrder() {
	  List<Order> listOrder = orderServiceImpl.findWorkingOrder();
	  for(Order order : listOrder) {
		  System.out.println(order);
		  System.out.println(order.getUser());
	  }
  }
  
  @Test(enabled = false)
  public void orderTicket() {
	  Order order = orderServiceImpl.findOne(1L);
	  System.out.println(order);
	  System.out.println(order.getUser());
  }
}
