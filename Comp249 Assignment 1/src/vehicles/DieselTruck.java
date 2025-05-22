// ---------------------------------------------------------
// Assignment 1
// Written by: Neil Bryan Tchuangou, SID : 40316930
// For COMP 249 Section S – Winter 2025
// ---------------------------------------------------------

package vehicles;

public class DieselTruck extends Truck{
	
	// ATTRIBUTES
	protected int maxFuelCapacity;
	
	
	// CONSTRUCTORS
	public DieselTruck() {
		super();
		this.maxFuelCapacity = 0;
	}
	
	public DieselTruck(String make, String model, int productionYear, int maxWeightCapacity, int maxFuelCapacity) {
		super(make, model, productionYear, maxWeightCapacity);
		this.maxFuelCapacity = maxFuelCapacity;
		this.plateNumber = generatePlateNumber();
	}
	
	public DieselTruck(DieselTruck other) {
		super(other.make, other.model, other.productionYear, other.maxWeightCapacity);
		this.maxFuelCapacity = other.maxFuelCapacity;
		this.plateNumber = other.plateNumber;
	}
	
	// GETTERS AND SETTERS
	public int getMaxFuelCapacity() {
		return this.maxFuelCapacity;
	}
	
	public void setMaxFuelCapacity(int newMaxFuelCapacity) {
		this.maxFuelCapacity = newMaxFuelCapacity;
	}
	
	// toString() and equals()
	@Override
	public String toString() {
		return "\nDiesel Truck: \n" +
				super.toString() + 
				"\nMax Fuel Capacity : " + maxFuelCapacity;
	}
	
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
            return false;
        }
        if (this.getClass() != otherObject.getClass()) {
            return false;
        }

        // if yes, cast it to Vehicle and compare
        DieselTruck otherDieselTruck = (DieselTruck) otherObject;

        // Now, compare
        if (this.plateNumber.equals(otherDieselTruck.plateNumber) && this.make.equals(otherDieselTruck.make) && this.model.equals(otherDieselTruck.model)
        		&& this.productionYear == otherDieselTruck.productionYear && this.maxWeightCapacity == otherDieselTruck.maxWeightCapacity && this.maxFuelCapacity == otherDieselTruck.maxFuelCapacity) {
            return true;
        } else {
            return false;
        }	
	}
	
	// OTHER METHODS
	protected String generatePlateNumber() {
		counter++;
		return "DT"+ (counter);
	}
}
