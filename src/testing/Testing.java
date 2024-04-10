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
		Container shipment=new Container();
		ArrayList <Object> order1=shipment.addorder();
		
//-----------------------------------------------------------------------------------------------		
		//Add item and their information beforehand
		// Laptop
		Item laptop = new Item();
		laptop.setItemname("Laptop");
		ArrayList<Double> laptopsize = new ArrayList<>();
			laptopsize.add(60.0);laptopsize.add(50.0);laptopsize.add(50.0);
		laptop.setItemsize(laptopsize);
		laptop.setItemweight(6.5);

		laptop.iteminfo();
				
		// Mouse
		Item mouse = new Item();
		mouse.setItemname("Mouse");
		ArrayList<Double> mousesize = new ArrayList<>();
			mousesize.add(30.0);mousesize.add(30.0);mousesize.add(20.0);
		mouse.setItemsize(mousesize);
		mouse.setItemweight(0.2);

		mouse.iteminfo();

		//Desktop
		Item desktop = new Item();
		desktop.setItemname("Desktop");
		ArrayList<Double> desktopsize = new ArrayList<>();
			desktopsize.add(100.0);desktopsize.add(150.0);desktopsize.add(50.0);
		desktop.setItemsize(desktopsize);
		desktop.setItemweight(20.0);

		desktop.iteminfo();
				
		//LCD screens
		Item LCDS = new Item();
		LCDS.setItemname("LCD Screen");
		ArrayList<Double> LCDSsize = new ArrayList<>();
			LCDSsize.add(120.0);LCDSsize.add(140.0);LCDSsize.add(80.0);
		LCDS.setItemsize(LCDSsize);
		LCDS.setItemweight(2.6);

		LCDS.iteminfo();

//-----------------------------------------------------------------------------------------------			
		//Add quantity and items to the order
		//Adding previously created objects into a list
		System.out.println("----------------------------------");
		shipment.additems(order1, 100, laptop.createitemlist()); //add laptop
				
		shipment.additems(order1, 200, mouse.createitemlist()); //add mouse

		shipment.additems(order1, 150, desktop.createitemlist()); //add desktop
				
		shipment.additems(order1, 200, LCDS.createitemlist()); //add LCD
			
//-----------------------------------------------------------------------------------------------			
		//Check information of containers and determine their volumes
		//Big container information
		shipment.Bcontainerinfo();
		double bigcontainervolume=shipment.Bcontainervol();
		
		//Small container information
		shipment.Scontainerinfo();
		double smallcontainervolume=shipment.Scontainervol();

//-----------------------------------------------------------------------------------------------				
		//Calculate total volume of the shipment
		double shipmentvolume=shipment.totalvol(order1);
				 
		//Calculate total weight of the shipment
		double shipmentweight=shipment.totalweight(order1);
				
		//Calculate ratio m3:kg
		double volumeweightratio=shipment.vwratio(shipmentvolume,shipmentweight);
				
		//Calculate the best shipping		
		ArrayList<String> bestshipment=shipment.bestship(shipmentvolume, shipmentweight, bigcontainervolume,smallcontainervolume,volumeweightratio);
				
		//Calculate the total price of the shipment
		int shipmenttotalprice=shipment.totalprice(bestshipment);
				
		//Print information of all items within the shipment
		shipment.itemsinfo(order1);
		
		//Print the information of the shipment
		shipment.orderinfo(order1, shipmentvolume, shipmentweight, bestshipment, shipmenttotalprice);
				
				
				
	}

}
