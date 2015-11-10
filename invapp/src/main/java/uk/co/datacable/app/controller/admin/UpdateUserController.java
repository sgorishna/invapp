package uk.co.datacable.app.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.actions.AbstractServletHandler;
import uk.co.datacable.app.entities.User;

@WebServlet("/admin/updateuser")
public class UpdateUserController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer idUser = Integer.parseInt(req.getParameter("idUser"));
		User user = getUserDao().findById(idUser);
		req.setAttribute("user", user);

		gotoToJSP("admin/updateUser.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = new User();

		user.setLogin(req.getParameter("login"));
		user.setPassword(req.getParameter("password"));
		user.setName(req.getParameter("name"));
		user.setIdRole((Integer.parseInt(req.getParameter("role"))));

		user.setIdUser(Integer.parseInt(req.getParameter("idUser")));

		getUserDao().update(user);

		redirectRequest("/admin/adminpanel", req, resp);

	}
}
