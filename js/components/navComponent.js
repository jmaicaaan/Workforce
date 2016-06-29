module.exports = navComponent;

function navComponent($mdSidenav){
	return {
		scope: {},
		restrict: "A",
		link: linker
	};

	function linker(scope, elem, attrs){
		var md_list_item = elem.find("md-list-item");

		for(var i = 0; i <= md_list_item.length -1; i++){
			angular.element(md_list_item[i]).on("click", function(){
				$mdSidenav("nav").close();
			});
		}
	}
}