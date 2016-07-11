module.exports = participantService;

function participantService(){
	var self = this;
	self.participant = {};
	self.setParticipantDetails = setParticipantDetails;

	function setParticipantDetails(participantModel){
		self.participant.firstname = participantModel.firstname;
		self.participant.lastname = participantModel.lastname;
		self.participant.imageURL = participantModel.imageURL;
	}

}