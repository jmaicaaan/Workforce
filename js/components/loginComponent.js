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

	function loginComponentController($state, githubService, loginService){
		var self = this;
		self.user = {};
		self.login = login;
		self.githubLogin = githubLogin;

		function login(){
			
			var actionUrl = "loginAction",
				actionData = {
					user: {
						email: self.user.email,
						password: self.user.password
					}
				};

			loginService.login(actionUrl, actionData)
				.then(function(response){
					console.log(response);
					if(response.statusText == "OK"){
						$state.go("dashboard");
					}
				});
		}

		function githubLogin(){
			githubService.githubLogin();
		}
	}
}