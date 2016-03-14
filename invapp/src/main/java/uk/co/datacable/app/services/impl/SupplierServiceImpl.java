package uk.co.datacable.app.services.impl;

import java.util.List;

import uk.co.datacable.app.dao.CustomerDao;
import uk.co.datacable.app.dao.SupplierDao;
import uk.co.datacable.app.dao.UserDao;
import uk.co.datacable.app.entities.Customer;
import uk.co.datacable.app.entities.Supplier;
import uk.co.datacable.app.entities.User;
import uk.co.datacable.app.services.AdminService;
import uk.co.datacable.app.services.SupplierService;

public class SupplierServiceImpl implements SupplierService {

	
	private SupplierDao supplierDao;
	
	public SupplierServiceImpl(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}

	
	@Override
	public List<Supplier> findAll(int offset, int limit) {
		
		return supplierDao.findAll(offset, limit);
	}

	@Override
	public int numberOfRecords() {
		
		return supplierDao.numberOfRecords();
	}

	public SupplierDao getSupplierDao() {
		return supplierDao;
	}

	public void setSupplierDao(SupplierDao supplierDao) {
		this.supplierDao = supplierDao;
	}


	@Override
	public List<Supplier> autocompleteSearchBySupplierAccountNumber(
			String number) {
		
		return supplierDao.autocompleteSearchBySupplierAccountNumber(number);
	}


	@Override
	public List<Supplier> autocompleteSearchBySupplierName(String name) {
		
		return supplierDao.autocompleteSearchBySupplierName(name);
	}


	@Override
	public Supplier findByAccountNumber(String accountNumber) {
		
		return supplierDao.findByAccountNumber(accountNumber);
	}


	@Override
	public void deleteAll() {
		
		supplierDao.deleteAll();
	}


	@Override
	public List<Supplier> searchBySupplierName(String name) {
		
		return supplierDao.searchBySupplierName(name);
	}


	@Override
	public List<Supplier> searchBySupplierAccountNumber(String number) {
		
		return supplierDao.searchBySupplierAccountNumber(number);
	}

	
}
