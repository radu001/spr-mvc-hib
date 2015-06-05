var newMarker = null;
var clickListener;
var map;
var newMarker = null;
var markers = [];
var markerRoute = null;

function handle(e){
    if(e.keyCode === 13){
    	location.href = ctx + "/search/" + document.getElementById('searchInput').value;
    }
}

function searchButton(){
    	location.href = ctx + "/search/" + document.getElementById('searchInput').value;
    	return false;
}

function changeMap() {


	var a = $.ajax({
		url : ctx + '/explore/listJson/-1',
		type : "POST",
		dataType : 'json',
		success : function(data) {
			console.log("sucessfull sending:")
			console.log(data);
			var json = data;

			putMarkers(data);
			
		},
		error : function() {
			console.log('failed');
		}
	});

}

function putMarkers(markersArray) {
	$
	.each(
			markersArray,
			function(i, marker) {
						var latlng = new google.maps.LatLng(marker.latitude,
								marker.longitude);
						var markerVar = new google.maps.Marker({
							position : latlng,
							title : marker.name,
							store_id : marker.idMarker,
							route : marker.route,
							map : map,
							icon : new google.maps.MarkerImage(
									ctx + "/" + marker.iconUrl, null, null,
									null, new google.maps.Size(36, 36)),
							draggable : false,
							animation : google.maps.Animation.DROP,
						});

						var infoboxContent = '<div class="infoW" style="height:300px;">'
								+ '<div class="propImg">' + '<img src="'
								+ ctx + marker.imageUrl
								+ '">'
								+ '<div class="propBg">'
								+ '<div class="propPrice"><a target="_blank" style="padding-left:5px;padding-right:5px; border-radius: 10px; border: 2px solid; border-color: black; color:black; background-color:#99FF66" href="http://www.'
								+ marker.site
								+ '">'
								+ marker.site
								+ '</a></div>'
								+

								'</div>'
								+ '</div>'
								+ '<div class="paWrapper">'
								+ '<div class="propTitle">'
								+ marker.name
								+ '</div>'
								+ '<div class="propAddress">' + marker.address + '</div>' +
								+ marker.description.substring(0, 80)
								+ '</div>'
								+

								'<div class="clearfix"></div>'
								+ '<div class="infoButtons">'
								+ '<a class="btn btn-sm btn-round btn-gray btn-o closeInfo">Close</a>'
								+ '<a href="' + ctx + '/single/' + marker.idMarker  + '" class="btn btn-sm btn-round btn-green viewInfo">View</a>'
								+ '</div>' + '</div>';

						google.maps.event.addListener(markerVar, 'dblclick',
								(function(marker, i) {
									return function() {
										
										infobox.setContent(infoboxContent);
										infobox.open(map, marker);
										
									}
								})(markerVar, i));

						$(document).on('click', '.closeInfo', function() {
							infobox.open(null, null);
						});

						
						markers.push(markerVar);
						console.log("marker put");
					});
}

// custom infowindow object
var infobox = new InfoBox({
	disableAutoPan : false,
	maxWidth : 202,
	pixelOffset : new google.maps.Size(-101, -285),
	zIndex : null,
	boxStyle : {
		background : "url('" + ctx + "/images/infobox-bg.png') no-repeat",
		opacity : 1,
		width : "202px",
		height : "245px"
	},
	closeBoxMargin : "28px 26px 0px 0px",
	closeBoxURL : "",
	infoBoxClearance : new google.maps.Size(1, 1),
	pane : "floatPane",
	enableEventPropagation : false
});


(function($) {
    "use strict";

    var options = {
            zoom : 14,
            mapTypeId : 'Styled',
            disableDefaultUI: true,
            mapTypeControlOptions : {
                mapTypeIds : [ 'Styled' ]
            },
            scrollwheel: false
        };
    var styles = [{
        stylers : [ {
            hue : "#cccccc"
        }, {
            saturation : -100
        }]
    }, {
        featureType : "road",
        elementType : "geometry",
        stylers : [ {
            lightness : 100
        }, {
            visibility : "simplified"
        }]
    }, {
        featureType : "road",
        elementType : "labels",
        stylers : [ {
            visibility : "on"
        }]
    }, {
        featureType: "poi",
        stylers: [ {
            visibility: "off"
        }]
    }];
    
    map = new google.maps.Map(document.getElementById('home-map'), options);
	var styledMapType = new google.maps.StyledMapType(styles, {
		name : 'Styled'
	});

	map.mapTypes.set('Styled', styledMapType);
	map.setCenter(new google.maps.LatLng(47.0263795, 28.840946));
	map.setZoom(14);

	changeMap();

   



    if(!(('ontouchstart' in window) || window.DocumentTouch && document instanceof DocumentTouch)) {
        $('body').addClass('no-touch');
    }

     $('.dropdown-select li a').click(function() {
        if (!($(this).parent().hasClass('disabled'))) {
            $(this).prev().prop("checked", true);
            $(this).parent().siblings().removeClass('active');
            $(this).parent().addClass('active');
            $(this).parent().parent().siblings('.dropdown-toggle').children('.dropdown-label').html($(this).text());
        }
    });

   

    $('#advanced').click(function() {
        $('.adv').toggleClass('hidden-xs');
    });

    $('.home-navHandler').click(function() {
        $('.home-nav').toggleClass('active');
        $(this).toggleClass('active');
    });

    //Enable swiping
    $(".carousel-inner").swipe( {
        swipeLeft:function(event, direction, distance, duration, fingerCount) {
            $(this).parent().carousel('next'); 
        },
        swipeRight: function() {
            $(this).parent().carousel('prev');
        }
    });

    $('.modal-su').click(function() {
        $('#signin').modal('hide');
        $('#signup').modal('show');
    });

    $('.modal-si').click(function() {
        $('#signup').modal('hide');
        $('#signin').modal('show');
    });

    $('input, textarea').placeholder();

})(jQuery);