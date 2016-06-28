module.exports = registerComponent;

function registerComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/register.html",
		link: linker,
		controller: control,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){

	}

	function control(){
		var self = this;
	}
}