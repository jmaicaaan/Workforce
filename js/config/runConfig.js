module.exports = runConfig;

function runConfig($rootScope, stateService){
	
	$rootScope.$on("$stateChangeSuccess", function(event, toState, toParams, fromState, fromParams, error){
		stateService.updateCurrentState();
	});
}