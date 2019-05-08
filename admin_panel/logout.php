<?php
session_start();
$_SESSION["admin"] = "";
session_destroy();
?>


<html>
<head>
<title>
Logout Page
</title>
</head>
<body>
<h2>You have successfully logged out</h2>
</body>


</html>