ProdutoService.$inject = ['GumgaRest'];

function ProdutoService(GumgaRest) {
	var Service = new GumgaRest(APILocation.apiLocation + '/api/produto');

	return Service;
}

module.exports = ProdutoService;
