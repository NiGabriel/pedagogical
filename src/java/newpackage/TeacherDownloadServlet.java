
package newpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "TeacherDownloadServlet", urlPatterns = {"/TeacherDownloadServlet"})
public class TeacherDownloadServlet extends HttpServlet {

   public static int BUFFER_SIZE = 1024 * 100;
    public static final String UPLOAD_DIR = "teacherresources";
    public static String tfileName = null;
    public static String tfileNamex = null;
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	
	tfileName = request.getParameter("tfileName");
	tfileNamex = request.getParameter("tfileNamex");
	
	if(tfileName == null || tfileName.equals("")){
	    
	    response.setContentType("text/html");
	    
	    response.getWriter().println("<h3>File " + tfileName + "is not present</h3>");
	    
	}
	else{
	    String applicationPath = getServletContext().getRealPath("");
	    String downloadPath = applicationPath + File.separator + UPLOAD_DIR;
	    String filePath = downloadPath + File.separator + tfileName;
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

		response.getWriter().println("<h3>File " + tfileName + "is not present</h3>");
	    }
	}
	if(tfileNamex == null || tfileNamex.equals("")){
	    
	    response.setContentType("text/html");
	    
	    response.getWriter().println("<h3>File " + tfileNamex + "is not present</h3>");
	    
	}
	else{
	    String applicationPath = getServletContext().getRealPath("");
	    String downloadPath = applicationPath + File.separator + UPLOAD_DIR;
	    String filePath = downloadPath + File.separator + tfileNamex;
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

		response.getWriter().println("<h3>File " + tfileNamex + "is not present</h3>");
	    }
	}
}}