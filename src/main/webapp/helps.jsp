<!DOCTYPE html>
<html lang="en">
<head>
    <title>helps</title>
	<link rel="stylesheet" href="css/st.css" />
</head>
<script>

</script>
<body>
<div class="container">
    <%@ page import = "java.sql.* , java.util.*" %>
    <a href="Home.jsp"></a>
    <form action="helps.jsp">
        <label for="city" class="city">Enter your city</label>
        <input type="text" name = "city"><br><br>
        <input type="submit" name = "submit">
    </form><br><br>
    <%
    String u = (String)request.getSession(false).getAttribute("username");
    if(u==null){
        response.sendRedirect("index.html");
    }
    else{
    String quory = "select * from request where city = ?";
    ArrayList<Integer> id = new ArrayList<>();
    ArrayList<String> task = new ArrayList<>();
    ArrayList<Integer> cost = new ArrayList<>();
    
    
    try{

    String ci = request.getParameter("city");
    String city = ci.toLowerCase();
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helper","<username>","<Password>");
    PreparedStatement st = con.prepareStatement(quory);
    st.setString(1,city);
    ResultSet rs  = st.executeQuery();
    
    while(rs.next()){
        id.add(rs.getInt(1));
        task.add(rs.getString(3));
        cost.add(rs.getInt(5));
        
    } 
   
}catch(Exception e){
    
}

%>
<div class="row">
    <label for="apply" class="column">Task</label><label for="apply" class="column">Cost</label>
    </div>
<%
   
    for(int i=0 ; i< task.size() ; i++){


    %>
   
    <form action="message.jsp" method="POST">
        <div class="row">
        <label for="apply" class="column"><%=task.get(i)%></label><label for="apply" class="column"><%=cost.get(i)%></label>
        <input hidden type="text" name = "id" value = <%=id.get(i)%>>
        <input type="submit" name = "apply" value = "apply" class="apply"><br><br></div>
    </form>

    <% } } %>
    </div>
</body>
</html>