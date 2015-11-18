package uk.co.datacable.app.services.impl;

import java.util.List;

import uk.co.datacable.app.dao.CustomerDao;
import uk.co.datacable.app.dao.UserDao;
import uk.co.datacable.app.entities.Customer;
import uk.co.datacable.app.entities.User;
import uk.co.datacable.app.services.AdminService;

public class AdminServiceImpl implements AdminService {

	private UserDao userDao;

	private CustomerDao customerDao;

	public AdminServiceImpl(UserDao userDao, CustomerDao customerDao) {
		this.userDao = userDao;
		this.customerDao = customerDao;
	}

	@Override
	public User findByLogin(String login) {

		return getUserDao().findByLogin(login);
	}

	@Override
	public List<User> findAll() {

		return getUserDao().findAll();
	}

	@Override
	public User findById(int idUser) {

		return getUserDao().findById(idUser);
	}

	@Override
	public void delete(User user) {
		getUserDao().delete(user);

	}

	@Override
	public void create(User user) {
		getUserDao().create(user);
	}

	@Override
	public void update(User user) {
		getUserDao().update(user);

	}

	@Override
	public void activate(User user) {
		getUserDao().activate(user);

	}

	@Override
	public void deactivate(User user) {
		getUserDao().deactivate(user);

	}

	@Override
	public void deleteAll() {

		getCustomerDao().deleteAll();

	}

	public UserDao getUserDao() {
		return userDao;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	@Override
	public void update(Customer customer) {
		getCustomerDao().update(customer);

	}

	@Override
	public void delete(Customer customer) {
		getCustomerDao().delete(customer);

	}

	@Override
	public Customer findByAccountNumber(String accountNumber) {

		return getCustomerDao().findByAccountNumber(accountNumber);
	}

}
