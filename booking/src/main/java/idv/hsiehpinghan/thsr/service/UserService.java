package idv.hsiehpinghan.thsr.service;

import idv.hsiehpinghan.thsr.model.User;

public interface UserService {
	<S extends User> S save(S entity);
	void deleteAll();
	boolean exists(String id);
	User findOne(String id);
}
