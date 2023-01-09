/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Amit
 */
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.sql.*;
import javax.swing.JPopupMenu;
import java.util.*;
import javax.swing.InputVerifier;
import javax.swing.text.JTextComponent;
import java.util.Date;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;
//display solution after fire human query
public class Dispsol extends JFrame
{	Connection connection=null;
	Statement stmt,stmt1;
	ResultSet rs,rs1,rs2;
	String[] strValue;
	String strValue1="";
	Container c;
	JComboBox cmbdiseases;
	JTextArea textArea;
	JButton save,delete,update,exit,find;
	JOptionPane jp = new JOptionPane();
	JTable table;
    JScrollPane scrollPane;
    DefaultTableModel dtm;

	JPanel panel;
	public Dispsol()
	{

		Image titleImage=Toolkit.getDefaultToolkit().getImage("F:\\Diseasetreatment12\\src\\images\\image9.png");
		setTitle("Medical Diagnoise");
		setIconImage(titleImage);
		textArea=new JTextArea();
			Font font=new Font("Times New Roman ",1,14);
				Font font1=new Font("Times New Roman ",1,18);
			textArea.setFont(font);
			panel=new JPanel()
		    {
			Image panelImage=Toolkit.getDefaultToolkit().getImage("abstract-light.jpg");
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				g.drawImage(panelImage, 0,0, this.getWidth(), this.getHeight(),this);
			}

		    };
		    	c = getContentPane();
		setLayout(null);
		setBounds(125, 50, 800, 600);


		c.add(panel);
		panel.setLayout(null);
		panel.setBounds(0, 0, 800, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setFont(new Font("Arial Black",3,16));

		JLabel lbldiseases= new JLabel("Solution");
		textArea.setFont(font);

		/*String[] strCOL={""};
        Object data[][] =new Object[100][1];
        dtm=new DefaultTableModel(data,strCOL);
        table = new JTable(dtm);
 		scrollPane = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
*/lbldiseases.setFont(font1);
		lbldiseases.setBounds(330,50,100,30);
		textArea.setBounds(80,80,500,500);
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(50,150,650,400);
		panel.add(scrollPane);
		panel.add(lbldiseases);
		//panel.add(textArea);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection	con=DriverManager.getConnection("jdbc:odbc:medical");
			Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
        	ResultSet.CONCUR_UPDATABLE);
	//first check human query value in table NLP
			String query="select Query from nlpjava ";
			 rs=stmt.executeQuery(query);
			 System.out.println(query);
			 int i=0;
			 while(rs.next())
			 {
			 strValue1=rs.getString(2);
			 strValue=strValue1.split(",");

			 }
			 System.out.println("strValue1>>>>>>>>>>>>"+strValue1);
			 	//int index=strValue.indexOf(",");
		}
		catch(Exception e){System.out.println("error>>>"+e);}
		try{
		   
		//convert Human query in sql query to check disease of particular symptoms
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection conn=DriverManager.getConnection("jdbc:odbc:medical");
			try{
				Statement stmt1=conn.createStatement();
				String query="select solu from solution where disease='"+strValue1+"'";
				 rs=stmt1.executeQuery(query);
				 System.out.println(query);
				 if(rs!=null && rs.next())
				 {
				 		textArea.append("Disease is "+rs.getString(1)+"\n\n");
						textArea.append("Solution is "+rs.getString(2)+"\n\n");

				 }
			}catch(Exception e){System.out.println("error"+e);}
			//check solution of particular disease

  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection conn1=DriverManager.getConnection("jdbc:odbc:medical");
			Statement stmt=conn1.createStatement();
			for(int i=0;i<strValue.length;i++)
			{	String solution="";
				String query1="select solu from solution where disease='"+strValue[i]+"'";
				 rs1=stmt.executeQuery(query1);
				 System.out.println(query1);
				 int j=1;

				 textArea.append("_______________________________________________________________________________________________\n");
				 if(rs1!=null)
				 {
				 while(rs1.next())
				 {
				   //table.setValueAt(rs.getString(1),i,0);
				      solution=rs1.getString(1);
				   textArea.append("\n"+j+") "+solution+"\n");

				   j++;
				 }
				 }
				 System.out.println("solution"+solution);
				 solution="";
				 textArea.append("_______________________________________________________________________________________________\n");
			if(solution.equals(""))
			 	textArea.append(" Requirement is insufficient or not available please contact to your phisician");


			}

		}
		catch(Exception e){System.out.println("error"+e);}
	}
	public static void main(String[] args)
	{
		Dispsol d=new Dispsol();
	}

}
