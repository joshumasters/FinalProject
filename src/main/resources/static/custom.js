let map, infoWindow;
console.log(parseFloat(places[2].geometry.location.lat));

function initMap() {

  map = new google.maps.Map(document.getElementById('map'), {
    center: { lat: parseFloat(userLocation.lat), lng: parseFloat(userLocation.lng) },
    
    zoom: 12,
    scrollwheel: false
    
});


  for (i=0; i<places.length; i++){
    let distance = places[i].distance;
    distance = distance.toFixed(2);
    let address = places[i].vicinity;
    let open = places[i].opening_hours.open_now;
    let name = places[i].name;
    console.log(name);
    let contentString = "<h2>" + name + "</h2><h2> Distance: " + distance + "mi</h2><h2> Address: " + address + "</h2><h2>Open: " + open + "</h2>"
    let infowindow = new google.maps.InfoWindow({
            content: contentString,
          });
  let marker = new google.maps.Marker({
      
        position: new google.maps.LatLng(parseFloat(places[i].geometry.location.lat), parseFloat(places[i].geometry.location.lng)),
        map: map,
        
    }); 

  let userCoords = userLocation.lat + "," + userLocation.lng;

    google.maps.event.addListener(marker, "click", function () {
      infowindow.open(map, marker);
      let latlng = marker.position.toString();
      console.log(latlng);
      latlng = latlng.replace("(", "");
      latlng = latlng.replace(")", "");
      console.log(latlng);
      calculateAndDisplayRoute(directionsService, directionsDisplay, userCoords, latlng);
    }); 
    }
    
    directionsService = new google.maps.DirectionsService;
    directionsDisplay = new google.maps.DirectionsRenderer({
      map: map
    });

    console.log(places[2].geometry.location.lat + "," + places[2].geometry.location.lng);
    console.log(places[1].geometry.location.lat + "," + places[1].geometry.location.lng);
    
}

  function calculateAndDisplayRoute(directionsService, directionsDisplay, pointA, pointB) {
    directionsService.route({
      origin: pointA,
      destination: pointB,
      travelMode: google.maps.TravelMode.DRIVING
    }, function(response, status) {
      if (status == google.maps.DirectionsStatus.OK) {
        directionsDisplay.setDirections(response);
      } else {
        window.alert('Directions request failed due to ' + status);
      }
    });
  }
  


