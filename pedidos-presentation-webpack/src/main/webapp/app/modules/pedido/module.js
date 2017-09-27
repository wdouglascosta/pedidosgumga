require('./services/module');
require('./controllers/module');

module.exports = angular.module('app.pedido', [
    'app.pedido.controllers',
    'app.pedido.services'
  ])
  .config(function($stateProvider, $httpProvider) {
    $stateProvider
      .state('pedido.list', {
        url: '/list',
        templateUrl: 'app/modules/pedido/views/list.html',
        controller: 'PedidoListController'
      })
      .state('pedido.insert', {
        url: '/insert',
        templateUrl: 'app/modules/pedido/views/form.html',
        controller: 'PedidoFormController',
        resolve: {
          entity: ['$stateParams', '$http', function($stateParams, $http) {
            return $http.get(APILocation.apiLocation + '/api/pedido/new');
          }]
        }
      })
      .state('pedido.edit', {
        url: '/edit/:id',
        templateUrl: 'app/modules/pedido/views/form.html',
        controller: 'PedidoFormController',
        resolve: {
          entity: ['$stateParams', '$http', function($stateParams, $http) {
            return $http.get(APILocation.apiLocation + '/api/pedido/' + $stateParams.id);
          }]
        }
      });
})