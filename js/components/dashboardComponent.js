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

	function dashboardComponentController($mdSidenav, stateService, userService, participantService, companyService){
		var self = this;
		self.openNav = openNav;
		self.stateTitle = stateService.stateName;
		self.userService = userService;

		init();

		function init(){
			
			userService.getUserAccountType().then(function(response){
				if(response.statusText == "OK"){
					if(userService.isUserAParticipant()){

						participantService.getParticpantDetails();

					}else if(userService.isUserACompany()){
						companyService.getCompanyDetails();
					}	
				}
			});
		}

		function openNav(){
			$mdSidenav("nav").toggle();
		}
	}
}