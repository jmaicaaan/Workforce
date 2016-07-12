module.exports = userSessionService;

function userSessionService(){
	var self = this;
	self.userSession = {
		email: "",
		password: "",
		hasAccessToken: false,
		accessToken: "",
		accountType: 0
	};
}
