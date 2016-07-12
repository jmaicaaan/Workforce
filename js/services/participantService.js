module.exports = participantService;

function participantService(httpClientService, userService){
	var self = this;
	self.participant = {};
	self.getParticpantDetails = getParticpantDetails;

	function setParticipantDetails(participantModel){
		self.participant.firstname = participantModel.firstname;
		self.participant.lastname = participantModel.lastname;
		self.participant.imageURL = participantModel.imageURL;

		setUserServiceDetails();
	}

	function setUserServiceDetails(){
		userService.user.displayName = [self.participant.firstname, 
						self.participant.lastname].join(" ");
		userService.user.imageURL = self.participant.imageURL;
	}

	function getParticpantDetails(){

		var actionUrl = "getParticipantDetails",
			actionData = {},
			withCredential = true;

		return httpClientService.clientRequest(actionUrl, actionData, withCredential)
			.then(function(response){
				setParticipantDetails(response.data.user.participantModel);
				return response;
			});
	}
}