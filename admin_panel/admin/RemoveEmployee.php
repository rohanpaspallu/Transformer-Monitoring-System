<?php
include "db.php";
   
	$id = $_REQUEST['id'];
	$order = "DELETE FROM user_reg
	          WHERE id = '$id'";
	mysql_query($order);
echo "employee Deleted Successfully";

	header("location:ManageUser.php");



?>
