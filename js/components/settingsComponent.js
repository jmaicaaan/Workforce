module.exports = settingsComponent;

function settingsComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/settings.html",
		link: linker,
		controller: settingsComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){

	}

	function settingsComponentController($state){
		var self = this;		
		// $state.go("dashboard.settings.profile");

	}
}