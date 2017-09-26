require('../services/module');

module.exports = angular
        .module('app.grupoclientes.controllers', ['app.grupoclientes.services'])
        .controller('GrupoClientesFormController', require('./GrupoClientesFormController'))
        .controller('GrupoClientesListController', require('./GrupoClientesListController'));
