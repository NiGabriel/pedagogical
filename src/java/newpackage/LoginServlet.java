/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author IPRC KARONGI
 */
public class LoginServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	response.setContentType("text/html;charset=UTF-8");
	try (PrintWriter out = response.getWriter()) {
	    /* TODO output your page here. You may use following sample code. */
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Servlet LoginServlet</title>");	    
	    out.println("</head>");
	    out.println("<body>");
	    
	    //feth data from login form
            
            String logemail = request.getParameter("email");
            String logpass = request.getParameter("password");
	    String rolen = request.getParameter("roln");
            
            UserDatabase db =  new UserDatabase(ConnectionPro.getConnection());
            user userAdmin = db.logAdministrator(logemail, logpass);
	    user userSupervisor = db.logSupervisor(logemail, logpass);
	    user userTeacher = db.logTeacher(logemail, logpass);
	    user userParent = db.logParent(logemail, logpass);
            //user rol = db.selectType();
	    
	    if("Admin".equals(rolen)){
		if(userAdmin!=null){
                HttpSession session = request.getSession();
                session.setAttribute("logAdministrator", userAdmin);
                response.sendRedirect("Admin.jsp");
            }else{
		out.println("<script type=\"text/javascript\">");
		out.println("alert('Invalid Username or Password');");
		out.println("location='index.jsp';");
		out.println("</script>");
                
		
            }
	    }
	    else if("Teacher".equals(rolen)){
		if(userTeacher!=null){
                HttpSession session = request.getSession();
                session.setAttribute("logTeacher", userTeacher);
                response.sendRedirect("Teachers.jsp");
            }else{
                out.println("<script type=\"text/javascript\">");
		out.println("alert('Invalid Username or Password');");
		out.println("location='index.jsp';");
		out.println("</script>");
            }
	    }
	    else if("Supervisor".equals(rolen)){
		if(userSupervisor!=null){
                HttpSession session = request.getSession();
                session.setAttribute("logSupervisor", userSupervisor);
                response.sendRedirect("Supervisors.jsp");
            }else{
                out.println("<script type=\"text/javascript\">");
		out.println("alert('Invalid Username or Password');");
		out.println("location='index.jsp';");
		out.println("</script>");
            }
	    }
	    else if("Parent".equals(rolen)){
		if(userParent!=null){
                HttpSession session = request.getSession();
                session.setAttribute("logParent", userParent);
                response.sendRedirect("Parent.jsp");
            }else{
                out.println("<script type=\"text/javascript\">");
		out.println("alert('Invalid Username or Password');");
		out.println("location='index.jsp';");
		out.println("</script>");
            }
	    }
            

	    
	    out.println("</body>");
	    out.println("</html>");
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
