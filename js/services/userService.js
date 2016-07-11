module.exports = userService;

function userService(httpClientService){
	var self = this;
	self.user = {};
	self.setUserDetails = setUserDetails;
	self.isUserACompany = isUserACompany;
	self.isUserAParticipant = isUserAParticipant;
	self.getDashboardUserDetails = getDashboardUserDetails;

	function setUserDetails(userModel){
		self.user.accessToken = userModel.accessToken;
		self.user.accountType = userModel.accountTypeModel.type;
	}

	function getDashboardUserDetails(actionUrl, actionData, withCredential) {
		return httpClientService.clientRequest(actionUrl, actionData, withCredential)
			.then(function(response){
				console.log(response);
				setUserDetails(response.data.user);
				return response;
			});
	}

	function getUserAccountType(){
		return self.user.accountType;
	}

	function isUserACompany(){
		return getUserAccountType() == "Company" ? true: false;
	}

	function isUserAParticipant(){
		return getUserAccountType() == "Participant" ? true: false;
	}

	function getUserAccessToken(){
		return self.user.accessToken;
	}
}