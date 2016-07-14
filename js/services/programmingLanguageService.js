module.exports = programmingLanguageService;

function programmingLanguageService(httpClientService){
	var self = this;
	self.programmingLanguageList = [];
	self.getProgrammingLanguages = getProgrammingLanguages;

	function getProgrammingLanguages(){
		var actionUrl = "getProgrammingLanguages",
			actionData = {},
			withCredential = true;

		return httpClientService.clientRequest(actionUrl, actionData, withCredential)
			.then(function(response){
				self.programmingLanguageList = response.data.programmingLanguageList;
				return response;
			});
	}

}