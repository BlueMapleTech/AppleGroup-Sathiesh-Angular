(function() {
	var app = angular.module("AJSExample");

	app.controller("ListController", [ '$log', '$scope', '$rootScope','$http',
			'$location','$routeParams', function($log, $scope, $rootScope, $http, $location,$routeParams) {
				$log.debug("List Controller Initialized.!");

				var self = $scope;
				
				$scope.init=function(){
					$log.debug("List method called");
					self.personList();
					
				};
				
				
				self.update=function(userId){
					
					$location.url("/update/"+userId);
				};
				
				
				self.Delete=function(userId){
					$http({
						method:"POST",
					url:"http://localhost:8080/AngularJSExample/signup/deleteUser"+ '?userId='+ userId,
					headers:{
						Accept:'application/json'
							}
					}).success(function(response){
						$log.debug("User Deleted successfully ",response);
						$location.url("/listofUsersss");
					}).error(function(response){
						$log.debug("Delete failed");
					});
				};
				
				
				
				

				self.personList = function(roleId) {
					$http({
						method : "GET",
						url : "http://localhost:8080/AngularJSExample/signup/personList",
						headers:{
							Accept : 'application/json'
						}
					}).success(function(response) {
						$log.debug("List controller success!",response);
						$log.debug(response);
						if(response){
							self.user=angular.fromJson(response);
							$log.debug("Success");
						}else{
							$log.debug(" failed!");
						}
						
					}).error(function(response) {
						$log.debug("please try again!");
					
					});	
				};
				self.init();
	}]);	
})();		