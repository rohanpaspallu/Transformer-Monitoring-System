<?php
$host = "localhost"; // host of MySQL server
$user = "root"; // MySQL user
$pwd = ""; // MySQL user's password
$db = "tms"; // database name
 
// Create connection
$con = mysqli_connect($host, $user, $pwd, $db);

 
// Check connection
if(mysqli_connect_errno($con)) {
    die("Failed to connect to MySQL: " . mysqli_connect_error());
}
//$v1 = '34890';
//		$v2 = 'password';
$v1 = $_POST['emp_id'];
	$v2 = $_POST['password'];
		$sql = "SELECT * FROM  user_reg WHERE emp_id='$v1' AND password='$v2'";
		
		$result = mysqli_query($con,$sql);
		
		$check = mysqli_fetch_array($result);
		
		if(isset($check)){
			echo 'success';
		}else{
			echo 'failure';
		}
	
// close the database connection
mysqli_close($con);
 
