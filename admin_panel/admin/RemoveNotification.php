<?php

error_reporting(E_ERROR);
include "db.php";
   
	$id = $_REQUEST['id'];
	$order = "DELETE FROM notification
	          WHERE n_id = '$id'";
	mysql_query($order);
echo "employee Deleted Successfully";

	header("Notification.php");



?>