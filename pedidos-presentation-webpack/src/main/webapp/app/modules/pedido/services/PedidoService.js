PedidoService.$inject = ['GumgaRest'];

function PedidoService(GumgaRest) {
	var Service = new GumgaRest(APILocation.apiLocation + '/api/pedido');

	return Service;
}

module.exports = PedidoService;
