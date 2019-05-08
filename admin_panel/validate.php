<?php
$aid = $_POST["aid"];
$pwd = $_POST["password"];

if (($aid == "admin")  && ($pwd == "admin"))
{
$_SESSION["admin"] = "admin";


 echo "<script> alert ('welcome admin');
 window.location = 'admin/Home.php'; </script>";
 
}
else
 {
	echo "<script> alert ('Invalid admin !! Try again.'); 
	window.location = 'index.php'; </script>";
 
 }

?>