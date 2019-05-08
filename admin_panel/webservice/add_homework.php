<?php
include('connection.php');

	
	$p1 = $_POST['faculty_name'];
	$p2 = $_POST['date'];
	$p3 = $_POST['homework'];	
	$p4 = $_POST['schoolname'];
	$p5 = $_POST['classname'];
	$p6 = $_POST['division'];
	

	
	
	
	
	
$select="INSERT INTO homework(id,faculty_name,date,homework,schoolname,classname,division) VALUES ('','$p1','$p2', '$p3', '$p4','$p5','$p6')";
$rs=mysql_query($select);
	if(rs)
{
		echo "Registered...";
	}
else{

echo "Not Registered...";
}

//mysql_close($con);
?>
