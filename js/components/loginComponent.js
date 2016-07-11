module.exports = loginComponent;

function loginComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/login.html",
		link: linker,
		controller: loginComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){}

	function loginComponentController($state, githubService, loginService, userService){
		var self = this;
		self.user = {};
		self.login = login;
		self.githubLogin = githubLogin;

		function login(){
			
			var actionUrl = "login",
				actionData = {
					user: {
						email: self.user.email,
						password: self.user.password
					}
				};

			loginService.login(actionUrl, actionData, true)
				.then(function(statusText){
					if(statusText == "OK"){
						$state.go("dashboard");
					}
				});
		}

		function githubLogin(){
			githubService.githubLogin();
		}
	}
}