package items;
import java.util.ArrayList;

import methods.Calculation;

//SEBASTIAN RUSSO
public class Item extends Calculation{

//-----------------------------------------------------------------------------------------------
	//Attributes for item's traits
	private String itemname;
	private ArrayList<Double> itemsize;
	private double itemweight;
	
//-----------------------------------------------------------------------------------------------
	//Constructors
	public Item() {}
	public Item(String itemname, ArrayList<Double> itemsize,double itemweight) {
		this.itemname = itemname;
		this.itemsize= itemsize;
		this.itemweight = itemweight;
	}

//-----------------------------------------------------------------------------------------------	
	//Getters and setters
	//Set and get the name of the item
	public String getItemname() {
		return this.itemname;}
	public void setItemname(String itemname) {
		this.itemname = itemname;}

	//Set and get the item's size (Length,Width,Height)
	public ArrayList<Double> getItemsize() {
		return this.itemsize;}
	public void setItemsize(ArrayList<Double> itemsize) {
		this.itemsize = itemsize;}

	//Set and get itme's weight
	public double getItemweight() {
		return this.itemweight;}
	public void setItemweight(double itemweight) {
		this.itemweight = itemweight;}
	
//-----------------------------------------------------------------------------------------------
	//Methods
	//To print the info of just 1 item (implemented from abstract class Calculate)
	public void iteminfo() {
		System.out.println("----------------------------------");
		System.out.println("Saved item:");
		System.out.println("-Name= "+this.itemname);
		System.out.println("-Size= "+this.itemsize.get(0)+"cm x "+this.itemsize.get(1)+"cm x "+this.itemsize.get(2)+"cm");
		System.out.println("-Volume= "+itemvol()+"m3 ");
		System.out.println("-Weight= "+this.itemweight+"kg");
	}
	/*This method is simply to print the information of the entered item*/

	
	//To calculate the volume of each individual item (implemented from abstract class Calculate)
	public double itemvol() {
		double x=(this.itemsize.get(0)*this.itemsize.get(1)*this.itemsize.get(2))/1000000;
		return x;
	}
	/*This method is to calculate and return the volume of the item by container by multiplying 
	 each sizes but since the entered values are expected to be cm, it is divided by 1000000 to
	 automatically convert the result from cm3 to m3*/
	
	
	//Generate list for each created object
	public ArrayList<Object>createitemlist(){
		ArrayList<Object> singleitemlist = new ArrayList<>();
		singleitemlist.add(this.itemname);
		singleitemlist.add(this.itemsize.get(0));
		singleitemlist.add(this.itemsize.get(1));
		singleitemlist.add(this.itemsize.get(2));
		singleitemlist.add(this.itemweight);
		
		return singleitemlist;
	}
	/*This is an extra method i decided to add, it simply generates and returns an ArrayList 
	 that stores the name, the 3 sizes and the weight of the entered item, that way it can be
	 used in the additems method of the Calculation class and therefore allow to use the 
	 following methods*/
	
	
	
	
//-----------------------------------------------------------------------------------------------	
	//Unuseful abstract methods
	@Override
	public void Bcontainerinfo() {// TODO Auto-generated method stub
		}
	@Override
	public void Scontainerinfo() {// TODO Auto-generated method stub
		}
	@Override
	public double Bcontainervol() {// TODO Auto-generated method stub
		return 0;}
	@Override
	public double Scontainervol() {// TODO Auto-generated method stub
		return 0;}

	/*These are just the unuseful methods to this class but that must be implemented here, 
	 however,are useful to the Item class*/

	
	
	
	
}
