
import java.io.IOException;
	import java.io.PrintWriter;
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

	@WebServlet("/LoginServlet")
	public class Login extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String e = req.getParameter("email");
			String p = req.getParameter("pass");
			
			System.out.println(e+" "+p);
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
				
				Connection con=DriverManager.getConnection("jdbc:mysql:/localhost:3306/bookshopee", "root", "root");
				System.out.println("Connection Successfull");
				
				PreparedStatement pstm=con.prepareStatement("select * from webuser where email=?");
				pstm.setString(1, e);
				
				
				ResultSet rs=pstm.executeQuery();
				String name=null;
				String email=null;
				String pass=null;
				
				while(rs.next())
				{
					name=rs.getString("name");
					email=rs.getString("email");
					pass=rs.getString("password");
				}
				HttpSession session=req.getSession();
				if(e.equals(email)&&p.equals(pass))
		     	{
		     		System.out.println("Welcome user:"+name);
		     		resp.sendRedirect("UpdateUser.html");		
				    }
		     	else
				    {
				    	System.out.println("Error");
				    	resp.sendRedirect("LoginUser.html");
				    }
				    con.close();
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}


