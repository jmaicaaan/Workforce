module.exports = loginService;

function loginService(httpClientService, userService){
	var self = this;
	self.login = login;

	function login(actionUrl, actionData, withCredential){
		return httpClientService.clientRequest(actionUrl, actionData, withCredential)
			.then(function(response){
				console.log(response);
				userService.setUserDetails(response.data.user);
				return response.statusText;
			});
	}
}
