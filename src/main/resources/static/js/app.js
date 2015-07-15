'use strict';

(function() {

    angular.module('IndexApplication', [ 'ngMaterial' ])

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