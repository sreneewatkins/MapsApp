
//added this method and deleted it from the index.html
var map;
var coords = {lat: 39.9612, lng: -82.9988};

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: coords,
        //center: {lat: 39.9612, lng: -82.9988},
        zoom: 10
        //TODO: uncomment below in a bit
        //scrollwheel: false
    });

    /*
    We've all used markers to pinpoint a location on Google Maps. Let's drop
    a marker on our map in the same spot as our center coordinates. Add a new
    marker instance to the initMap function.
    */
    var marker = new google.maps.Marker({
        position: coords,
        map: map
    });
}