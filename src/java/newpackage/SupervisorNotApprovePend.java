/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author IPRC KARONGI
 */
public class SupervisorNotApprovePend extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try (PrintWriter out = response.getWriter()) {
	    /* TODO output your page here. You may use following sample code. */
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Not Approved documents</title>");	    
	    out.println("</head>");
	    out.println("<body>");
	    
	    String did = request.getParameter("idna");
	    int id=Integer.parseInt(did);
	    
	    DateTimeFormatter dt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	    LocalDateTime now = LocalDateTime.now();
	    
	    String createdon = dt.format(now);
	    
	    UserDatabase NotApDoc = new UserDatabase(ConnectionPro.getConnection());
	    
	    Connection conp = ConnectionPro.getConnection();
	    Statement stp = null;
	    ResultSet rsp = null;
	    stp = conp.createStatement();
	   
	    String datap = "select * from teacherpendingdoc where id = '"+id+"'";
	    
	    rsp = stp.executeQuery(datap);
	    rsp.next();
	    
	    String Tit = rsp.getString("title");
	    String Des = rsp.getString("description");
	    String Aut = rsp.getString("author");
	    
	    //make user object
	    user TeacherNotApModel = new user.teacherNotAp(Tit, Des, Aut, createdon);

	    //create a database model
	    
	    if (NotApDoc.saveNotApDoc(TeacherNotApModel)) {
		UserDatabase.deleteTeacherPendDoc(id);
	       response.sendRedirect("Supervisors.jsp");
	    } else {
		String errorMessage = "User Available";
		HttpSession regSession = request.getSession();
		regSession.setAttribute("RegError", errorMessage);
		response.sendRedirect("Supervisors.jsp");
	    }
	    out.println("</body>");
	    out.println("</html>");
	} catch (SQLException ex) {
	    Logger.getLogger(SupervisorNotApprovePend.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
