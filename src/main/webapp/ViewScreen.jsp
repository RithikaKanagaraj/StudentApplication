<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String driver = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String database = "todoApp";
String userid = "root";
String password = "123";

try {
	Class.forName(driver);
	} catch (ClassNotFoundException e) {
	e.printStackTrace();
	}
	
	%>
<!DOCTYPE html>
<html>

<head>
<style>
@import url(https://fonts.googleapis.com/css?family=Lily+Script+One);


table, td, th {  
  border: 1px solid #ddd;
  text-align: center;
  font-size:15px;
}

table {
  border-collapse: collapse;
  width: 70%;
   margin:auto;
}

th, td {
  padding: 15px;
}


input[type=submit] {
	padding:15px 50px;
	width:auto;
	background:#1abc9c;
	border:none;
	border-radius:20px;
	color:white;
	cursor:pointer;
	display:inline-block;
	clear:right;
	-webkit-transition:0.2s ease all;
	   -moz-transition:0.2s ease all;
	    -ms-transition:0.2s ease all;
	     -o-transition:0.2s ease all;
	        transition:0.2s ease all;
}

input[type=submit]:hover {
	opacity:0.8;
}

input[type="submit"]:active {
	opacity:0.4;
}

.forgot,
.register {
	margin-top:10px;
	margin-left:40%;
	display:inline-block;
	color:cornflowerblue;
	text-decoration:none;
}

.forgot:hover,
.register:hover {
	color:darkgray;
}

#logo {
	margin: 40px auto 0px auto;
	width:200px;
	font-family:'Lily Script One', cursive;
	font-size:60px;
	font-weight:bold;
	text-align:center;
	color:lightgray;
	-webkit-transition:0.2s ease all;
	   -moz-transition:0.2s ease all;
	    -ms-transition:0.2s ease all;
	     -o-transition:0.2s ease all;
	        transition:0.2s ease all;
}

#logo:hover {
	color:cornflowerblue;
}

body {
	margin:0;
	font-family:arial,tahoma,sans-serif;
	font-size:15px;
	font-weight:normal;
	direction:ltr;
  background:white;
}

select{
	padding: 12px;
	border-radius:20px;
	background-color:white;
	font-size:15px;
}

.logout {
	position: fixed;
	top: 40px;
	right: 40px;
	border-radius:20px;
}

</style>


</head>
<body>
<a class="register logout"   href="Logout"><input type="submit" value="Logout"></a>
<h3 id="logo">Student Status</h3>
<table border="1">
<tr>
<td>Name</td>
<td>Rollno</td>
<td>Status</td>

</tr>
<%
try{
	Connection con = DriverManager.getConnection(connectionUrl+database, userid, password);
	Statement statement=con.createStatement();
	String sql ="select * from statuslist left join userslist on statuslist.rollno=userslist.rollno;";
	ResultSet resultSet = statement.executeQuery(sql);
	while(resultSet.next()){
%>
<form action="ChangeStatus" method="post">
<tr>
<td><%=resultSet.getString("Student_name") %></td>
<td><%=resultSet.getString("rollno") %></td>
<td><%=resultSet.getBoolean("status") ?"Yes":"No" %></td>
</tr>
</form>
<%
}

} catch (Exception e) {
e.printStackTrace();
}

%>
</table> 
<br>
<br>
<a class="register" href="Userscreen.html">
<input  type="submit" value="UserScreen">
</a>
</body>
</html>