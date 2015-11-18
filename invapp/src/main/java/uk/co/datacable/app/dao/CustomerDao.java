package uk.co.datacable.app.dao;

import java.util.List;

import uk.co.datacable.app.entities.Customer;

public interface CustomerDao {

	List<Customer> findAll(int offset, int limit);

	int numberOfRecords();

	void update(Customer customer);

	void delete(Customer customer);

	void deleteAll();

	Customer findByAccountNumber(String accountNumber);

	List<Customer> searchByCustomerName(String name);

	List<Customer> searchByCustomerAccountNumber(String number);

	List<Customer> searchByCustomerName(String name, int offset, int limit);

	List<Customer> searchByCustomerAccountNumber(String number, int offset, int limit);
}
