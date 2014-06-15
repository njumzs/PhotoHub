package photohubservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import photohub.TableUser;

/**
 * Servlet implementation class signin
 */
@WebServlet("/signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SigninServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String useremail = null;
		Integer userid = -1;

		useremail = request.getParameter("signinEmail");
		String password = request.getParameter("signinPassword");
		System.out.println("sign in " + useremail + " " + password);
		try {
			userid = TableUser.signIn(useremail, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (userid < 0 ) {
			System.out.println("sign in failed");
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		System.out.println("User : " + useremail + " (id : " + userid + ") sign in successfully");
		
		userid = TableUser.userID();
		if (userid < 0) {
			response.sendRedirect(request.getContextPath() + "/index.jsp");
			return;
		}
		System.out.println("userid " + userid);
		request.getSession().setAttribute("userId", (new Integer(userid)));
		request.getSession().setAttribute("userEmail", useremail);
		response.sendRedirect(request.getContextPath() + "/photostream.jsp");	
	}

}
