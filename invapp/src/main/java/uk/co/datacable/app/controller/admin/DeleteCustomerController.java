package uk.co.datacable.app.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.actions.AbstractServletHandler;
import uk.co.datacable.app.entities.Customer;

@WebServlet("/admin/deletecustomer")
public class DeleteCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Customer customer = new Customer();

		customer = getCustomerDao().findByAccountNumber(req.getParameter("accNumber"));

		if (customer != null) {

			getCustomerDao().delete(customer);
		}
		redirectRequest("/admin/customerlist", req, resp);
	}

}
