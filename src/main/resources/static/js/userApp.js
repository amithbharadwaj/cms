var app = angular.module('userApp',[]);

app.controller('userChannels', function($scope, $http, $window) {
	$scope.isLoggedIn = false;
	$scope.channels='';
	
	$http.get('/user/channels', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			$scope.channels=data;
		});
	
});

