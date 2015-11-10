package uk.co.datacable.app.dao;

import java.util.List;

import uk.co.datacable.app.entities.User;

public interface UserDao {

	User findByLogin(String login);

	List<User> findAll();

	User findById(int idUser);

	void delete(User user);

	void create(User user);

	void update(User user);

	void activate(User user);

	void deactivate(User user);

}
