    app.controller('ServerController', [ '$scope', 'ToastService', function($scope, toastService) {
        $scope.version = angular.version.full;
        $scope.messages = toastService.messages;


    } ]);

   app.factory('ToastService', [ '$rootScope', function($rootScope) {
        var messages = [];
        var websocketSocket = atmosphere;
        var websocketSubSocket;
        var websocketTransport = 'websocket';

      /*  function getUrl() {
            var url = window.location.origin;
            if (url.contains('cfapps.io')) {
                url = url + ':4443';
            }
            return url + '/websocket/toast';
        }*/

        var websocketRequest = {
            //url : '/websocket/toast',
           // url : '/items',
            url : '/websocket/toast2',
            contentType : "application/json",
            transport : websocketTransport,
            trackMessageLength : true,
            withCredentials : true,
            reconnectInterval : 5000,
            enableXDR : true,
            timeout : 60000
        };

        websocketRequest.onOpen = function(response) {
            console.log('Trying to use transport: ' + response.transport);
            websocketTransport = response.transport;
        };

        websocketRequest.onClientTimeout = function(r) {
            setTimeout(function() {
                websocketSubSocket = websocketSocket.subscribe(websocketRequest);
            }, websocketRequest.reconnectInterval);
        };

        websocketRequest.onClose = function(response) {
            console.log('Server closed websocket connection. Changing transport to: '+ response.transport);
        };

        websocketRequest.onMessage = function(data) {
            console.log('onMessage ...called ');
            var responseText = data.responseBody;

            // messages = atmosphere.util.parseJSON(responseText);
          //  console.log("description ="+responseText.description);

          //  var propNames = Object.getOwnPropertyNames(responseText);

          //  propNames.forEach(function(name) {
            //    console.log("naaaaaaaaaaa ="+name);
          //  });

           // messages.removeAll();
            $rootScope.$apply(function() {
                items = atmosphere.util.parseJSON(responseText);
                //console.log("cccc="+messages[0]['description']);
                //messages.push(item[0]['description']);
                for(i=0;i<items.length;i++)
                    messages.push(items[i]);
            });
            //messages = atmosphere.util.parseJSON(responseText);

        };

        websocketSubSocket = websocketSocket.subscribe(websocketRequest);

        return {
            messages : messages
        };
    } ]);



