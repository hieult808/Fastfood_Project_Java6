const app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function ($scope, $http) {
    $scope.cart = {
        items: [],
        //them san pham vao gio hang
        // add(itemId) {
        //     var item = this.items.find(item => item.itemId == itemId);
        //     if (item) {
        //         item.qty++;
        //         this.saveToLocalStorage();
        //     }
        //     else {
        //         $http.get(`/rest/products/${itemId}`).then(resp => {
        //             resp.data.qty = 1;
        //             this.items.push(resp.data);
        //             this.saveToLocalStorage();
        //         })
        //     }
        // },

        // remote(itemId) {
        //     var index = this.items.findIndex(item => item.itemId == itemId);
        //     this.items.splice(index, 1);
        //     this.saveToLocalStorage();
        // },


        // get count() {
        //     return this.items
        //         .map(item => item.qty)
        //         .reduce((total, qty) => total + qty, 0);
        // },
        // get amount() {
        //     return this.items
        //         .map(item => item.qty * item.price)
        //         .reduce((total, qty) => total + qty, 0);
        // },
        //luu vao local storages
        // saveToLocalStorage() {
        //     var json = JSON.stringify(angular.copy(this.items));
        //     localStorage.setItem("cart", json);
        // }, 
        // calculateTotalPrice() {
        //     return this.items
        //         .map(item => item.qty * item.price)
        //         .reduce((total, amount) => total + amount, 0);
        // },
        // //load cart
        // loadFromLocalStorege() {
        //     var json = localStorage.getItem("cart");
        //     this.items = json ? JSON.parse(json) : [];
        // },


        add(itemId) {
            var item = this.items.find(item => item.itemId == itemId);
            if (item) {
                item.quantity++;
                this.saveToDatabase(itemId, item.quantity);
            }
            else {
                $http.get(`/rest/products/${itemId}`).then(resp => {
                    resp.data.quantity = 1;
                    this.items.push(resp.data);
                    this.saveToDatabase(itemId, 1);
                })
            }
        },
        saveToDatabase(itemId, quantity) {
            var accountId = 1; // Thay thế bằng cách lấy accountId từ người dùng sau khi đăng nhập
            var url = `/rest/products/add-to-cart/${itemId}/${accountId}/${quantity}`;

            $http.post(url)
                .then(response => {
                    console.log(response.data);
                    this.loadCartItems(); // Load lại danh sách sản phẩm trong giỏ hàng sau khi cập nhật
                })
                .catch(error => {
                    console.error(error);
                });
        },

        loadCartItems() {
            var accountId = 1; // Thay thế bằng cách lấy accountId từ người dùng sau khi đăng nhập
            var url = `/rest/products/cart-items/${accountId}`;

            $http.get(url)
                .then(response => {
                    this.items = response.data;
                })
                .catch(error => {
                    console.error(error);
                });
        },

        // remove(itemId) {
        //     var accountId = 1; // Thay thế bằng cách lấy accountId từ người dùng sau khi đăng nhập
        //     var url = `/rest/products/remove-from-cart/${itemId}/${accountId}`;

        //     $http.delete(url)
        //         .then(response => {
        //             console.log(response.data);
        //             this.loadCartItems(); // Load lại danh sách sản phẩm trong giỏ hàng sau khi xóa
        //         })
        //         .catch(error => {
        //             console.error(error);
        //         });
        // }
    }
    // $scope.cart.selectAllItems = function (selectAll) {
    //     $scope.cart.items.forEach(item => {
    //         item.selected = selectAll;
    //     });
    // };
    
    // $scope.cart.removeSelectedItems = function () {
    //     var selectedItems = $scope.cart.items.filter(item => item.selected);
    //     selectedItems.forEach(selectedItem => {
    //         var index = $scope.cart.items.indexOf(selectedItem);
    //         if (index !== -1) {
    //             $scope.cart.items.splice(index, 1);
    //         }
    //     });
    //     $scope.cart.saveToLocalStorage();
    // };
    
    $scope.cart.loadCartItems();
});

