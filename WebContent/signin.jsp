<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="photohub.* " %>
<%! String useremail = null;
	int userid = -1;
%>
<%  useremail = request.getParameter("signinEmail");
	String password = request.getParameter("signinPassword");
	System.out.println("sign in " + useremail + " " + password);
	userid = TableUser.signIn(useremail, password);
	if (userid < 0 ) {
		System.out.println("sign in failed");
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}
	System.out.println("User : " + useremail + " (id : " + userid + ") sign in successfully");
	
	session.setAttribute("userId", userid);
	session.setAttribute("userEmail", useremail);
	if (session.getAttribute("userEmail") == null || session.getAttribute("userEmail").toString().equals("")) {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}
	response.sendRedirect(request.getContextPath() + "/photostream.jsp");	
%>
