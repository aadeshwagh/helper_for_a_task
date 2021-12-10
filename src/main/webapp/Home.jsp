<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    
    <title>Home</title>
    <link rel="stylesheet" href="css/Home.css">
</head>
<!---%@ page import = "java_web.logout" %-->
<%
   String user = (String)request.getSession(false).getAttribute("username");
   if (user==null){
       response.sendRedirect("index.html");
   }
   else{
%>

<body>
    <div class="back">
        <h2>Welcome <%=user%> </h2>
    <form action="logout" class = "form1">
        <input type="submit" value="Logout">
    </form>
        <h1 class="about">About</h1>
        <p class="info">There are many tasks which we can't do alone</p><br><br>
        <p class="info">So, why not get help from local people !!</p><br><br>
        <p class="info">OR</p> <br><br>
        <p class="info">you are willing to help somebody</p><br><br>
        <p class="info">search for help requests and get compensated</p>
    </div>
    <a href="request.html">
    <div class="button" >
        <h1 class="but">Add a job</h1>
        <p class="info1"></p>
            
    </div>
    </a>
    <a href="helps.jsp">
        <div class="button1" >
            <h1 class="but">Find work</h1>
            <p class="info1">Find work available in your city </p>
        </div>
        </a>
</body>
<% } %>
</html>