package containers;
import java.util.ArrayList;
import java.util.Arrays;

import methods.Calculation;

//SEBASTIAN RUSSO
public class Container extends Calculation{

//-----------------------------------------------------------------------------------------------		
	//Attributes for containers (fixed values)
	//big containet
	private ArrayList<Double> bcontainersize= new ArrayList<>(Arrays.asList(2.59, 2.43, 12.01));
	private int bcontainercost=1800;
	
	//small container
	private ArrayList<Double> scontainersize = new ArrayList<>(Arrays.asList(2.59, 2.43, 6.06));
	private int scontainercost_s_weigth=1000;
	private int scontainercost_h_weight=1200;
	
	/*As stated, all the values of all the attributes in this class are already given because,
	 since the volume and price of the containers are constant and cannot be modified by the
	 client then there is no reason to ask the client to set their values*/
//-----------------------------------------------------------------------------------------------		
	//Constructor
    public Container() {}

    public Container(ArrayList<Double> bcontainersize, int bcontainercost,
    		ArrayList<Double> scontainersize, int scontainercost_s_weigth, 
    		int scontainercost_h_weight) {
    	
        this.bcontainersize = bcontainersize;
        this.bcontainercost = bcontainercost;
        this.scontainersize = scontainersize;
        this.scontainercost_s_weigth = scontainercost_s_weigth;
        this.scontainercost_h_weight = scontainercost_h_weight;
    }
    /*since all values are private of course we need to create an empty constructor and one with
     the this. keyword so the values can be accessed*/
//-----------------------------------------------------------------------------------------------		   
	//Setters and getters
	//get the big container size (length, width, height)
	public ArrayList<Double> getBcontaienersize() {
		return this.bcontainersize;}
	//get the big container cost 
	public int getBcontainercost() {
		return this.bcontainercost;}

	
	//get the small container size (length, width, height)
	public ArrayList<Double> getScontainersize() {
		return scontainersize;}
	//get the small container cheapest cost 
	public int getScontainercost_s_weigth() {
		return scontainercost_s_weigth;}
	//get the small container most expensive cost 
	public int getScontainercost_h_weight() {
		return scontainercost_h_weight;}
	
	/*In this case, only the getters are generated for the reasons given in the attributes,
	 if the values like size and cost of the containers remain constant and cannot be altered
	 by the client, then there is no reason to generate setters*/

//-----------------------------------------------------------------------------------------------		
	//Methods
	//method for the containers volume (implemented from abstract class Calculate)
	public double Bcontainervol() {
		double bcv=this.bcontainersize.get(0)*this.bcontainersize.get(1)*this.bcontainersize.get(2);
		return bcv;
	}

	public double Scontainervol() {
		double scv=this.scontainersize.get(0)*this.scontainersize.get(1)*this.scontainersize.get(2);
		return scv;
	}
	/*Both of the methods are to calculate and return the volume of both big and small 
	 containers by multiplying each sizes*/
	
	
	//method to print info of both containers (implemented from abstract class Calculate)
	public void Bcontainerinfo() {
		System.out.println("----------------------------------");
		System.out.println("Big container");
		System.out.println("-Size= "+this.bcontainersize.get(0)+"m x "+this.bcontainersize.get(1)+"m x "+this.bcontainersize.get(2)+"m");
		System.out.println("-Price= "+1800+" euros regardless of weight");
		System.out.println("-Available volume= "+Bcontainervol()+"m3");
	}
	
	public void Scontainerinfo() {
		System.out.println("----------------------------------");
		System.out.println("Small container");
		System.out.println("-Size= "+this.scontainersize.get(0)+"m x "+this.scontainersize.get(1)+"m x "+this.scontainersize.get(2)+"m");
		System.out.println("-Price= "+1000+" euros if weight<="+500+"kg, but if weight>"+500+"kg then "+1200+" euros");
		System.out.println("-Available volume= "+Scontainervol()+"m3");
	}
	/*These methods are simply to print the information regarding both type of containers*/
	
	
//-----------------------------------------------------------------------------------------------		
	//Abstract methods required to be implemented but not useful to this class
	@Override
	public void iteminfo() {// TODO Auto-generated method stub
		}
	@Override
	public double itemvol() {// TODO Auto-generated method stub
		return 0;}
	/*These are just the unuseful methods to this class but that must be implemented here, 
	 however,are useful to the Item class*/
	
	
	
}
