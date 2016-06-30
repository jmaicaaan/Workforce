module.exports = profileComponent;

function profileComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/settings/profile.html",
		link: linker,
		controller: profileComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){

	}

	function profileComponentController(){
		var self = this;
	}
}