import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/WelcomeServlet")
public class Welcome extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded in Welcome Page");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshopee","root","root");
			System.out.println("Connection Success in Welcome Page");
			
		 	Statement stm=con.createStatement();
		    ResultSet rs=stm.executeQuery("select * from books");
		    
		    HttpSession session=req.getSession();
		    session.setAttribute("rs", rs);
		    
		    /*while(rs.next()) 
		    {
		    	System.out.println(rs.getString("Books_Name")+"|");
		    	System.out.println(rs.getString("Author")+"|");
		    	System.out.println(rs.getInt("price")+"|");
		    	System.out.println();
		    }*/
		    resp.sendRedirect("WelcomeUser.jsp");
	
		 		} catch (ClassNotFoundException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		} catch (SQLException e) {
		 			// TODO Auto-generated catch block
		 			e.printStackTrace();
		 		}
	}
}
