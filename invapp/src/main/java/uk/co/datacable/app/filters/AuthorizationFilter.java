package uk.co.datacable.app.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.entities.User;
import uk.co.datacable.app.utils.WebappConstants;

@WebFilter(filterName = "securityFilter")
public class AuthorizationFilter extends AbstractWebappFilter implements WebappConstants {

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

		String servletPath = request.getServletPath();

		if (servletPath.equals("/login")) {
			chain.doFilter(request, response);
			return;
		}

		User currentAccount = (User) request.getSession().getAttribute(CURRENT_SESSION_ACCOUNT);

		if (currentAccount != null) {

			chain.doFilter(request, response);
			return;
		}

		response.sendRedirect(request.getServletContext().getContextPath() + "/login");
	}

}
