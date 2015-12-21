(function() {
	var app = angular.module("AJSExample");

	app.controller("SignupController", [ '$log', '$scope', '$rootScope','$http',
			'$location','$routeParams', function($log, $scope, $rootScope, $http , $location,$routeParam) {
				$log.debug("Signup Controller Initialized.!");

				var self = this;

				self.user = {
					firstName : "",
					lastName : "",
					emailAddress : "",
					password : "",
					confirmPassword : "",
					mobileNumber : "",
					address : "",
					roleId:""
				};

				self.createUser = function() {
					$log.debug("create user method initiated!");

					$http({
						method:"POST",
						url:"http://localhost:8080/AngularJSExample/signup/createUser",
						data:self.user,
						headers:{
							Accept:'application/json'
						}
					}).success(function(response){
						$log.log("created user:",self.user);
						$log.log("User has been created successfully!");
						$location.url("/login");
					}).error(function(response){
						$log.log("Unable to create user,please try again!");
					});
					
				}
				
				self.doGoBack = function() {
					$log.debug("Redirecting to login page.!");
					$location.url("/login");
				};

			} ]);
})();