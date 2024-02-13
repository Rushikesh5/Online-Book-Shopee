<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <center> 
  
      <style>
      body {
           background-image: url(BB.jpg);
           }
           
           h1{
           font-size: 3.0em;
           }
           
           input value{
           font-size: 2.1em;
           }
           
           .topleft {
            position: absolute;
            top: 0;
            left: 16px;
            color: white;
            font-family: Courier;
            font-size: 25px;
            }
           
             .middle {
          position: absolute;
          top: 50%;
          left: 50%;
          transform: translate(-50%, -45%);
          text-align: center;
          color: white;
          font-family: "Courier New";
          font-size: 18x;
          }
          
          .boxed {
          border: 4px solid white ;
          background-color: #000000;
          }
          
      </style>
 
       <div class="topleft">
       <a href="Welcome.jsp"><p style="color:#4DED30">Home Page &#127968;</p></a>
       </div>  
  
       <h1><u><p style="color:white">Shopping Cart for Book store &#128722;</p></u></h1> 
       
    <form action="./CustomerRegistration">
    <div class="middle">
    <div class="boxed">
    <br>
    <p style="color:#87CEEB">Customer Name:<input type="text" name="name"></p><br>
    <p style="color:#87CEEB">Address:<input type="text" name="addr"></p><br>
    <p style="color:#87CEEB">Phone No:<input type="text" name="phn"></p><br>
    <p style="color:#87CEEB">Order Date:<input type="date" name="dt"></p><br>
    </div>
    <p style="color:#4DED30"><b>Your Order Details are:</b></p>
     
     
     <div class="boxed">
     <table border="4">
       <tr>
          <th><p style="color:#FE994A">Book Name</p></th>
          <th><p style="color:#87CEEB">Author</p></th>
          <th><p style="color:#90EE90">Price</p></th>
          <th><p style="color:#CF9FFF">Quantity</p></th>
          <th><p style="color:#FFC0CB">Total Price</p></th>
          
       </tr>
       
       <%
       try
       {
            ResultSet rs=(ResultSet)session.getAttribute("rs2");
            String Qty=(String)session.getAttribute("Qty");
            int qty=Integer.parseInt(Qty);
            while(rs.next())
		{
            	
            	int price=rs.getInt("price");
			  
       %>
       
       <tr>
          <td><p style="color:white"><%=rs.getString("Books_Name") %></p></td>
          <td><p style="color:white"><%=rs.getString("Author") %></p></td>
          <td><p style="color:white"><%=rs.getInt("price") %></p></td>
          <td><p style="color:white"><%=qty %></p></td>
          <td><p style="color:white"><%=price*qty%></p></td>
       </tr>
       
       <%
         }
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }     
       %>
       
     </table>
     </div>
     <br>
     <input type="Submit" value="Confirm">
     </form>
     
    <form action="Index.jsp">
    <br>
    <input type="Submit" value="Cancel">
    </form>
    </div>
    
  </center>
    
</body>
</html>