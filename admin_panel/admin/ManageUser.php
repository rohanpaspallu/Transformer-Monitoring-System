<html>
<head>
<title>
Manage User
</title>
</head>
<body>
<h2>Here You have to manage the user</h2>

<form id="form1" name="form1">
 <table border="1">
		<tr> 
			<th>ID</th>
			<th> emp_id</th>
			<th> designation</th>
			<th> emp_name</th>
			<th> email_id</th>
			<th> mobile_no</th>
			<th> action</th>
		</tr>
	 <?php
		  error_reporting(E_ERROR);
		  
	include "db.php";
	      $order = "SELECT * FROM user_reg";
	      $result = mysql_query($order);

	      while ($row=mysql_fetch_array($result)){
	        echo ("<tr><td>$row[id]</td>");
	        echo ("<td>$row[emp_id]</td>");
	        echo ("<td>$row[designation]</td>");
			echo ("<td>$row[emp_name]</td>");
			echo ("<td>$row[email_id]</td>");
			echo ("<td>$row[mobile_no]</td>");
	        
	       
	echo ("<td><a href=\"RemoveEmployee.php?id=$row[id] \">Remove</a><br>");
	echo ("<a href=\"AcceptEmployee.php?emp_id=$row[emp_id] \">Accept</a></td></tr>");
	      }
		  
	      ?>
	      </table>
</form>
</body>
</html>