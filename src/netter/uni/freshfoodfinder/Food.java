package netter.uni.freshfoodfinder;



import java.util.ArrayList;

import java.util.Calendar;

import android.os.Parcel;
import android.os.Parcelable;
public class Food implements Parcelable {
	private String name;
	private int foodType;
	private int seasonStart;
	private int seasonEnd;
	private String recipeSite;
	
	public static final int FOOD_FRUIT = 1;
	public static final int FOOD_VEG = 2;
	
	
	public Food(String foodName, int foodType, int seasonStart, int seasonEnd, String recipeURL) {
		recipeSite = recipeURL;
		name=foodName;
		this.foodType = foodType;
		this.seasonStart = seasonStart;
		this.seasonEnd = seasonEnd;
	}
	public String getName(){
		return name;
	}
	public int getSeasonStart() {
		return seasonStart;
	}
	public int getSeasonEnd() {
		return seasonEnd;
	}
	public int getFoodType() {
		return this.foodType;
	}
	public void setFoodType(int foodType) {
		this.foodType = foodType;
	}
	public String getRecipeSite() {
		return recipeSite;
	}
	@Override
	public int hashCode(){		
		return name.hashCode();
	}
	@Override
	public String toString() {	
		return name.toString();
	}
	@Override
	public boolean equals(Object o){
		if(o.hashCode()==hashCode()){
			return true;
		}
		return false;
	}
	
