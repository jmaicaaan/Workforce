module.exports = httpClientService;

function httpClientService($http, serverConfig){
	var self = this;
	self.clientRequest = clientRequest;

	function clientRequest(actionUrl, actionData, withCredential){
		var config = {
			url: [serverConfig.host, serverConfig.appName, actionUrl].join(serverConfig.delimeter),
			method: "POST",
			headers: {
				"Content-Type": serverConfig.contentType
			},
			data: actionData,
			withCredentials: withCredential
		};

		return $http(config)
			.then(function(response){
				return response;
			});
	}
}