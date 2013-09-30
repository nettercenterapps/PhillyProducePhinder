package netter.uni.freshfoodfinder;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import com.example.freshfoodfinder.R;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

public class DirectionsDialogFragment extends DialogFragment {
	
	private Location userLocation;
	private LatLng markerLatLng;
	
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Which type of directions would you like?");
        builder.setItems(R.array.directionOptions, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            	Bundle bundle = getArguments();
        		userLocation = (Location)bundle.getParcelable("userLocation");
        		markerLatLng = (LatLng)bundle.getParcelable("markerLatLng");
            	String directionFlag = "";
            	switch(which) {
            	case 0:
            		//Walking
            		directionFlag = "w";
            		break;
            	case 1:
            		//Biking
            		directionFlag = "b";
            		break;
            	case 2: 
            		//Public transit
            		directionFlag = "r";
            		break;
            	case 3:
            		//Driving
            		directionFlag = "d";
            		break;
            	default:
            		break;
            	}
            	
            	final Intent intent = new Intent(Intent.ACTION_VIEW,
			       //** Using the web based turn by turn directions url. 
			       Uri.parse(
			                "http://maps.google.com/maps?" +
			                "saddr="+ userLocation.getLatitude()+","+userLocation.getLongitude()+
			                "&daddr="+markerLatLng.latitude+","+markerLatLng.longitude+"&dirflg="+directionFlag));
				intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
			    startActivity(intent);
            }
        });
        return builder.create();
    }
}
			 

