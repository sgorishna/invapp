package uk.co.datacable.app.services;

import java.util.List;

import uk.co.datacable.app.entities.Customer;
import uk.co.datacable.app.entities.Supplier;
import uk.co.datacable.app.entities.User;

public interface SupplierService {
	
	Supplier findByAccountNumber(String accountNumber);

	List<Supplier> findAll(int offset, int limit);

	int numberOfRecords();

List<Supplier> autocompleteSearchBySupplierAccountNumber(String number);
	
	List<Supplier> autocompleteSearchBySupplierName(String name);
	
	List<Supplier> searchBySupplierName(String name);

	List<Supplier> searchBySupplierAccountNumber(String number);
	
	void deleteAll();
}
