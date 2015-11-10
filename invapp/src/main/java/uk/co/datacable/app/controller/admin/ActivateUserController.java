package uk.co.datacable.app.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.actions.AbstractServletHandler;
import uk.co.datacable.app.entities.User;

@WebServlet("/admin/activate")
public class ActivateUserController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();

		user = getUserDao().findById(Integer.parseInt(req.getParameter("idUser")));

		if (user != null) {

			getUserDao().activate(user);
		}
		redirectRequest("/admin/adminpanel", req, resp);
	}

}
