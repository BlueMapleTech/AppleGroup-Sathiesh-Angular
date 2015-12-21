(function() {
	var app = angular.module("AJSExample");

	app.controller("UpdateController", [ '$log', '$scope', '$rootScope','$http',
			'$location','$routeParams', function($log, $scope, $rootScope, $http, $location,$routeParams) {
				$log.debug("Update Controller Initialized.!");

				var self = $scope;
				 
				self.user={
						firstName:"",
						lastName:"",
						emailAddress:"",
						password:"",
						confirmPassword:"",
						moblieNumber:"",
						address:""
						
				};
				 self.update=function(){
	                	$log.debug("update controller called");
	                	$http({
	                		method:"POST",
	                		url:"http://localhost:8080/AngularJSExample/signup/updateUser",
	                		data:self.user,
	                		headers:{
	                			Accept:"application/json"
	                		}
	                	}).success(function(response){
	                		
	                		$log.debug("Updated Successfully",response);
	                		$location.url("/listofUser");
	                	}).error(function(response){
	                		$log.debug("Update Failed");
	                	})
	                	
	                };
				
				$scope.init=function(){
					$log.debug("List for update  method called");
					self.findUser($routeParams.userId);
					
				};
                
               
                
                
				self.findUser=function(userId){
					$http({
						method:"GET",
					url:"http://localhost:8080/AngularJSExample/signup/findUser"+ '?userId='+userId,
					headers:{
						Accept:"application/json"
					}
					}).success(function(response){
						$log.debug("user detail for update ",response);
						$log.debug("response",response);
						self.user=angular.fromJson(response);
					}).error(function(response){
						$log.debug("Find User failed");
					});
					
				};
				self.init();
					}]);	
})();	