module.exports = mapComponent;


function mapComponent($mdDialog, dialogService){
	return {
		scope: {},
		restrict: "E",
		templateUrl: "../../views/map.html",
		link: linker,
		controller: control,
		controllerAs: "vm"
	};

	function linker(scope, elem, attrs){
		var map = elem[0].querySelector("#map");
		var bounds = new google.maps.LatLngBounds();
		var position = {lat: 14.5995, lng: 120.9842, desc: "Manila"}
		var mapOptions = {
				center: position,
				zoom: 10,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			};
	
		var gMap = new google.maps.Map(map, mapOptions);

		createMarker(position);

		for(var i = 0; i <= 4; i++){
			var pos = [
				{lat: 14.5176, lng: 121.0509, title: "Baguio City", desc: "Baguio City"},
				{lat: 14.5547, lng: 121.0244, title: "Makati City", desc: "Makati City"},
				{lat: 14.6760, lng: 121.0437, title: "Quezon City", desc: "Quezon City"},
				{lat: 14.4793, lng: 121.0198, title: "Parañaque City", desc: "Parañaque City"},
				{lat: 14.5794, lng: 121.0359, title: "Mandaluyong City", desc: "Mandaluyong City"}
			];
			createMarker(pos[i]);
		}

		gMap.fitBounds(bounds);

		function createMarker(location){
			var marker = new google.maps.Marker({
				position: location,
				map: gMap,
				title: location.title,
				desc: location.desc
			});

			bounds.extend(marker.position);

			marker.addListener("click", function(event){

				var selectedDeveloper = this;
				var dialogConfig = {
					event: event,
					templateUrl: "../../views/contactDeveloperDialog.html",
					controller: control,
					locals: {
						developer: selectedDeveloper
					}
				};

				function control(developer){
					var self = this;
					self.developer = developer;
					self.closeSearchDialog = closeSearchDialog;

					function closeSearchDialog(){
						dialogService.closeDialog();	
					}
				}

				dialogService.showDialog(dialogConfig);
			});
		}
	}

	function control(){
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