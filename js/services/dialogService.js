module.exports = dialogService;

function dialogService($mdDialog){
	var self = this;
	self.showDialog = showDialog;
	self.closeDialog = closeDialog;

	function showDialog(dialogConfig){
		$mdDialog.show({
			parent: angular.element(document.body),
			templateUrl: dialogConfig.templateUrl,
			controller: dialogConfig.controller,
			clickOutsideToClose: true,
			controllerAs: "vm",
			locals: dialogConfig.locals
		});
	}

	function closeDialog(){
		$mdDialog.hide();
	}
}