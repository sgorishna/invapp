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

import uk.co.datacable.app.dao.UserDao;
import uk.co.datacable.app.db.DBUtill;
import uk.co.datacable.app.entities.User;

public class UserDaoImpl implements UserDao {

	public User findByLogin(String login) {

		Connection connection = null;
		User user = new User();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where login=?");
			preparedStatement.setString(1, login);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setIdUser(rs.getInt("idUser"));
				user.setName(rs.getString("name"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setIdRole(rs.getInt("idRole"));
				user.setActive(rs.getByte("active"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

		return user;

	}

	public List<User> findAll() {

		Connection connection = null;

		List<User> userList = new ArrayList<User>();

		Statement stmt = null;
		ResultSet rs = null;

		try {

			connection = DBUtill.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select u.idUser, u.name, u.login, u.password, u.idRole, u.active, r.role as role from user u  join role r on u.idRole=r.idRole order by name");
			while (rs.next()) {
				User user = new User();
				user.setIdUser(rs.getInt("idUser"));
				user.setName(rs.getString("name"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setIdRole(rs.getInt("idRole"));

				user.setActive(rs.getByte("active"));
				user.setRole(rs.getString("role"));

				userList.add(user);

			}

		} catch (SQLException ex) {
			Logger.getLogger(UserDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			DBUtill.closeConnection(connection);
		}

		return userList;
	}

	public User findById(int idUser) {
		Connection connection = null;
		User user = new User();
		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from user where idUser=?");
			preparedStatement.setInt(1, idUser);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				user.setIdUser(rs.getInt("idUser"));
				user.setName(rs.getString("name"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setIdRole(rs.getInt("idRole"));
				user.setActive(rs.getByte("active"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

		return user;
	}

	public void delete(User user) {

		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("delete from user where idUser=" + user.getIdUser());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	public void create(User user) {
		Connection connection = null;

		try {
			connection = DBUtill.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("insert into user(name,login,password,idRole,active) values (?, ?, ?, ?, ?)");

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLogin());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setInt(4, user.getIdRole());
			preparedStatement.setByte(5, user.getActive());

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(connection);
		}

	}

	public void update(User user) {
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("update user set name=?, login=?, password=?, idRole=?" + " where idUser=?");

			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getLogin());
			preparedStatement.setString(3, user.getPassword());

			preparedStatement.setInt(4, user.getIdRole());

			preparedStatement.setLong(5, user.getIdUser());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	public void activate(User user) {
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("update user set active=1" + " where idUser=?");

			preparedStatement.setLong(1, user.getIdUser());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

	public void deactivate(User user) {
		Connection conn = null;
		try {
			conn = DBUtill.getConnection();
			PreparedStatement preparedStatement = conn.prepareStatement("update user set active=0" + " where idUser=?");

			preparedStatement.setLong(1, user.getIdUser());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtill.closeConnection(conn);
		}

	}

}
