module.exports = geocodingService;

function geocodingService(httpClientService, $q){
	var self = this;
	self.geocoder;
	self.geocodeArrayOfAddress = geocodeArrayOfAddress;

	function geocodeAddress(address){
		var defer = $q.defer();
		geocoder = new google.maps.Geocoder();

		geocoder.geocode({"address": address}, function(result, status){
		
			defer.resolve(result);
		});

		return defer.promise;
	}

	function geocodeArrayOfAddress(arrayOfAddress){
		var defer = $q.defer();
		var promises = [];
		var chain = $q.when();
		for(var i = 0, j = arrayOfAddress.length; i <= j - 1; i++){
			geocodeAddress(arrayOfAddress[i].location).then(function(response){
				promises.push(response);
			});
		}
		defer.resolve(promises);
		return defer.promise;
	}
}