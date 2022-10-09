
package newpackage;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(name = "SupervisorDownloadServlet", urlPatterns = {"/SupervisorDownloadServlet"})
public class SupervisorDownloadServlet extends HttpServlet {
    
    public static int BUFFER_SIZE = 1024 * 100;
    public static final String UPLOAD_DIR = "resources";
    public static String fileName = null;
    public static String fileNamexx = null;
    //public static String fileNamet = null;

   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	fileName = request.getParameter("fileName");
	fileNamexx = request.getParameter("tfileNamexx");
	
	if(fileName == null || fileName.equals("")){
	    
	    response.setContentType("text/html");
	    
	    response.getWriter().println("<h3>File " + fileName + "is not present</h3>");
	    
	}
	else{
	    String applicationPath = getServletContext().getRealPath("");
	    String downloadPath = applicationPath + File.separator + UPLOAD_DIR;
	    String filePath = downloadPath + File.separator + fileName;
	    File file = new File(filePath);
	    OutputStream outStream = null;
	    FileInputStream inputStream = null;
	    
	    if (file.exists()) {
		String mimeType = "application/octet-stream";
		response.setContentType(mimeType);

		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
		response.setHeader(headerKey, headerValue);

		try {
		    outStream = response.getOutputStream();
		    inputStream = new FileInputStream(file);
		    byte[] buffer = new byte[BUFFER_SIZE];
		    int bytesRead = -1;
		    while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		    }
		} catch (IOException ioExObj) {
		    System.out.println("Exception while performing the I/O operatings?= " + ioExObj.getMessage());
		} finally {
		    if (inputStream != null) {
			inputStream.close();
		    }
		    outStream.flush();
		    if (outStream != null) {
			outStream.close();
		    }
		}
	    } else {

		response.setContentType("text/html");

		response.getWriter().println("<h3>File " + fileName + "is not present</h3>");
	    }
	}
	
	if(fileNamexx == null || fileNamexx.equals("")){
	    
	    response.setContentType("text/html");
	    
	    response.getWriter().println("<h3>File " + fileNamexx + "is not present</h3>");
	    
	}
	else{
	    String applicationPath = getServletContext().getRealPath("");
	    String downloadPath = applicationPath + File.separator + UPLOAD_DIR;
	    String filePath = downloadPath + File.separator + fileNamexx;
	    File file = new File(filePath);
	    OutputStream outStream = null;
	    FileInputStream inputStream = null;
	    
	    if (file.exists()) {
		String mimeType = "application/octet-stream";
		response.setContentType(mimeType);

		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", file.getName());
		response.setHeader(headerKey, headerValue);

		try {
		    outStream = response.getOutputStream();
		    inputStream = new FileInputStream(file);
		    byte[] buffer = new byte[BUFFER_SIZE];
		    int bytesRead = -1;
		    while ((bytesRead = inputStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		    }
		} catch (IOException ioExObj) {
		    System.out.println("Exception while performing the I/O operatings?= " + ioExObj.getMessage());
		} finally {
		    if (inputStream != null) {
			inputStream.close();
		    }
		    outStream.flush();
		    if (outStream != null) {
			outStream.close();
		    }
		}
	    } else {

		response.setContentType("text/html");

		response.getWriter().println("<h3>File " + fileNamexx + "is not present</h3>");
	    }
	}
}}