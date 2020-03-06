var app = angular.module('userApp',[]);

app.controller('userChannels', function($scope, $http, $window) {
	$scope.isLoggedIn = false;
	$scope.channels=null;
	
	$http.get('/user/channels?pageNo=0&pageSize=999', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			if (data.length > 0) {
				$scope.channels=data;
			}
		});
	
});

