package photohubservlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photohub.*;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    int userid = (int) request.getSession().getAttribute("userId"); 
	       if (userid < 0) {
	       		response.sendRedirect(request.getContextPath() + "/index.jsp");
	    		return;
	    	}

	       Integer photoid = TablePhoto.photoID();
	       String filename = request.getParameter("inputFile");
	       Upload.uploadPhoto(filename, "./IMAGE/" + userid + "/" + photoid);
	       response.sendRedirect(request.getContextPath() + "/photostream.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
