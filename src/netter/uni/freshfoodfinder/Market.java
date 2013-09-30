package netter.uni.freshfoodfinder;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

import android.location.Location;

import com.google.android.gms.maps.model.LatLng;
public class Market {
	private String name;
	private String phoneNumber;
	
	//Maps days to hours
	private Map<String,String> hours;
	
	private ArrayList<Food> foodSoldHere;
	private LatLng location;
	public Market(String marketName, ArrayList<Food> foods, LatLng whereIsThisMarket) throws IllegalArgumentException {
		if (marketName == null || foods == null || foods.contains(null) || whereIsThisMarket == null) {
			throw new IllegalArgumentException("Provided bad input to Market Constructor");
		}
		name=marketName;
		location=whereIsThisMarket;
		foodSoldHere = new ArrayList<Food>();
		foodSoldHere.addAll(foods);
		phoneNumber = "";
		hours = new HashMap<String,String>();
	}
	
	public void setPhoneNumber(String phone) {
		phoneNumber = phone;
	}
	
	public void setHours(Map<String,String> map) {
		hours = map;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public Map<String,String> getHours() {
		return hours;
	}
	public String getName(){
		return name;
	}
	public ArrayList<Food> getFoods(){
		return foodSoldHere;
	}
	public Boolean hasFood(Food aFood){
		if(foodSoldHere.contains(aFood)){
			return true;
		}
		return false;
	}
	public LatLng getLatLng(){
		return location;
	}
	public Location getLocation(){
		Location userLoc = new Location("uloc");
		userLoc.setLatitude(location.latitude);
		userLoc.setLongitude(location.longitude);

		return userLoc;
	}
	public void addFood(Food FoodIn){
		if (FoodIn == null) {
			return;
		}
		 foodSoldHere.add(FoodIn);
	}
	public void removeFood(Food FoodIn){
		if (FoodIn == null) {
			return;
		}
		 foodSoldHere.remove(FoodIn);
	}
	@Override
	public int hashCode(){		
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object o){
		if(o.hashCode()==hashCode()){
			return true;
		}
		return false;
	}
	
}
