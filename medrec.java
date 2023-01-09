/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "medrec", urlPatterns = {"/medrec"})
public class medrec extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String query,patientId,Name,Sex,Age,disease,mailId,allergy,medicine,doctor;
            
        int i=0;
                HttpSession session= request.getSession(true);
		Name=request.getParameter("name");
		Sex=request.getParameter("sex");
		Age=request.getParameter("age");
		disease=request.getParameter("disease");
		mailId=session.getAttribute("email").toString();
		allergy=request.getParameter("allergy");
		medicine=request.getParameter("medicine");
                doctor=request.getParameter("doctor");
         
         try
                {
                   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   Connection conn=DriverManager.getConnection("jdbc:odbc:medical");
		   Statement stmt=conn.createStatement();
		   ResultSet rs; 
            
            if(request.getParameter("btnsubmit")!=null)
            {
                
                if(disease.equals("") || Name.equals("") || Age.equals("") || medicine.equals("") || doctor.equals("") || Sex.equals("") || mailId.equals("") || allergy.equals(""))
                {
                    out.println("<script language='javascript'>alert('Please Enter Complete Values!!!!!!!!');</script>");
                }
                else
                {                      
                query="insert into medrecord values('"+0+"','"+Name+"','"+Sex+"','"+Age+"','"+mailId+"','"+allergy+"','"+disease+"','"+medicine+"','"+doctor+"')";
		i=stmt.executeUpdate(query);
		if(i==1)
		{
			
                       // out.println("<script language='javascript'>alert('Details Added Successfully!!!!!!!!!');</script>");
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Details Added Successfully!!!!!!!!!');");
                    out.println("window.location.href='http://localhost:8080/DiseaseTreatwebv1/User.jsp';");
                    
                        
                        out.println("</script>");
			
		}
                }
                }
                   
              


              
              }
                catch(Exception e)
                {
                   e.printStackTrace();
                   out.println(e);                   
                }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
