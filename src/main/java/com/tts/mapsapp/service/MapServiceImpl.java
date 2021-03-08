package com.tts.mapsapp.service;

import com.tts.mapsapp.model.GeocodingResponse;
import com.tts.mapsapp.model.Location;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
To make this app useful, we want to enable the user to type in a City/State
and view the map at that location.
Since the Maps JavaScript API requires coordinates, we are going to use the
Geocoding API to get the coordinates for a particular City/State.
 */
@Service
public class MapServiceImpl implements MapService {

    @Value("$api_key")
    private String apiKey;

    @Override
    public void addCoordinates(Location location) {
        /*
        In the method, we'll build the URL from the root geocoding endpoint and
        include the city, state and API key.
         */
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=" +
                location.getCity() + "," + location.getState() + "&key=" + apiKey;
        /*
        Then we'll used the RestTemplate class to make the API call and
        deserialize it into an object of type GeocodingReponse.
         */
        RestTemplate restTemplate = new RestTemplate();
        GeocodingResponse response = restTemplate.getForObject(url, GeocodingResponse.class);
        Location coordinates = response.getResults().get(0).getGeometry().getLocation();
        /*
        We set the coordinates for our passed in location object. We are
        updating the object in place, so we end up with a location object that
        contains a city, state, latitude, and longitude.
        */
        location.setLat(coordinates.getLat());
        location.setLng(coordinates.getLng());
    }

}//end MapServiceImpl class
