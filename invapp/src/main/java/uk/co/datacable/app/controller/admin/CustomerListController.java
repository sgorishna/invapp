package uk.co.datacable.app.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.co.datacable.app.actions.AbstractServletHandler;

@WebServlet("/admin/customerlist")
public class CustomerListController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int page = 1;

		int recordsPerPage = 50;

		HttpSession session = req.getSession();

		if (session.getAttribute("recordsPerPage") != null) {

			recordsPerPage = Integer.parseInt((String) session.getAttribute("recordsPerPage"));

		}

		if (req.getParameter("page") != null) {

			page = Integer.parseInt(req.getParameter("page"));
		}

		req.setAttribute("customers", getCustomerDao().findAll((page - 1) * recordsPerPage, recordsPerPage));

		int numberOfRecords = getCustomerDao().numberOfRecords();
		int numberOfPages = (int) Math.ceil(numberOfRecords * 1.0 / recordsPerPage);

		req.setAttribute("numberOfPages", numberOfPages);
		req.setAttribute("currentPage", page);

		req.setAttribute("recordsPerPage", recordsPerPage);

		gotoToJSP("admin/customerlist.jsp", req, resp);

		req.getSession().setAttribute("uploadFileStatus", false);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.setAttribute("recordsPerPage", req.getParameter("recordsPerPage"));
		this.doGet(req, resp);

	}
}
