<?php
include('connection.php');

	
	$p1 = $_POST['type'];
	$p2 = $_POST['Description'];
	$p3 = $_POST['c_date'];
	$p4 = $_POST['email_id'];
	$p5 = '0';

	
	
	
	
	
$select="INSERT INTO complaint(type,Description,c_date,email_id,status) VALUES ('$p1','$p2','$p3','$p4','$p5')";
$rs=mysql_query($select);
	if($rs)
{
		echo "Registered...";
	}
else{

echo "Not Registered...";
}

//mysql_close($con);