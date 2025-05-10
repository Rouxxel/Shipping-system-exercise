package methods;

import java.util.ArrayList;
//SEBASTIAN RUSSO

//Class for performing the relevant calculations
public abstract class Calculation {

	// METHODS
	// Add an order method
	public ArrayList<Object> add_order() {
		/**
		 * This methods generates an empty list that is inmediately added
		 * a random unique id for the order, so the user is supposed to
		 * create a value equal to this method so this empty list can be
		 * updated as the user uses all the other methods
		 * 
		 * @return an ArrayList<Object> containing the generated order ID.
		 */

		// Generate random order id
		int order_id = (int) ((Math.random() * 900000) + 100000);

		// Generate empty array list of multiple data types
		ArrayList<Object> order_list = new ArrayList<>();
		order_list.add(order_id); // Add order id as first value

		System.out.println("-------------------------------------");
		System.out.println("Added new order: " + order_list.get(0));
		return order_list; // return new list
	}

	// -----------------------------------------------------------------------------------------------
	// Add items to the order in an empty list
	public void add_items_to_order(ArrayList<Object> order_list,
			int quantity,
			ArrayList<Object> entered_item_list) {
		/**
		 * This methods accepts the list that was created with the
		 * add_order method, the big_container_amount of items that the user wants
		 * to enter and a list with the information of the item that
		 * must be created with the create_item_list method in the Item
		 * class, so then the quantity and the list of the item is
		 * saved within the empty list to be used in the next methods.
		 * As shown in the if statement, it checks if the entered
		 * parameters are valid or not
		 */
		// Check parameters before proceeding
		if (order_list.isEmpty()) {
			System.out.println("Error: The order_list is empty. " +
					"Please ensure the list is not empty before proceeding.");
			return;
		}
		if (entered_item_list.isEmpty()) {
			System.out.println("Error: The entered_item_list is empty. " +
					"Please ensure the list is not empty before proceeding.");
			return;
		}
		if (quantity <= 0) {
			System.out.println("Error: The quantity must be greater than 0. " +
					"Please ensure that quantity is a valid number");
			return;
		}

		// Add item to the order list if no condition is met
		entered_item_list.add(0,quantity);
		order_list.add(entered_item_list);
		System.out.println("-Added item= " + quantity + "x " + entered_item_list.get(1));
	}

	// -----------------------------------------------------------------------------------------------
	// Calculate total volume of the shipment
	public double total_vol(ArrayList<Object> order_list) {
		/**
		* Once all items are added to the list with the add_items_to_order 
		* method, this method simply asks for the aforementioned list 
		* and then access the quantity and the size values of each saved item
		* so the total volume of the whole shipment can be calculated and 
		* returned with a for loop that checks the specific indexes given 
		* that the list it always follows the structure:
		* list[quantity, name, measure1, measure2, measure3, weight]...
		*/

		// Instantiate variable to return
		double total_volume = 0.0;
		// For loop to iterate through all item lists in the order list
		for (int i = 1; i < order_list.size(); i = i + 1) {

			//Access each list individually because each list represents an item
			ArrayList<Object> item = (ArrayList<Object>) order_list.get(i);

			//Calculate volume
			double item_volume = 0.0;
			item_volume = ((double) item.get(2) * (double) item.get(3) * 
							(double) item.get(4));
			//Obtain total item volume according to quantity and convert to m3
			item_volume = ((int) item.get(0) * item_volume) / 1000000.0; 
			
			//Add to the total volume
			total_volume = total_volume + item_volume;
		}
		
		//Return total volume
		return total_volume;
	}

	// -----------------------------------------------------------------------------------------------
	// Calculate total weight of the shipment
	public double total_weight(ArrayList<Object> order_list) {
		/**
		* Once all items are added to the list with the add_items_to_order 
		* method, this method simply asks for the aforementioned list 
		* and then access the quantity and the weight value of each saved item
		* so the total weight of the whole shipment can be calculated and 
		* returned with a for loop that checks the specific indexes given 
		* that the list it always follows the structure:
		* list[quantity, name, measure1, measure2, measure3, weight]...
		*/

		// Instantiate variable to return
		double total_weight = 0.0;
		// For loop to iterate through all item lists in the order list
		for (int i = 1; i < order_list.size(); i = i + 1) {

			//Access each list individually because each list represents an item
			ArrayList<Object> item = (ArrayList<Object>) order_list.get(i);

			//Calculate weight
			double item_weight = ((int) item.get(0) * (double) item.get(5));
			//Add to the total volume
			total_weight = total_weight + item_weight;
		}

		//Return total volume
		return total_weight;
	}
	
