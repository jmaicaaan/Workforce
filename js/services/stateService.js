module.exports = stateService;

function stateService($state){
	var self = this;
	self.stateName = {};
	self.updateCurrentState = updateCurrentState;

	function updateCurrentState(){
		self.stateName.title = $state.current.title;	
	}

}