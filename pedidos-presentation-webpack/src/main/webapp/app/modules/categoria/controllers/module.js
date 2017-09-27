require('../services/module');

module.exports = angular
        .module('app.categoria.controllers', ['app.categoria.services'])
        .controller('CategoriaFormController', require('./CategoriaFormController'))
        .controller('CategoriaListController', require('./CategoriaListController'));
