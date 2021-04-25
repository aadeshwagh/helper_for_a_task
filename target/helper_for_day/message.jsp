<!DOCTYPE html>
<html lang="en">
<head>
    <title>message</title>
	<link rel="stylesheet" href="css/style1.css" />
</head>
<body>

    <%
    int i = Integer.parseInt(request.getParameter("id"));

    %>
    <form action="apply">
	<div class="enclosed1">
        <input hidden type="number" name = "id" value= <%=i%>  >
        <label for="" >name</label>
		<input type="text" name = "name"></div>
		<div class="enclosed1"
        <label for="">mobile</label>
		<input type="number" name = "mo_no"></div>
		<div class="enclosed1">
        <label for="">message</label>
        <input type="text" name = "message"></div>
	    <input class="submit" type="submit" value="submit">
        
    </form>
    
</body>
</html>