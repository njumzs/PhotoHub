<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="photohub.*"%>
<%!
    int userid = -1; 
%>
<% 
userid = (Integer)(request.getSession()).getAttribute("userId"); 
   if (userid < 0) {
   		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}

   Integer photoid = TablePhoto.photoID();
   String filename = request.getParameter("inputFile");
   Upload.uploadPhoto(filename, "./IMAGE/" + userid + "/" + photoid);
   response.sendRedirect(request.getContextPath() + "/photostream.jsp");
%>  
