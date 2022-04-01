package problem1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mobile mobiles = new Mobile();
		
		//Adding Redmi phones
		mobiles.addMobile("Redmi", "m2 pro");
		mobiles.addMobile("Redmi", "X3 Ultra Pro Max");
		mobiles.addMobile("Redmi", "Poco m3 ");
		mobiles.addMobile("Redmi", "Xiaomi 2");
		
		//Adding Samsung phone
		mobiles.addMobile("Samsung", "galaxy s1");
		
		
		//Getting the list of phones of a given company
		int count = 1;
		ArrayList<String> listOfPhones = mobiles.getModels("Redmi");
		
		if(listOfPhones == null) {
			System.out.println("No phones to display :(");
		} else {
			System.out.println("List of Redmi Phones: ");
			for(String model: listOfPhones) {
				System.out.println(count + ": " + model);
				count++;
			}
		}
	}

}
