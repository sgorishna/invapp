package uk.co.datacable.app.dao;

import java.util.List;

import uk.co.datacable.app.entities.Customer;
import uk.co.datacable.app.entities.Supplier;

public interface SupplierDao {
	
	Supplier findByAccountNumber(String accountNumber);

	List<Supplier> findAll(int offset, int limit);

	int numberOfRecords();
	
List<Supplier> autocompleteSearchBySupplierAccountNumber(String number);
	
	List<Supplier> autocompleteSearchBySupplierName(String name);
	
	List<Supplier> searchBySupplierName(String name);

	List<Supplier> searchBySupplierAccountNumber(String number);

	void deleteAll();
	
}
