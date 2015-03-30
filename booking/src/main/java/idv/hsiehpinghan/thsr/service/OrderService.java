package idv.hsiehpinghan.thsr.service;

import idv.hsiehpinghan.thsr.model.Order;

public interface OrderService {
	<S extends Order> S save(S entity);
	Order findOne(Long id);
	boolean orderTicket(Order order);
	void scheduledOrderTicket();
}
