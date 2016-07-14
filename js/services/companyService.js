module.exports = companyService;

function companyService(httpClientService, userService){
	var self = this;
	self.company = {};
	self.companyParticipants = [];
	self.getCompanyDetails = getCompanyDetails;
	self.getCompanyParticipants = getCompanyParticipants;

	function setCompanyDetails(companyModel){
		self.company.email = companyModel.email;
		self.company.name = companyModel.name;
		self.company.description = companyModel.description;
		self.company.location = companyModel.location;
		self.company.imageURL = companyModel.imageURL;
		self.company.programmingLanguage = companyModel.programmingLanguageModel.language;
		self.company.website = companyModel.website;

		setUserServiceDetails();
	}

	function setUserServiceDetails(){
		userService.user.displayName = self.company.name
		userService.user.imageURL = self.company.imageURL;
	}

	function getCompanyDetails(){
		var actionUrl = "getCompanyDetails",
			actionData = {},
			withCredential = true;

		return httpClientService.clientRequest(actionUrl, actionData, withCredential)
			.then(function(response){
				setCompanyDetails(response.data.user.companyModel);
				return response;
			});
	}

	function getCompanyParticipants(){
		var actionUrl = "getCompanyParticipants",
			actionData = {},
			withCredential = true;

		return httpClientService.clientRequest(actionUrl, actionData, withCredential)
			.then(function(response){
				self.companyParticipants = response.data.user.companyModel.programmingLanguageModel.participantModel;
				console.log(self.companyParticipants);
				console.log(response);
				return response.data.user.companyModel.programmingLanguageModel.participantModel;
			});
	}
}