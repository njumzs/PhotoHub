package photohubservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.io.output.*;

import photohub.*;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer userid = null;

		System.out.println("uploading ...");
		String introduction = request.getParameter("inputIntroduction");
		System.out.println("introduction " + introduction);
		// String filename = request.getParameter("inputPath") +
		// request.getParameter("inputFile");

		userid = (Integer) request.getSession().getAttribute("userId");
		if (userid < 0) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(factory);

		sfu.setFileSizeMax(1024 * 1024 * 10);
		try {
			List<FileItem> items = sfu.parseRequest(request);
			int photoid = TablePhoto.photoID();

			for (int i = 0; i < items.size(); i++) {
				FileItem item = items.get(i);
				String path = null;
				String fileName = null;
				String suffix = null;

				if (!item.isFormField()) {
					// ServletContext sctx = getServletContext();

					// path = request.getContextPath() + File.separator +
					// "photo";
					// String path =
					// getServletContext().getInitParameter("upload-photo");
					path = "C:\\Users\\cc\\Documents\\GitHub\\PhotoHub\\WebContent\\IMAGE";
					fileName = item.getName();
					System.out.println("filename " + path + "\\" + fileName);
					System.out.println("point at " + fileName.lastIndexOf("."));

					File filePath = new File(path);

					if (!filePath.exists()) {
						filePath.mkdir();
					}

					// suffix = fileName.substring(fileName.lastIndexOf(".") +
					// 1);
					// System.out.println("suffix " + suffix);
					File file = new File(path + "\\" + fileName);
					if (file.length() > 1024 * 1024 * 10) {
						response.sendRedirect("sizefalse.jsp");
					}

					// request.getSession().setAttribute("photoPath", fileName);
					item.write(file);

					System.out.println("get id ...");
					/*
					 * System.out.println("userid " + userid.intValue() +
					 * " path " + path + "\\" + photoid + "." + fileName +
					 * " photoid " + photoid);
					 */
					TablePhoto.InvertPhoto(userid.intValue(), path + "\\"
							+ fileName, photoid);
					TablePhoto.updateIntroduction(photoid, introduction);					
				}
			}
			response.sendRedirect(request.getContextPath() + "/photostream.jsp");
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
