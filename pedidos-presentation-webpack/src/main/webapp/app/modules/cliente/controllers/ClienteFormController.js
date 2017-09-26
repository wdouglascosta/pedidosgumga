ClienteFormController.$inject = ['ClienteService', '$state', 'entity', '$scope', 'gumgaController', 'GrupoClientesService'];

function ClienteFormController(ClienteService, $state, entity, $scope, gumgaController, GrupoClientesService) {

	gumgaController.createRestMethods($scope, ClienteService, 'cliente');


	gumgaController.createRestMethods($scope, GrupoClientesService, 'grupoclientes');
	$scope.grupoclientes.methods.search('nomeGrupo','');

	$scope.grupoclientesConfig = {};

	$scope.grupoClientesOptions=[];

	$scope.cliente.data = entity.data || {};
	$scope.continue = {};

	$scope.cliente.on('putSuccess',function(data){
		$state.go('cliente.list');
	});
}

module.exports = ClienteFormController;
