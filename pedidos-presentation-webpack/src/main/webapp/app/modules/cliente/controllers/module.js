require('../services/module');

module.exports = angular
        .module('app.cliente.controllers', ['app.cliente.services'])
        .controller('ClienteFormController', require('./ClienteFormController'))
        .controller('ClienteListController', require('./ClienteListController'));
