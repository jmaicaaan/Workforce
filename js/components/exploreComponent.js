module.exports = exploreComponent;


function exploreComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/explore.html",
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