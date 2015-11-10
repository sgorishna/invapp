package uk.co.datacable.app.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.actions.AbstractServletHandler;
import uk.co.datacable.app.entities.Customer;

@WebServlet("/admin/updatecustomer")
public class UpdateCustomerController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String accNumber = req.getParameter("accNumber");

		Customer customer = getCustomerDao().findByAccountNumber(accNumber);
		req.setAttribute("customer", customer);

		gotoToJSP("admin/updatecustomer.jsp", req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = new Customer();

		customer.setAccNumber(req.getParameter("accNumber"));
		customer.setName(req.getParameter("name"));
		customer.setAddress1(req.getParameter("address1"));
		customer.setAddress2(req.getParameter("address2"));
		customer.setAddress3(req.getParameter("address3"));
		customer.setAddress4(req.getParameter("address4"));
		customer.setPostcode(req.getParameter("postcode"));

		getCustomerDao().update(customer);

		redirectRequest("/admin/customerlist", req, resp);
	}

}
