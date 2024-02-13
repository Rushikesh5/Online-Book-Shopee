import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PurchaseServlet")
public class Purchase extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
	    String bkid=(String) session.getAttribute("bid");
	    System.out.println("Books Id in Purchase servlet"+bkid);
	    
	    try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded in Purchase Page");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshopee","root","root");
			System.out.println("Connection Success in Purchase Page");
			
			PreparedStatement pstm=con.prepareStatement("Select * from books where Books_ID=?");
			pstm.setString(1, bkid);
			
			ResultSet rs=pstm.executeQuery();
			System.out.println("Data in Purchase Page");
			
			session.setAttribute("rs1", rs);
		    /* while(rs.next())
			{
				System.out.println(rs.getString("Books_Name")+"|");
		    	System.out.println(rs.getString("Author")+"|");
		    	System.out.println(rs.getInt("price")+"|");
		    	System.out.println();
			}*/
			
			resp.sendRedirect("PurchasePage.jsp");
			
		} catch (ClassNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
   }		
}
