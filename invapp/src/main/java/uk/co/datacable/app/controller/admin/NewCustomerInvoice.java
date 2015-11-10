package uk.co.datacable.app.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import uk.co.datacable.app.actions.AbstractServletHandler;
import uk.co.datacable.app.xls.CustomerDataTransfer;

@WebServlet("/admin/newCustomerInvoice")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 100, // 50 MB
maxRequestSize = 1024 * 1024 * 100)
// 100 MB
public class NewCustomerInvoice extends AbstractServletHandler {

	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIR = "xls";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		gotoToJSP("admin/newCustomerInvoice.jsp", req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		boolean uploadFileStatus = false;

		String applicationPath = req.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + File.separator + "resourses" + File.separator + UPLOAD_DIR;

		File fileSaveDir = new File(uploadFilePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		System.out.println("Upload File Directory=" + fileSaveDir.getAbsolutePath());

		String fileName = null;

		for (Part part : req.getParts()) {
			String name = CustomerDataTransfer.getFileName(part);
			if (name.endsWith(".csv")) {
				fileName = "customerInv.csv";
				part.write(uploadFilePath + File.separator + fileName);

				CustomerDataTransfer.transfer(uploadFilePath + File.separator + fileName);
				CustomerDataTransfer.deleteFile(uploadFilePath + File.separator + fileName);

				uploadFileStatus = true;

				HttpSession session = req.getSession();
				session.setAttribute("uploadFileStatus", uploadFileStatus);

				redirectRequest("/admin/customerlist", req, resp);
			} else {

				req.setAttribute("uploadFileStatus", uploadFileStatus);

				gotoToJSP("admin/newCustomerInvoice.jsp", req, resp);

			}
		}

	}

}
