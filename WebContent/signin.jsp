<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="photohub.*"%>
<%! String useremail = null;
	int userid = -1;
%>
<%  useremail = request.getParameter("signinEmail");
	String password = request.getParameter("signinPassword");
	System.out.println("sign in " + useremail + " " + password);
	if ( (userid = TableUser.signIn(useremail, password)) < 0 ) {
		System.out.println("sign in failed");
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}
	System.out.println("User : " + useremail + " (id : " + userid + ") sign in successfully");
	
	session.setAttribute("userId", (new Integer(userid)).toString);
	session.setAttribute("userEmail", useremail);
	if (session.getAttribute("userEmail") == null || session.getAttribute("userEmail").toString().equals("")) {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}
	response.sendRedirect(request.getContextPath() + "/photostream.jsp");	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>