	// -----------------------------------------------------------------------------------------------
	//Calculate weight:volume ratio of the shipment
	public double volume_weight_ratio(double total_vol, double total_weight) {
		/**
		* This is a method i decided to create to calculate the best shipping, what it
		* does is simply calculate the ratio of how many kg are there for each unit of 
		* m3 (1m3:?kg) by using the results of the total_vol and the total_weight methods 
		* and returning the said ratio
		*/

		//Calculate and return ratio
		double ratio = total_weight / total_vol;
		return ratio;
	}
	
	// -----------------------------------------------------------------------------------------------
	// Calculate Best Shipping
	public ArrayList<String> best_shipment(double total_vol, double total_weight, 
											double big_container_vol, 
											double small_container_vol,
											double volume_weight_ratio) {
		/**
		* This method aks for the total volume and weight of the shipment, 
		* the total volume of both big and small containers and the ratio
		* volume:weight in order to generate and return a list of strings 
		* where each string represents a kind of container (big, small 
		* cheap or small expensive) to be used in another method.
		* 
		* By using a for loop we first check how many big containers are 
		* required and each time a big container is added then the volume 
		* of the said big container substracts the total volume and weight
		* of the shipment (by using the ratio).
		* 
		* Then we check using if statements to check how many and which kind 
		* of small containers are required by using a modified version of the 
		* previous for loop and inserted within an if statement and taking 
		* into account the weight since according to it the value of a small
		* container will change.
		* 
		* The reasoning behind this is that the bigger in volume the shipment the
		* cheapest it will be to ship it, hence why we check first if we can use 
		* big containers, but it also takes into account that maybe small containers 
		* are a better option
		*/

		//Instantiate array for needed containers and total volume and weight
		ArrayList<String> needed_containers = new ArrayList<>();
		double remaining_vol = total_vol;
		double remaining_weight = total_weight;

		//First, Check how many big containers are required because its the best cost-value
		//Substract remaining volume and weight
		for (double i = big_container_vol; i < total_vol; i = i + big_container_vol) {
			needed_containers.add("Big Container");
			remaining_vol = remaining_vol - big_container_vol;
			remaining_weight = remaining_vol * volume_weight_ratio;
		}

		//Check how many small containers are required and which price
		if (remaining_vol > small_container_vol) {
			for (double i = small_container_vol; i < remaining_vol; i = i + small_container_vol) {
				if (remaining_weight <= 500) {
					needed_containers.add("Small Container (cheap)");
					remaining_vol = remaining_vol - small_container_vol;
					remaining_weight = remaining_vol * volume_weight_ratio;
				} else {
					needed_containers.add("Small Container (expensive)");
					remaining_vol = remaining_vol - small_container_vol;
					remaining_weight = remaining_vol * volume_weight_ratio;
				}
			}
		}

		//Check for the last needed container
		if (remaining_vol <= small_container_vol && remaining_weight <= 500) {
			needed_containers.add("Small Container (cheap)");
			remaining_vol = remaining_vol - small_container_vol;
			remaining_weight = remaining_vol * volume_weight_ratio;
		}
		if (remaining_vol <= small_container_vol && remaining_weight > 500) {
			needed_containers.add("Small Container (expensive)");
			remaining_vol = remaining_vol - small_container_vol;
			remaining_weight = remaining_vol * volume_weight_ratio;
		}

		// Print each required container
		System.out.println("----------------------------------");
		System.out.println("Best shipping requires:");
		for (int i = 0; i < needed_containers.size(); i = i + 1) {
			System.out.println("-1 x " + needed_containers.get(i));
		}

		return needed_containers;
	}

	// -----------------------------------------------------------------------------------------------
	// Calculate shipping price
	public int total_cost(ArrayList<String> needed_containers) {
		/**
		* This method asks for the arraylist generated by the best_shipment 
		* method and then by using a local variable and a for loop, it checks 
		* each string within the provided list and according to which string 
		* is presented, it will add a specific value to the local variable and 
		* then return the total price of the shipment according to the containers 
		* that are required
		*/
		//Instantiate total price to return
		int total_cost = 0;

		//Go through the list and calculate the price according to type
		for (int i = 0; i < needed_containers.size(); i = i + 1) {
			switch (needed_containers.get(i)) {
				case "Big Container":
					total_cost += 1800;
					break;  
				case "Small Container (cheap)":
					total_cost += 1000;
					break;
				case "Small Container (expensive)":
					total_cost += 1200;
					break;
				default:
					System.out.println("Unknown container type: " + needed_containers.get(i));
					break; 
			}
		}

		System.out.println("----------------------------------");
		System.out.println("For a total of: " + total_cost + " euros");

		//Return total price
		return total_cost;
	}

