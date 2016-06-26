module.exports = mainComponent;

function mainComponent(){

	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/main.html",
		link: linker,
		controller: control,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){
		
	}

	function control($mdSidenav, $mdPanel){
		var self = this;

		self.openNav = openNav;

		openNav();

		function openNav(event){
			//$mdSidenav("nav").toggle();

			// $mdDialog.show({
			// 	parent: angular.element(document.body),
			// 	targetEvent: event,
			// 	templateUrl: "../../views/dialog.html"
			// })

			var config = {
				attachTo: angular.element(document.body),
				disableParentScroll: true,
				templateUrl: "../../views/dialog.html",
				hasBackdrop: true,
				panelClass: "demo-dialog-example",
				targetEvent: event,
				position: $mdPanel.newPanelPosition().absolute().center(),
				trapFocus: true,
				zIndex: 150,
				clickOutsideToClose: true,
			    escapeToClose: true,
			    focusOnOpen: true
			};

			$mdPanel.open(config);
		}
	}
}