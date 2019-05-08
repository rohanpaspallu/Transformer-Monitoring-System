<html>
<head>
<title>
Manage Notification
</title>
</head>
<body>
<h2>You have to manage the notifications:</h2>




<form id="form1" name="form1">
 <table>
 
	  <tr>
	    <td>
	      <table border="1">
		<tr> 
			<th> Sr_no</th>
			<th> n_id</th>
			<th> volt</th>
			<th> temp</th>
			<th> oil</th>
			<th> longitude</th>
			<th> latitude</th>
		</tr>
	      <?php
		  error_reporting(E_ERROR);
		  
	include "db.php";
	      $order = "SELECT * FROM notification";
	      $result = mysql_query($order);

	      while ($row=mysql_fetch_array($result)){
	        echo ("<tr><td>$row[Sr_no]</td>");
	        echo ("<td>$row[n_id]</td>");
	        echo ("<td>$row[volt]</td>");
			echo ("<td>$row[temp]</td>");
			echo ("<td>$row[oil]</td>");
			echo ("<td>$row[longitude]</td>");
			echo ("<td>$row[latitude]</td>");
	        
	       
	echo ("<td><a href=\"RemoveNotification.php?id=$row[Sr_no] \">Remove</a></td></tr>");
	      }
	      ?>
	      </table>
	    
	</body>
	</html>
