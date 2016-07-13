module.exports = profileComponent;

function profileComponent(){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/settings/profile.html",
		link: linker,
		controller: profileComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){
		console.log(scope);
	}

	function profileComponentController(userService){
		var self = this;
		self.userService = userService; //To use in the view...

		userService.getUserAccountType()
			.then(function(response){
			
				console.log(response.statusText);
				
			});
	}
}