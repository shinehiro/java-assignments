// ---------------------------------------------------------
// Assignment 1
// Written by: Neil Bryan Tchuangou, SID : 40316930
// For COMP 249 Section S – Winter 2025
// ---------------------------------------------------------

package vehicles;

public class ElectricTruck extends Truck {
	
	// ATTRIBUTES
	protected int maxAutonomyRange;
	
	
	// CONSTRUCTORS
	public ElectricTruck() {
		super();
		this.maxAutonomyRange = 0;
	}
	
	public ElectricTruck(String make, String model, int productionYear, int maxWeightCapacity, int maxAutonomyRange) {
		super(make, model, productionYear, maxWeightCapacity);
		this.maxAutonomyRange = maxAutonomyRange;
		this.plateNumber = generatePlateNumber();
	}
	
	public ElectricTruck(ElectricTruck other) {
		super(other.make, other.model, other.productionYear, other.maxWeightCapacity);
		this.maxAutonomyRange = other.maxAutonomyRange;
		this.plateNumber = other.plateNumber;
	}
	// GETTERS AND SETTERS
	public int getMaxAutonomyRange() {
		return this.maxAutonomyRange;
	}
	
	public void setMaxAutonomyRange(int newMaxAutonomyRange) {
		this.maxAutonomyRange = newMaxAutonomyRange;
	}
	
	// toString() and equals()
	@Override
	public String toString() {
		return "\nElectric Truck: \n" +
				super.toString() + 
				"\nMax Autonomy Range: " + this.maxAutonomyRange;
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
        ElectricTruck otherElectricTruck = (ElectricTruck) otherObject;

        // Now, compare
        if (this.plateNumber.equals(otherElectricTruck.plateNumber) && this.make.equals(otherElectricTruck.make) && this.model.equals(otherElectricTruck.model)
        		&& this.productionYear == otherElectricTruck.productionYear && this.maxWeightCapacity == otherElectricTruck.maxWeightCapacity && this.maxAutonomyRange == otherElectricTruck.maxAutonomyRange) {
            return true;
        } else {
            return false;
        }
	}
	
	// OTHER METHODS


	@Override
	protected String generatePlateNumber() {
		return "ET" + (counter++);
	}

}


