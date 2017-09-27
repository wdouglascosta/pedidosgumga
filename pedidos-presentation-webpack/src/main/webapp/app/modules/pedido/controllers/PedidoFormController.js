PedidoFormController.$inject = ['PedidoService', '$state', 'entity', '$scope', 'gumgaController', 'ClienteService'];

function PedidoFormController(PedidoService, $state, entity, $scope, gumgaController, ClienteService) {

	gumgaController.createRestMethods($scope, PedidoService, 'pedido');

	$scope.valueTpPedido = [{value:'COMPRA', label:'COMPRA'}, {value:'VENDA', label:'VENDA'}]

	gumgaController.createRestMethods($scope, ClienteService, 'cliente');
	$scope.cliente.methods.search('nome','');

	$scope.clienteConfig = {};


	$scope.pedido.data = entity.data || {};
	$scope.pedido.data.itens = $scope.pedido.data.itens || [];

	$scope.itensConfig = {
		ngModel: 'pedido.data.itens',
		options: {
			type: 'array',
			message: 'Its not array',
			empty: {
				value: false,
				message: 'Is Empty'
			}
		}
	};
	$scope.continue = {};

	$scope.pedido.on('putSuccess',function(data){
		$state.go('pedido.list');
	});
}

module.exports = PedidoFormController;

