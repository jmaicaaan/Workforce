module.exports = accountComponent;

function accountComponent($timeout){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/settings/account.html",
		link: linker,
		controller: accountComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){
		
	}

	function accountComponentController(participantService){
		var self = this;
		self.participant = {};
		self.participantService = participantService;
		self.updatePassword = updatePassword;

		function updatePassword(){
			participantService.updateParticipantPassword(self.participant)
				.then(function(response){
					console.log(response);
				});
		}

	}
}