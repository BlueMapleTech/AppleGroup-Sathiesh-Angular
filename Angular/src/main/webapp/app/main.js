(function() {
	var app = angular.module("AJSExample", [ 'ngRoute' ]);

	app.config(function($routeProvider) {
		$routeProvider.when("/login", {
			templateUrl : "app/views/login.html"
		}).when("/signup", {
			templateUrl : "app/views/signup.html"
		}).when("/listofUser", {
			templateUrl : "app/views/List.html"
		}).when("/update/:userId", {
			templateUrl : "app/views/Update.html"
		}).when("/listofUsersss",{
			templateUrl:"app/views/List.html"
		}).otherwise({
			redirectTo : "/login"
		});
	});

	app.run(function($log) {
		$log.debug("Started running.!");
	})

})();