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
workforceApp.directive("mainComponent", require("./components/mainComponent"));