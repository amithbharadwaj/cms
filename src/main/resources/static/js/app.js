var app = angular.module('myApp',['userApp','adminApp']);

app.controller('Authentication', function($scope, $http, $window) {
	$scope.isLoggedIn = false;
	$scope.firstName = false;
	
	if (localStorage.getItem('token') == null || localStorage.getItem('token') == '') {
		/*if ($window.location.pathname != '/') {
			$window.location.href = "/";
		} */
	} else {
		$http.get('/user', {
		    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
			.success(function (data, status, headers, config) {
				$scope.isLoggedIn=true
				$scope.firstName=data.firstName;
			}).error(function (data, status, headers, config) {
				if (data.messgage.toLowerCase().includes('jwt expired')) {
					$scope.logout();
				} 
			});
	}
	
	$scope.logout = function() {
		localStorage.setItem('token', '');
		$window.location.href = "/";
	}
});

app.controller('Login', function($scope, $http, $window) {
	$scope.form = {}
	$scope.emailReg=/^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9-]+.[a-zA-Z]+(.[a-zA-Z]+)*$/;
	$scope.error=false;
	
	$scope.checkUser = function() {
		$http.get('/user', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
			.success(function (data, status, headers, config) {
			if (data.roles == 'ROLE_USER') {
				$window.location.href = "/userHome";
			} else if (data.roles == 'ROLE_ADMIN') {
				$window.location.href = "/adminHome";
			} 
		});
	}
	$scope.checkUser();
	
	$scope.authenticate = function() {
		$http.post('/authenticate', JSON.stringify(this.form))
			.success(function (data, status, headers, config) {
				localStorage.setItem('token', data.jwt);
				$scope.checkUser();
			}).error(function (data, status, headers, config) {
				$scope.error=true;
				$('.alert-danger').html('<i class="fas fa-times-circle"></i>' + ' Invalid Username and Password');
			});
	}
	
	$scope.handleError = function($error, patternMessage) {
		if ($error.required) {
			return " (Required)";
		} else if ($error.pattern) {
			return patternMessage;
		}
	}
});

app.controller('Registration', function($scope, $http, $window) {
	$scope.form = {}
	$scope.nameReg=/^[a-zA-Z]+$/;
	$scope.emailReg=/^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9-]+.[a-zA-Z]+(.[a-zA-Z]+)*$/;
	$scope.pwReg=/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[#$@])/;
	$scope.pwMinLn=8;
	$scope.pwMaxLn=20;
	$scope.txtMinLn=3;
	$scope.txtMaxLn=20;
	$scope.error=false;
	
	$http.get('/user', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			if (data.roles == 'ROLE_USER') {
				$window.location.href = "/userHome";
			} else if (data.roles == 'ROLE_ADMIN') {
				$window.location.href = "/adminHome";
			} 
		});
	
	$scope.register = function() {
		$http.post('/register', JSON.stringify(this.form))
			.success(function (data, status, headers, config) {
				$window.location.href = "/?regSuccess=true";
			}).error(function (data, status, headers, config) {
				$scope.error=true;
				$('.alert-danger').html('<i class="fas fa-times-circle"></i>' + ' ' + data.message)
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