	//Code added by Andrew to just make one copy of all the foods
	//Included most up-to-date seasonality form Nick
	public static Food asparagus = new Food("Asparagus", Food.FOOD_VEG, Calendar.MAY, Calendar.JUNE,"http://www.yummly.com/recipes?q=asparagus");
	public static Food artichoke = new Food("Artichoke", Food.FOOD_VEG, Calendar.JANUARY, Calendar.DECEMBER, "http://www.yummly.com/recipes?q=artichoke");
	public static Food arugula = new Food("Arugula", Food.FOOD_VEG, Calendar.MAY, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=arugula");
	public static Food beets = new Food("Beets", Food.FOOD_VEG, Calendar.APRIL, Calendar.NOVEMBER,"http://www.yummly.com/recipes?q=beets");
	public static Food beetroot = new Food("Beetroot", Food.FOOD_VEG, Calendar.JANUARY, Calendar.DECEMBER, "http://www.yummly.com/recipes?q=beet+root");
	public static Food bellPepper = new Food("Bell pepper", Food.FOOD_VEG, Calendar.JUNE, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=bell+pepper");
	public static Food blackEyedPeas = new Food("Black-eyed peas", Food.FOOD_VEG, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=black+eyed+peas");
	public static Food broccoli = new Food("Broccoli", Food.FOOD_VEG, Calendar.JUNE, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=broccoli");
	public static Food brusselsSprouts = new Food("Brussels sprouts", Food.FOOD_VEG, Calendar.AUGUST, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=brussels+sprouts");
	public static Food cabbage = new Food("Cabbage", Food.FOOD_VEG, Calendar.SEPTEMBER, Calendar.MARCH,"http://www.yummly.com/recipes?q=cabbage");
	public static Food carrot = new Food("Carrot", Food.FOOD_VEG, Calendar.JULY, Calendar.APRIL,"http://www.yummly.com/recipes?q=carrot");
	public static Food cauliflower = new Food("Cauliflower", Food.FOOD_VEG, Calendar.AUGUST, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=cauliflower");
	public static Food celery = new Food("Celery", Food.FOOD_VEG, Calendar.SEPTEMBER, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=celery");
	public static Food collardGreens =new Food("Collard Greens", Food.FOOD_VEG, Calendar.SEPTEMBER, Calendar.MAY,"http://www.yummly.com/recipes?q=collard+greens");
	public static Food cucumber = new Food("Cucumber", Food.FOOD_VEG, Calendar.JUNE, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=cucumber");
	public static Food daikon = new Food("Daikon", Food.FOOD_VEG, Calendar.APRIL, Calendar.MAY,"http://www.yummly.com/recipes?q=daikon"); 
	public static Food daikonTwo = new Food("Daikon", Food.FOOD_VEG, Calendar.SEPTEMBER, Calendar.NOVEMBER,"http://www.yummly.com/recipes?q=daikon");
	public static Food eggplant = new Food("Eggplant", Food.FOOD_VEG, Calendar.JULY, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=eggplant");
	public static Food florenceFennel = new Food("Florence fennel", Food.FOOD_VEG, Calendar.APRIL, Calendar.MAY,"http://www.yummly.com/recipes?q=fennel");
	public static Food florenceFennelTwo = new Food("Florence fennel", Food.FOOD_VEG, Calendar.SEPTEMBER, Calendar.NOVEMBER,"http://www.yummly.com/recipes?q=florence+funnel");
	public static Food garlic = new Food("Garlic", Food.FOOD_VEG, Calendar.AUGUST, Calendar.FEBRUARY,"http://www.yummly.com/recipes?q=garlic");//STORED YEAR ROUND THOUGH
	public static Food garbanzo = new Food("Garbanzo", Food.FOOD_VEG, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=garbanzo");
	public static Food ginger = new Food("Ginger", Food.FOOD_VEG, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=ginger");
	public static Food greenBeans = new Food("Green Beans", Food.FOOD_VEG, Calendar.JUNE, Calendar.AUGUST,"http://www.yummly.com/recipes?q=green+beans");
	public static Food kale = new Food("Kale", Food.FOOD_VEG, Calendar.JUNE, Calendar.NOVEMBER,"http://www.yummly.com/recipes?q=kale");
	public static Food leek = new Food("Leek", Food.FOOD_VEG, Calendar.AUGUST, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=leek");
	public static Food lentil = new Food("Lentil", Food.FOOD_VEG, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=lentil");
	public static Food lettuce = new Food("Lettuce", Food.FOOD_VEG, Calendar.SEPTEMBER, Calendar.MAY,"http://www.yummly.com/recipes?q=lettuce");
	public static Food limaBean = new Food("Lima Bean", Food.FOOD_VEG, Calendar.JULY, Calendar.AUGUST,"http://www.yummly.com/recipes?q=lima+beans");
	public static Food mustard = new Food("Mustard", Food.FOOD_VEG, Calendar.APRIL, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=mustard");
	public static Food okra = new Food("Okra", Food.FOOD_VEG, Calendar.AUGUST, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=okra");
	public static Food onion = new Food("Onion", Food.FOOD_VEG, Calendar.MAY, Calendar.FEBRUARY,"http://www.yummly.com/recipes?q=onion");
	public static Food parsnip = new Food("Parsnip", Food.FOOD_VEG, Calendar.APRIL, Calendar.MAY,"http://www.yummly.com/recipes?q=parsnip"); //AND OCTOBER - DECEMBER
	public static Food peas = new Food("Peas", Food.FOOD_VEG, Calendar.MAY, Calendar.JUNE,"http://www.yummly.com/recipes?q=peas");
	public static Food pumpkin = new Food("Pumpkin", Food.FOOD_VEG, Calendar.AUGUST, Calendar.NOVEMBER,"http://www.yummly.com/recipes?q=pumpkin");
	public static Food potato = new Food("Potato", Food.FOOD_VEG, Calendar.SEPTEMBER, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=potato");
	public static Food scallion = new Food("Scallion", Food.FOOD_VEG, Calendar.MAY, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=scallion");
	public static Food shallot = new Food("Shallot", Food.FOOD_VEG, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=shallot");
	public static Food snapPea = new Food("Snap pea", Food.FOOD_VEG, Calendar.JUNE, Calendar.JUNE,"http://www.yummly.com/recipes?q=snap+peas");
	public static Food snowPea = new Food("Snow pea", Food.FOOD_VEG, Calendar.JUNE, Calendar.JUNE,"http://www.yummly.com/recipes?q=snow+peas");
	public static Food soybean = new Food("Soybean", Food.FOOD_VEG, Calendar.JULY, Calendar.AUGUST,"http://www.yummly.com/recipes?q=soy+beans");
	public static Food spinach = new Food("Spinach", Food.FOOD_VEG, Calendar.MAY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=spinach");
	public static Food squash = new Food("Squash", Food.FOOD_VEG, Calendar.JUNE, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=squash");//AND AGUST-DECEMBER
	public static Food sweetCorn = new Food("Sweet corn", Food.FOOD_VEG, Calendar.JUNE, Calendar.AUGUST,"http://www.yummly.com/recipes?q=sweet+corn");
	public static Food sweetPepper = new Food("Sweet pepper", Food.FOOD_VEG, Calendar.JULY, Calendar.AUGUST,"http://www.yummly.com/recipes?q=sweet+peppers");
	public static Food sweetPotato = new Food("Sweet potato", Food.FOOD_VEG, Calendar.AUGUST, Calendar.FEBRUARY,"http://www.yummly.com/recipes?q=sweet+potato");
	public static Food swissChard = new Food("Swiss Chard", Food.FOOD_VEG, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=swiss+chard");
	public static Food radish = new Food("Radish", Food.FOOD_VEG, Calendar.MAY, Calendar.NOVEMBER,"http://www.yummly.com/recipes?q=radish");
	public static Food radishTwo = new Food("Radish", Food.FOOD_VEG, Calendar.SEPTEMBER, Calendar.NOVEMBER,"http://www.yummly.com/recipes?q=radish");
	public static Food tomato = new Food("Tomato", Food.FOOD_VEG, Calendar.MAY, Calendar.NOVEMBER,"http://www.yummly.com/recipes?q=tomato");
	public static Food turnip = new Food("Turnip", Food.FOOD_VEG, Calendar.AUGUST, Calendar.NOVEMBER,"http://www.yummly.com/recipes?q=turnip");
	public static Food turnipGreens = new Food("Turnip greens", Food.FOOD_VEG, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=turnip+greens");
	public static Food yam = new Food("Yam", Food.FOOD_VEG, Calendar.AUGUST, Calendar.FEBRUARY,"http://www.yummly.com/recipes?q=yams");
	public static Food zucchini = new Food("Zucchini", Food.FOOD_VEG, Calendar.JUNE, Calendar.AUGUST,"http://www.yummly.com/recipes?q=zucchini");
	
	//Fruits
	public static Food apple = new Food("Apple", Food.FOOD_FRUIT, Calendar.AUGUST, Calendar.APRIL,"http://www.yummly.com/recipes?q=apple");
	public static Food apricot = new Food("Apricot", Food.FOOD_FRUIT, Calendar.JULY, Calendar.AUGUST,"http://www.yummly.com/recipes?q=apricot");
	public static Food avocado = new Food("Avocado", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=avocado");
	public static Food banana = new Food("Banana", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=banana");
	public static Food blackberry = new Food("Blackberry", Food.FOOD_FRUIT, Calendar.JULY, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=blackberry");
	public static Food blueberry = new Food("Blueberry", Food.FOOD_FRUIT, Calendar.JUNE, Calendar.JUNE,"http://www.yummly.com/recipes?q=blueberry");
	public static Food cantaloupe = new Food("Cantaloupe", Food.FOOD_FRUIT, Calendar.JUNE, Calendar.JULY,"http://www.yummly.com/recipes?q=cantaloupe");
	public static Food cherry = new Food("Cherry", Food.FOOD_FRUIT, Calendar.JULY, Calendar.JULY,"http://www.yummly.com/recipes?q=cherry");
	public static Food clementine = new Food("Clementine", Food.FOOD_FRUIT, Calendar.JUNE, Calendar.JUNE,"http://www.yummly.com/recipes?q=clementine");
	public static Food coconut = new Food("Coconut", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=coconut");
	public static Food date = new Food("Date", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=date");
	public static Food fig = new Food("Fig", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=figs");
	public static Food grape = new Food("Grape", Food.FOOD_FRUIT, Calendar.AUGUST, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=grape");
	public static Food grapeFruit = new Food("Grapefruit", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=grapefruit");
	public static Food honeydew = new Food("Honeydew", Food.FOOD_FRUIT, Calendar.JUNE, Calendar.JULY,"http://www.yummly.com/recipes?q=honeydew");
	public static Food kiwi = new Food("Kiwi fruit", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=kiwi");
	public static Food lemon = new Food("Lemon", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=lemon");
	public static Food lime = new Food("Lime", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=lime");
	public static Food mango = new Food("Mango", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=mango");
	public static Food nectarine = new Food("Nectarine", Food.FOOD_FRUIT, Calendar.JULY, Calendar.AUGUST,"http://www.yummly.com/recipes?q=nectarine");
	public static Food orange = new Food("Orange", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=orange");
	public static Food peach = new Food("Peach", Food.FOOD_FRUIT, Calendar.JUNE, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=peach");
	public static Food pear = new Food("Pear", Food.FOOD_FRUIT, Calendar.AUGUST, Calendar.AUGUST,"http://www.yummly.com/recipes?q=pear");
	public static Food plum = new Food("Plum", Food.FOOD_FRUIT, Calendar.AUGUST, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=plum");	
	public static Food pineapple = new Food("Pineapple", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=pineapple");
	public static Food pomegranate = new Food("Pomegranate", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=pomegranate");
	public static Food raspberry = new Food("Raspberry", Food.FOOD_FRUIT, Calendar.JUNE, Calendar.JUNE,"http://www.yummly.com/recipes?q=raspberry");
	public static Food strawberry = new Food("Strawberry", Food.FOOD_FRUIT, Calendar.MAY, Calendar.JUNE,"http://www.yummly.com/recipes?q=strawberry");
	public static Food tangerine = new Food("Tangerine", Food.FOOD_FRUIT, Calendar.JANUARY, Calendar.DECEMBER,"http://www.yummly.com/recipes?q=tangerine");
	public static Food watermelon = new Food("Watermelon", Food.FOOD_FRUIT, Calendar.JULY, Calendar.SEPTEMBER,"http://www.yummly.com/recipes?q=watermelon");
	
			
	
	public static ArrayList<Food> getAllFoods() {
		ArrayList<Food> allFoods = new ArrayList<Food>();
		allFoods = new ArrayList<Food>(getAllFruits());
		allFoods.addAll(getAllVeggies());
		return allFoods;

	}
	
	public static ArrayList<Food> getAllFruits() {
		ArrayList<Food> allFoods = new ArrayList<Food>();
		//-----fruits
		allFoods.add(Food.apple);
		allFoods.add(Food.apricot);
		allFoods.add(Food.avocado);
		allFoods.add(Food.banana);
		allFoods.add(Food.blackberry);
		allFoods.add(Food.blueberry);
		allFoods.add(Food.cantaloupe);
		allFoods.add(Food.cherry );
		allFoods.add(Food.clementine);
		allFoods.add(Food.coconut );
		allFoods.add(Food.date );
		allFoods.add(Food.fig );
		allFoods.add(Food.grape);
		allFoods.add(Food.grapeFruit);
		allFoods.add(Food.honeydew);
		allFoods.add(Food.kiwi);
		allFoods.add(Food.lemon);
		allFoods.add(Food.lime);
		allFoods.add(Food.mango);
		allFoods.add(Food.nectarine);
		allFoods.add(Food.orange );
		allFoods.add(Food.peach);
		allFoods.add(Food.pear);
		allFoods.add(Food.plum );	
		allFoods.add(Food.pineapple );
		allFoods.add(Food.pomegranate);
		allFoods.add(Food.raspberry);
		allFoods.add(Food.strawberry);
		allFoods.add(Food.tangerine);
		allFoods.add(Food.watermelon);
		
		return allFoods;
		
	}
	
	public static ArrayList<Food> getAllVeggies() {
		//-----veggies
		ArrayList<Food> allFoods = new ArrayList<Food>();
		allFoods.add(Food.asparagus); 
		allFoods.add(Food.artichoke); 
		allFoods.add(Food.arugula ); 
		allFoods.add(Food.beets ); 
		allFoods.add(Food.beetroot ); 
		allFoods.add(Food.bellPepper);  
		allFoods.add(Food.blackEyedPeas ); 
		allFoods.add(Food.broccoli ); 
		allFoods.add(Food.brusselsSprouts); 
		allFoods.add(Food.cabbage ); 
		allFoods.add(Food.carrot); 
		allFoods.add(Food.cauliflower ); 
		allFoods.add(Food.celery);  
		allFoods.add(Food.collardGreens); 
		allFoods.add(Food.cucumber); 
		allFoods.add(Food.daikon); 
		allFoods.add(Food.eggplant); 
		allFoods.add(Food.florenceFennel); 
		allFoods.add(Food.garlic); 
		allFoods.add(Food.garbanzo); 
		allFoods.add(Food.ginger);
		allFoods.add(Food.greenBeans); 
		allFoods.add(Food.kale); 
		allFoods.add(Food.leek);
		allFoods.add(Food.lentil); 
		allFoods.add(Food.lettuce); 
		allFoods.add(Food.limaBean);
		allFoods.add(Food.mustard); 
		allFoods.add(Food.okra); 
		allFoods.add(Food.onion); 
		allFoods.add(Food.parsnip); 
		allFoods.add(Food.peas); 
		allFoods.add(Food.pumpkin);
		allFoods.add(Food.potato);
		allFoods.add(Food.scallion);
		allFoods.add(Food.shallot); 
		allFoods.add(Food.snapPea); 
		allFoods.add(Food.snowPea);
		allFoods.add(Food.soybean);
		allFoods.add(Food.spinach);
		allFoods.add(Food.squash); 
		allFoods.add(Food.sweetCorn); 
		allFoods.add(Food.sweetPepper);
		allFoods.add(Food.sweetPotato); 
		allFoods.add(Food.swissChard);
		allFoods.add(Food.radish); 
		allFoods.add(Food.tomato); 
		allFoods.add(Food.turnip); 
		allFoods.add(Food.turnipGreens); 
		allFoods.add(Food.yam); 
		allFoods.add(Food.zucchini);
		return allFoods;
	}
	
	public static ArrayList<Food> getSeasonalFoods() {
		//add "two" versions
		ArrayList<Food> foods = getAllFoods();
		foods.add(daikonTwo);
		foods.add(florenceFennelTwo);
		foods.add(radishTwo);
		
		Calendar current = Calendar.getInstance();
		int currentMonth = current.get(Calendar.MONTH);

		ArrayList<Food> seasonalFoods = new ArrayList<Food>();
		
		for (Food f : foods) {
			//We do not count foods that have seasons of "january" and "december"
			if (f.seasonStart == Calendar.JANUARY && 
					f.seasonEnd == Calendar.DECEMBER) {
				continue;
			}
			if (f.seasonStart >= f.seasonEnd) { //if we have Nov-Feb. or an overlapping duration
				if (!(currentMonth < f.seasonStart && currentMonth > f.seasonEnd)) {
					seasonalFoods.add(f);
				}
			} else if (currentMonth >= f.seasonStart && currentMonth <= f.seasonEnd) {
				seasonalFoods.add(f);
			}
		}
		return seasonalFoods;
	}
	
	//This method is put in for testing purposes
	public static ArrayList<Food> getSeasonalFoods(ArrayList<Food> foods,int month) {
		//add "two" versions
		
		Calendar current = Calendar.getInstance();
		int currentMonth = current.get(Calendar.MONTH);
		if (month != -1) {
			currentMonth = month;
		}

		ArrayList<Food> seasonalFoods = new ArrayList<Food>();
		
		for (Food f : foods) {
			//We do not count foods that have seasons of "january" and "december"
			if (f.seasonStart == Calendar.JANUARY && 
					f.seasonEnd == Calendar.DECEMBER) {
				continue;
			}
			if (f.seasonStart >= f.seasonEnd) { //if we have Nov-Feb. or an overlapping duration
				if (!(currentMonth < f.seasonStart && currentMonth > f.seasonEnd)) {
					seasonalFoods.add(f);
				}
			} else if (currentMonth >= f.seasonStart && currentMonth <= f.seasonEnd) {
				seasonalFoods.add(f);
			}
		}
		return seasonalFoods;
	}
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}
	
}
