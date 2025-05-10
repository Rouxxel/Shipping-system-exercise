package testing;
import java.util.ArrayList;

import items.Item;
import containers.Container;


//SEBASTIAN RUSSO
public class Testing_everything {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Add an order, add_orders method
		Container shipment=new Container();
		ArrayList <Object> order_1=shipment.add_order();
		System.out.println("");
		System.out.println("Testing return of add order method= "+order_1+" (should have an id for the order)");
		
		//Add item and their information beforehand
		// Laptop
		Item laptop = new Item();
		laptop.set_item_name("Laptop");
		ArrayList<Double> laptop_size = new ArrayList<>();
		laptop_size.add(60.0);
		laptop_size.add(50.0);
		laptop_size.add(50.0);
		laptop.set_item_size(laptop_size);
		laptop.set_item_weight(6.5);

		laptop.item_info();
		
		System.out.println("");
		System.out.println("Testing return of item volume method testing= " + laptop.item_vol());
		System.out.println("Testing return of item list of values of laptop testing= " + laptop_size);
		System.out.println("Testing return of item list of information testing= "+laptop.create_item_list());
		
		// Mouse
		Item mouse = new Item();
		mouse.set_item_name("Mouse");
		ArrayList<Double> mouse_size = new ArrayList<>();
		mouse_size.add(30.0);
		mouse_size.add(30.0);
		mouse_size.add(20.0);
		mouse.set_item_size(mouse_size);
		mouse.set_item_weight(0.2);

		mouse.item_info();
		
		System.out.println("");
		System.out.println("Testing return of item volume method testing= " + mouse.item_vol());
		System.out.println("Testing return of item list of values of mouse testing= " + mouse_size);
		System.out.println("Testing return of item list of information testing= "+mouse.create_item_list());

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
		
		System.out.println("");
		System.out.println("Testing return of item volume method testing= " + desktop.item_vol());
		System.out.println("Testing return of item list of values of Desktop testing= " + desktop_size);
		System.out.println("Testing return of item list of information testing= "+desktop.create_item_list());
		
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
		
		System.out.println("");
		System.out.println("Testing return of item volume method testing= " + LCD.item_vol());
		System.out.println("Testing return of item list of values of LCD testing= " + LCD_size);
		System.out.println("Testing return of item list of information testing= "+LCD.create_item_list());
		
		//Add quantity and items, add_items_to_ordermethods test 
		//Adding previously created objects into a list
		System.out.println("----------------------------------");
		shipment.add_items_to_order(order_1, 100, laptop.create_item_list());
		System.out.println("Testing return of iteration of list 1="+order_1);
		
		shipment.add_items_to_order(order_1, 200, mouse.create_item_list());
		System.out.println("Testing return of iteration of list 2="+order_1);
		
		shipment.add_items_to_order(order_1, 150, desktop.create_item_list());
		System.out.println("Testing return of iteration of list 3="+order_1);
		
		shipment.add_items_to_order(order_1, 200, LCD.create_item_list());
		System.out.println("Testing return of iteration of list 4="+order_1);
		
		System.out.println("");
		System.out.println("Checks the if each time an item is added is stored within the list dedicated to the order");

		
		// Container class test------------------------------------------------------------------
		//Check information of containers and create their volumes
		shipment.big_container_info();
		System.out.println("");
		System.out.println("Testing return of big container total volume "+shipment.big_container_vol());
		double big_container_volume=shipment.big_container_vol();
		
		shipment.small_container_info();
		System.out.println("");
		System.out.println("Testing return of small container total volume "+shipment.small_container_vol());
		double small_container_volume=shipment.small_container_vol();
		
		System.out.println("----------------------------------");
		
		//Calculate total volume of the shipment
		System.out.println("Testing return of total volume method of the shipment= "+shipment.total_vol(order_1)+"m3");
		double shipment_volume=shipment.total_vol(order_1); 
		
		//Calculate total weight of the shipment
		System.out.println("Testing return of total weight method of the shipment= "+shipment.total_weight(order_1)+"kg");
		double shipment_weight=shipment.total_weight(order_1);
		
		//Calculate ratio m3:kg
		System.out.println("Testing return of ratio method of the shipment= 1m3:"+shipment.volume_weight_ratio(shipment_volume,shipment_weight)+"kg");
		double volume_weight_ratio=shipment.volume_weight_ratio(shipment_volume,shipment_weight);
		
		//Calculate the best shipping
		ArrayList<String> best_shipment=shipment.best_shipment(shipment_volume, shipment_weight, big_container_volume,small_container_volume,volume_weight_ratio);
		System.out.println("");
		System.out.println("Testing return of needed containers list testing= "+best_shipment);
		
		//Calculate the total price of the shipment
		int shipment_total_price=shipment.total_cost(best_shipment);
		System.out.println("");
		System.out.println("Testing return of total price method= "+shipment_total_price+" Euros");
		
		//Print information of all items within the shipment
		System.out.println(order_1);
		shipment.items_info(order_1);
		
		//Print the information of the shipment
		shipment.order_info(order_1, shipment_volume, shipment_weight, best_shipment, shipment_total_price);
		
	}

}
