package problem1;

import java.util.ArrayList;
import java.util.HashMap;

public class Mobile {
	HashMap<String,ArrayList<String>> mobiles = new HashMap<>();
	
	public String addMobile(String company, String model) {
	
		//First I will check if the company already exists
		if(mobiles.get(company) == null) {
			ArrayList<String> models = new ArrayList<>();
			models.add(model);
			mobiles.put(company, models);
		} else {
			//If the company exists then I'll fetch and update the value
			mobiles.get(company).add(model);
		}
		
		return "Mobile added successfully";
	}
	
	public ArrayList<String> getModels(String company){
		if(mobiles.get(company) == null) {
			return null;
		} else {
			return mobiles.get(company);
		}
	}
}
