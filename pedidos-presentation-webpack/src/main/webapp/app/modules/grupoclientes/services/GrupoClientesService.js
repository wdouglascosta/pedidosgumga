GrupoClientesService.$inject = ['GumgaRest'];

function GrupoClientesService(GumgaRest) {
	var Service = new GumgaRest(APILocation.apiLocation + '/api/grupoclientes');

	return Service;
}

module.exports = GrupoClientesService;
