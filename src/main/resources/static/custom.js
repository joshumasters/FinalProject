let map, infoWindow;

console.log(parseFloat(places[2].geometry.location.lat));

function initMap() {
  // map = new google.maps.Map(document.getElementById('map'), {
  //   center: {lat: -34.397, lng: 150.644},
  //   zoom: 8
  // });
//   $(window).on('load', function () {
//     //my logic here

//  });
  map = new google.maps.Map(document.getElementById('map'), {
    center: { lat: parseFloat(userLocation.lat), lng: parseFloat(userLocation.lng) },
    
    zoom: 12,
    scrollwheel: false
});

var userMarker = new google.maps.Marker({
    position: { lat: parseFloat(userLocation.lat), lng: parseFloat(userLocation.lng) },
    map: map,
});

for (i=0; i<places.length; i++){
    let marker = new google.maps.Marker({
        position: { lat: parseFloat(places[i].geometry.location.lat), 
                    lng: parseFloat(places[i].geometry.location.lng) },
        map: map,
        
        
    });
    
    console.log("Map: " + map)  


    }
 
  }
    
    


