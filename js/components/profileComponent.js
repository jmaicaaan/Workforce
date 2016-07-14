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

	function profileComponentController(userService, companyService, participantService, programmingLanguageService){
		var self = this;
		self.userService = userService; //To be use in the view...
		self.companyService = companyService;
		self.participantService = participantService;
		self.programmingLanguageService = programmingLanguageService;
		self.company = {};
		self.participant = {};


		init();

		function init(){
			userService.getUserAccountType().then(function(response){
				if(response.statusText == "OK"){
					if(userService.isUserAParticipant()){
						
						participantService.getParticpantDetails();
						self.participant = participantService.participant;

					}else if(userService.isUserACompany()){
						
						companyService.getCompanyDetails();
						self.company = companyService.company;
					}	
				}
			}).then(function(){
				programmingLanguageService.getProgrammingLanguages();
			});
		}		
	}
}