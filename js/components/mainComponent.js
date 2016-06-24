module.exports = mainComponent;

function mainComponent(){

	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/main.html",
		link: linker
	};

	function linker(scope, elem, attrs){
		
	}
}