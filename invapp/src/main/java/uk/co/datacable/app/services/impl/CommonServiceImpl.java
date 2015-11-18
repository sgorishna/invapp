package uk.co.datacable.app.services.impl;

import java.util.List;

import uk.co.datacable.app.dao.CustomerDao;
import uk.co.datacable.app.entities.Customer;
import uk.co.datacable.app.services.CommonService;

public class CommonServiceImpl implements CommonService {

	private CustomerDao customerDao;

	public CommonServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public List<Customer> findAll(int offset, int limit) {

		return getCustomerDao().findAll(offset, limit);
	}

	@Override
	public Customer findByAccountNumber(String accountNumber) {

		return getCustomerDao().findByAccountNumber(accountNumber);
	}

	@Override
	public int numberOfRecords() {

		return getCustomerDao().numberOfRecords();
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	@Override
	public List<Customer> searchByCustomerName(String name) {

		return getCustomerDao().searchByCustomerName(name);
	}

	@Override
	public List<Customer> searchByCustomerAccountNumber(String number) {

		return getCustomerDao().searchByCustomerAccountNumber(number);
	}

}
