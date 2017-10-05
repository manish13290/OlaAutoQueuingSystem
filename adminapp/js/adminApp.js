angular.module('adminapp', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);
angular.module('adminapp').controller('AdminAppCtrl', function ($scope, $http) {

    $scope.driverId = '4';
    $scope.rideList = [];
    $scope.message = '';
    $scope.refresh = function() {
        $scope.getAllRide();
    };
    $scope.getAllRide = function() {
        var config = {
            method: "GET",
            url: $scope.baseUrl + 'ride/all',
        };
        $http(config).success(function(data){
            if(data.anyError){
                $scope.message = data.message;
            } else{
                $scope.rideList = data.dataList;
            }
        });
    }
});
