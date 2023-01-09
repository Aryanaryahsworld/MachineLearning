/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Naive", urlPatterns = {"/Naive"})
public class Naive extends HttpServlet {
    

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
        String filename = request.getParameter("filename");
        try 
        {
            BufferedReader breader = null;
            breader= new BufferedReader(new FileReader(filename));
            Instances train = new Instances(breader);
            train.setClassIndex(train.numAttributes()-1);
            breader.close();
            
            NaiveBayes nb = new NaiveBayes();
            nb.buildClassifier(train);
            Evaluation eval = new Evaluation(train);
            eval.crossValidateModel(nb, train, 10, new Random(1));
//            jTextArea1.append(eval.toSummaryString("\nResults\n----------\n\n",true));
//            jTextArea1.append("F-Measure Score : "+eval.fMeasure(1)+"\n"+"Precision Score : "+eval.precision(1)+"\n"+"Recall Score : "+eval.recall(1));
//            jTextArea1.append("Confusion Matrix : "+eval.toMatrixString());
            String data1=eval.toSummaryString("\nResults\n----------\n",true)+" "+"F-Measure Score : "+eval.fMeasure(1)+"\n"+"Precision Score : "+eval.precision(1)+"\n"+"Recall Score : "+eval.recall(1)+"\n"+"Confusion Matrix : "+eval.toMatrixString();
            System.out.println(eval.toSummaryString("\nResults\n----------\n",true));
            System.out.println(eval.fMeasure(1)+" "+eval.precision(1)+" "+eval.recall(1));
            request.setAttribute("sans", data1);
        RequestDispatcher view = request.getRequestDispatcher("NaiveBayes.jsp");
          view.forward(request, response);
        }
        catch (Exception e)
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
