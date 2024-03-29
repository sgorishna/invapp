package uk.co.datacable.app.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.actions.AbstractServletHandler;
import uk.co.datacable.app.entities.Customer;
import uk.co.datacable.app.entities.Supplier;

@WebServlet("/admin/supplierSearch")
public class SupplierSearchController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		redirectRequest("/admin/supplierlist", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String accNumber = req.getParameter("accNumber");
		String name = req.getParameter("name");

		if (accNumber != null && accNumber != "") {

			String n = accNumber.split(" ")[0];
			
			List<Supplier> searchBySupplierAccountNumber = getSupplierService().searchBySupplierAccountNumber(n);

			req.setAttribute("RESULT", searchBySupplierAccountNumber);

		}

		if (name != null && name != "") {

			List<Supplier> searchBySupplierName = getSupplierService().searchBySupplierName(name);
			req.setAttribute("RESULT", searchBySupplierName);

		}

		gotoToJSP("admin/supplierSearch.jsp", req, resp);

	}

}
