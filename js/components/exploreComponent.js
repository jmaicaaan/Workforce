module.exports = exploreComponent;


function exploreComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/explore.html",
		link: linker,
		controller: exploreComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){

	}

	function exploreComponentController(){
		var self = this;
	}
}