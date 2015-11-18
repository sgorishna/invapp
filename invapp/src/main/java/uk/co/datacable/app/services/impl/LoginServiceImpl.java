package uk.co.datacable.app.services.impl;

import uk.co.datacable.app.dao.UserDao;
import uk.co.datacable.app.entities.User;
import uk.co.datacable.app.exceptions.InvalidDataException;
import uk.co.datacable.app.services.LoginService;

public class LoginServiceImpl implements LoginService {

	private UserDao userDao;

	public LoginServiceImpl(UserDao dao) {

		this.userDao = dao;
	}

	public User login(String login, String password) throws InvalidDataException {

		User user = userDao.findByLogin(login);

		if (user == null) {
			throw new InvalidDataException("Account not found");
		} else {
			if (password.equals(user.getPassword())) {
				if (user.getActive() == 1) {
					return user;
				} else {
					throw new InvalidDataException("Account is not active");
				}

			} else {
				throw new InvalidDataException("Invalid password");
			}

		}

	}

}
