/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Filter", urlPatterns = {"/Filter"})
public class Filter extends HttpServlet {
String filename="";
int counter=0;
    String [] tokens = new String[50000];
    //String []trimmed= new String[tokens.length];
    ArrayList<String> trimmed = new ArrayList<String>();
    String[] stopwords ={"a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost", 
                "alone", "along", "already", "also","although","always","am","among", "amongst", "amoungst", "amount",  "an", "and", 
                "another", "any","anyhow","anyone","anything","anyway", "anywhere", "are", "around", "as",  "at", "back","be","became", 
                "because","become","becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", 
                "between", "beyond", "bill", "both", "bottom","but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt",
                "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", "eleven","else",
                "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", 
                "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", 
                "front", "full", "further", "get", "give", "go", "had", "has", "hasnt",
                "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", 
                "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", 
                "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", 
                "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", 
                "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", 
                "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", 
                "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own","part", "per", "perhaps",
                "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she",
                "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", 
                "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", "their", 
                "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", 
                "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", 
                "thus", "to", "together", "too", "top", "toward", "towards", "twelve", "twenty", "two", "un", "under", "until", 
                "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever",
                "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", 
                "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet",
                "you","you're", "your", "yours", "yourself", "yourselves","1","2","3","4","5","6","7","8","9","10","1.","2.","3.","4.","5.","6.","11",
                "7.","8.","9.","12","13","14","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
                "terms","CONDITIONS","conditions","values","interested.","care","sure",".","!","@","#","$","%","^","&","*","(",")","{","}","[","]",":",";",",","<",".",">","/","?","_","-","+","=",
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                "contact","grounds","buyers","tried","said,","plan","value","principle.","forces","sent:","is,","was","like",
                "discussion","tmus","diffrent.","layout","area.","thanks","thankyou","hello","bye","rise","fell","fall","psqft.","http://","km","miles"};
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
        filename=request.getParameter("filename");
        try
        {
        File file = new File("D://file.txt");
        file.delete();
    BufferedReader br = new BufferedReader(new FileReader(filename));
    String line;
    while ((line = br.readLine()) != null) 
    {   
         tokens = line.split(" ");
         for (int i = 0; i < tokens.length; i++) 
         {
             for (int j = 0; j < stopwords.length; j++) 
             {
                 if(tokens[i].equalsIgnoreCase(stopwords[j]))
                 {
                     tokens[i]="";
                     break;
                 }
                 if(tokens[i].endsWith("."))
                 {
                     tokens[i]=tokens[i].substring(0,tokens[i].length()-1);
                 }
                 if(tokens[i].endsWith("s"))
                 {
                     tokens[i]=tokens[i].substring(0,tokens[i].length()-1);
                 }
                 if(tokens[i].endsWith("ed"))
                 {
                     tokens[i]=tokens[i].substring(0,tokens[i].length()-2);
                 }
                 if(tokens[i].endsWith("ing"))
                 {
                     tokens[i]=tokens[i].substring(0,tokens[i].length()-3);
                 }
                 if(tokens[i].endsWith("ion"))
                 {
                     tokens[i]=tokens[i].substring(0,tokens[i].length()-3);
                 }
                 if(tokens[i].contains("."))
                 {
                     tokens[i]=tokens[i].replace(".","");
                     break;
                 }
                 if(tokens[i].contains(":"))
                 {
                     tokens[i]=tokens[i].replace(":","");
                 }
                 if(tokens[i].contains(","))
                 {
                     tokens[i]=tokens[i].replace(",","");
                 }
             }
             //System.out.println(tokens[i]);
            
         }   
         for (int i = 0; i < tokens.length; i++)
    {
        if(tokens[i].equals("") || tokens[i].equals(null))
        {  
            
        }
        else
        {
            trimmed.add(tokens[i].toLowerCase());
            //System.out.println(tokens[i]);
        }
        
    }
    }
    br.close();
    JOptionPane.showMessageDialog(null,"Filtering and Stemming Successfull");
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
