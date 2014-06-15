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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String introduction = request.getParameter("inputIntroduction"); 
		String filename = request.getParameter("inputFile"); 

	    Integer userid = (Integer) request.getSession().getAttribute("userId"); 
	       if (userid < 0) {
	       		response.sendRedirect(request.getContextPath() + "/index.jsp");
	    		return;
	    	}

	       int photoid = TablePhoto.photoID();
	       System.out.println("store " + filename + " to ./IMAGE/" + userid + "/" + photoid);
	       Upload.uploadPhoto(userid.intValue(), filename, "./IMAGE/" + userid.toString() + "/");
	       TablePhoto.introduction(photoid);
	       response.sendRedirect(request.getContextPath() + "/photostream.jsp");
	}

}
