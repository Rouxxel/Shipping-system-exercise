package testing;

import java.util.ArrayList;

import containers.Container;
import items.Item;


//SEBASTIAN RUSSO
public class Testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//-----------------------------------------------------------------------------------------------	
		//Add an order 
		Container shipment = new Container();
		ArrayList <Object> order_1 = shipment.add_order();
		
//-----------------------------------------------------------------------------------------------		
		//Add item and their information beforehand
		//Laptop
		Item laptop = new Item();

		laptop.set_item_name("Laptop");

		ArrayList<Double> laptop_size = new ArrayList<>();
		laptop_size.add(60.0);
		laptop_size.add(50.0);
		laptop_size.add(50.0);

		laptop.set_item_size(laptop_size);
		laptop.set_item_weight(6.5);

		laptop.item_info();
				
		//Mouse
		Item mouse = new Item();

		mouse.set_item_name("Mouse");

		ArrayList<Double> mouse_size = new ArrayList<>();
		mouse_size.add(30.0);
		mouse_size.add(30.0);
		mouse_size.add(20.0);

		mouse.set_item_size(mouse_size);
		mouse.set_item_weight(0.2);

		mouse.item_info();

		//Desktop
		Item desktop = new Item();

		desktop.set_item_name("Desktop");

		ArrayList<Double> desktop_size = new ArrayList<>();
		desktop_size.add(100.0);
		desktop_size.add(150.0);
		desktop_size.add(50.0);

		desktop.set_item_size(desktop_size);
		desktop.set_item_weight(20.0);

		desktop.item_info();
				
		//LCD screens
		Item LCD = new Item();

		LCD.set_item_name("LCD Screen");

		ArrayList<Double> LCD_size = new ArrayList<>();
		LCD_size.add(120.0);
		LCD_size.add(140.0);
		LCD_size.add(80.0);

		LCD.set_item_size(LCD_size);
		LCD.set_item_weight(2.6);

		LCD.item_info();

//-----------------------------------------------------------------------------------------------			
		//Add quantity and items to the order
		//Adding previously created objects into a list
		System.out.println("----------------------------------");
		shipment.add_items_to_order(
			order_1, 100, laptop.create_item_list()); //add laptop
				
		shipment.add_items_to_order(
			order_1, 200, mouse.create_item_list()); //add mouse

		shipment.add_items_to_order(
			order_1, 150, desktop.create_item_list()); //add desktop
				
		shipment.add_items_to_order(
			order_1, 200, LCD.create_item_list()); //add LCD
			
//-----------------------------------------------------------------------------------------------			
		//Check information of containers and determine their volumes
		//Big container information
		shipment.big_container_info();
		double big_container_volume = shipment.big_container_vol();
		
		//Small container information
		shipment.small_container_info();
		double small_container_volume = shipment.small_container_vol();

//-----------------------------------------------------------------------------------------------				
		//Calculate total volume of the shipment
		double shipment_volume=shipment.total_vol(order_1);

		//Calculate total weight of the shipment
		double shipment_weight=shipment.total_weight(order_1);
				
		//Calculate ratio m3:kg
		double vol_weight_ratio=shipment.volume_weight_ratio(shipment_volume,shipment_weight);
				
		//Calculate the best shipping		
		ArrayList<String> best_shipment=shipment.best_shipment(shipment_volume,
																shipment_weight, 
																big_container_volume,
																small_container_volume,
																vol_weight_ratio);
				
		//Calculate the total price of the shipment
		int shipment_total_price=shipment.total_cost(best_shipment);
				
		//Print information of all items within the shipment
		shipment.items_info(order_1);
		
		//Print the information of the shipment
		shipment.order_info(order_1, shipment_volume, shipment_weight, 
							best_shipment, shipment_total_price);

	}
}
