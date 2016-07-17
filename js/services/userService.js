module.exports = userService;

function userService(httpClientService, $q){
	var self = this;
	self.user = {};
	self.setUserDetails = setUserDetails;
	self.isUserACompany = isUserACompany;
	self.isUserAParticipant = isUserAParticipant;
	self.getUserAccountType = getUserAccountType;

	function setUserDetails(userModel){
		self.user.accessToken = userModel.accessToken;
		self.user.accountType = userModel.accountTypeModel.type;
	}

	function getUserAccountType() {

		var actionUrl = "getUserAccountType",
				actionData = {},
				withCredential = true;


		return httpClientService.clientRequest(actionUrl, actionData, withCredential)
			.then(function(response){
				setUserDetails(response.data.user);
				return response;
			});
	}

	function isUserACompany(){
		return self.user.accountType == "Company" ? true : false; 
	}

	function isUserAParticipant(){
		return self.user.accountType == "Participant" ? true: false;
	}

	function getUserAccessToken(){
		return self.user.accessToken;
	}
}