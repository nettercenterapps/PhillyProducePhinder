package netter.uni.freshfoodfinder;

import com.example.freshfoodfinder.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

public class SearchRadiusDialogFragment extends DialogFragment {
	public static final int UserMap_ID = 1;
	private String activeFoodName;
	private int searchRadius;
	private Activity callingActivity;

	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        callingActivity = getActivity();
		// Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.searchRadiusQuestion);
        builder.setItems(R.array.searchRadiusOptions, new DialogInterface.OnClickListener() {
        	public void onClick(DialogInterface dialog, int which) {
        		Bundle bundle = getArguments();
        		activeFoodName = bundle.getString("activeFoodName");
        		searchRadius = 0;
        		switch(which) {
        		case 0: //1 mile selected
        			searchRadius = 1609;
        			break;
        		case 1://2 mile selected
        			searchRadius = 3218;
        			break;
        		case 2://5 mile selected
        			searchRadius = 8045;
        			break;
        		case 3: //no limit selected
        			searchRadius = 0;
        			break;
        		default:
        			searchRadius = 0;
        			break;
        		}
        		Intent i = new Intent(callingActivity,UserMap.class);
        	    
        	    //Puts the name of the active food into the UserMap activity
        	    i.putExtra("activeFoodName", activeFoodName);
        	    i.putExtra("searchRadius", searchRadius);
        	    startActivityForResult(i,UserMap_ID);
        	}
        });
        return builder.create();
	}
}
