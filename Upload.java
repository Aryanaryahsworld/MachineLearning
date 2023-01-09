/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 *
 * @author Administrator
 */
@WebServlet(name = "Upload", urlPatterns = {"/Upload"})
public class Upload extends HttpServlet {
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out1 = response.getWriter();
                String str=null;
                String fpath=null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	 
	        if (isMultipart) {
	        	// Create a factory for disk-based file items
	        	FileItemFactory factory = new DiskFileItemFactory();
// out1.println("<html><body><script type=\"text/javascript\">");  
//                              out1.println("confirm('FileItemfactory');");  
//                              out1.println("</script></body></html>"); 
	        	// Create a new file upload handler
	        	ServletFileUpload upload = new ServletFileUpload(factory);
//	  out1.println("<html><body><script type=\"text/javascript\">");  
//                              out1.println("confirm('servletupload');");  
//                              out1.println("</script></body></html>"); 
	            try {
                        HttpSession session = request.getSession();
                        String mail = session.getAttribute("email").toString();
	            	// Parse the request
	            	List /* FileItem */ items = upload.parseRequest(request);
	                Iterator iterator = items.iterator();
	                while (iterator.hasNext()) {
	                    FileItem item = (FileItem) iterator.next();
	                    if (!item.isFormField()) {
	                        String fileName = item.getName();	 
	                        String root = getServletContext().getRealPath("/");
	                        File path = new File("D:/medical/"+mail+"/");
                                 //File path1 = new File("/opt/tomcat/webapps/cc3/"+mail+"/"+"Backup");
                               fpath=root+ "/uploads";
//                                 out1.println("<html><body><script type=\"text/javascript\">");  
//                              out1.println("confirm('uploads');");  
//                              out1.println("</script></body></html>"); 
	                        if (!path.exists()) {
	                            boolean status = path.mkdirs();
	                        }
//                                if (!path1.exists()) {
//	                            boolean status = path1.mkdirs();
//	                        }
	 
                        File uploadedFile = new File(path + "/" + fileName);
                         //File uploadedFile1 = new File(path1 + "/" + fileName);       
	                        System.out.println(uploadedFile.getAbsolutePath());
	                        item.write(uploadedFile);
                               // item.write(uploadedFile1);
                                str=" file uploaded";
//                               enc e = new enc();
//                               e.Encrypt(path + "/" + fileName);
//                                File f = new File(path+"//"+fileName);
//                               f.delete();
//                               
//                               e.Encrypt(path1 + "/" + fileName);
//                                File f1 = new File(path1+"//"+fileName);
//                               f1.delete();
                               
//                               DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//                Date date = new Date();
//                String dat =dateFormat.format(date).toString();
//                String content = mail+" uploaded file "+fileName+" at "+dat;
//                File file = new File("/opt/tomcat/webapps/cc3/"+mail+"/"+"Logs"+"/"+"Upload.txt");
//                if (!file.exists()) {
//				file.createNewFile();
//			}
// 
//			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
//			BufferedWriter bw = new BufferedWriter(fw);
//			bw.write(content);
//                        bw.write("\r\n");
//			bw.close();
	                    }
	                }
	            } catch (FileUploadException e) {
	              System.out.println(e.getMessage());
                      str=e.getMessage();
                        //  e.printStackTrace();
	            } catch (Exception e) {
                         System.out.println(e.getMessage());
                           str=e.getMessage();
	              //  e.printStackTrace();
	            }
	        }
                
//                File file = new File(txtpath);
//        FileInputStream fis = new FileInputStream(file);
             
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet uploadservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" +str + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
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
