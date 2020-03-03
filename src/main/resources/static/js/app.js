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

app.controller('Registration', function($scope, $http, $window, $location) {
	$scope.form = {}
	$scope.nameReg=/^[a-zA-Z]+$/;
	$scope.emailReg=/^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9-]+.[a-zA-Z]+(.[a-zA-Z]+)*$/;
	$scope.pwReg=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[.#$%])/;
	$scope.pwMinLn=8;
	$scope.pwMaxLn=20;
	$scope.txtMinLn=3;
	$scope.txtMaxLn=20;
	$scope.error=false;
	
	$scope.register = function() {
		$http.post('/register', JSON.stringify(this.form))
			.success(function (data, status, headers, config) {
				$window.location.href = "/?regSuccess=true";
			}).error(function (data, status, headers, config) {
				$scope.error=true;
				$('.alert').text(data.message)
			});
	}
	
	$scope.handleError = function($error, patternMessage) {
		this.handleError($error, patternMessage, null, null);
	}
	
	$scope.handleError = function($error, patternMessage, minLength, maxLength) {
		if ($error.required) {
			return " (Required)";
		} else if ($error.pattern) {
			return patternMessage;
		} else if (minLength && $error.minlength) {
			return " Minimum Length:" + minLength;
		} else if (maxLength && $error.maxlength) {
			return " Maximum Length:" + maxLength;
		}
	}
	
});