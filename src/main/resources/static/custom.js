
//added this method and deleted it from the index.html
let map;

function initMap() {
//    let coords = {lat: 32.3327, lng: -93.9478};

//    let coords = {
//        lat: parseFloat(`${location.lat}`) || 32.3327,
//        lng: parseFloat(`${location.lng}`) || -93.9478
//    };
//    let city = `${location.city}`;
//    let state = `${location.state}`;
//    let city = 'Dallas';
//    let state = 'TX';

    let mapOptions = {
//        center: {lat: 39.9833, lng: -82.9833},
        center: coords,
        zoom: 10,
        scrollwheel: false
    };

    map = new google.maps.Map(document.getElementById('map'), mapOptions);

    let image = {
        url: '/me.png',
        scaledSize: new google.maps.Size(50, 50)
    };

    /*
    We've all used markers to pinpoint a location on Google Maps. Let's drop
    a marker on our map in the same spot as our center coordinates. Add a new
    marker instance to the initMap function.
    */
    let marker = new google.maps.Marker({
        position: coords,
        map: map,
        icon: image,
        animation: google.maps.Animation.BOUNCE
    });

//    let contentString = '<h2>' + `${city}` + ', ' + `${state}` + '</h2>  <p>Where your dreams come true!</p>';
    let contentString = '<h2>' + city + ', ' + state + '</h2>  <p>Where your dreams come true!</p>';

    let infoWindow = new google.maps.InfoWindow({
        content: contentString
    });

//    google.maps.event.addListener(marker, 'click', () => infoWindow.open(map,marker));
    google.maps.event.addListener(marker, 'click', function() {
        infoWindow.open(map, marker);
    });

}