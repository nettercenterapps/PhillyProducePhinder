package netter.uni.freshfoodfinder;

import java.util.ArrayList;

import com.example.freshfoodfinder.R;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;


public class MainActivity extends ListActivity {
	public Food activeFood;
	public final int UserMap_ID = 1;
	public ArrayList<Food> allFoods;
	public ArrayList<Food> seasonalFoods;
	public boolean togglerIsMap = true;
	public boolean isSeasonal = false;
	public final int Recipe_ID = 1;
	
	//This class will manage the code for the screen involving the search bar and buttons for food
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		allFoods = Food.getAllFoods();
		seasonalFoods = Food.getSeasonalFoods();
		
		ColoredArrayAdapter<Food> adapter = new ColoredArrayAdapter<Food>(this,
		        android.R.layout.simple_list_item_1, allFoods);
		setListAdapter(adapter);
		
		RadioButton mapButton = (RadioButton) this.findViewById(R.id.radioButtonMap);
		mapButton.setChecked(true);
		togglerIsMap = true;
	}
	  @Override
	  protected void onListItemClick(ListView l, View v, int position, long id) {
	    super.onListItemClick(l, v, position, id);
	    // Get the item that was clicked
	    Food foodClickedByUser = (Food) this.getListAdapter().getItem(position);
	    activeFood = foodClickedByUser;
	    
	    if (togglerIsMap) {
		    Bundle bundle = new Bundle();
		    bundle.putString("activeFoodName",activeFood.getName());
		    SearchRadiusDialogFragment searchRadiusQuery = new SearchRadiusDialogFragment();
		    searchRadiusQuery.setArguments(bundle);
		    searchRadiusQuery.show(getFragmentManager(), "search radius");
		    /*Intent i = new Intent(this, SearchRadiusDialogFragment.class);
		    
		    //Puts the name of the active food into the UserMap activity
		    i.putExtra("activeFoodName", activeFood.getName());
		    
		    startActivityForResult(i,UserMap_ID);*/
	    }
	    //This code is executed when "Recipe" is toggled
	    else {
	    	Intent viewIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(activeFood.getRecipeSite()));  
	    	startActivityForResult(viewIntent,Recipe_ID);
	    }
	    
	  }
	  
	  public void goSeasonal(View view) {
		  Button button = (Button)view;
		  if (isSeasonal) {
			  isSeasonal = false;
			  button.setText(R.string.Seasonal);
			  ArrayAdapter<Food> adapter = new ColoredArrayAdapter<Food>(this,
					  android.R.layout.simple_list_item_1, allFoods);
			  setListAdapter(adapter);
			  
		  }
		  else {
			  isSeasonal = true;
			  button.setText(R.string.UnSeasonal);
			  ArrayAdapter<Food> adapter = new ColoredArrayAdapter<Food>(this,
					  android.R.layout.simple_list_item_1, seasonalFoods);
			  setListAdapter(adapter);
		  }
	  }
	  
	  public void toggleMap(View view) {
		  togglerIsMap = true;
	  }
	  
	  public void toggleRecipe(View view) {
		  togglerIsMap = false;
	  }
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.activity_main, menu);
//		return true;
//	}

}
