package idv.hsiehpinghan.thsr.service.data;

import idv.hsiehpinghan.thsr.enumeration.StationEnum;
import idv.hsiehpinghan.thsr.enumeration.TrainCompartmentClassEnum;
import idv.hsiehpinghan.thsr.model.Order;
import idv.hsiehpinghan.thsr.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class UserDataProvider {
	@DataProvider
	public static Iterator<Object[]> userDataProvider(ITestContext iTestContext) {
		List<Object[]> listObjects = new ArrayList<Object[]>();
		for (int i = 0; i < 3; ++i) {
			User user = new User();
			user.setEmail("email" + i);
			user.setMobilePhoneNumber("mobilePhoneNumber" + i);
			user.setOrders(getListOrder(user));
			user.setPassword("password" + i);
			user.setPersonalId("personalId" + i);

			Object[] objects = new Object[] { user };
			listObjects.add(objects);
		}

		return listObjects.iterator();
	}

	public static List<Order> getListOrder(User user) {
		List<Order> listOrder = new ArrayList<Order>();
		for (int i = 0; i < 3; ++i) {
			Order order = new Order();
			order.setAdultTicketAmount(i);
			order.setChildTickenAmount(i);
			order.setDate(new Date());
			order.setDestinationStation(StationEnum.BANQIAO);
			order.setDisabledTicketAmount(i);
			order.setSeniorTicketAmount(i);
			order.setStartStation(StationEnum.TAINAN);
			order.setTrainCompartmentClass(TrainCompartmentClassEnum.BUSINESS);
			order.setTrainId("trainId");
			order.setUser(user);
			listOrder.add(order);
		}

		return listOrder;
	}
}
