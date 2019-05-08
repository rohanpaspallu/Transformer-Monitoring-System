<html>
<head>
<title>
Manage Complaint
</title>
</head>
<body>
<h2>Here You have to manage the complaints</h2>

<form id="form1" name="form1">
 <table border="1">
		<tr> 
			<th>Sr_no</th>
			<th> c_id</th>
			<th> c_date</th>
			<th> type</th>
			<th> status</th>
			<th> emp_id</th>
			<th> action</th>
		</tr>
		 <?php
		  error_reporting(E_ERROR);
		  
	include "db.php";
	      $order = "SELECT * FROM complaint";
	      $result = mysql_query($order);

	      while ($row=mysql_fetch_array($result)){
	        echo ("<tr><td>$row[Sr_no]</td>");
	        echo ("<td>$row[c_id]</td>");
	        echo ("<td>$row[c_date]</td>");
			echo ("<td>$row[type]</td>");
			echo ("<td>$row[status]</td>");
			echo ("<td>$row[emp_id]</td>");
	        
	       
	echo ("<td><a href=\"RemoveComplaint.php?id=$row[Sr_no] \">Remove</a><br></td></tr>");
	      }
		  
	      ?>
	      </table>
</form>
</body>
</html>