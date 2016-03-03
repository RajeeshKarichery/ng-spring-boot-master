/**
 * 
 */

 var UserController = function($scope, User,$mdDialog) {	 	
	 User.query(function(response) {
	      $scope.items = response ? response : [];
	    });
	    
	    $scope.addItem = function(name,loginid,password) {
	      new User({
	        name: name,
	        loginid: loginid,
	        password: password
	      }).$save(function(item) {
	        $scope.items.push(item);
	      });
	      $scope.newItem = "";
	    };
	    
	    $scope.updateItem = function(item) {
	      item.$update();
	    };
	    
	    $scope.deleteItem = function(item) {
	      item.$remove(function() {
	        $scope.items.splice($scope.items.indexOf(item), 1);
	      });
	    };
	    
	    
	    $scope.showConfirm = function(ev,item) {	    		
	        var confirm = $mdDialog.confirm()
	              .title('Would you like to delete user?')
	              .ariaLabel('Lucky day')
	              .targetEvent(ev)
	              .ok('Please do it!')
	              .cancel('No');
	        $mdDialog.show(confirm).then(function() {
				$scope.deleteItem(item);
	        }, function() {
	         
	        });
	      };
	    
	    
	    
  };
  UserController.$inject = ['$scope', 'User','$mdDialog'];
  app.controller('UserController', UserController);
