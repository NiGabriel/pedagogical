/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author IPRC KARONGI
 */
public class SupervisorEditServlet extends HttpServlet {

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
	    out.println("<title>Supervisor Edit</title>");	    
	    out.println("</head>");
	    out.println("<body>");
	    
	     String sid = request.getParameter("sid");
	     int idsupervisor = Integer.parseInt(sid);
	    String sname = request.getParameter("sname");
	    String suname = request.getParameter("suname");
	    String spass = request.getParameter("spass");
	    String stel = request.getParameter("stel");
	    
	    user e = new user();
	    e.setSid(idsupervisor);
	    e.setSname(sname);
	    e.setSuname(suname);
	    e.setSpass(spass);
	    e.setStel(stel);
	    int status = UserDatabase.updateSupervisor(e);
	    if (status > 0) {
		response.sendRedirect("Admin.jsp#teachers");
	    } else {
		out.println("Sorry! unable to update record");
	    }
	    out.close();
	    
	    out.println("</body>");
	    out.println("</html>");
	}
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
	return "Short description";
    }// </editor-fold>

}
