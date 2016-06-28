module.exports = workforceConfig;


function workforceConfig($stateProvider, $urlRouterProvider, $mdThemingProvider){
	

	$mdThemingProvider.theme("default")
		.primaryPalette("blue")
		.accentPalette("pink")
		.warnPalette("red");

	$urlRouterProvider.otherwise("/");

	$stateProvider
		.state("index", {
			url: "/",
			template: "<main-Component>Loading...</main-Component>"
		})
		.state("login", {
			url: "/login",
			template: "<login-Component>Loading...</login-Component>"
		})
		.state("register", {
			url: "/register",
			template: "<register-Component>Loading...</register-Component>"
		})
		.state("login.github", {
			url: "/login/auth",
			template: "github"
		})
		.state("callback", {
			url: "/callback",
			controller: function($state, $stateParams, $location){
				var self = this;

				console.log($location.$$absUrl);
				var xxx = $location.$$absUrl;
				console.log(xxx.substring(xxx.indexOf("=") + 1, xxx.indexOf("#") -1));
			}
		});
}