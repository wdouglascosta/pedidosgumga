require('../services/module');

module.exports = angular
        .module('app.produto.controllers', ['app.produto.services'])
        .controller('ProdutoFormController', require('./ProdutoFormController'))
        .controller('ProdutoListController', require('./ProdutoListController'));
