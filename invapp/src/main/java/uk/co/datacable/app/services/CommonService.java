package uk.co.datacable.app.services;

import java.util.List;

import uk.co.datacable.app.entities.Customer;

public interface CommonService {

	List<Customer> findAll(int offset, int limit);

	Customer findByAccountNumber(String accountNumber);

	int numberOfRecords();

	List<Customer> searchByCustomerName(String name);

	List<Customer> searchByCustomerAccountNumber(String number);

}
