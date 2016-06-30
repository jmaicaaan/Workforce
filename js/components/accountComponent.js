module.exports = accountComponent;

function accountComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/settings/account.html",
		link: linker,
		controller: accountComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){

	}

	function accountComponentController(){
		var self = this;
	}
}