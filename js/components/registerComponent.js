module.exports = registerComponent;

function registerComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/register.html",
		link: linker,
		controller: registerComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){

	}

	function registerComponentController(){
		var self = this;
	}
}