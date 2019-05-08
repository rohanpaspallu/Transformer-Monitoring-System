<?php

error_reporting(E_ERROR);
include "db.php";
   
	$id = $_REQUEST['id'];
	$order = "DELETE FROM complaint
	          WHERE c_id = '$id'";
	mysql_query($order);
echo "employee Deleted Successfully";

	header("Complaint.php");



?>