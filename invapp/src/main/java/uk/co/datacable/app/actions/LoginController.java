package uk.co.datacable.app.actions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.entities.User;
import uk.co.datacable.app.exceptions.InvalidDataException;

@WebServlet("/login")
public class LoginController extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	private final Map<Integer, String> homePages = new HashMap<Integer, String>();

	public LoginController() {

		homePages.put(ROLE_ADMIN, "/admin/home");
		homePages.put(ROLE_USER, "/user/home");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		gotoToJSP("login.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String login = req.getParameter("login");
		String password = req.getParameter("password");

		try {
			User user = getLoginService().login(login, password);

			String homePage = homePages.get(user.getIdRole());

			if (homePage != null) {

				req.getSession().setAttribute(CURRENT_SESSION_ACCOUNT, user);
				req.getSession().setAttribute("CURRENT_ROLE_ACCOUNT", user.getIdRole());

				redirectRequest(homePage, req, resp);
			} /*
			 * else { throw new InvalidDataException("Invalid credentials"); }
			 */

		} catch (InvalidDataException e) {

			req.setAttribute("VALIDATION_MESSAGE", e.getMessage());

			gotoToJSP("login.jsp", req, resp);
		}
	}
}
