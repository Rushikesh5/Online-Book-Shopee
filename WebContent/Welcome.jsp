<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>    
<style>
body, html {
  height: 100%;
  margin: 0;
}

.bgimg {
  background-image: url(BB.jpg);
  height: 100%;
  background-position: center;
  background-size: cover;
  position: relative;
  color: white;
  font-family: "Courier New", Courier, monospace;
  font-size: 25px;
}

.topmiddle {
  position: absolute;
  top: 0%;
  left: 18%
}

.bottomleft {
  position: absolute;
  bottom: 0%;
  left: 16px;
}

.middle {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: center;
}

.bottomright {
  position: absolute;
  bottom: 10%;
  right: 22px;
  }

hr {
  margin: auto;
  width: 40%; 
}
.boxed {
          border: 6px solid white ;
          }
</style>
<body>

<div class="bgimg">
  <div class="topmiddle">
    <p><h1><p style="color:white">Shopping Cart For Book Store &#128722;</p></h1></p>
    <p><h4><p style="color:#87CEEB"><b><i>"A room without</i></b></p></h4></p>
    <p><h4><p style="color:#87CEEB"><b><i>BOOKS</i></b></p></h4></p>
    <p><h4><p style="color:#87CEEB"><b><i>is like</i></b></p></h4></p>
    <p><h4><p style="color:#87CEEB"><b><i>a body without</i></b></p></h4></p>
    <p><h4><p style="color:#87CEEB"><b><i>SOUL"</i></b></p></h4></p> 
    <p><h4><p style="color:#87CEEB"><b><i>-Cicero.</i></b></p></h4></p>   
  </div>
  
  <div class="middle">
  <div class="boxed">
    <h2>_Home&#127968;Page_</h2>
    <hr>
    <a href="Index.jsp"><p style="color:#4DED30">&#128218; <b>ENTER</b> &#128218;</p></a>
  </div>
  </div>
  <div class="bottomright">
    <a href="WelcomeHtml.html"><p style="color:white">&#128100; LOGIN/REGISTER</p></a>
  </div>
  <div class="bottomleft">
    <p>Contact &#9742; 987654321/789456123</p>
    <p>About Us</p><br>
  </div>
</div>

</body>
</html>