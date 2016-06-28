module.exports = loginComponent;

function loginComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/login.html",
		link: linker,
		controller: control,
		controllerAs: "vm",
	};

	function linker(scope, elem, attrs){

	}

	function control(){
		var self = this;
	}
}