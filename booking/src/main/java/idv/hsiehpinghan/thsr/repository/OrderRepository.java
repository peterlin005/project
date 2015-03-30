package idv.hsiehpinghan.thsr.repository;

import java.util.List;

import idv.hsiehpinghan.thsr.model.Order;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
	@Query("SELECT o FROM Order o WHERE o.gotTimestamp IS NULL ")
	<S extends Order> List<S> findWorkingOrder();
}
