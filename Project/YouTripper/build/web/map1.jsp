<html>
    <head>
        <title>Place Autocomplete</title>
        <meta name="viewport" content="width=1366">
<!--        <meta name="viewport" content="initial-scale=1.0, user-scalable=no">-->
        <meta charset="utf-8">
        <style>
            html, body {
                height: 100%;
                margin: 0;
                padding: 0;
            }
            #map {
                height: 500px;
                width: 80%;
                margin: 0 auto;
            }
            .controls {
                margin-top: 10px;
                border: 1px solid transparent;
                border-radius: 2px 0 0 2px;
                box-sizing: border-box;
                -moz-box-sizing: border-box;
                height: 32px;
                outline: none;
                box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
            }

            #pac-input {
                background-color: #fff;
                font-family: Roboto;
                font-size: 15px;
                font-weight: 300;
                margin-left: 12px;
                padding: 0 11px 0 13px;
                text-overflow: ellipsis;
                width: 300px;
            }

            #pac-input:focus {
                border-color: #4d90fe;
            }

            .pac-container {
                font-family: Roboto;
            }

            #type-selector {
                color: #fff;
                background-color: #4d90fe;
                padding: 5px 11px 0px 11px;
            }

            #type-selector label {
                font-family: Roboto;
                font-size: 13px;
                font-weight: 300;
            }

        </style>
    </head>
    <body>
        <input id="pac-input" class="controls" type="text"
               placeholder="Enter a location">
        <table id="address">
            <tr>
                <td class="label">Street address</td>
                <td class="slimField"><input class="field" id="street_number"
                                             disabled="true"></input></td>
                <td class="wideField" colspan="2"><input class="field" id="route"
                                                         disabled="true"></input></td>
            </tr>
            <tr>
                <td class="label">City</td>
                <td class="wideField" colspan="3"><input class="field" id="locality"
                                                         disabled="true"></input></td>
            </tr>
            <tr>
                <td class="label">State</td>
                <td class="slimField"><input class="field"
                                             id="administrative_area_level_1" disabled="true"></input></td>
                <td class="label">Zip code</td>
                <td class="wideField"><input class="field" id="postal_code"
                                             disabled="true"></input></td>
            </tr>
            <tr>
                <td class="label">Country</td>
                <td class="wideField" colspan="3"><input class="field"
                                                         id="country" disabled="true"></input></td>
                <td class="label">Coordinate</td>
                <td class="wideField"><input class="field" id="coordinate"></input></td>
            </tr>
        </table>
        <div id="map"></div>

        <script>
            var componentForm = {
                street_number: 'short_name',
                route: 'long_name',
                locality: 'long_name',
                administrative_area_level_1: 'short_name',
                country: 'long_name',
                postal_code: 'short_name'
            };
            function initMap() {
                var map = new google.maps.Map(document.getElementById('map'), {
                    center: {lat: -33.8688, lng: 151.2195},
                    zoom: 13,
                    draggable: false
                });
                var input = /** @type {!HTMLInputElement} */(
                        document.getElementById('pac-input'));

                map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

                var autocomplete = new google.maps.places.Autocomplete(input, {types: ['address']});
                autocomplete.bindTo('bounds', map);

                var infowindow = new google.maps.InfoWindow();
                var marker = new google.maps.Marker({
                    map: map,
                    anchorPoint: new google.maps.Point(0, -29)
                });

                marker.setIcon(/** @type {google.maps.Icon} */({
                    size: new google.maps.Size(71, 71),
                    origin: new google.maps.Point(0, 0),
                    anchor: new google.maps.Point(17, 34),
                    scaledSize: new google.maps.Size(35, 35)
                }));

                autocomplete.addListener('place_changed', function () {
                    infowindow.close();
                    var place = autocomplete.getPlace();
                    if (!place.geometry) {
                        window.alert("Autocomplete's returned place contains no geometry");
                        return;
                    }

                    // If the place has a geometry, then present it on a map.
                    if (place.geometry.viewport) {
                        map.fitBounds(place.geometry.viewport);
                    } else {
                        map.setCenter(place.geometry.location);
                        map.setZoom(17);  // Why 17? Because it looks good.
                    }
                    fillInforWindow(place, infowindow, map, marker);
                    marker.setPosition(place.geometry.location);
                    fillToForm(place, marker);
                    

                    
                });

                google.maps.event.addListener(map, 'click', function (event) {
                    var location = event.latLng;
                    marker.setPosition(location);
                    document.getElementById("coordinate").value = location.lat() + "," + location.lng();
                });
            }

            function fillToForm(place, marker) {
                for (var component in componentForm) {
                    document.getElementById(component).value = '';
                    document.getElementById(component).disabled = false;
                }
                // Get each component of the address from the place details
                // and fill the corresponding field on the form.
                for (var i = 0; i < place.address_components.length; i++) {
                    var addressType = place.address_components[i].types[0];
                    if (componentForm[addressType]) {
                        var val = place.address_components[i][componentForm[addressType]];
                        document.getElementById(addressType).value = val;
                    }
                }

                document.getElementById("coordinate").value = marker.getPosition().lat() + "," + marker.getPosition().lng();
            }

            function fillInforWindow(place, infowindow, map, marker) {
                var address = '';
                if (place.address_components) {
                    address = [
                        (place.address_components[0] && place.address_components[0].short_name || ''),
                        (place.address_components[1] && place.address_components[1].short_name || ''),
                        (place.address_components[2] && place.address_components[2].short_name || '')
                    ].join(' ');
                }

                infowindow.setContent('<div><strong>' + place.name + '</strong><br>' + address);
                infowindow.open(map, marker);
            }

        </script>
        <script src="https://maps.googleapis.com/maps/api/js?signed_in=true&libraries=places&callback=initMap"
        async defer></script>
    </body>
</html>