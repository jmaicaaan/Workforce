module.exports = dashboardComponent;

function dashboardComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/dashboard.html",
		link: linker,
		controller: dashboardComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){

	}

	function dashboardComponentController($mdSidenav, stateService){
		var self = this;
		self.openNav = openNav;
		self.stateTitle = stateService.stateName;

		function openNav(){
			$mdSidenav("nav").toggle();
		}
	}
}