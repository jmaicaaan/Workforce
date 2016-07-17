module.exports = mainComponent;

function mainComponent(){

	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/main.html",
		link: linker,
		controller: mainComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){
		
	}

	function mainComponentController($mdSidenav, $mdPanel){
		var self = this;

		self.openNav = openNav;

		function openNav(event){
			$mdSidenav("nav").toggle();
		}
	}
}