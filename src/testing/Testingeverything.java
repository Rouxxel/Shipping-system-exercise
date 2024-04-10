package testing;
import java.util.ArrayList;

import items.Item;
import containers.Container;


//SEBASTIAN RUSSO
public class Testingeverything {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Add an order, addorders method
		Container shipment=new Container();
		ArrayList <Object> order1=shipment.addorder();
		System.out.println("");
		System.out.println("Testing return of add order method= "+order1+" (should have an id for the order)");
		
		//Add item and their information beforehand
		// Laptop
		Item laptop = new Item();
		laptop.setItemname("Laptop");
		ArrayList<Double> laptopsize = new ArrayList<>();
		laptopsize.add(60.0);
		laptopsize.add(50.0);
		laptopsize.add(50.0);
		laptop.setItemsize(laptopsize);
		laptop.setItemweight(6.5);

		laptop.iteminfo();
		
		System.out.println("");
		System.out.println("Testing return of item volume method testing= " + laptop.itemvol());
		System.out.println("Testing return of item list of values of laptop testing= " + laptopsize);
		System.out.println("Testing return of item list of information testing= "+laptop.createitemlist());
		
		// Mouse
		Item mouse = new Item();
		mouse.setItemname("Mouse");
		ArrayList<Double> mousesize = new ArrayList<>();
		mousesize.add(30.0);
		mousesize.add(30.0);
		mousesize.add(20.0);
		mouse.setItemsize(mousesize);
		mouse.setItemweight(0.2);

		mouse.iteminfo();
		
		System.out.println("");
		System.out.println("Testing return of item volume method testing= " + mouse.itemvol());
		System.out.println("Testing return of item list of values of mouse testing= " + mousesize);
		System.out.println("Testing return of item list of information testing= "+mouse.createitemlist());

		//Desktop
		Item desktop = new Item();
		desktop.setItemname("Desktop");
		ArrayList<Double> desktopsize = new ArrayList<>();
		desktopsize.add(100.0);
		desktopsize.add(150.0);
		desktopsize.add(50.0);
		desktop.setItemsize(desktopsize);
		desktop.setItemweight(20.0);

		desktop.iteminfo();
		
		System.out.println("");
		System.out.println("Testing return of item volume method testing= " + desktop.itemvol());
		System.out.println("Testing return of item list of values of Desktop testing= " + desktopsize);
		System.out.println("Testing return of item list of information testing= "+desktop.createitemlist());
		
		//LCD screens
		Item LCDS = new Item();
		LCDS.setItemname("LCD Screen");
		ArrayList<Double> LCDSsize = new ArrayList<>();
		LCDSsize.add(120.0);
		LCDSsize.add(140.0);
		LCDSsize.add(80.0);
		LCDS.setItemsize(LCDSsize);
		LCDS.setItemweight(2.6);

		LCDS.iteminfo();
		
		System.out.println("");
		System.out.println("Testing return of item volume method testing= " + LCDS.itemvol());
		System.out.println("Testing return of item list of values of LCD testing= " + LCDSsize);
		System.out.println("Testing return of item list of information testing= "+LCDS.createitemlist());
		
		//Add quantity and items, additemsmethods test 
		//Adding previously created objects into a list
		System.out.println("----------------------------------");
		shipment.additems(order1, 100, laptop.createitemlist());
		System.out.println("Testing return of iteration of list 1="+order1);
		
		shipment.additems(order1, 200, mouse.createitemlist());
		System.out.println("Testing return of iteration of list 2="+order1);
		
		shipment.additems(order1, 150, desktop.createitemlist());
		System.out.println("Testing return of iteration of list 3="+order1);
		
		shipment.additems(order1, 200, LCDS.createitemlist());
		System.out.println("Testing return of iteration of list 4="+order1);
		
		System.out.println("");
		System.out.println("Checks the if each time an item is added is stored within the list dedicated to the order");

		
		// Container class test------------------------------------------------------------------
		//Checkn information of containers and create their volumes
		shipment.Bcontainerinfo();
		System.out.println("");
		System.out.println("Testing return of big container total volume "+shipment.Bcontainervol());
		double bigcontainervolume=shipment.Bcontainervol();
		
		shipment.Scontainerinfo();
		System.out.println("");
		System.out.println("Testing return of small container total volume "+shipment.Scontainervol());
		double smallcontainervolume=shipment.Scontainervol();
		
		System.out.println("----------------------------------");
		
		//Calculate total volume of the shipment
		System.out.println("Testing return of total volume method of the shipment= "+shipment.totalvol(order1)+"m3");
		double shipmentvolume=shipment.totalvol(order1); 
		
		//Calculate total weight of the shipment
		System.out.println("Testing return of total weight method of the shipment= "+shipment.totalweight(order1)+"kg");
		double shipmentweight=shipment.totalweight(order1);
		
		//Calculate ratio m3:kg
		System.out.println("Testing return of ratio method of the shipment= 1m3:"+shipment.vwratio(shipmentvolume,shipmentweight)+"kg");
		double volumeweightratio=shipment.vwratio(shipmentvolume,shipmentweight);
		
		//Calculate the best shipping
		ArrayList<String> bestshipment=shipment.bestship(shipmentvolume, shipmentweight, bigcontainervolume,smallcontainervolume,volumeweightratio);
		System.out.println("");
		System.out.println("Testing return of needed containers list testing= "+bestshipment);
		
		//Calculate the total price of the shipment
		int shipmenttotalprice=shipment.totalprice(bestshipment);
		System.out.println("");
		System.out.println("Testing return of total price method= "+shipmenttotalprice+" Euros");
		
		//Print information of all items within the shipment
		shipment.itemsinfo(order1);
		
		//Print the information of the shipment
		shipment.orderinfo(order1, shipmentvolume, shipmentweight, bestshipment, shipmenttotalprice);
		
		
		
	}

}
