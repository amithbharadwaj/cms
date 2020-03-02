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

app.controller('Registration', ['$scope','$http', function($scope, $http) {
	$scope.form = {}
	
	$scope.register = function() {
		this.$http.post('/register', JSON.stringify(this.form))
			.success(function (data, status, headers, config) {
				$location.path("/login?regSuccess=true");
			}).error(function (data, status, headers, config) {
				$location.path("/register?error=true");
			});
		$scope.form = {}
	}
}]);