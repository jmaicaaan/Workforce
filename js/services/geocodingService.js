module.exports = geocodingService;

function geocodingService(httpClientService){
	var self = this;
	self.geocoder;
	self.reverseGeocoding = reverseGeocoding;

	function reverseGeocoding(address){
		geocoder = new google.maps.Geocoder();
		geocoder.geocode({"address": address}, function(results, status){
			console.log(results);
		});
	}
}