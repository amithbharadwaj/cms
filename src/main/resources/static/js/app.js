var app = angular.module('myApp',[]);

app.controller('Authentication', ['$scope', function($scope) {
	$scope.isLoggedIn = false;
}]);

app.controller('Login', ['$scope', function($scope) {
	$scope.form = {}
	
	$scope.authenticate = function() {
		alert("login success," + JSON.stringify(this.form));
		$scope.form = {}
	}
}]);

app.controller('Registration', function($scope, $http, $window) {
	$scope.form = {}
	$scope.nameReg=/[a-zA-Z]+/;
	$scope.pwReg=/^[a-zA-Z]\w{3,14}$/; 
	
	$scope.register = function() {
		$http.post('/register', JSON.stringify(this.form))
			.success(function (data, status, headers, config) {
				$window.location.href = "/?regSuccess=true";
			}).error(function (data, status, headers, config) {
				$window.location.href = "/registration?error=true";
			});
		$scope.form = {}
	}
});