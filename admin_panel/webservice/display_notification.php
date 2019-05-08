<?php
include('connection.php');

 
// Check connection
//if(mysqli_connect_errno($con)) {
  //  die("Failed to connect to MySQL: " . mysqli_connect_error());
//}
//$v1='N. D. KOTHARI ENGLISH SCHOOL (ANTROLI)';
//$v2='2ND';
//$v3='A';
 
// query the application data
$sql = "SELECT * FROM notification";

$result = mysql_query($sql);
 
// an array to save the application data
$rows = array();
 
// iterate to query result and add every rows into array
while($row = mysql_fetch_array($result, MYSQL_ASSOC)) {
    $rows['data'][] = $row;
}
 
// close the database connection
//mysqli_close($con);
 
// echo the application data in json format
echo json_encode($rows);