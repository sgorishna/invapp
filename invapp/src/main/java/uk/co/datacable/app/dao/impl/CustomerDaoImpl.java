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
import uk.co.datacable.app.db.DBUtill;
import uk.co.datacable.app.entities.Customer;

public class CustomerDaoImpl implements CustomerDao {

	@Override
	public List<Customer> findAll(int offset, int limit) {

		Connection connection = null;

		List<Customer> customerList = new ArrayList<Customer>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			connection = DBUtill.getConnection();
			connection.setAutoCommit(false);
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from customer order by accNumber limit " + offset + ", " + limit);

			while (rs.next()) {
				Customer customer = new Customer();

				customer.setAccNumber(rs.getString("accNumber"));
				customer.setName(rs.getString("name"));
				customer.setAddress1(rs.getString("address1"));
				customer.setAddress2(rs.getString("address2"));
				customer.setAddress3(rs.getString("address3"));
				customer.setAddress4(rs.getString("address4"));
				customer.setPostcode(rs.getString("postcode"));
				customerList.add(customer);

			}

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customerList;
	}

	@Override
	public int numberOfRecords() {

		int numberOfRecords = 0;

		Connection connection = null;

		try {

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT count(*) from customer");

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
	public void update(Customer customer) {

		Connection conn = null;

		try {

			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("update customer set name=?, address1=?, address2=?,address3=?,address4=?,postcode=?" + " where accNumber=?");
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getAddress1());
			preparedStatement.setString(3, customer.getAddress2());

			preparedStatement.setString(4, customer.getAddress3());

			preparedStatement.setString(5, customer.getAddress4());
			preparedStatement.setString(6, customer.getPostcode());

			preparedStatement.setString(7, customer.getAccNumber());

			preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	@Override
	public Customer findByAccountNumber(String accountNumber) {
		Connection connection = null;
		Customer customer = new Customer();

		try {

			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from customer where accNumber=?");
			preparedStatement.setString(1, accountNumber);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				customer.setAccNumber(rs.getString("accNumber"));
				customer.setName(rs.getString("name"));
				customer.setAddress1(rs.getString("address1"));
				customer.setAddress2(rs.getString("address2"));
				customer.setAddress3(rs.getString("address3"));
				customer.setAddress4(rs.getString("address4"));
				customer.setPostcode(rs.getString("postcode"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customer;
	}

	@Override
	public void delete(Customer customer) {
		Connection conn = null;

		try {

			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("delete from customer where accNumber= " + "'" + customer.getAccNumber() + "'");

			preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	@Override
	public void deleteAll() {

		Connection conn = null;

		try {

			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("delete from customer");

			preparedStatement.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	@Override
	public List<Customer> searchByCustomerName(String name) {

		Connection connection = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select accNumber, name, address1, address2, address3, address4, postcode from customer where name like ?");
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();

				customer.setAccNumber(rs.getString("accNumber"));
				customer.setName(rs.getString("name"));
				customer.setAddress1(rs.getString("address1"));
				customer.setAddress2(rs.getString("address2"));
				customer.setAddress3(rs.getString("address3"));
				customer.setAddress4(rs.getString("address4"));
				customer.setPostcode(rs.getString("postcode"));
				customerList.add(customer);

			}
		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customerList;
	}

	@Override
	public List<Customer> searchByCustomerAccountNumber(String number) {

		Connection connection = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select accNumber, name, address1, address2, address3, address4, postcode from customer where accNumber like ?");
			preparedStatement.setString(1, "%" + number + "%");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();

				customer.setAccNumber(rs.getString("accNumber"));
				customer.setName(rs.getString("name"));
				customer.setAddress1(rs.getString("address1"));
				customer.setAddress2(rs.getString("address2"));
				customer.setAddress3(rs.getString("address3"));
				customer.setAddress4(rs.getString("address4"));
				customer.setPostcode(rs.getString("postcode"));
				customerList.add(customer);

			}
		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customerList;
	}

	@Override
	public List<Customer> searchByCustomerName(String name, int offset, int limit) {

		Connection connection = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select accNumber, name, address1, address2, address3, address4, postcode from customer where name like ? order by accNumber limit " + offset + ", " + limit);
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();

				customer.setAccNumber(rs.getString("accNumber"));
				customer.setName(rs.getString("name"));
				customer.setAddress1(rs.getString("address1"));
				customer.setAddress2(rs.getString("address2"));
				customer.setAddress3(rs.getString("address3"));
				customer.setAddress4(rs.getString("address4"));
				customer.setPostcode(rs.getString("postcode"));
				customerList.add(customer);

			}
		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customerList;

	}

	@Override
	public List<Customer> searchByCustomerAccountNumber(String number, int offset, int limit) {
		Connection connection = null;
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select accNumber, name, address1, address2, address3, address4, postcode from customer where accNumber like ? order by accNumber limit " + offset + ", " + limit);
			preparedStatement.setString(1, "%" + number + "%");
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Customer customer = new Customer();

				customer.setAccNumber(rs.getString("accNumber"));
				customer.setName(rs.getString("name"));
				customer.setAddress1(rs.getString("address1"));
				customer.setAddress2(rs.getString("address2"));
				customer.setAddress3(rs.getString("address3"));
				customer.setAddress4(rs.getString("address4"));
				customer.setPostcode(rs.getString("postcode"));
				customerList.add(customer);

			}
		} catch (SQLException e) {
			Logger.getLogger(CustomerDaoImpl.class.getName()).log(Level.SEVERE, null, e);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return customerList;

	}

}
