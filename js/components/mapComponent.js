module.exports = mapComponent;


function mapComponent($mdDialog, dialogService, $window, mapService){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/map.html",
		link: linker,
		controller: mapComponentController,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){
		var map = elem[0].querySelector("#map");
		var bounds = new google.maps.LatLngBounds();

		var googleMap = mapService.createMap(map);

		var pos = [
			{position: {lat: 14.5995, lng: 120.9842}, title: "Manila City", desc: "Manila City"},
			{position: {lat: 14.5176, lng: 121.0509}, title: "Baguio City", desc: "Baguio City"},
			{position: {lat: 14.5547, lng: 121.0244}, title: "Makati City", desc: "Makati City"},
			{position: {lat: 14.6760, lng: 121.0437}, title: "Quezon City", desc: "Quezon City"},
			{position: {lat: 14.4793, lng: 121.0198}, title: "Parañaque City", desc: "Parañaque City"},
			{position: {lat: 14.5794, lng: 121.0359}, title: "Mandaluyong City", desc: "Mandaluyong City"}
		];


		for(var i = 0; i <= pos.length - 1; i++){

			var marker = mapService.createMapMarker(googleMap, pos[i]);
			bounds.extend(marker.position);
		}

		googleMap.fitBounds(bounds);
	}

	function mapComponentController(){
		var self = this;			
		self.showSearchDialog = showSearchDialog;

		function showSearchDialog(event){

			var dialogConfig = {
				event: event,
				templateUrl: "../../views/searchDeveloperDialog.html",
				controller: control
			};

			function control(){
				var self = this;
				self.closeSearchDialog = closeSearchDialog;

				function closeSearchDialog(){
					dialogService.closeDialog();
				}
			}

			dialogService.showDialog(dialogConfig);
		}
	}
}