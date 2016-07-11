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

	function dashboardComponentController($mdSidenav, stateService, userService, participantService){
		var self = this;
		self.openNav = openNav;
		self.stateTitle = stateService.stateName;

		loadDashboardUserDetails();

		function loadDashboardUserDetails(){
			var actionUrl = "getDashboardUserDetails",
				actionData = {
					user: {
						accessToken: userService.user.accessToken
					}
				};

			userService.getDashboardUserDetails(actionUrl, actionData, true)
				.then(function(response){
					console.log(response);
					if(response.statusText == "OK"){
						if(userService.isUserAParticipant){
							participantService.setParticipantDetails(response.data.user.participantModel);
						}
					}
				});
		}

		function openNav(){
			$mdSidenav("nav").toggle();
		}
	}
}