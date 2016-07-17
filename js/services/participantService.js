module.exports = participantService;

function participantService(httpClientService, userService){
	var self = this;
	self.participant = {};
	self.getParticpantDetails = getParticpantDetails;
	self.updateParticipantProfile = updateParticipantProfile;
	self.updateParticipantPassword = updateParticipantPassword;

	function setParticipantDetails(participantModel){
		self.participant.firstname = participantModel.firstname;
		self.participant.lastname = participantModel.lastname;
		self.participant.imageURL = participantModel.imageURL;
		self.participant.location = participantModel.location;
		self.participant.programmingLanguage = participantModel.programmingLanguageModel.language;

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
				console.log(response);
				setParticipantDetails(response.data.user.participantModel);
				return response;
			});
	}

	function updateParticipantProfile(participant){

		var actionUrl = "updateParticipantProfile",
			actionData = {
				participant : participant,
				programmingLanguageModel : {
					language : participant.programmingLanguage
				}
			},
			withCredential = true;

		return httpClientService.clientRequest(actionUrl, actionData, withCredential)
			.then(function(response){
				console.log("Invoked participantService updateParticipant");
				console.log(response);
				alert("Updated profile");
			});
	}

	function updateParticipantPassword(participant){

		var actionUrl = "updateParticipantPassword",
			actionData = {
				user: participant
			},
			withCredential = true;

		return httpClientService.clientRequest(actionUrl, actionData, withCredential)
			.then(function(response){
				console.log("Invoked participantService updateParticipantPassword");
				console.log(response);
				alert("Password changed");
			});

	}
}