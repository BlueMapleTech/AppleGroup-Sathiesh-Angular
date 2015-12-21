<!DOCTYPE html>
<html ng-app="AJSExample">
<head>
<meta charset="ISO-8859-1">
<title>My First App</title>

<link rel="stylesheet" href="lib/css/bootstrap/bootstrap.min.css">

</head>
<body ng-cloak>

	<div ng-view=""></div>

	<!-- Libraries -->
	<script type="text/javascript" src="lib/js/angular/angular.min.js"></script>
	<script type="text/javascript"
		src="lib/js/angular/angular-route.min.js"></script>
	<script type="text/javascript" src="lib/js/jquery/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="lib/js/bootstrap/bootstrap.min.js"></script>

	<!-- Source Files -->
	<script type="text/javascript" src="app/main.js"></script>
	<script type="text/javascript"
		src="app/js/controllers/loginController.js"></script>
	<script type="text/javascript"
		src="app/js/controllers/signupController.js"></script>
<script type="text/javascript"
        src="app/js/controllers/ListController.js"></script>
    <script type="text/javascript"
        src="app/js/controllers/UpdateController.js"></script>
    
</body>
</html>