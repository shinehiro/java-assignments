// ---------------------------------------------------------
// Assignment 1
// Written by: Neil Bryan Tchuangou, SID : 40316930
// For COMP 249 Section S – Winter 2025
// ---------------------------------------------------------
package vehicles;

public class Vehicle {
	// ATTRIBUTES
	protected String plateNumber;
	protected String make;	
	protected String model;
	protected int productionYear;
	protected boolean isLeased = false; //by default, all vehicles aren't leased.
	protected static int counter = 1000; 
	
	// CONSTRUCTORS
	public Vehicle() { // Default constructor.
		this.plateNumber = "";
		this.make = "Unknown";
		this.model = "Unknown";
		this.productionYear = 0;
	}
	
	public Vehicle(String make, String model, int productionYear) { // Parameterized constructor.
		this.plateNumber = generatePlateNumber();
		this.make = make;
		this.model = model;
		this.productionYear = productionYear;
	}
	
	public Vehicle(Vehicle other) { // Copy constructor, copies only the attributes, not the lease status.
		this.plateNumber = generatePlateNumber();
		this.make = other.make;
		this.model = other.model;
		this.productionYear = other.productionYear;
	}
	
	// GETTERS AND SETTERS
	public String getPlateNumber() {
		return this.plateNumber;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public int getProductionYear() {
		return this.productionYear;
	}
	
	public boolean getLeaseStatus() {
		return this.isLeased;
	}
	
	public void newPlateNumber() {
		this.plateNumber = generatePlateNumber();
	}
	
	public void setPlateNumber(int customCounter) {
		this.plateNumber = generatePlateNumber(customCounter);
	}
	
	public void setMake(String newMake) {
		this.make = newMake;
	}
	
	public void setModel(String newModel) {
		this.model = newModel;
	}
	
	public void setYear(int newYear) {
		this.productionYear = newYear;
	}
	
	// instead of setting lease status manually, we have methods to lease and return to implement in a leasing class.
	public void leaseVehicle() { 
		this.isLeased = true;
	}
	
	public void returnVehicle() {
		this.isLeased = false;
	}
	
	// toString() and equals()
	@Override
	public String toString() {
		return  "\nPlate: " + this.plateNumber +
				"\nMake: " + this.make +
				"\nModel: " + this.model +
				"\nYear: " + this.productionYear;
	}
	
	  @Override
	    public boolean equals(Object otherObject) { 
	        if (otherObject == null) {
	            return false;
	        }
	        if (this.getClass() != otherObject.getClass()) {
	            return false;
	        }

	        // if yes, cast it to Vehicle and compare
	        Vehicle otherVehicle = (Vehicle) otherObject;

	        // Now, compare
	        if (this.plateNumber.equals(otherVehicle.plateNumber) && this.make.equals(otherVehicle.make) && this.model.equals(otherVehicle.model)
	        		&& this.productionYear == otherVehicle.productionYear) {
	            return true;
	        } else {
	            return false;
	        }
	    }
	
	// OTHER METHODS
	protected String generatePlateNumber() {
		counter++;
		return "VT" + (counter);
	}


	protected String generatePlateNumber(int customCounter) {
		return "VT"+ (customCounter);
	}
	
}
