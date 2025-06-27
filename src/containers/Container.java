package containers;
import java.util.ArrayList;
import java.util.Arrays;

import methods.Calculation;

//SEBASTIAN RUSSO
public class Container extends Calculation{
		
	//Attributes for containers (fixed values)
	//big container
	private ArrayList<Double> big_container_measures = new ArrayList<>(Arrays.asList(2.59, 2.43, 12.01));
	private int big_container_cost = 1800;
	
	//small containers
	private ArrayList<Double> small_container_measures = new ArrayList<>(Arrays.asList(2.59, 2.43, 6.06));
	private int small_cheap_container_cost = 1000;
	private int small_expensive_container_cost = 1200;
	
	//Constructor
	public Container() {}; //Default container to instantiate without passing parameters

    public Container(ArrayList<Double> big_container_measures , 
					int big_container_cost,
					ArrayList<Double> small_container_measures, 
					int small_cheap_container_cost, 
					int small_expensive_container_cost) {

        this.big_container_measures  = big_container_measures;
        this.big_container_cost = big_container_cost;
        this.small_container_measures = small_container_measures;
        this.small_cheap_container_cost = small_cheap_container_cost;
        this.small_expensive_container_cost = small_expensive_container_cost;
    }

	//Setters and getters
	//get the big container size (length, width, height)
	public ArrayList<Double> get_big_container_measures() {
		return this.big_container_measures ;}
	//get the big container cost 
	public int get_big_container_cost() {
		return this.big_container_cost;}

	//get the small container size (length, width, height)
	public ArrayList<Double> get_small_container_measures() {
		return small_container_measures;}
	//get the small container cheapest cost 
	public int get_small_cheap_container_cost() {
		return small_cheap_container_cost;}
	//get the small container most expensive cost 
	public int get_small_expensive_container_cost() {
		return small_expensive_container_cost;}

//-----------------------------------------------------------------------------------------------		
	//Methods
	//method for the containers volume (implemented from abstract class Calculate)
	public double big_container_vol() {
		/*
		* Calculate and return the volume of big container by multiplying each 
		* measure
		*/
		double big_container_volume = (this.big_container_measures.get(0)
					* this.big_container_measures .get(1)
					* this.big_container_measures .get(2));
		return big_container_volume;
	}

	public double small_container_vol() {
		/*
		* Calculate and return the volume of small containers by multiplying each 
		* measure
		*/
		double small_container_vol = (this.small_container_measures.get(0)
									* this.small_container_measures.get(1)
									* this.small_container_measures.get(2));
		return small_container_vol;
	}

	//method to print info of both containers (implemented from abstract class Calculate)
	public void big_container_info() {
		/*
		 * Print the information regarding big containers
		 */
		System.out.println("----------------------------------");
		System.out.println("Big container");
		System.out.println("-Size= "+this.big_container_measures .get(0)+"m x "+this.big_container_measures .get(1)+"m x "+this.big_container_measures .get(2)+"m");
		System.out.println("-Price= "+1800+" euros regardless of weight");
		System.out.println("-Available volume= "+big_container_vol()+"m3");
	}
	
	public void small_container_info() {
		/*
		 * Print the information regarding small containers
		 */
		System.out.println("----------------------------------");
		System.out.println("Small container");
		System.out.println("-Size= "+this.small_container_measures.get(0)+"m x "+this.small_container_measures.get(1)+"m x "+this.small_container_measures.get(2)+"m");
		System.out.println("-Price= "+1000+" euros if weight <= "+500+"kg, but if weight > "+500+"kg then "+1200+" euros");
		System.out.println("-Available volume= "+small_container_vol()+"m3");
	}
	
//-----------------------------------------------------------------------------------------------		
	//Abstract methods required to be implemented but not useful to this class
	@Override
	public void item_info() {
		}
	@Override
	public double item_vol() {
		return 0;}
/*These are just the Unused methods to this class but that must be implemented here, 
however,are useful to the Item class*/
}
