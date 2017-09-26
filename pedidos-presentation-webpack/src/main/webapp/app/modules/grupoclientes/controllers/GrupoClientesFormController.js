GrupoClientesFormController.$inject = ['GrupoClientesService', '$state', 'entity', '$scope', 'gumgaController'];

function GrupoClientesFormController(GrupoClientesService, $state, entity, $scope, gumgaController) {

	gumgaController.createRestMethods($scope, GrupoClientesService, 'grupoclientes');




	$scope.grupoclientes.data = entity.data || {};
	$scope.continue = {};

	$scope.grupoclientes.on('putSuccess',function(data){
		$state.go('grupoclientes.list');
	});
}

module.exports = GrupoClientesFormController;
