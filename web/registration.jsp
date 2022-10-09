<%@page import="java.sql.*"%>
<%@page import="newpackage.ConnectionPro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Account</title>
        <link href="https://fonts.googleapis.com/css?family=ZCOOL+XiaoWei" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="regbox">
                <img class="avatar" src="img/login-logo.png">
                <h1>
Register Account</h1>
<form action="RegisterServlet" method="post">
    <table>
	<tr>
	    <td style="padding-left: 10px">
		<p>Full name</p>
		<input type="text" placeholder="Username" name="name" required>
		<p>User email</p>
		<input type="text" placeholder="Useremail" name="email" required>
		<p>Password</p>
		<input type="password" placeholder="Password" name="password" required>
	    </td>
	    <td>
		<p>Role</p>
		    <select name="roln">
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
		<p>Telephone number</p>
		<input type="text" placeholder="telephone number" name="tel" required>
		<p>Level</p>
		<select name="level">
		    <option value="Lower primary">Lower primary</option>
		    <option value="Upper primary">Upper primary</option>
		</select>
		
	    </td>
	    
	</tr>
    </table>
                   
                   <input type="submit" value="Register">
                   <a href="index.jsp">Already have Account?</a>
                </form>
</div>
</div>
</body>
</html>