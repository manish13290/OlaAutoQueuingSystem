angular.module('customerapp', ['ngAnimate', 'ngSanitize', 'ui.bootstrap']);
angular.module('customerapp').controller('CustomerAppCtrl', function ($scope, $http) {

    $scope.customerId = '';
    $scope.message = '';
    $scope.baseUrl = 'http://localhost:8080/OlaAutoWebService/rest/';
    $scope.rideNow = function() {
        if($scope.customerId != '') {
            var data = {customerId: $scope.customerId};
            var config = {
                method: "POST",
                url: $scope.baseUrl + 'ride/create',
                data: angular.toJson(data),
                headers: {
                    'Content-Type': 'application/json; charset=utf-8'
                }
            };
            $http(config).success(function(data){
                if(data.anyError){
                    $scope.message = data.message;
                } else{
                    $scope.message = 'Ride request submitted.';
                }
            });
        }
    };
});
