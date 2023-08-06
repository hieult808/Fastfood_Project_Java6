let host = "http://localhost:8080/rest";
const app = angular.module("shopping-cart-app", []);
app.controller("shopping-cart-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.load_all = function () {
        var url = `${host}/cart`;
        $http
          .get(url)
          .then((resp) => {
            $scope.items = resp.data;
            alertSuccess("Load dữ liệu thành công");
            console.log("Success", resp);
          })
          .catch((error) => {
            alertDanger("Load dữ liệu thất bại");
            console.log("Error", error);
          });
      };

















    
      $scope.load_all();

});