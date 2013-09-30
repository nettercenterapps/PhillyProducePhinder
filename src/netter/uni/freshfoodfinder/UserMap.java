	package netter.uni.freshfoodfinder;
	
	import java.util.Calendar;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;

import com.example.freshfoodfinder.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
	
	public class UserMap extends Activity{
	
	private GoogleMap map;
	private MapFragment mapFragment;

	private LocationManager locationManager;
	private String provider;

	private Food activeFood;
	private Location userLocation;

	
	private MarketManager marketManager;
	



	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.usermap);
	mapFragment = ((MapFragment) getFragmentManager().findFragmentById(R.id.map));
	
	//Map setup
	map = mapFragment.getMap();
	setUpMapIfNeeded();
	GoogleMapOptions options = new GoogleMapOptions();
	options.mapType(GoogleMap.MAP_TYPE_TERRAIN)
	.compassEnabled(true)
	.rotateGesturesEnabled(true)
	.tiltGesturesEnabled(true);
	

	map.setMyLocationEnabled(true);
	

	
	//Get user location set
	locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	// Define the criteria how to select the locatioin provider -> use
	// default
	Criteria criteria = new Criteria();
	provider = locationManager.getBestProvider(criteria, false);
	userLocation = locationManager.getLastKnownLocation(provider);
	
	LatLng userLatLng = new LatLng(userLocation.getLatitude(),userLocation.getLongitude());
	
	Intent intentThatIniiatedUserMap = getIntent();
	String activeFoodName = intentThatIniiatedUserMap.getStringExtra("activeFoodName");
	
	/*Foods are compared based on their names only, so therefore giving dummy fields for 
	 * the activeFood here does not matter
	 */
	activeFood = new Food(activeFoodName, 1, Calendar.JANUARY, Calendar.DECEMBER,"");

	int searchRadius = intentThatIniiatedUserMap.getIntExtra("searchRadius",0);

	marketManager = new MarketManager(activeFood,userLocation,searchRadius);
	
	//Filtering by distance and markets that contain food are now carried out in MarketManager
	//Make markers on map for the appropriate markets
	markMarkets(marketManager.getWawas(),"Wawa Logo-resized.bmp");
	markMarkets(marketManager.getCornerStores(),"Corner_Store-icon-resized.bmp");
	markMarkets(marketManager.getSuperMarkets(),"super market icon-resized.bmp");
	markMarkets(marketManager.getAldis(),"aldi_logo-resized.bmp");
	markMarkets(marketManager.getFarmerMarkets(),"farmers market icon-resized.bmp");

	
	// Move the camera instantly to user's location with a zoom of 15.
	map.moveCamera(CameraUpdateFactory.newLatLngZoom(userLatLng, 15));
	
	// Zoom in, animating the camera.
	map.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);
	

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.mapactivity, menu);
	return true;
	}
	
	
	//This method provided by the Google Documentation
	//* https://developers.google.com/maps/documentation/android/map
	
	private void setUpMapIfNeeded() {
	// Do a null check to confirm that we have not already instantiated the map.
		if (map == null) {
			map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
					.getMap();
	// Check if we were successful in obtaining the map.
			if (map != null) {
	// The Map is verified. It is now safe to manipulate the map.
	
			}
		}
	}
	
	private String findAppropriateHours(Market market) {
		Map<String,String> weekHours = market.getHours();
		String hoursToday = "";
		if (weekHours.isEmpty()) {
			return "";
		}
		else  {
			Calendar current = Calendar.getInstance();
			int dayOfWeek = current.DAY_OF_WEEK;
			switch(dayOfWeek) {
			case Calendar.SUNDAY:
				hoursToday = weekHours.get("Sunday");
				break;
			case Calendar.MONDAY:
				hoursToday = weekHours.get("Monday");
				break;
			case Calendar.TUESDAY:
				hoursToday = weekHours.get("Tuesday");
				break;
			case Calendar.WEDNESDAY:
				hoursToday = weekHours.get("Wednesday");
				break;
			case Calendar.THURSDAY:
				hoursToday = weekHours.get("Thursday");
				break;
			case Calendar.FRIDAY:
				hoursToday = weekHours.get("Friday");
				break;
			case Calendar.SATURDAY:
				hoursToday = weekHours.get("Saturday");
				break;
			default:
				break;
			}
		}
		return "Hours today: " + hoursToday;
	}
	
	private void markMarkets(List<Market> marketsWithActiveFood, String bitmapImage) {
		if (marketsWithActiveFood == null) return;
		for (Market m : marketsWithActiveFood) {
			LatLng location = new LatLng(m.getLatLng().latitude,m.getLatLng().longitude);
			String hoursToday = findAppropriateHours(m);
			String phoneNumber = m.getPhoneNumber();
			String snippet = "";
			if (!hoursToday.equals("") && !phoneNumber.equals("")) {
				snippet = phoneNumber + " , " + hoursToday;
			}
			else if (hoursToday.equals("")) {
				snippet = phoneNumber;
			}
			else {
				snippet = hoursToday;
			}
			map.addMarker(new MarkerOptions()
			.position(location)
			.title(m.getName())
			.icon(BitmapDescriptorFactory.fromAsset(bitmapImage))
			.snippet(snippet));
			
			OnInfoWindowClickListener mcl = new OnInfoWindowClickListener() {
				
				@Override
				public void onInfoWindowClick(Marker marker) {
					Bundle bundle = new Bundle();
					bundle.putParcelable("userLocation", userLocation);
					bundle.putParcelable("markerLatLng", marker.getPosition());
					DialogFragment newFragment = new DirectionsDialogFragment();
					newFragment.setArguments(bundle);
				    newFragment.show(getFragmentManager(), "directions type");

					/*final Intent intent = new Intent(Intent.ACTION_VIEW,
						       //** Using the web based turn by turn directions url. *//*
						       Uri.parse(
						                "http://maps.google.com/maps?" +
						                "saddr="+ userLocation.getLatitude()+","+userLocation.getLongitude()+
						                "&daddr="+marker.getPosition().latitude+","+marker.getPosition().longitude+"&dirflg=w"));
								intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
						       startActivity(intent);*/
						 
				}
			};
			map.setOnInfoWindowClickListener(mcl);
			

		}
	}
	
	}