package uk.co.datacable.app.services;

import uk.co.datacable.app.entities.User;
import uk.co.datacable.app.exceptions.InvalidDataException;

public interface LoginService {

	User login(String login, String password) throws InvalidDataException;

}
