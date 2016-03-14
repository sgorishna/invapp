package uk.co.datacable.app.actions;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import uk.co.datacable.app.dao.impl.CustomerDaoImpl;
import uk.co.datacable.app.dao.impl.SupplierDaoImpl;
import uk.co.datacable.app.dao.impl.UserDaoImpl;
import uk.co.datacable.app.services.AdminService;
import uk.co.datacable.app.services.CommonService;
import uk.co.datacable.app.services.SupplierService;
import uk.co.datacable.app.services.impl.AdminServiceImpl;
import uk.co.datacable.app.services.impl.CommonServiceImpl;
import uk.co.datacable.app.services.impl.LoginServiceImpl;
import uk.co.datacable.app.services.impl.SupplierServiceImpl;
import uk.co.datacable.app.utils.WebappConstants;

public abstract class AbstractServletHandler extends HttpServlet implements WebappConstants, Serializable {

	private static final long serialVersionUID = 1L;

	private AdminService adminService;
	
	private SupplierService supplierService;

	private CommonService commonService;

	private LoginServiceImpl loginService;

	public AbstractServletHandler() {

		this.setAdminService(new AdminServiceImpl(new UserDaoImpl(), new CustomerDaoImpl()));
		this.setLoginService(new LoginServiceImpl(new UserDaoImpl()));
		this.setCommonService(new CommonServiceImpl(new CustomerDaoImpl()));
		this.setSupplierService(new SupplierServiceImpl(new SupplierDaoImpl()));

	}

	protected final void gotoToJSP(String page, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/resourses/JSP/" + page).forward(request, response);
	}

	protected final void redirectRequest(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + path);
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public CommonService getCommonService() {
		return commonService;
	}

	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public LoginServiceImpl getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginServiceImpl loginService) {
		this.loginService = loginService;
	}

	public SupplierService getSupplierService() {
		return supplierService;
	}

	public void setSupplierService(SupplierService supplierService) {
		this.supplierService = supplierService;
	}

}
