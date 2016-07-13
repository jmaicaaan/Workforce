module.exports = programmingLanguageService;

function programmingLanguageService(httpClientService){
	var self = this;
	self.programmingLanguages = [];
	self.getProgrammingLanguages = self.getProgrammingLanguages;

	function getProgrammingLanguages(){
		var actionUrl = "",
			actionData = {},
			withCredential = true;

		return httpClientService.clientRequest(actionUrl, actionData, withCredential)
			.then(function(response){
				console.log(response);
				return response;
			});
	}

}