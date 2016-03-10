app.controller('MessageController',function($scope,MessageService){
    init();

    function init(){
        MessageService.getMessages($scope).then(function(data) {
                $scope.stories = data;
            },
            function(error){
                $scope.error = error;
            });
    }

});

app.service('MessageService', function($http) {
    return {
        getMessages:function(){
            return $http.get('/users').then(function(response) {
                return response.data;
            });
        }
    };
});