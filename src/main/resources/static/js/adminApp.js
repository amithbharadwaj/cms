var app = angular.module('adminApp',[]);

app.config( [ '$locationProvider', function( $locationProvider ) {
	   // In order to get the query string from the
	   // $location object, it must be in HTML5 mode.
	   $locationProvider.html5Mode( true );
	}]);

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
	$scope.createError=false;
	$scope.createSuccess=false;
	
	$http.get('/user', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			if (data.roles == 'ROLE_USER') {
				$window.location.href = "/userHome";
			}
		});
	
	$scope.createChannel = function() {
		$scope.createError=false;
		$scope.createSuccess=false;
		$http.post('/admin/channels/', JSON.stringify(this.form),
				{headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
			.success(function (data, status, headers, config) {
				$scope.createSuccess=true;
				$('.alert-info').text('Channel successfully created with ID:' + data.id);
				$window.scrollTo(0, 0);
				$scope.createChannelForm.$setUntouched();
				$scope.form = {}
			}).error(function (data, status, headers, config) {
				$scope.createError=true;
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


app.controller('searchChannelController', function($scope, $http, $window) {
	$scope.form = {}
	$scope.numReg=/^[0-9]+$/;
	$scope.idMinLn=5;
	$scope.idMaxLn=20;
	$scope.search=0;
	$scope.channel=null;
	$scope.searchError=false;
	$scope.searchSuccess=false;
	
	$http.get('/user', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			if (data.roles == 'ROLE_USER') {
				$window.location.href = "/userHome";
			}
		});

	$scope.updateChannelUser = function() {
		$window.location.href='/updateChannelUser?channelId=' + $scope.channel.id;
	}
	
	$scope.updateChannel = function() {
		$window.location.href='/updateChannel?channelId=' + $scope.channel.id;
	}
	$scope.searchChannel = function() {
		$scope.searchError=false;
		$scope.searchSuccess=false;
		$http.get('/admin/channels/'+this.form.id,
				{headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
			.success(function (data, status, headers, config) {
				$scope.channel=data;
			}).error(function (data, status, headers, config) {
				$scope.searchError=true;
				$('.alert-danger').text(data.message);
				$window.scrollTo(0, 0);
			});
	}
	
	$scope.deleteChannel = function() {
		$scope.searchError=false;
		$scope.searchSuccess=false;
		$http.delete('/admin/channels/'+$scope.channel.id,
				{headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
			.success(function (data, status, headers, config) {
				$scope.channel = null;
				$scope.searchChannelForm.$setUntouched();
				$scope.form = {}
				$scope.searchSuccess=true;
				$('.alert-info').text('Channel Deleted Successfully');
				$window.scrollTo(0, 0);
			}).error(function (data, status, headers, config) {
				$scope.searchError=true;
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


app.controller('updateChannelController', function($location, $scope, $http, $window) {
	$scope.form = {}
	$scope.txtReg=/^[a-zA-Z0-9\s]+$/;
	$scope.nameMinLn=8;
	$scope.nameMaxLn=20;
	$scope.descMinLn=0;
	$scope.descMaxLn=200;
	$scope.fldMinLn=3;
	$scope.fldMaxLn=20;
	$scope.error=false;
	$scope.success=false;
	$scope.channelId='';
	
	$http.get('/user', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			if (data.roles == 'ROLE_USER') {
				$window.location.href = "/userHome";
			}
		});
	
	$scope.channelId = $location.search()['channelId'];
	
	if ($scope.channelId == null || $scope.channelId == '') {
		$window.location.href = "/adminHome";
	}
	
	$http.get('/admin/channels/' + $scope.channelId, {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			$scope.form.name=data.name;
			$scope.form.description=data.description;
			$scope.form.field1=data.field1;
			$scope.form.field2=data.field2;
			$scope.form.field3=data.field3;
			$scope.form.field4=data.field4;
			$scope.form.field5=data.field5;
			$scope.form.field6=data.field6;
			$scope.form.field7=data.field7;
			$scope.form.field8=data.field8;
		}).error(function (data, status, headers, config) {
			$scope.error=true;
			$('.alert-danger').text(data.message);
			$window.scrollTo(0, 0);
		});
	
	$scope.updateChannel = function() {
		$scope.error=false;
		$scope.success=false;
		$http.put('/admin/channels/' + $scope.channelId, JSON.stringify(this.form),
				{headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
			.success(function (data, status, headers, config) {
				$scope.success=true;
				$('.alert-info').text('Channel successfully with ID:' + data.id + ' has been successfully updated');
				$window.scrollTo(0, 0);
				$scope.updateChannelForm.$setUntouched();
			}).error(function (data, status, headers, config) {
				$scope.error=true;
				$('.alert-danger').text(data.message);
				$window.scrollTo(0, 0);
			});
	}
	
	$scope.cancelUpdateChannel = function() {
		$window.location.href='/adminHome';
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


app.controller('updateChannelUserController', function($location, $scope, $http, $window) {
	$scope.updateChannelUserForm = {}
	$scope.numReg=/^[0-9]+$/;
	$scope.nameReg=/^[a-zA-Z]+$/;
	$scope.emailReg=/^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9-]+.[a-zA-Z]+(.[a-zA-Z]+)*$/;
	$scope.txtMinLn=3;
	$scope.txtMaxLn=20;
	$scope.error=false;
	$scope.users=null;
	$scope.userId='';
	
	$http.get('/user', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			if (data.roles == 'ROLE_USER') {
				$window.location.href = "/userHome";
			}
		});
	
	$scope.channelId = $location.search()['channelId'];
	
	if ($scope.channelId == null || $scope.channelId == '') {
		$window.location.href = "/adminHome";
	}
	
	$scope.searchUserOrUpdateChannel = function() {
		$scope.error=false;
		if ($scope.updateChannelUserForm.userId == null || $scope.updateChannelUserForm.userId == '') {
			$http.post('/admin/users', JSON.stringify(this.form),
					{headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
				.success(function (data, status, headers, config) {
					$scope.users=data;
				}).error(function (data, status, headers, config) {
					$scope.error=true;
					$('.alert-danger').text(data.message);
					$window.scrollTo(0, 0);
				});
			
		} else {
			$scope.userId=$scope.updateChannelUserForm.userId.$viewValue;
			$http.put('/admin/channels/' + $scope.channelId + '/user/' + $scope.userId,{},
					{headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
				.success(function (data, status, headers, config) {
					$scope.success=true;
					$('.alert-info').text('User:' + $scope.userId + ' updated to channel:' + $scope.channelId + ' successfully');
					$scope.users=null;
					$scope.userId=null;
					$scope.updateChannelUserForm.$setUntouched();
					$scope.form = {}
					$window.scrollTo(0, 0);
				}).error(function (data, status, headers, config) {
					$scope.error=true;
					if (data == null || data == '') {
						$('.alert-danger').text('Please choose a user from the list');
					} else {
						$('.alert-danger').text(data.message);
					}
					$window.scrollTo(0, 0);
				});
		}
		
	}
	
	$scope.cancelSearchUserChannel = function() {
		$window.location.href='/adminHome';
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

