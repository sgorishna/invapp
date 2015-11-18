package uk.co.datacable.app.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uk.co.datacable.app.actions.AbstractServletHandler;

@WebServlet("/admin/adminpanel")
public class AdminPanelController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.getAttribute("uploadFileStatus");

		req.setAttribute("users", getAdminService().findAll());

		gotoToJSP("admin/adminpanel.jsp", req, resp);
	}

}
