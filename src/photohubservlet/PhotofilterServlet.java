package photohubservlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import PhotoFilter.PicUtil;

/**
 * Servlet implementation class PhotofilterServlet
 */
@WebServlet("/PhotofilterServlet")
public class PhotofilterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PhotofilterServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filter = (String) request.getParameter("inputFilter");
		String path = (String) request.getParameter("inputPath");
		String text = (String) request.getParameter("inputText");
		switch (filter) {
		case "getGrayPicture":
			PicUtil.getGrayPicture(path, path);
			break;
		case "getDlurPicture":
			PicUtil.getDlurPicture(path, path);
			break;
		case "getSharperPicture":
			PicUtil.getSharperPicture(path, path);
			break;
		case "getPicEdge":
			PicUtil.getPicEdge(path, path);
			break;
		case "gray":
			PicUtil.gray(path, path);
			break;
		case "pressText":
			PicUtil.pressText(text, path, path);
			break;
		default:
			PicUtil.getDlurPicture(path, path);
			System.out.println("Such utilities not avaliable");
			break;
		}
		response.sendRedirect(request.getContextPath() + "/photostream.jsp");	

	}

}
