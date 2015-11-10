package uk.co.datacable.app.actions;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.dao.CustomerDao;
import uk.co.datacable.app.dao.UserDao;
import uk.co.datacable.app.dao.impl.CustomerDaoImpl;
import uk.co.datacable.app.dao.impl.UserDaoImpl;
import uk.co.datacable.app.services.LoginService;
import uk.co.datacable.app.utils.WebappConstants;

public abstract class AbstractServletHandler extends HttpServlet implements WebappConstants, Serializable {

	private static final long serialVersionUID = 1L;
	private UserDao userDao;
	private CustomerDao customerDao;

	private LoginService loginService;

	public AbstractServletHandler() {

		this.setUserDao(new UserDaoImpl());
		this.setLoginService(new LoginService(getUserDao()));
		this.setCustomerDao(new CustomerDaoImpl());

	}

	protected final void gotoToJSP(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/resourses/JSP/" + page).forward(request, response);
	}

	protected final void redirectRequest(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

}
