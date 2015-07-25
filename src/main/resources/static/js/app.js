'use strict';

(function() {

    angular.module('IndexApplication', [ 'ngMaterial','ui.router' ])

    .config(function($locationProvider, $stateProvider, $urlRouterProvider) {
    	
    	$locationProvider.html5Mode(true);
    	
    	$urlRouterProvider
    	.otherwise('/index');

    	$stateProvider
    	
    	.state('index', {
    		url: '/index'
    	})
    	
    	.state('kurento' , {
    		url : '/kurento',
    		templateUrl : '/partials/kurento.html'
    	})
    })
    
    .controller('IndexController', function($scope, $mdDialog) {

	$scope.login = function(event) {
	    $mdDialog.show(
		      $mdDialog.alert()
		        .parent(angular.element(document.body))
		        .title('This is an alert title')
		        .content('You can specify some description text in here.')
		        .ariaLabel('Alert Dialog Demo')
		        .ok('Got it!')
		        .targetEvent(event)
		    );
	};

	$scope.register = function(event) {
	    console.log('register');
	};

	$scope.toolbarTitle = 'John Kemp';
    })

})();