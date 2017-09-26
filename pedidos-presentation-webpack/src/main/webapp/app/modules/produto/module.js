require('./services/module');
require('./controllers/module');

module.exports = angular.module('app.produto', [
    'app.produto.controllers',
    'app.produto.services'
  ])
  .config(function($stateProvider, $httpProvider) {
    $stateProvider
      .state('produto.list', {
        url: '/list',
        templateUrl: 'app/modules/produto/views/list.html',
        controller: 'ProdutoListController'
      })
      .state('produto.insert', {
        url: '/insert',
        templateUrl: 'app/modules/produto/views/form.html',
        controller: 'ProdutoFormController',
        resolve: {
          entity: ['$stateParams', '$http', function($stateParams, $http) {
            return $http.get(APILocation.apiLocation + '/api/produto/new');
          }]
        }
      })
      .state('produto.edit', {
        url: '/edit/:id',
        templateUrl: 'app/modules/produto/views/form.html',
        controller: 'ProdutoFormController',
        resolve: {
          entity: ['$stateParams', '$http', function($stateParams, $http) {
            return $http.get(APILocation.apiLocation + '/api/produto/' + $stateParams.id);
          }]
        }
      });
})