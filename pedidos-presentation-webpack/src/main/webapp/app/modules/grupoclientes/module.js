require('./services/module');
require('./controllers/module');

module.exports = angular.module('app.grupoclientes', [
    'app.grupoclientes.controllers',
    'app.grupoclientes.services'
  ])
  .config(function($stateProvider, $httpProvider) {
    $stateProvider
      .state('grupoclientes.list', {
        url: '/list',
        templateUrl: 'app/modules/grupoclientes/views/list.html',
        controller: 'GrupoClientesListController'
      })
      .state('grupoclientes.insert', {
        url: '/insert',
        templateUrl: 'app/modules/grupoclientes/views/form.html',
        controller: 'GrupoClientesFormController',
        resolve: {
          entity: ['$stateParams', '$http', function($stateParams, $http) {
            return $http.get(APILocation.apiLocation + '/api/grupoclientes/new');
          }]
        }
      })
      .state('grupoclientes.edit', {
        url: '/edit/:id',
        templateUrl: 'app/modules/grupoclientes/views/form.html',
        controller: 'GrupoClientesFormController',
        resolve: {
          entity: ['$stateParams', '$http', function($stateParams, $http) {
            return $http.get(APILocation.apiLocation + '/api/grupoclientes/' + $stateParams.id);
          }]
        }
      });
})