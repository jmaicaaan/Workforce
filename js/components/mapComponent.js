module.exports = mapComponent;


function mapComponent($mdDialog, dialogService, $q, mapService, geocodingService, companyService){
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

		companyService.getCompanyParticipants().then(function(companyParticipants){
			
			// for(var i in companyParticipants){
			// 	var participantLocation = companyParticipants[i].location;
			// 	var prom = geocodingService.reverseGeocoding(participantLocation);
			// }
			$q.all(geocodingService.geocodeArrayOfAddress(companyParticipants))
				.then(function(response){
					console.log(response);
				});


			// for(var i = 0; i <= companyParticipants.length -1; i++){
				
			// 	console.log(companyParticipants);
			// 	var promise = geocodingService.reverseGeocoding(companyParticipants[i].location);
					
			// 	promise.then(function(response){
			// 		console.log(response);

			// 		var location = {
			// 			position: {lat: response[0].geometry.location.lat(), lng: response[0].geometry.location.lng()},
			// 			title: companyParticipants[i].firstname,
			// 			desc: "companyParticipants[i].lastname"
			// 		};

			// 		var marker = mapService.createMapMarker(googleMap, location);
			// 		bounds.extend(marker.position);
			// 	});
					

					// console.log(companyParticipants[i].firstname);
					// console.log(xxx);

					// var location = {
					// 	position: {lat: response[0].geometry.location.lat(), lng: response[0].geometry.location.lng()},
					// 	title: "companyParticipants[i].firstname",
					// 	desc: "companyParticipants[i].lastname"
					// };




					// console.log(response);
					// console.log(location);
					// var marker = mapService.createMapMarker(googleMap, location);
					// console.log(marker);
					// console.log(marker.position);
					// console.log(JSON.stringify(marker.position));
					// bounds.extend(marker.position);
			// }
			// googleMap.fitBounds(bounds);
		});

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