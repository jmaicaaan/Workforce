module.exports = loginService;

function loginService(httpClientService){
	var self = this;
	self.login = login;

	function login(actionUrl, actionData){
		return httpClientService.clientRequest(actionUrl, actionData)
			.then(function(response){
				return response;
			});
	}
}