<!DOCTYPE html>
<html lang="en">
<head>
   
    <title>Application</title>
    <link rel="stylesheet" href="css/app.css">
</head>
<body>
    <%@ page import = "java.sql.* , java.util.*  , java_web.apply , java_web.delete_req" %>
    
    <a class="heading" href="apporoved.jsp" >Apporoved applicants</a>    
    <a class="heading" href="Home.jsp" >Home</a>
    
  </div>
    <%

    String active_user = (String)request.getSession(false).getAttribute("username");
    if(active_user==null){
        response.sendRedirect("index.html");
    }
    else{
            
            String quory = "select * from applicants where username = ?";
            ArrayList<Long> mo_no  = new ArrayList<>();
            ArrayList<String> name = new ArrayList<>();
            ArrayList<String> message = new ArrayList<>();
            ArrayList<String> applicant = new ArrayList<>();
            
            
            try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helper","<username>","<Password>");
            PreparedStatement st = con.prepareStatement(quory);
            st.setString(1,active_user);
            ResultSet rs  = st.executeQuery();
            
            while(rs.next()){
                mo_no.add(rs.getLong(3));
                name.add(rs.getString(2));
                message.add(rs.getString(4));
                applicant.add(rs.getString(5));
                
            } 

            
        
        }catch(Exception e){
            System.out.println("line 50");
        }

   
    for(int i=0 ; i< name.size() ; i++){


    %>
    
    
    <form action="accept" method="POST">
        <div class="list">
        <label for="apply" class="list_item"><%=name.get(i)%> | <%=mo_no.get(i)%> | <%=message.get(i)%></label>
        <input hidden type="text" name="name" value = "<%=name.get(i)%>">
        <input type="submit" name = "accept" value="" class="submit"></div><br><br> 

        
    </form>
    
    <% } }  %>
    
       
       
            
    
    
</body>
</html>