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
@WebServlet(name = "Log"
        + "in", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
         String email="",pass="",submit="";
            
            email=request.getParameter("email");
            pass=request.getParameter("pass");
            submit=request.getParameter("sub1");
                try
                {
                    HttpSession session= request.getSession(true);
                
                    
                    int i;
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		   Connection conn=DriverManager.getConnection("jdbc:odbc:medical");
                    String t1="select * from patient";
                  
                  
                   Statement st=conn.createStatement();
                  ResultSet rs =st.executeQuery(t1);
                  while(rs.next())
                  {
                      String str=rs.getString("mailid");
                      String str1= rs.getString("pass");
                      if(str.equals(email) && str1.equals(pass))
                      {
                          session.setAttribute("email",email );
                          response.sendRedirect("User.jsp");
                      }
                      
                      else
           {
               out.println("<script type=\"text/javascript\">");  
           out.println("alert('Invalid Username or Password') ");  
           out.println("window.location.href='http://localhost:8080/DiseaseTreatweb1/Login.jsp';");
           out.println("</script>");
           }
                  }
                  if(email.equals("admin") && pass.equals("admin"))
                      {
                          session.setAttribute("email",email );
                          response.sendRedirect("index.jsp");
                      }
                }
                catch(Exception e)
                {
                    System.out.println(e);
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
