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
          transform: translate(-50%, -50%);
          text-align: center;
          color: white;
          font-family: "Courier New";
          font-size: 25px;
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
      
      <div class="middle">
      <h3><p style="color:#FFFF33">Selected Book Details are Displayed</p></h3>
       
      <form action="./CustomerServlet">
    
    <%
    try
    {
    ResultSet rs=(ResultSet)session.getAttribute("rs1");
   	while(rs.next())	
   	{	
    %>
    <div class="boxed">
    <p style="color:#FE994A">Book Name:<%=rs.getString("Books_Name") %><br></p>
    <p style="color:#87CEEB">Author:<%=rs.getString("Author") %><br></p>
    <p style="color:#90EE90">Price:<%=rs.getInt("price") %><br></p>
    <%
   	}
    }
    catch(Exception e)
    {
    	e.printStackTrace();
   	}
    %>
    
    <p style="color:#CF9FFF">Quantity:<input type="text" name="Quantity"><br></p>
    </div>
    <br>
    <input type="Submit" value="Purchase">
    </form>
    <br>
    <form action="Index.jsp">
    <input type="Submit" value="Cancel">
    </form>
    
    </div>
    
  </center> 
</body>
</html>