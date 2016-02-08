package uk.co.datacable.app.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.actions.AbstractServletHandler;
import uk.co.datacable.app.entities.Customer;

@WebServlet("/admin/search")
public class SearchController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		redirectRequest("/admin/customerlist", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String accNumber = req.getParameter("accNumber");
		String name = req.getParameter("name");

		if (accNumber != null && accNumber != "") {

			String n = accNumber.split(" ")[0];
			
			List<Customer> searchByCustomerAccountNumber = getCommonService().searchByCustomerAccountNumber(n);

			req.setAttribute("RESULT", searchByCustomerAccountNumber);

		}

		if (name != null && name != "") {

			List<Customer> searchByCustomerName = getCommonService().searchByCustomerName(name);
			req.setAttribute("RESULT", searchByCustomerName);

		}

		gotoToJSP("admin/search.jsp", req, resp);

	}

}
