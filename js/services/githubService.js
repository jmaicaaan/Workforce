module.exports = githubService;

function githubService($http, $window){
	var self = this;
	self.githubLogin = githubLogin;

	function githubLogin(){
		//Request the clientID to the server.
		var client_id = "f5b724bbd6f9dc617016";
		var authURI = "https://github.com/login/oauth/authorize?client_id=" + client_id;

		$window.open(authURI, "_blank");
	}

	function githubLoginCallback(){
		
	}
}