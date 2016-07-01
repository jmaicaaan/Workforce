module.exports = mapService;

function mapService(dialogService){
	var self = this;
	self.createMap = createMap;
	self.createMapMarker = createMapMarker;

	function createMap(mapElement){
		var mapOptions = {
			zoom: 10,
			mapTypeId: google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(mapElement, mapOptions);
		return map;
	}

	function createMapMarker(map, location){
		var marker = new google.maps.Marker({
			map: map,
			position: location.position,
			title: location.title,
			desc: location.desc
		});

		marker.addListener("click", markerClickListener);

		function markerClickListener(event){
			
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
		}

		return marker;
	}
}