<html>
<head>
<title>
Transformer Details
</title>
</head>
<body>
<h2>Here are various information regarding the transformers</h2>
<form id="form1" name="form1">
 <table border="1">
		<tr> 
			<th> Sr_no</th>
			<th> t_id</th>
			<th> t_details</th>
			<th> company_name</th>
			<th> capacity</th>
			<th> volt</th>
			<th> temp</th>
			<th> oil</th>
			<th> longitude</th>
			<th> latitude</th>
			<th> warranty</th>
		</tr>
		
	<?php
		  error_reporting(E_ERROR);
		  
		include "db.php";
	      $order = "SELECT * FROM transformer";
	      $result = mysql_query($order);

	      while ($row=mysql_fetch_array($result)){
	        	echo ("<tr><td>$row[Sr_no]</td>");
				echo ("<td>$row[t_id]</td>");
				echo ("<td>$row[t_details]</td>");
				echo ("<td>$row[company_name]</td>");
				echo ("<td>$row[capacity]</td>");
				echo ("<td>$row[volt]</td>");
				echo ("<td>$row[temp]</td>");
				echo ("<td>$row[oil]</td>");
				echo ("<td>$row[longitude]</td>");
				echo ("<td>$row[latitude]</td>");
				echo ("<td>$row[warranty]</td>");
	        }
	    ?>
	    </table>
		</form>
	</body>
</html>