ClienteService.$inject = ['GumgaRest'];

function ClienteService(GumgaRest) {
	var Service = new GumgaRest(APILocation.apiLocation + '/api/cliente');

	return Service;
}

module.exports = ClienteService;
