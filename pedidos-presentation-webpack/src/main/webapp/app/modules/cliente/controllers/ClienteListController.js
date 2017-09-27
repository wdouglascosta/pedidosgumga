ClienteListController.$inject = ['$scope', 'ClienteService', 'gumgaController'];

function ClienteListController($scope, ClienteService, gumgaController) {

  gumgaController.createRestMethods($scope, ClienteService, 'cliente');

  ClienteService.resetDefaultState();
  $scope.cliente.execute('get');

  $scope.cliente.on('deleteSuccess', function() {
    $scope.cliente.execute('get');
  });

  $scope.actions = [
    { key: 'option1', label: 'option1' },
    { key: 'option2', label: 'option2' }
  ];

  $scope.search = function(field, param) {
    $scope.query = { searchFields: [field], q: param }
    $scope.cliente.methods.search(field,param)
  }

  $scope.advancedSearch = function(param) {
    $scope.cliente.methods.advancedSearch(param)
  }

  $scope.action = function(queryaction) {
    console.log(queryaction);
  }

  $scope.tableConfig = {
    columns: 'nome ,button',
    checkbox: true,
    selection: 'multi',
    materialTheme: true,
    itemsPerPage: [5, 10, 15, 30],
    columnsConfig: [{
      name: 'nome',
      title: '<span gumga-translate-tag="cliente.nome"> nome </span>',
      content: '{{$value.nome }}',
      sortField: 'nome'
    }, {
      name: 'button',
      title: ' ',
      content: '<span class="pull-right"><a class="btn btn-primary btn-sm" ui-sref="cliente.edit({id: {{$value.id}} })"><i class="glyphicon glyphicon-pencil"></i></a></span>'
    }]
  };

};

module.exports = ClienteListController;
