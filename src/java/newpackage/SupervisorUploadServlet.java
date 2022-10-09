/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.*;
import java.nio.file.*;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

/**
 *
 * @author IPRC KARONGI
 */
@WebServlet (name = "SupervisorUploadServlet", urlPatterns = {"/SupervisorUploadServelt"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10,
	maxFileSize = 1024 * 1024 * 1000,
	maxRequestSize = 1024 * 1024 * 1000)
public class SupervisorUploadServlet extends HttpServlet {
    PrintWriter out = null;
    Connection con = null;
    PreparedStatement ps = null;
    HttpSession session = null;

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	try{
	    out = response.getWriter();
	    session = request.getSession(false);
	    String folderName = "resources";
	    String uploadPath = request.getServletContext().getRealPath("")+ File.separator + folderName;
	    File dir = new File(uploadPath);
	    if(!dir.exists()){
		dir.mkdirs();
	    }
	    Part filePart = request.getPart("file");
	    String FileType = request.getParameter("ftype");
	    String fileName = filePart.getSubmittedFileName();
	    String path = folderName + File.separator + fileName;
	    Timestamp added_date = new Timestamp(System.currentTimeMillis());
	    System.out.println("fileName: " + fileName);
	    System.out.println("Path: " + uploadPath);
	    System.out.println("Name: " + FileType);
	    InputStream is = filePart.getInputStream();
	    Files.copy(is, Paths.get(uploadPath + File.separator + fileName), StandardCopyOption.REPLACE_EXISTING);
	    
	    try{
		con = ConnectionPro.getConnection();
		System.out.println("Connection done");
		String sql = "insert into supervisorupload(author, filename, path, added_date) values(?,?,?,?)";
		ps = con.prepareStatement(sql);
		ps.setString(1, FileType);
		ps.setString(2, fileName);
		ps.setString(3, path);
		ps.setTimestamp(4, added_date);
		int status = ps.executeUpdate();
		if(status>0){
		    session.setAttribute("filename", fileName);
		    String msg = "" + fileName + "File uploaded successfully";
		    request.setAttribute("msg", msg);
		    response.sendRedirect("Supervisors.jsp");
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
