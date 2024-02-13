import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class Update extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nm = req.getParameter("name");
		String em = req.getParameter("email");
		
		System.out.println();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loaded");
			
			Connection con=DriverManager.getConnection("jdbc:mysql:/localhost:3306/bookshopee", "root", "root");
			System.out.println("Connection Successfull");
			
			PreparedStatement pstm=con.prepareStatement("update web_user set name = ? where email = ?");
			pstm.setString(1, nm);
			pstm.setString(2, em);
			
			int i= pstm.executeUpdate();
			
			PrintWriter pw= resp.getWriter();
			
			  if(i!=0)
			    {
			    	System.out.println("Record Updated");
			    	resp.sendRedirect("DeleteUser.html");
			    }
			    else
			    {
			    	System.out.println("Error");
			    	resp.sendRedirect("UpdateUser.html");
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
