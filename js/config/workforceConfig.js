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
			template: "<main-Component>Hello</main-Component>"
		})
		.state("index.login", {
			url: "login",
			template: "What's up peeps"
		});
}