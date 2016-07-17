module.exports = httpClientService;

function httpClientService($http, serverConfig){
	var self = this;
	self.clientRequest = clientRequest;

	function clientRequest(actionUrl, actionData, withCredential){

		var dataObject = Object.getOwnPropertyNames(actionData).length !== 0? actionData : {};

		var config = {
			url: [serverConfig.host, serverConfig.appName, actionUrl].join(serverConfig.delimeter),
			method: "POST",
			headers: {
				"Content-Type": serverConfig.contentType
			},
			data: dataObject,
			withCredentials: withCredential
		};

		return $http(config)
			.then(function(response){
				return response;
			});
	}
}