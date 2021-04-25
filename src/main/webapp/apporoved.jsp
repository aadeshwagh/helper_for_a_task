<!DOCTYPE html>
<html lang="en">
<head>
    
    <title>Document</title>
    <style>
        body{
    background-color: aliceblue;
}

.list{
    position: relative;
    display: block;
    left: 50%;
    transform: translate(-50%);
    background-color: white;
    width: 70%;
   font-size: 24px;
   padding-left: 20px;
   padding-right: 20px;
   padding-top: 20px;
   padding-bottom: 20px;
   border-radius: 30px;
   box-shadow:
  0 2.8px 2.2px rgba(0, 0, 0, 0.034),
  0 6.7px 5.3px rgba(0, 0, 0, 0.048),
  0 12.5px 10px rgba(0, 0, 0, 0.06),
  0 22.3px 17.9px rgba(0, 0, 0, 0.072);
  word-wrap: break-word;
  overflow: auto;
}


.submit{
    border-radius: 32px;
    position: relative;
    float: right;
    height: 64px;
    width: 64px;
   display: block;
   border: 0ch;


}

    </style>
</head>
<body>
    <%@ page import = "java.sql.* , java.util.*" %>
    <%
    String active_user = (String)request.getSession(false).getAttribute("username");
    String quory = "select * from apporoved where username = ? ";
    ArrayList<Long> mo_no  = new ArrayList<>();
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> message = new ArrayList<>();
    ArrayList<String> applicant = new ArrayList<>();
    
    
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/helper","root","Phe6@nol");
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


<form action="Home.jsp" >
<div class="list">
<label for="apply" class="list_item"><%=name.get(i)%> | <%=mo_no.get(i)%> | <%=message.get(i)%></label>
<input type="submit" name = "accept" value="Home" class="submit"></div><br><br> 


</form>

<% }   %>
    
</body>
</html>