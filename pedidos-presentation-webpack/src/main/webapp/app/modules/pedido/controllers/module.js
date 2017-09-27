require('../services/module');

module.exports = angular
        .module('app.pedido.controllers', ['app.pedido.services'])
        .controller('ModalItemPedidoController', require('./ModalItemPedidoController'))
        .controller('PedidoFormController', require('./PedidoFormController'))
        .controller('PedidoListController', require('./PedidoListController'));
