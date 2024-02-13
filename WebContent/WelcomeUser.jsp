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
           background-image:url(BB.jpg);
           }
           
           h1{
           font-size: 3.0em;
           }
           
           h2{
           font-size: 1.9em;
           }
            
           .topmiddle {
           position: absolute;
           top: -6.0%;
           left: 27%
           }
           
           .topleft {
            position: absolute;
            top: 0;
            left: 16px;
            color: white;
            font-family: Courier;
            font-size: 25px;
            }
            
            table, th, td {
            border: 2px solid white;
            border-collapse: collapse;
            }
            th, td {
            background-color: #000000;
            }
           
            .middle {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-48%);
            text-align: center;
            color: white;
            font-family: "Courier New";
            font-size: 8x;
            }
           
      </style>
      
      <div class="topleft">   
      <a href="Welcome.jsp"><p style="color:#4DED30">Home Page &#127968;</p></a>
      </div>
       
      <div class="topmiddle">
      <h1><u><p style="color:white">Shopping Cart For Book Store &#128722;</p></u></h1>
      </div>
      
      <div class="middle">
      <h2><u><p style="color:#FFFF33">&#128214;Welcome Page&#128214;</p></u></h2>  
      
       <table border="4">
       
          <tr>
              <th><p style="color:white">Books_Name</p></th>
              <th><p style="color:white">Author</p></th>
              <th><p style="color:white">price</p></th>
          </tr>
          
          <%
          try
          {
        	 ResultSet rs=(ResultSet)session.getAttribute("rs");
        	 System.out.println("Data In WelcomeUser.jsp");
        	 while(rs.next())
          {
          %>
          <tr>
              <td><a href="Book.jsp?BKID=<%=rs.getString("Books_ID")%>"><p style="color:#FE994A"><%=rs.getString("Books_Name")%></p></a></td>
              <td><p style="color:#87CEEB"><%=rs.getString("Author") %></p></td>
              <td><p style="color:#90EE90"><%=rs.getInt("price") %></p></td> 
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
   </center>
</body>
</html>