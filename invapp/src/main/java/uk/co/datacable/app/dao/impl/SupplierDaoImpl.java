package uk.co.datacable.app.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import uk.co.datacable.app.dao.CustomerDao;
import uk.co.datacable.app.dao.SupplierDao;
import uk.co.datacable.app.db.DBUtill;
import uk.co.datacable.app.entities.Customer;
import uk.co.datacable.app.entities.Supplier;

public class SupplierDaoImpl implements SupplierDao {

	@Override
	public List<Supplier> findAll(int offset, int limit) {
		
		Connection connection = null;

		List<Supplier> supplierList = new ArrayList<Supplier>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			connection = DBUtill.getConnection();
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from supplier order by accNumber limit " + offset + ", " + limit);

			while (rs.next()) {
				Supplier supplier = new Supplier();

				supplier.setAccNumber(rs.getString("accNumber"));
				supplier.setName(rs.getString("name"));
				supplier.setAddress1(rs.getString("address1"));
				supplier.setAddress2(rs.getString("address2"));
				supplier.setAddress3(rs.getString("address3"));
				supplier.setAddress4(rs.getString("address4"));
				supplier.setPostcode(rs.getString("postcode"));
				supplierList.add(supplier);

			}

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return supplierList;
		
		
	}

	@Override
	public int numberOfRecords() {
		int numberOfRecords = 0;

		Connection connection = null;

		try {

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) from supplier");

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {

				numberOfRecords = rs.getInt(1);
			}

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

		} finally {
			DBUtill.closeConnection(connection);

		}

		return numberOfRecords;
	}

	@Override
	public List<Supplier> autocompleteSearchBySupplierAccountNumber(
			String number) {
		
		Connection connection = null;
		List<Supplier> supplierList = new ArrayList<Supplier>();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select accNumber, name  from supplier where accNumber like ?");
			preparedStatement.setString(1,  number+ "%" );
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Supplier supplier = new Supplier();

				supplier.setAccNumber(rs.getString("accNumber"));
				supplier.setName(rs.getString("name"));
				
				supplierList.add(supplier);

			}
		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return supplierList;
		
	}

	@Override
	public List<Supplier> autocompleteSearchBySupplierName(String name) {
		Connection connection = null;
		List<Supplier> supplierList = new ArrayList<Supplier>();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select  name  from supplier where accNumber like ?");
			preparedStatement.setString(1,  name+ "%" );
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Supplier supplier = new Supplier();

				
				supplier.setName(rs.getString("name"));
				
				supplierList.add(supplier);

			}
		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return supplierList;
	}

	@Override
	public Supplier findByAccountNumber(String accountNumber) {
		Connection connection = null;
		Supplier supplier = new Supplier();

		try {

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from supplier where accNumber=?");
			preparedStatement.setString(1, accountNumber);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				supplier.setAccNumber(rs.getString("accNumber"));
				supplier.setName(rs.getString("name"));
				supplier.setAddress1(rs.getString("address1"));
				supplier.setAddress2(rs.getString("address2"));
				supplier.setAddress3(rs.getString("address3"));
				supplier.setAddress4(rs.getString("address4"));
				supplier.setPostcode(rs.getString("postcode"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return supplier;
	}

	@Override
	public void deleteAll() {
		Connection conn = null;

		try {

			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("delete from supplier");

			preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(conn);
		}
		
	}

	@Override
	public List<Supplier> searchBySupplierName(String name) {
		Connection connection = null;
		List<Supplier> supplierList = new ArrayList<Supplier>();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select accNumber, name, address1, address2, address3, address4, postcode from supplier where name like ?");
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Supplier supplier = new Supplier();

				supplier.setAccNumber(rs.getString("accNumber"));
				supplier.setName(rs.getString("name"));
				supplier.setAddress1(rs.getString("address1"));
				supplier.setAddress2(rs.getString("address2"));
				supplier.setAddress3(rs.getString("address3"));
				supplier.setAddress4(rs.getString("address4"));
				supplier.setPostcode(rs.getString("postcode"));
				supplierList.add(supplier);

			}
		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return supplierList;
	}

	@Override
	public List<Supplier> searchBySupplierAccountNumber(String number) {
		Connection connection = null;
		List<Supplier> supplierList = new ArrayList<Supplier>();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select accNumber, name, address1, address2, address3, address4, postcode from supplier where accNumber like ?");
			preparedStatement.setString(1,  "%" + number + "%" );
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Supplier supplier = new Supplier();

				supplier.setAccNumber(rs.getString("accNumber"));
				supplier.setName(rs.getString("name"));
				supplier.setAddress1(rs.getString("address1"));
				supplier.setAddress2(rs.getString("address2"));
				supplier.setAddress3(rs.getString("address3"));
				supplier.setAddress4(rs.getString("address4"));
				supplier.setPostcode(rs.getString("postcode"));
				supplierList.add(supplier);

			}
		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return supplierList;
	}

	


}
