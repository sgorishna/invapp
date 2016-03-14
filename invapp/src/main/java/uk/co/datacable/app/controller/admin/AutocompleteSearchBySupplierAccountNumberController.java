package uk.co.datacable.app.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.actions.AbstractServletHandler;
import uk.co.datacable.app.entities.Customer;
import uk.co.datacable.app.entities.Supplier;

import org.json.JSONArray;

@WebServlet("/admin/searchBySupplierAccountNumber")
public class AutocompleteSearchBySupplierAccountNumberController extends
		AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		String accountNumber = req.getParameter("term");

		List<Supplier> list = getSupplierService()
				.autocompleteSearchBySupplierAccountNumber(accountNumber);

		JSONArray json = new JSONArray();

		Iterator<Supplier> itr = list.iterator();
		while (itr.hasNext()) {

			Supplier s = itr.next();

			String accNum = s.getAccNumber();
			String name = s.getName();

			json.put(accNum + " - " + name);

		}
		out.println(json.toString());

		out.close();

	}

}
