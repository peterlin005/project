package idv.hsiehpinghan.thsr.service.impl;

import idv.hsiehpinghan.thsr.model.User;
import idv.hsiehpinghan.thsr.service.UserService;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class UserServiceImplTest {
	private GenericXmlApplicationContext genericXmlApplicationContext = null;
	private UserService userService = null;
	private User user = null;

	@Factory(dataProviderClass = idv.hsiehpinghan.thsr.service.data.UserDataProvider.class, dataProvider = "userDataProvider")
	public UserServiceImplTest(User user) {
		this.user = user;
	}

	@BeforeClass
	public void beforeClass() {
		genericXmlApplicationContext = new GenericXmlApplicationContext();
		genericXmlApplicationContext.load("classpath:applicationContext.xml");
		genericXmlApplicationContext.refresh();

		userService = genericXmlApplicationContext.getBean("userServiceImpl", UserService.class);

		// 清除所有資料
//		 userService.deleteAll();
	}

	@AfterClass
	public void afterClass() {
		genericXmlApplicationContext.close();
	}

	@Test(enabled = false)
	public void save() {
		userService.save(user);
		boolean condition = userService.exists(user.getPersonalId());
		Assert.assertTrue(condition);
		
//		user = userService.findOne("personalId0");
//		user.getOrders().remove(1);
//		
//		user = userService.save(user);
//		boolean condition = userService.exists(user.getPersonalId());
//		Assert.assertTrue(condition);
	}
}
