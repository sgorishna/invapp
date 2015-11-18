package uk.co.datacable.app.services;

import java.util.List;

import uk.co.datacable.app.entities.Customer;
import uk.co.datacable.app.entities.User;

public interface AdminService {

	User findByLogin(String login);

	List<User> findAll();

	User findById(int idUser);

	void delete(User user);

	void create(User user);

	void update(User user);

	void activate(User user);

	void deactivate(User user);

	void deleteAll();

	void update(Customer customer);

	void delete(Customer customer);

	Customer findByAccountNumber(String accountNumber);

}
