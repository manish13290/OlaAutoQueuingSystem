angular.module('driverapp', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);
angular.module('driverapp').controller('DriverAppCtrl', function ($scope, $http) {

    $scope.driverId = '';
    $scope.message = '';
    $scope.waitingList = [];
    $scope.ongoingList = [];
    $scope.finishedList = [];
    $scope.refresh = function() {
        $scope.init();
    };
    $scope.init = function() {
        $scope.getDriverById(driverId);
    }
    $scope.getDriverById = function(driverId) {
        var config = {
                method: "GET",
                url: $scope.baseUrl + 'driver/'+driverId,
            };
            $http(config).success(function(data){
                if(data.anyError){
                    $scope.message = data.message;
                } else{
                    if(data.dataList && data.dataList[0]) {
                        $scope.driverId = data.dataList[0].id;
                        $scope.getAllRide();
                    }
                }
            });
    }
    $scope.getAllRide = function() {
            var config = {
                method: "GET",
                url: $scope.baseUrl + 'ride/all',
            };
            $http(config).success(function(data){
                if(data.anyError){
                    $scope.message = data.message;
                } else{
                    $scope.rearrangeList(data.dataList);
                }
            });
    }
    $scope.rearrangeList = function(rideList) {
        $scope.finishedList = [];
        $scope.ongoingList = [];
        $scope.waitingList = [];
        if(rideList){
            return;
        }
        for(var i=0; i<rideList.length; i++) {
            var ride = rideList[i];
            if(ride.status === 'WAITING') {
                $scope.waitingList.push(ride);
            } else if(ride.status === 'ONGOING') {
                $scope.ongoingList.push(ride);
            } else if(ride.status === 'COMPLETE') {
                $scope.finishedList.push(ride);
            }
        }
    }
});
