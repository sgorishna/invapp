package uk.co.datacable.app.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.actions.AbstractServletHandler;

@WebServlet("/admin/clearAllSupplierList")
public class DeleteAllSuppliers extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		getAdminService().deleteAll();

		req.getSession().setAttribute("uploadFileStatus", false);

		redirectRequest("/admin/supplierlist", req, resp);
	}

}
