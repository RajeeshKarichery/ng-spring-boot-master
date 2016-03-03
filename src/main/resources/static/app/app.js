var app = angular.module("myApp", ['ngResource','ui.router','ngMaterial','ngMessages']);

app.config(function($stateProvider, $urlRouterProvider) {    
$urlRouterProvider.otherwise('/home');

	$stateProvider        
	    .state('item', {
	        url: '/item',
	        templateUrl: 'app/views/item.html',
	        controller:'ItemController'
	    })
	    .state('user', {
	        url: '/user',
	        templateUrl: 'app/views/user.html',
	        controller:'UserController'
	    })
	    .state('home', {
	        url: '/home',
	        templateUrl: 'app/views/home.html'
	    });

});