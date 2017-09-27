PedidoListController.$inject = ['$scope', 'PedidoService', 'gumgaController'];

function PedidoListController($scope, PedidoService, gumgaController) {

  gumgaController.createRestMethods($scope, PedidoService, 'pedido');

  PedidoService.resetDefaultState();
  $scope.pedido.execute('get');

  $scope.pedido.on('deleteSuccess', function() {
    $scope.pedido.execute('get');
  });

  $scope.actions = [
  ];

  $scope.search = function(field, param) {
    $scope.query = { searchFields: [field], q: param }
    $scope.pedido.methods.search(field,param)
  }

  $scope.advancedSearch = function(param) {
    $scope.pedido.methods.advancedSearch(param)
  }

  $scope.action = function(queryaction) {
    console.log(queryaction);
  }

  $scope.tableConfig = {
    columns: 'cliente ,button',
    checkbox: true,
    selection: 'multi',
    materialTheme: true,
    itemsPerPage: [5, 10, 15, 30],
    columnsConfig: [{
      name: 'cliente',
      title: '<span gumga-translate-tag="cliente.title"> Clientes </span>',
      content: '{{$value.cliente.nome }}',
      sortField: 'cliente.nome'
    }, {
      name: 'button',
      title: ' ',
      content: '<span class="pull-right"><a class="btn btn-primary btn-sm" ui-sref="pedido.edit({id: {{$value.id}} })"><i class="glyphicon glyphicon-pencil"></i></a></span>'
    }]
  };

};

module.exports = PedidoListController;
