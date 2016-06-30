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

	function linker(scope, elem, attrs){

	}

	function loginComponentController($state){
		var self = this;

		self.user = {};
		self.login = login;

		function login(){
			console.log(self.user);
			if(self.user.email == "admin" && self.user.password == "admin")
				$state.go("dashboard");
			else
				alert("Incorrect email or password.");
		}
	}
}