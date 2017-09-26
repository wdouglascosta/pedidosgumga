require('./services/module');
require('./controllers/module');

module.exports = angular.module('app.categoria', [
    'app.categoria.controllers',
    'app.categoria.services'
  ])
  .config(function($stateProvider, $httpProvider) {
    $stateProvider
      .state('categoria.list', {
        url: '/list',
        templateUrl: 'app/modules/categoria/views/list.html',
        controller: 'CategoriaListController'
      })
      .state('categoria.insert', {
        url: '/insert',
        templateUrl: 'app/modules/categoria/views/form.html',
        controller: 'CategoriaFormController',
        resolve: {
          entity: ['$stateParams', '$http', function($stateParams, $http) {
            return $http.get(APILocation.apiLocation + '/api/categoria/new');
          }]
        }
      })
      .state('categoria.edit', {
        url: '/edit/:id',
        templateUrl: 'app/modules/categoria/views/form.html',
        controller: 'CategoriaFormController',
        resolve: {
          entity: ['$stateParams', '$http', function($stateParams, $http) {
            return $http.get(APILocation.apiLocation + '/api/categoria/' + $stateParams.id);
          }]
        }
      });
})