'use strict';

(function() {

    angular.module('IndexApplication', [])

    .controller('IndexController', function($scope) {
	$scope.welcomeMessage = 'Hello world!';
    })
    
})();