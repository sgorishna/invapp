package uk.co.datacable.app.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.actions.AbstractServletHandler;
import uk.co.datacable.app.entities.Customer;
import uk.co.datacable.app.entities.Supplier;

@WebServlet("/admin/supplierDetails")
public class SupplierDetails extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String accNumber = req.getParameter("accNum");

		Supplier s = getSupplierService().findByAccountNumber(accNumber);

		req.setAttribute("supplierDetails", s);

		gotoToJSP("admin/supplierDetails.jsp", req, resp);
	}

}
