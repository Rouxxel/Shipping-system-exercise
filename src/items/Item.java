package items;
import java.util.ArrayList;

import methods.Calculation;

//SEBASTIAN RUSSO

//Class for Item instantiation
public class Item extends Calculation{
	//Attributes for item's traits
	private String item_name;
	private ArrayList<Double> item_size;
	private double item_weight;

	//Constructors
	public Item() {}
	public Item(String item_name, ArrayList<Double> item_size,double item_weight) {
		this.item_name = item_name;
		this.item_size= item_size;
		this.item_weight = item_weight;
	}

	//Getters and setters
	//Set and get the name of the item
	public String get_item_name() {
		return this.item_name;}
	public void set_item_name(String item_name) {
		this.item_name = item_name;}

	//Set and get the item's size (Length,Width,Height)
	public ArrayList<Double> get_item_size() {
		return this.item_size;}
	public void set_item_size(ArrayList<Double> item_size) {
		this.item_size = item_size;}

	//Set and get item's weight
	public double get_item_weight() {
		return this.item_weight;}
	public void set_item_weight(double item_weight) {
		this.item_weight = item_weight;}
	
//-----------------------------------------------------------------------------------------------
	//Methods
	//To print the info of just 1 item (implemented from abstract class Calculate)
	public void item_info() {
		/*This method is simply to print the information of the entered item*/
		System.out.println("----------------------------------");
		System.out.println("Saved item:");
		System.out.println("-Name= "+this.item_name);
		System.out.println("-Size= "+this.item_size.get(0)+"cm x "
							+this.item_size.get(1)+"cm x "
							+this.item_size.get(2)+"cm");
		System.out.println("-Volume= "+item_vol()+"m3 ");
		System.out.println("-Weight= "+this.item_weight+"kg");
	}
	
	//To calculate the volume of each individual item (implemented from abstract class Calculate)
	public double item_vol() {
		/*
		 * This method is to calculate and return the volume of the item by 
		 * container by multiplying each sizes but since the entered values 
		 * are expected to be cm, it is divided by 1000000 to convert the 
		 * result from cm3 to m3
		 */

		//Calculate item volume
		double item_volume = (this.item_size.get(0)
								* this.item_size.get(1)
								* this.item_size.get(2));
		item_volume = item_volume / 1000000; //Convert to m3

		//Return volume
		return item_volume;
	}
	
	//Generate list for each created object
	public ArrayList<Object>create_item_list(){
		/*
		 * This is an extra method i decided to add, it simply generates 
		 * and returns an ArrayList that stores the name, the 3 sizes 
		 * and the weight of the entered item, that way it can be used in 
		 * the add_items method of the Calculation class and therefore 
		 * allow to use the following methods
		 */

		//Instantiate list for item info
		ArrayList<Object> item_info_list = new ArrayList<>();
		item_info_list.add(this.item_name);
		item_info_list.add(this.item_size.get(0));
		item_info_list.add(this.item_size.get(1));
		item_info_list.add(this.item_size.get(2));
		item_info_list.add(this.item_weight);
		
		//Return list of item
		return item_info_list;
	}
	
//-----------------------------------------------------------------------------------------------	
	//Unused abstract methods
	@Override
	public void big_container_info() {// TODO Auto-generated method stub
		}
	@Override
	public void small_container_info() {// TODO Auto-generated method stub
		}
	@Override
	public double big_container_vol() {// TODO Auto-generated method stub
		return 0;}
	@Override
	public double small_container_vol() {// TODO Auto-generated method stub
		return 0;}

	/*These are just the unused methods to this class but that must be implemented here, 
	however,are useful to the Item class*/
}
