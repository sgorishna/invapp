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

import org.json.JSONArray;

@WebServlet("/admin/searchByCustomerName")
public class AutocompleteSearchByCustomerNameController extends
		AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		resp.setContentType("text/html");

		PrintWriter out = resp.getWriter();

		String name = req.getParameter("term");

		List<Customer> list = getCommonService()
				.autocompleteSearchByName(name);

		JSONArray json = new JSONArray();

		Iterator<Customer> itr = list.iterator();
		while (itr.hasNext()) {

			Customer c = itr.next();

			
			String n = c.getName();

			json.put(n);

		}
		out.println(json.toString());

		out.close();

	}

}