	// -----------------------------------------------------------------------------------------------
	// Print item's info
	public void items_info(ArrayList<Object> final_list) {
		/* 
		 * Print all individual items info in shipment order
		 */
		System.out.println("----------------------------------");
		System.out.println("-Items within the shipment "+final_list.get(0)+": ");
		for (int i = 1; i < final_list.size(); i = i + 1) {
			//Obtain list of info of each item
			ArrayList<Object> item_info_list = (ArrayList<Object>) final_list.get(i);

			//Print quantity x name of volume and weight
			System.out.print(item_info_list.get(0));
			System.out.print("x " + item_info_list.get(1));
			System.out.print(" of " + (((double) item_info_list.get(2) 
								* (double) item_info_list.get(3) 
								* (double) item_info_list.get(4)) / 1000000)
								+ " m3 each box (");
			System.out.print(item_info_list.get(2) + "x" 
								+ item_info_list.get(3) + "x" 
								+ item_info_list.get(4) + ")");
			System.out.println(" and a weight of " + item_info_list.get(5) + "kg each box");
		}
	}

	// -----------------------------------------------------------------------------------------------
	// Print order info
	public void order_info(ArrayList<Object> final_list, 
							double total_vol, 
							double total_weight, 
							ArrayList<String> best_shipment,
							int total_cost) {
		/* 
		 * Print all information of the shipment order
		 */
		System.out.println("----------------------------------");
		System.out.println("Order information");
		System.out.println("-Order ID: " + final_list.get(0));

		// Shipment information
		System.out.print("-Items within the shipment: ");
		for (int i = 1; i < final_list.size(); i = i + 1) {
			//Extract item info individually
			@SuppressWarnings("unchecked") //Data is sure an array list of multiple data type
			ArrayList<Object> item_list = (ArrayList<Object>) final_list.get(i);

			//Print quantity x item name
			System.out.print(item_list.get(0));
			System.out.print("x " + item_list.get(1));
			System.out.print(", ");
		}
		System.out.println("");

		//Print shipment volume
		System.out.println("-Total volume of the shipment: " + total_vol + "m3");
		//Print shipment weight
		System.out.println("-Total weight of the shipment: " + total_weight + "kg");

		//Required containers
		System.out.print("-Required containers: ");
		//Big containers
		int big_container_amount = 0;
		for (int i = 0; i < best_shipment.size(); i = i + 1) {
			if (best_shipment.get(i) == "Big Container") {
				big_container_amount = big_container_amount + 1;
			}
		}
		if (big_container_amount > 1) {
			System.out.print(big_container_amount + " Big containers");
		} else {
			if (big_container_amount == 1) {
				System.out.print(big_container_amount + " Big container");
			} else {
				System.out.print("No Big containers");
			}
		}

		// Cheap small containers
		int small_cheap_container_amount = 0;
		for (int i = 0; i < best_shipment.size(); i = i + 1) {
			if (best_shipment.get(i) == "Small Container (cheap)") {
				small_cheap_container_amount = small_cheap_container_amount + 1;
			}
		}
		if (small_cheap_container_amount > 1) {
			System.out.print(", ");
			System.out.print(small_cheap_container_amount + " Small Container (cheap)");
		} else {
			if (small_cheap_container_amount == 1) {
				System.out.print(", ");
				System.out.print(small_cheap_container_amount + " Small Container (cheap)");
			} else {
				System.out.print(", No Small Container (cheap)");
			}
		}

		// Expensive small containers
		int small_expensive_container_amount = 0;
		for (int i = 0; i < best_shipment.size(); i = i + 1) {
			if (best_shipment.get(i) == "Small Container (expensive)") {
				small_expensive_container_amount = small_expensive_container_amount + 1;
			}
		}
		if (small_expensive_container_amount > 1) {
			System.out.print(" and ");
			System.out.print(small_expensive_container_amount + " Small Container (expensive)");
		} else {
			if (small_expensive_container_amount == 1) {
				System.out.print(" and ");
				System.out.print(small_expensive_container_amount + " Small Container (expensive)");
			} else {
				System.out.print(" and No Small Container (expensive)");
			}
		}
		System.out.println("");
		//

		// print total price of the shipment
		System.out.println("-Total price of the shipment: " + total_cost + " Euros");

	}

	// -----------------------------------------------------------------------------------------------
	// Abstract methods
	// Print single item info
	public abstract void item_info();

	// Calculate single item volume
	public abstract double item_vol();

	// Print container info
	public abstract void big_container_info();

	public abstract void small_container_info();

	// Print container capacity
	public abstract double big_container_vol();

	public abstract double small_container_vol();

	/*
	 * this are all the methods that the other 2 classes are supposed to finish,
	 * however, only a
	 * portion of these abstract methods are actually useful to each class, so the
	 * ones that are
	 * not useful are simply overridden to do nothing
	 */
}
