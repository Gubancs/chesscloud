/// <reference path="../ts/angular.d.ts" />
/// <reference path="../ts/chesscloud.d.ts" />

var chessCloud = angular.module("chesscloud", ['ngRoute']);

chessCloud.controller("WelcomeController", function ($scope, $http) {
    $scope.preloadReply = {};

    /**
     * Initialize function of the Welcome controller
     */
    $scope.init = function () {
        var response = $http.get("welcome/preload");

        response.success(function (preloadReply:PreloadReply) {
            console.log("Received pre load reply : ", preloadReply);
            $scope.preloadReply = preloadReply;
        });
        response.error(function (preloadReply:PreloadReply, status:number) {
            alert("AJAX failed!");
        });
    }
});

// configure our routes
chessCloud.config(function ($routeProvider) {
    $routeProvider

    // route for the home page
        .when('/', {
            templateUrl: 'views/home.html',
            controller: 'WelcomeController'
        })

        // route for the about page
        .when('/about', {
            templateUrl: 'views/about.html',
            controller: 'AboutController'
        })

        // route for the contact page
        .when('/contact', {
            templateUrl: 'views/contact.html',
            controller: 'ContactController'
        });
});


chessCloud.controller('AboutController', function ($scope) {
    $scope.message = 'Look! I am an about page.';
});

chessCloud.controller('ContactController', function ($scope) {
    $scope.message = 'Contact us! JK. This is just a demo.';
});

