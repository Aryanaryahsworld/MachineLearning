/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name="DownloadReport",urlPatterns={"/DownloadReport"})
public class DownloadReport extends HttpServlet{
    private String str1;

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
    private static final int DEFAULT_BUFFER_SIZE = 10240;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
             String mail = session.getAttribute("email").toString();
        String filename = request.getParameter("fname"); 
  String filepath = "D:/medical/"+mail+"/"; 
  response.setContentType("APPLICATION/OCTET-STREAM");
        File file=new File(filepath+filename);
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");

        // Prepare streams.
        BufferedInputStream input = null;
        BufferedOutputStream output = null;

        try {
            // Open streams.
            input = new BufferedInputStream(new FileInputStream(file), DEFAULT_BUFFER_SIZE);
            output = new BufferedOutputStream(response.getOutputStream(), DEFAULT_BUFFER_SIZE);

            // Write file contents to response.
            byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } finally {
            // Gently close streams.
            close(output);
         
        }

//    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//                Date date = new Date();
//                String dat =dateFormat.format(date).toString();
//                String content = mail+" Downloaded file "+filename+" at "+dat;
                //File file1 = new File("/opt/tomcat/webapps/cc3/"+mail+"/"+"Logs"+"/"+"Download.txt");
//                if (!file1.exists()) {
//				file1.createNewFile();
//			}
 
//			FileWriter fw = new FileWriter(file1.getAbsoluteFile(),true);
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(content);
//                        bw.write("\r\n");
//			bw.close();
//        try {
//            /* TODO output your page here. You may use following sample code. */
////            out.println("<!DOCTYPE html>");
////            out.println("<html>");
////            out.println("<head>");
////            out.println("<title>Servlet dwnservlet</title>");            
////            out.println("</head>");
////            out.println("<body>");
////            out.println("<h1>Servlet dwnservlet at " + request.getContextPath() + "</h1>");
////            out.println("</body>");
////            out.println("</html>");
//        } finally {            
         //  out.close();
//        }
    }
private static void close(Closeable resource) {
        if (resource != null) {
            try {
                resource.close();
            } catch (IOException e) {
                // Do your thing with the exception. Print it, log it or mail it.
                e.printStackTrace();
            }
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
