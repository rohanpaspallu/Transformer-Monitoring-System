<?php
include('connection.php');

	//$p1 = '359666';
	//$p2 = 'rohan paspallu';
	//$p3 = 'junior engineer';
	//$p4 = '9173927448';
	//$p5 = 'paspallu.rohan@gmail.com';
	//$p6 = 'rohan';
	
	$p1 = $_POST['emp_id'];
	$p2 = $_POST['emp_name'];
	$p3 = $_POST['designation'];	
	$p4 = $_POST['mobile_no'];
	$p5 = $_POST['email_id'];
	$p6 = $_POST['password'];
	

	
	
	
	
	
$select="INSERT INTO user_reg(emp_id,emp_name,designation,mobile_no,email_id,password) VALUES ('$p1','$p2','$p3','$p4','$p5','$p6')";
$rs=mysql_query($select);
	if($rs)
{
		echo "Registered...";
	}
else{

echo "Not Registered...";
}

//mysql_close($con);
?>
