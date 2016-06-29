module.exports = dashboardComponent;

function dashboardComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/dashboard.html",
		link: linker,
		controller: control,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){

	}

	function control($mdSidenav){
		var self = this;
		self.openNav = openNav;

		function openNav(){
			$mdSidenav("nav").toggle();
		}
	}
}