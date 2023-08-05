const app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function ($scope, $http) {
    $scope.cart = {
        items: [],
        //them san pham vao gio hang
        add(itemId) {
            var item = this.items.find(item => item.itemId == itemId);
            if (item) {
                item.qty++;
                this.saveToLocalStorage();
            }
            else {
                $http.get(`/rest/products/${itemId}`).then(resp => {
                    resp.data.qty = 1;
                    this.items.push(resp.data);
                    this.saveToLocalStorage();
                })
            }
        },
        remote(itemId) {
            var index = this.items.findIndex(item => item.itemId == itemId);
            this.items.splice(index, 1);
            this.saveToLocalStorage();
        },


        get count() {
            return this.items
                .map(item => item.qty)
                .reduce((total, qty) => total + qty, 0);
        },
        get amount() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, qty) => total + qty, 0);
        },
        //luu vao local storages
        saveToLocalStorage() {
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart", json);
        }, 
        calculateTotalPrice() {
            return this.items
                .map(item => item.qty * item.price)
                .reduce((total, amount) => total + amount, 0);
        },
        //load cart
        loadFromLocalStorege() {
            var json = localStorage.getItem("cart");
            this.items = json ? JSON.parse(json) : [];
        },
    }
    $scope.cart.selectAllItems = function (selectAll) {
        $scope.cart.items.forEach(item => {
            item.selected = selectAll;
        });
    };
    
    $scope.cart.removeSelectedItems = function () {
        var selectedItems = $scope.cart.items.filter(item => item.selected);
        selectedItems.forEach(selectedItem => {
            var index = $scope.cart.items.indexOf(selectedItem);
            if (index !== -1) {
                $scope.cart.items.splice(index, 1);
            }
        });
        $scope.cart.saveToLocalStorage();
    };
    
    $scope.cart.loadFromLocalStorege();
});

