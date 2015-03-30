package idv.hsiehpinghan.thsr.repository;

import idv.hsiehpinghan.thsr.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
