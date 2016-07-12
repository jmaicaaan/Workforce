module.exports = companyService;

function companyService(httpClientService, userService){
	var self = this;
	self.company = {};
	self.getCompanyDetails = getCompanyDetails;

	function setCompanyDetails(companyModel){
		self.company.name = companyModel.name;
		self.company.imageURL = companyModel.imageURL;

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
				console.log(response);
				setCompanyDetails(response.data.user.companyModel);
				return response;
			});
	}
}