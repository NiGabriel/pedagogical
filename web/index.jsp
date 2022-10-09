<%-- 
    Document   : index
    Created on : Sep 7, 2021, 12:28:29 AM
    Author     : IPRC KARONGI
--%>

<%@page import="java.sql.*"%>
<%@page import="newpackage.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedagogical system</title>
	
	
	<link href="css/style.css" rel="stylesheet">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css">
    </head>
    <body>
	
	<div class="banner" style="width: 100%;height: 100px;background: #042331;">
	    <h1 style="color: white; text-align: center; font-size: 72px;">WELCOME TO PIMS</h1>
	</div>
        <div class="container">
	    <div class="box">
		<img class="avatar" src="img/login-logo.png">
		<h1>Login Account</h1>
		<form action="LoginServlet" method="post">
		    <p>Select role</p>
		    <select name="roln" class="form-control" style="height: 45px; width: 260px;">
			<% 

try
{

     Connection con = ConnectionPro.getConnection();
     
     PreparedStatement pst=con.prepareStatement("select rolename from role");
     
     ResultSet rs=pst.executeQuery();
     while(rs.next())
     {
          String name = rs.getString("rolename");
%>
         <option value="<%=name%>"><%=name%></option>
<%
     }
}catch(Exception e)
{    out.print(e);
}
%>
		    </select>
		    <p>Username</p>
		    <input type="text" placeholder="Username" name="email"  required>
		    <p>Password</p>
		    <input type="password" placeholder="Password" name="password" autocomplete="current-password" id="id_password" required>
		   
		    <input type="submit" value="Login">
		    
		    
		</form>
	    </div>
	</div>
    </body>
</html>
