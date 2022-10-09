
package newpackage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet (name = "TeacherUploadServlet", urlPatterns = {"/TeacherUploadServelt"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
	maxFileSize = 1024 * 1024 * 1000,
	maxRequestSize = 1024 * 1024 * 1000)

public class TeacherUploadServlet extends HttpServlet {

    PrintWriter out = null;
    Connection con = null;
    PreparedStatement ps = null;
    HttpSession session = null;

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	try{
	    out = response.getWriter();
	    session = request.getSession(false);
	    String folderName = "teacherresources";
	    String uploadPath = request.getServletContext().getRealPath("")+ File.separator + folderName;
	    File dir = new File(uploadPath);
	    if(!dir.exists()){
		dir.mkdirs();
	    }
	    Part filePart = request.getPart("tfile");
	    String TAuthor = request.getParameter("tauthor");
	    String tfileName = filePart.getSubmittedFileName();
	    String path = folderName + File.separator + tfileName;
	    Timestamp added_date = new Timestamp(System.currentTimeMillis());
	    System.out.println("tfileName: " + tfileName);
	    System.out.println("Path: " + uploadPath);
	    System.out.println("Name: " + TAuthor);
	    InputStream is = filePart.getInputStream();
	    Files.copy(is, Paths.get(uploadPath + File.separator + tfileName), StandardCopyOption.REPLACE_EXISTING);
	    
	    try{
		con = ConnectionPro.getConnection();
		System.out.println("Connection done");
		String sql = "insert into teacherupload(author, filename, path, added_date) values(?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, TAuthor);
		ps.setString(2, tfileName);
		ps.setString(3, path);
		ps.setTimestamp(4, added_date);
		int status = ps.executeUpdate();
		if(status>0){
		    session.setAttribute("filename", tfileName);
		    String msg = "" + tfileName + "File uploaded successfully";
		    request.setAttribute("msg", msg);
		    response.sendRedirect("Teachers.jsp");
		}
		
	    }
	    catch(SQLException e){
		out.println("Exception: " +e);
		System.out.println("Exception: " +e);
	    }
	    finally{
		try{
		    if(ps != null){
			ps.close();
		    }
		    if(con != null){
			con.close();
		    }
		    
		}
		catch(SQLException e){
		    out.println(e);
		}
	    }
	    
	    
	}
	catch(IOException | ServletException e){
	    out.println("Exception: " + e);
	    System.out.println("Exception2: " + e);
	}
    }

}
