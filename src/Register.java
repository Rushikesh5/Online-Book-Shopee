
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

	@WebServlet("/RegisterServlet")
	public class Register extends HttpServlet {

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String n = req.getParameter("name");
			String e = req.getParameter("email");
			String p = req.getParameter("pass");
			
			System.out.println(n+" "+e+" "+p);
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver Loaded");
				
				Connection con=DriverManager.getConnection("jdbc:mysql:/localhost:3306/bookshopee", "root", "root");
				System.out.println("Connection Successfull");
				
				PreparedStatement pstm=con.prepareStatement("insert into registeruser values(?,?,?)");
				pstm.setString(1, n);
				pstm.setString(2, e);
				pstm.setString(3, p);
				
				boolean inserted = pstm.execute();
				
				PrintWriter pw= resp.getWriter();
				
				  if(inserted)
				    {
				    	System.out.println("Record Inserted");
				    	resp.sendRedirect("LoginUser.html");
				    }
				    else
				    {
				    	System.out.println("Error");
				    	resp.sendRedirect("Error.html");
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
