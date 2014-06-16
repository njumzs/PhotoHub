<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="photohub.*"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*"%>
<%@ page import="javax.servlet.http.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.*"%>
<%@ page import="org.apache.commons.fileupload.servlet.*"%>
<%@ page import="org.apache.commons.io.output.*"%>

<%!
    Integer userid = null; 
%>
<% 
/*
	System.out.println("uploading ...");
	String introduction = request.getParameter("inputIntroduction");
	String filename = request.getParameter("inputPath") + request.getParameter("inputFile");

	Integer userid = (Integer) request.getSession().getAttribute("userId");
	if (userid < 0) {
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}

	int photoid = TablePhoto.photoID();
	System.out.println("store " + filename + " to photo/" + userid + "/"
			+ photoid);
	Upload.uploadPhoto(userid.intValue(), filename,
			"photo/" + userid.toString() + "/");
	// TablePhoto.(photoid);
	response.sendRedirect(request.getContextPath() + "/photostream.jsp");
*/	
%>
<%
/*
	File file;
	int maxFileSize = 5000 * 1024;
	int maxMemSize = 5000 * 1024;
	ServletContext context = pageContext.getServletContext();
	String filePath = context.getInitParameter("photo");
	System.out.println("filepath " + filePath);

	// Verify the content type
	String contentType = request.getContentType();
	if ((contentType.indexOf("multipart/form-data") >= 0)) {

		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("photo"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);
		try {
			// Parse the request to get file items.
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(filePath
								+ fileName.substring(fileName
										.lastIndexOf("\\")));
					} else {
						file = new File(filePath
								+ fileName.substring(fileName
										.lastIndexOf("\\") + 1));
					}
					fi.write(file);
					System.out.println("Uploaded Filename: " + filePath
							+ fileName);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	*/
%>
<%
System.out.println("uploading ...");
String introduction = request.getParameter("inputIntroduction");
//System.out.println("introduction " + introduction);
//String filename = request.getParameter("inputPath") + request.getParameter("inputFile");

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
		for (int i = 0; i < items.size(); i++) {
			FileItem item = items.get(i);
			String path = null;
			String fileName = null;
			String suffix = null;
			int photoid = TablePhoto.photoID();

			if (!item.isFormField()) {
				//ServletContext sctx = getServletContext();

				//path = request.getContextPath() + File.separator + "photo";
				//String path = getServletContext().getInitParameter("upload-photo");
				path = "C:\\Users\\cc\\Documents\\GitHub\\PhotoHub\\WebContent\\IMAGE";
				fileName = item.getName();
				System.out.println("filename " + path + "\\" + fileName);
				System.out.println("point at " + fileName.lastIndexOf("."));
				
				File filePath = new File(path);

				if (!filePath.exists()) {
					filePath.mkdir();
				}

				//suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
				//System.out.println("suffix " + suffix);
				File file = new File(path + "\\" + fileName);
				if (file.length() > 1024 * 1024 * 10) {
					response.sendRedirect("sizefalse.jsp");
				}

				//request.getSession().setAttribute("photoPath", fileName);
				item.write(file);
				
				System.out.println("get id ...");
				/* System.out.println("userid " + userid.intValue()
						+ " path " + path + "\\" + photoid + "."
						+ fileName
						+ " photoid " + photoid);*/
				TablePhoto.InvertPhoto(userid.intValue(), path + "\\" + fileName, photoid);
			}
		}
		response.sendRedirect(request.getContextPath() + "/photostream.jsp");
		return ;
		
	} catch (Exception e) {
		e.printStackTrace();
	}


%>
