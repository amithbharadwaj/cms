var app = angular.module('myApp',[]);

app.controller('Authentication', ['$scope', function($scope) {
	$scope.isLoggedIn = false;
}]);

app.controller('Login', ['$scope', function($scope) {
	$scope.form = {}
	
	$scope.authenticate = function() {
		alert("login success," + this.form.username + " " + this.form.password);
		$scope.form = {}
	}
}]);