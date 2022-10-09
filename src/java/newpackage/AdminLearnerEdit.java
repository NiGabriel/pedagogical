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
public class AdminLearnerEdit extends HttpServlet {

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
	    out.println("<link rel=\"stylesheet\" href=\"css/styleAdmin.css\">");
	    out.println("<script src =\"https://kit.fontawesome.com/a076d05399.js\"></script>");
	    out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\" integrity=\"sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO\" crossorigin=\"anonymous\">");
	    out.println("<script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js\" integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\" crossorigin=\"anonymous\"></script>");
	    out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js\" integrity=\"sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN\" crossorigin=\"anonymous\"></script>");
	    out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js\" integrity=\"sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/\" crossorigin=\"anonymous\"></script>");
	    out.println("<script src=\"https://cdn.ckeditor.com/4.16.2/standard/ckeditor.js\"></script>");
	    
	    out.println("<title>Admin - Edit learner</title>");	    
	    out.println("</head>");
	    out.println("<body>");
	    
	    String idxs = request.getParameter("lid");
	    //int myId = Integer.parseInt(idxs);

	    user e = UserDatabase.getLearnerById(idxs);
	    
	    out.println("<div class=\"banner\"></div>");
	    out.println("<div class=\"main-content\">");
	    
	    out.println("<div class=\"card-header\">\n" +
"			    <h2> pedagogical document System - Modify learner's data</h2>\n" +
"			</div>");
	    
	    
	    out.println("<div class=\"modal-content\">");
	    out.println("<div class=\"modal-body\">");
	    
	    
	    
	    out.println("<button class=\"btn btn-success badge-pill\" data-bs-toggle=\"modal\" onclick=\"window.print();return false;\" style=\"width: 80px;\"> PRINT </button>");
	    out.println("<button class=\"btn btn-success badge-pill\" data-bs-toggle=\"modal\" style=\"width: 80px;\"> <a href=\"Admin.jsp\" style=\"color: white;\">BACK</a> </button>");
	    out.print("<form action='LearnerEditServlet' method='post'>");
	    out.println("<div class=\"mb-3\">");
	    out.print("<input type ='hidden' name ='lid' value ='"+e.getLid()+"'/>");
	    out.println("</div>");
	    out.println("<div class=\"mb-3\">");
	    out.print("Names of learner:<input type='text' name='lname' class=\"form-control\" style=\"width: 270px;\" value='" + e.getLname() + "'/>");
	    out.println("</div>");
	    out.println("<div class=\"mb-3\">");
	    out.print("Level of study:<input type='text' name='llevel' class=\"form-control\" style=\"width: 270px;\" value='" + e.getLlevel() +"'/>");
	    out.println("</div>");
	    out.println("<div class=\"mb-3\">");
	    out.print("Date of birth:<input type='text' name='lbirth' class=\"form-control\" style=\"width: 270px;\" value='" + e.getLbirth() +"'/>");
	    out.println("</div>");
	    out.println("<div class=\"mb-3\">");
	    out.print("Names of father:<input type='text' name='lfather' class=\"form-control\" style=\"width: 270px;\" value='" + e.getLfather() +"'/>");
	    out.println("</div>");
	    out.println("<div class=\"mb-3\">");
	    out.print("Names of mother:<input type='text' name='lmother' class=\"form-control\" style=\"width: 270px;\" value='" + e.getLmother() +"'/>");
	    out.println("</div>");

	    out.println("<div class=\"mb-3\">");

	    out.print("<input type='submit' class=\"btn btn-primary\" value='Edit & Save '/>");
	    out.println("</div>");
	    out.print("</form>");
	    out.println("</div>");
	    out.println("</div>");
	    out.println("</div>");
	    
	    out.close();
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
