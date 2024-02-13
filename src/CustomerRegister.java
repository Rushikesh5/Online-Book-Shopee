import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CustomerRegistration")
public class CustomerRegister extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String nm=req.getParameter("name");
       String addr=req.getParameter("addr");
       String ph=req.getParameter("phn");
       String dt=req.getParameter("dt");
       Date dtd=Date.valueOf(dt);
   
       HttpSession session=req.getSession();
       String qty=(String) session.getAttribute("Qty");
       Integer Qty=Integer.parseInt(qty);
       
       String bkid=(String) session.getAttribute("bid");
      
       System.out.println(nm+" "+ph+" "+addr+" "+Qty+" "+bkid+" "+dtd);
       
       try {
    	    Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded in Customer Registration Page");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshopee","root","root");
			System.out.println("Connection Success in Customer Registration Page");
			
			PreparedStatement pstm=con.prepareStatement("insert into Customer(Cust_Name,phone,Address,Qty,Book_ID,Order_Date) values(?,?,?,?,?,?)");
			pstm.setString(1, nm);
			pstm.setString(2, ph);
            pstm.setString(3, addr);
            pstm.setInt(4, Qty);
            pstm.setString(5, bkid);
            pstm.setDate(6, dtd);
            
            int i=pstm.executeUpdate();
            if(i!=0)
            {
            	System.out.println("Record Inserted");
            	resp.sendRedirect("ThankYou.jsp");
            }
            else
            {
            	System.out.println("Error");
            	resp.sendRedirect("Error.jsp");
            }
            con.close();
       } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
     }
 }
   
   

