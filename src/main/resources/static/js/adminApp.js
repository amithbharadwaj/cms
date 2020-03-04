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

app.controller('createChannelController', function($scope, $http, $window) {
	$scope.form = {}
	$scope.numReg=/^[0-9]+$/;
	$scope.txtReg=/^[a-zA-Z0-9\s]+$/;
	$scope.idMinLn=5;
	$scope.idMaxLn=20;
	$scope.nameMinLn=8;
	$scope.nameMaxLn=20;
	$scope.descMinLn=0;
	$scope.descMaxLn=200;
	$scope.fldMinLn=3;
	$scope.fldMaxLn=20;
	$scope.error=false;
	$scope.success=false;
	
	$http.get('/user', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			if (data.roles == 'ROLE_USER') {
				$window.location.href = "/userHome";
			}
		});
	
	$scope.createChannel = function() {
		$scope.error=false;
		$scope.success=false;
		$http.post('/admin/channels/', JSON.stringify(this.form),
				{headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
			.success(function (data, status, headers, config) {
				$scope.success=true;
				$('.alert-info').text('Channel successfully created with ID:' + data.id);
				$window.scrollTo(0, 0);
				$scope.createChannelForm.$setUntouched();
				$scope.form = {}
			}).error(function (data, status, headers, config) {
				$scope.error=true;
				$('.alert-danger').text(data.message);
				$window.scrollTo(0, 0);
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