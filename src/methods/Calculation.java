package methods;
import java.util.ArrayList;

//SEBASTIAN RUSSO
public abstract class Calculation{
	
//-----------------------------------------------------------------------------------------------	
	//Methods
	//Add an order
	public ArrayList<Object> addorder() {
		int orderid=(int) (Math.random() * 900000) + 100000;
		ArrayList<Object> orderlist=new ArrayList<>();
		
		orderlist.add(orderid);
		
		System.out.println("----------------------------------");
		System.out.println("Add order: "+orderid);
		return orderlist;
	}
	/*This methods generates an empty list that is inmediately added a random unique id for the 
	order, so the user is supposed to create a value equal to this method so this empty list can
	be updated as the user uses all the other methods*/
//-----------------------------------------------------------------------------------------------	
	//Add items to the order in an empty list
	public void additems (ArrayList<Object>orderlist,int quantity,ArrayList<Object>entereditemlist) {
		 if (!orderlist.isEmpty()&& quantity>0 && !entereditemlist.isEmpty()){
			 orderlist.add(quantity);
			 orderlist.add(entereditemlist);  
			 System.out.println("-Added item= "+quantity+"x "+entereditemlist.get(0));
		 } else {
			 System.out.println("INVALID VALUES ENTERED!, make sure the Order's List, the Quantity and the Item's list have values");
		 }
	}	
	/*This methods accepts the list that was created with the addorder method, the amount of items
	 that the user wants to enter and a list with the information of the item that must be created
	 with the createitemlist method in the Item class, so then the quantity and the list of the 
	 item is saved within the empty list to be used in the next methods. As shown in the if 
	 statement, it checks if the entered parameters are valid or not*/
//-----------------------------------------------------------------------------------------------	
	//Calculate total volume of the shipment
	public double totalvol(ArrayList<Object>filleditemslist) {
		double totalvol=0.0;
		for (int i = 1; i < filleditemslist.size(); i =i+2) {
            ArrayList<Object> innerlistgetter = (ArrayList<Object>)filleditemslist.get(i + 1);
            double volume = ((int) filleditemslist.get(i) * ((double) innerlistgetter.get(1)
                    * (double) innerlistgetter.get(2) * (double) innerlistgetter.get(3)))/1000000.0;
            totalvol= totalvol+volume;
        }

		return totalvol;
	}
	/*Once all items are added to the list with the additems method, this method simply asks for 
	 the aforementioned list and then access the quantity and the size values of each saved item
	 so the total volume of the whole shipment can be calculated and returned with a for loop that
	 checks the specific indexes given that the list it always follows the structure 
	 quantity-list-quatity-list-quantity-list...*/
//-----------------------------------------------------------------------------------------------		
	//Calculate total weight of the shipment
	public double totalweight(ArrayList<Object>filleditemslist) {
		double totalweight=0.0;
		for (int i = 1; i < filleditemslist.size(); i =i+2) {
            ArrayList<Object> innerArrayList = (ArrayList<Object>)filleditemslist.get(i + 1);
            double volume = ((int) filleditemslist.get(i) * (double) innerArrayList.get(4));
            totalweight= totalweight+volume;
        }
		
		return totalweight;
	}
	/*Does the same as the totalvol method but with the purpose of calculating and returning 
	 the total weight of the whole shipment, hence why both are almost the same but obviously 
	 with the needed changes*/
//-----------------------------------------------------------------------------------------------		
	//Calculate weight:volume ratio of the shipment
	public double vwratio(double totalvol, double totalweight) {
		double ratio=totalweight/totalvol;
		return ratio;
	}
	/*This is a method i decided to create to calculate the best shipping, what it does is simply
	 calculate the ratio of how many kg are there for each unit of m3 (1m3:?kg) by using the 
	 results of the totalvol and the totalweight methods and returning the said ratio*/
//-----------------------------------------------------------------------------------------------		
	//Calculate Best Shipping
	public ArrayList<String> bestship(double totalvol,double totalweight,double bcontainervol,double scontainervol,double vwratio) {
	    ArrayList<String> neededcontainers=new ArrayList<>();
	    double remvol=totalvol;
	    double remweight=totalweight;

	    //Check how many big containers are required
	    for (double i=bcontainervol;i<totalvol;i=i+bcontainervol) {
	    	neededcontainers.add("Big Container");
	    	remvol=remvol-bcontainervol;
	    	remweight=remvol*vwratio;
	    }
	    
	    //Check how many small containers are required and which price
	    if (remvol>scontainervol) {
	    	for (double i=scontainervol;i<remvol;i=i+scontainervol) {
	    		if(remweight<=500) {
	    			neededcontainers.add("Small Container (cheap)");
	    			remvol=remvol-scontainervol;
	    			remweight=remvol*vwratio;
	    		}
	    		else {
	    			neededcontainers.add("Small Container (expensive)");
	    			remvol=remvol-scontainervol;
	    			remweight=remvol*vwratio;
	    		}
	    	}
	    }
	    
	    if (remvol<=scontainervol && remweight<=500) {
	    	neededcontainers.add("Small Container (cheap)");
	    	remvol=remvol-scontainervol;
			remweight=remvol*vwratio;
	    } 
	    
	    if (remvol<=scontainervol && remweight>500){
	    	neededcontainers.add("Small Container (expensive)");
	    	remvol=remvol-scontainervol;
			remweight=remvol*vwratio;
	    }
	    
	    //print each required container
	    System.out.println("----------------------------------");
	    System.out.println("Best shipping requires:");
	    for (int i=0;i<neededcontainers.size();i=i+1) {
	    	System.out.println("-1 x "+neededcontainers.get(i));
	    }
	    
	    return neededcontainers;
	}
	/*This method is pretty long and complicated. Basically asks for the total volume and weight 
	 of the shipment, the total volume of both big and small containers and the ratio 
	 volume:weight in order to generate and return a list of strings where each string represents 
	 a kind of container (big, small cheap or small expensive) to be used in another method. 
	 
	 By using a for loop we first check how many big containers are required and each time a 
	 big container is added then the volume of the said big container substracts the total 
	 volume of the shipment and subtracting the total weight of the shipment (by using the ratio).
	 
	 Then we check using if statements to check how many and which kind of small containers are 
	 required by using a modified version of the previous for loop and inserted within an if 
	 statement and taking into account the weight since according to it the value of a small
	 container will change.
	 
	 The reasoning behind this is that the bigger in volume the shipment the cheapest it will be
	 to ship it, hence why we check first if we can use big containers, but it also takes into 
	 account that maybe small containers are a better option*/
//-----------------------------------------------------------------------------------------------		
	//Calculate shipping price
	public int totalprice(ArrayList<String> bestship) {
		int totalprice=0;
		
		for (int i=0;i<bestship.size();i=i+1) {
			if(bestship.get(i)=="Big Container") {
				totalprice=totalprice+1800;
			}
			if (bestship.get(i)=="Small Container (cheap)") {
				totalprice=totalprice+1000;
			}
			if(bestship.get(i)=="Small Container (expensive)") {
				totalprice=totalprice+1200;
			}
		}
		
		System.out.println("----------------------------------");
		System.out.println("For a total of: "+totalprice+" euros");
		
		return totalprice;
	}
	/*This method asks for the arraylist generated by the bestship method and then by using a
	 local variable and a for loop, it checks each string within the provided list and according
	 to which string is presented, it will add a specific value to the local variable and then
	 return the total price of the shipment according to the containers that are required*/
//-----------------------------------------------------------------------------------------------
	//Print item's info
	public void itemsinfo(ArrayList<Object> finallist) {
		System.out.println("----------------------------------");
		System.out.println("-Items within the shipment: ");
		for (int i = 1; i < finallist.size(); i =i+2) {
            System.out.print(finallist.get(i));
            
            ArrayList<Object> innerList = (ArrayList<Object>) finallist.get(i + 1);
            System.out.print("x "+innerList.get(0));
            System.out.print(" of "+(((double)innerList.get(1)*(double)innerList.get(2)*
            		(double)innerList.get(3))/1000000)+" m3 each box (");
            System.out.print(innerList.get(1)+"x"+innerList.get(2)+"x"+innerList.get(3)+")");
            System.out.println(" and a weight of "+innerList.get(4)+"kg each box");
        }
	}
	/*This method simply has the function of printing the relevant information of all the items
	within the shipment, by using a for loop that searches within the final list with all the 
	items that are supposed to be shipped, it retrieves the information store within it*/
//-----------------------------------------------------------------------------------------------	
	//Print order info
	public void orderinfo(ArrayList<Object> finallist,double totalvol,double totalweight,ArrayList<String> bestship,int totalprice) {
		System.out.println("----------------------------------");
		System.out.println("Order "+finallist.get(0)+" information");
		
		System.out.println("-Order ID: "+finallist.get(0));
		
		//Shipment information
		System.out.print("-Items within the shipment: ");
		for (int i = 1; i < finallist.size(); i =i+2) {
            System.out.print(finallist.get(i));
            
            ArrayList<Object> innerList = (ArrayList<Object>) finallist.get(i + 1);
            System.out.print("x "+innerList.get(0));
            System.out.print(", ");
        }
		System.out.println("");
		
		//Print shipment volume
		System.out.println("-Total volume of the shipment: "+totalvol+"m3");
		
		//Print shipment weight
		System.out.println("-Total weight of the shipment: "+totalweight+"kg");
		
		//Required containers
		System.out.print("-Required containers: ");
		//Big containers
		int amount1=0;
		for(int i=0;i<bestship.size();i=i+1) {
			if (bestship.get(i)=="Big Container") {
				amount1= amount1+1;
			}
		}
		if(amount1>1) {
			System.out.print(amount1+" Big containers");
		} else {
			if(amount1==1) {
				System.out.print(amount1+" Big container");
			} else {
				System.out.print("No Big containers");
			}
		}
		
		//Cheap small containers
		int amount2=0;
		for(int i=0;i<bestship.size();i=i+1) {
			if (bestship.get(i)=="Small Container (cheap)") {
				amount2= amount2+1;
			}
		}
		if(amount2>1) {
			System.out.print(", ");
			System.out.print(amount2+" Small Container (cheap)");
		} else {
			if(amount2==1) {
				System.out.print(", ");
				System.out.print(amount2+" Small Container (cheap)");
			} else {
				System.out.print(", No Small Container (cheap)");
			}
		}
		
		//Expensive small containers
		int amount3=0;
		for(int i=0;i<bestship.size();i=i+1) {
			if (bestship.get(i)=="Small Container (expensive)") {
				amount3= amount3+1;
			}
		}
		if(amount3>1) {
			System.out.print(" and ");
			System.out.print(amount3+" Small Container (expensive)");
		} else {
			if(amount3==1) {
				System.out.print(" and ");
				System.out.print(amount3+" Small Container (expensive)");
			} else {
				System.out.print(" and No Small Container (expensive)");
			}
		}
		System.out.println("");
		//
		
		//print total price of the shipment
		System.out.println("-Total price of the shipment: "+totalprice+" Euros");
		
	}
	
	/* This method simply prints all the relevant information of the order, by asking the results
	of many of the previous methods to print, it was necessary to use some for loops and if 
	statements to achieve a specific way of printing*/
//-----------------------------------------------------------------------------------------------		
	//Abstract methods
	//Print single item info
	public abstract void iteminfo();
	//Calculate single item volume
	public abstract double itemvol();
	
	//Print container info
	public abstract void Bcontainerinfo();
	public abstract void Scontainerinfo();
	//Print container capacity
	public abstract double Bcontainervol();	
	public abstract double Scontainervol();	
	
	/*this are all the methods that the other 2 classes are supposed to finish, however, only a 
	 portion of these abstract methods are actually useful to each class, so the ones that are
	 not useful are simply overridden to do nothing*/

	
	
}
