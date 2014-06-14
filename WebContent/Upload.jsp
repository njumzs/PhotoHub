<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%!
    int userid = Integer.parseInt((String)session.getAttribute("userId")); 
%>
<% 
   if (userid < 0) {
   		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}

   Integer photoid = TablePhoto.photoID();
   String filename = getElement("inputFile");
   Upload.uploadPhoto(filename, "./IMAGE/" + userid + "/" + photoid.toString);
   response.sendRedirect(request.getContextPath() + "/photostream.jsp");
%>  
