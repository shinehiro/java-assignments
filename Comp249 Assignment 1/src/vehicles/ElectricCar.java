// ---------------------------------------------------------
// Assignment 1
// Written by: Neil Bryan Tchuangou, SID : 40316930
// For COMP 249 Section S – Winter 2025
// ---------------------------------------------------------

package vehicles;

public class ElectricCar extends Car{
	
	// ATTRIBUTES
	// plateNumber, make, model, year, isLeased and maxPassengers is inherited.
	protected int maxAutonomyRange;
	
	
	// CONSTRUCTORS
	public ElectricCar() {
		super();
		this.maxAutonomyRange = 0;
	}
	
	public ElectricCar(String make, String model, int productionYear, int maxPassengers, int maxAutonomyRange) {
		super(make, model, productionYear, maxPassengers);
		this.maxAutonomyRange = maxAutonomyRange;
		this.plateNumber = generatePlateNumber();
	}
	
	public ElectricCar(ElectricCar other) {
		super(other.make, other.model, other.productionYear, other.maxPassengers);
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
		return "\nElectric Car: \n" +
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

        // if yes, cast it to Car and compare
        ElectricCar otherElectricCar = (ElectricCar) otherObject;
        
        if (this.plateNumber.equals(otherElectricCar.plateNumber) && this.make.equals(otherElectricCar.make) && this.model.equals(otherElectricCar.model)
        		&& this.productionYear == otherElectricCar.productionYear && this.maxPassengers == otherElectricCar.maxPassengers && this.maxAutonomyRange == otherElectricCar.maxAutonomyRange)
        {
            return true;
        } else {
            return false;
        }    
	}
	
	// OTHER METHODS
	protected String generatePlateNumber() {
		counter++;
		return "EC" + (counter);
		
	}
	

}
