GrupoClientesListController.$inject = ['$scope', 'GrupoClientesService', 'gumgaController'];

function GrupoClientesListController($scope, GrupoClientesService, gumgaController) {

  gumgaController.createRestMethods($scope, GrupoClientesService, 'grupoclientes');

  GrupoClientesService.resetDefaultState();
  $scope.grupoclientes.execute('get');

  $scope.grupoclientes.on('deleteSuccess', function() {
    $scope.grupoclientes.execute('get');
  });

  $scope.actions = [
    { key: 'option1', label: 'option1' },
    { key: 'option2', label: 'option2' }
  ];

  $scope.search = function(field, param) {
    $scope.query = { searchFields: [field], q: param }
    $scope.grupoclientes.methods.search(field,param)
  }

  $scope.advancedSearch = function(param) {
    $scope.grupoclientes.methods.advancedSearch(param)
  }

  $scope.action = function(queryaction) {
    console.log(queryaction);
  }

  $scope.tableConfig = {
    columns: 'nomeGrupo ,button',
    checkbox: true,
    selection: 'multi',
    materialTheme: true,
    itemsPerPage: [5, 10, 15, 30],
    columnsConfig: [{
      name: 'nomeGrupo',
      title: '<span gumga-translate-tag="grupoclientes.nomeGrupo"> nomeGrupo </span>',
      content: '{{$value.nomeGrupo }}',
      sortField: 'nomeGrupo'
    }, {
      name: 'button',
      title: ' ',
      content: '<span class="pull-right"><a class="btn btn-primary btn-sm" ui-sref="grupoclientes.edit({id: {{$value.id}} })"><i class="glyphicon glyphicon-pencil"></i></a></span>'
    }]
  };

};

module.exports = GrupoClientesListController;
