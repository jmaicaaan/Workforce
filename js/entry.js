var angular = require("angular");
var angular_material = require("angular-material");
var angular_aria = require("angular-aria");
var angular_animate = require("angular-animate");
var ui_router = require("angular-ui-router");


var workforceApp = angular.module("workforceApp", [
		angular_aria,
		angular_animate,
		angular_material,
		ui_router
	]);

workforceApp.config(require("./config/workforceConfig"));
workforceApp.constant("serverConfig", require("./config/serverConfig"));
workforceApp.run(require("./config/runConfig"));

workforceApp.service("httpClientService", require("./services/httpClientService"));
workforceApp.service("dialogService", require("./services/dialogService"));
workforceApp.service("stateService", require("./services/stateService"));
workforceApp.service("mapService", require("./services/mapService"));
workforceApp.service("githubService", require("./services/githubService"));
workforceApp.service("loginService", require("./services/loginService"));
workforceApp.service("userService", require("./services/userService"));
workforceApp.service("participantService", require("./services/participantService"));



workforceApp.directive("mainComponent", require("./components/mainComponent"));
workforceApp.directive("navComponent", require("./components/navComponent"));
workforceApp.directive("activateAccountComponent", require("./components/activateAccountComponent"));

workforceApp.directive("loginComponent", require("./components/loginComponent"));
workforceApp.directive("registerComponent", require("./components/registerComponent"));
workforceApp.directive("dashboardComponent", require("./components/dashboardComponent"));

workforceApp.directive("settingsComponent", require("./components/settingsComponent"));
workforceApp.directive("profileComponent", require("./components/profileComponent"));
workforceApp.directive("accountComponent", require("./components/accountComponent"));

workforceApp.directive("exploreComponent", require("./components/exploreComponent"));
workforceApp.directive("mapComponent", require("./components/mapComponent"));
