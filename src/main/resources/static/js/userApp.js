var app = angular.module('userApp',['chart.js']);

app.config( [ '$locationProvider', function( $locationProvider ) {
	   // In order to get the query string from the
	   // $location object, it must be in HTML5 mode.
	   $locationProvider.html5Mode( true );
	}]);

app.controller('userChannels', function($scope, $http, $window) {
	$scope.channels=null;
	
	$http.get('/user/channels?pageNo=0&pageSize=999', {
	    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
		.success(function (data, status, headers, config) {
			if (data.length > 0) {
				$scope.channels=data;
			}
		});
	
	$scope.viewChannelFeeds = function(id) {
		$window.location.href='/viewChannelFeeds?channelId=' + id;
	}
	
});

app.controller('viewChannelFeeds', function($location, $scope, $http, $window, $filter) {
	
	$scope.colors = ['#45b7cd', '#ff6384', '#ff8e72'];
	$scope.feeds=null;
	$scope.pageSize=10;
	$scope.channelId='';
	$scope.pageSizeOptions = [];
	
	$scope.labels=[];
	$scope.series=[];
	$scope.data=[];
	$scope.fields=[];
	$scope.totalFields=['field1','field2','field3','field4','field5','field6','field7','field8'];
	
	$scope.options1={
		  legend: {
		      labels: {
		          fontColor: '#000000'
		      }
		  },
		  title: {
		      display: true,
		      fontColor: '#000000', // can Add title color also
		      text: 'Bar Chart'
		  }     ,
		  scales: {
		      yAxes: [{
		          ticks: {
		              beginAtZero:true,
		              fontColor: '#000000' // y-Axes color you want to add
		          },
		      }],
		      xAxes: [{
		          ticks: {
		              fontColor: '#000000'// y-Axes color you want to add
		          },
		      }]
		  }
	};
	
	
	for (x = 1; x < 1000; x++) {
	    $scope.pageSizeOptions.push(x);
	}
	
	$scope.updateChannelFeeds = function() {
		$scope.labels=[];
		$scope.series=[];
		$scope.data=[];
		$scope.fields=[];
		$http.get('/user/channels/' + $scope.channelId + '/feeds?pageNo=0&pageSize=' + $scope.pageSize, {
		    headers: {'Authorization': 'Bearer ' + localStorage.getItem('token')}})
			.success(function (data, status, headers, config) {
				$scope.feeds=data;
				for (var fieldIndex in $scope.totalFields) {
					if (data.channel[$scope.totalFields[fieldIndex]] != null && data.channel[$scope.totalFields[fieldIndex]] != '') {
						$scope.series.push(data.channel[$scope.totalFields[fieldIndex]]);
						$scope.fields.push($scope.totalFields[fieldIndex]);
					}
				}
				for (var innerFieldIndex in $scope.fields) {
					$scope.data[innerFieldIndex] = [];
				}
				if (data.feeds != null && data.feeds.length > 0) {
					var feed=null;
					for (var feedIndex in data.feeds) {
						feed = data.feeds[feedIndex]; 
						$scope.labels.push($filter('date')(new Date(feed.created_at),'yyyy-MM-dd H:mm:ss'));
						for (var innerFieldIndex in $scope.fields) {
							$scope.data[innerFieldIndex].push(feed[$scope.fields[innerFieldIndex]]);
						}
					}
				}
			});
	}
	
	$scope.channelId = $location.search()['channelId'];
	$scope.updateChannelFeeds($scope.pageSize);
	
});
