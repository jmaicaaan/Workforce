module.exports = workforceConfig;


function workforceConfig($stateProvider, $urlRouterProvider, $mdThemingProvider){
	

	$mdThemingProvider.theme("default")
		.primaryPalette("blue")
		.accentPalette("pink")
		.warnPalette("red");

	$urlRouterProvider
		.when("/dashboard/settings", "/dashboard/settings/profile")
		.when("/dashboard/settings/", "/dashboard/settings/profile")
		.otherwise("/");

	$stateProvider
		.state("index", {
			url: "/",
			title: "Index",
			template: "<main-Component>Loading...</main-Component>"
		})
		.state("login", {
			url: "/login",
			title: "Login",
			template: "<login-Component>Loading...</login-Component>"
		})
		.state("register", {
			url: "/register",
			title: "Register",
			template: "<register-Component>Loading...</register-Component>"
		})
		.state("dashboard", {
			url: "/dashboard",
			title: "Dashboard",
			template: "<dashboard-Component>Loading...</dashboard-Component>"
		})
		.state("dashboard.explore", {
			url: "/explore",
			title: "Explore",
			template: "<explore-Component>Loading...</explore-Component>"
		})
		.state("dashboard.settings", {
			url: "/settings",
			title: "Settings",
			template: "<settings-Component>Loading...</settings-Component>"
		})
		.state("dashboard.settings.profile", {
			url: "/profile",
			title: "Profile Settings",
			template: "<profile-Component>Loading...</profile-Component>"
		})
		.state("dashboard.settings.account", {
			url: "/account",
			title: "Account Settings",
			template: "<account-Component>Loading...</account-Component>"
		})
		.state("activateAccount", {
			url: "/activate",
			template: "<activate-Account-Component>Loading...</activate-Account-Component>"
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