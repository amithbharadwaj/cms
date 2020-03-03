var app = angular.module('adminApp',[]);

app.controller('checkAdmin', function($scope, $http, $window) {
	$http.get('/user', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			if (data.roles == 'ROLE_USER') {
				$window.location.href = "/userHome";
			}
		}).error(function (data, status, headers, config) {
			$window.location.href = "/";
		});
	
});