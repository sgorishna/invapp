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

}
