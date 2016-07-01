module.exports = activateAccountComponent;

function activateAccountComponent(){
	return{
		scope: {},
		restrict: "E",
		templateUrl: "../../views/activateAccount.html",
		link: linker,
		controller: activateAccountController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){

	}

	function activateAccountController(){
		var self = this;
	}
}