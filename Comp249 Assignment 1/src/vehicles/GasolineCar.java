// ---------------------------------------------------------
// Assignment 1
// Written by: Neil Bryan Tchuangou, SID : 40316930
// For COMP 249 Section S – Winter 2025
// ---------------------------------------------------------

package vehicles;

public class GasolineCar extends Car {
	
	// ATTRIBUTES
	// plateNumber, make, model, year, isLeased and maxPassengers is inherited.

	
	// CONSTRUCTORS
	public GasolineCar() {
		super();
		this.plateNumber = "Default";
	}

	public GasolineCar(String make, String model, int productionYear, int maxPassengers) {
		super(make, model, productionYear, maxPassengers);
		this.plateNumber = generatePlateNumber();
	}

	public GasolineCar(Car other) {
		super(other);
		this.plateNumber = generatePlateNumber();
	}
	// GETTERS AND SETTERS
	
	// relevant methods are already implemented.
	
	// toString() and equals()
	@Override
	public String toString() {
		return "\nGasoline Car: \n" +
				super.toString();
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
        GasolineCar otherCar = (GasolineCar) otherObject;

        // Now, compare
        if (this.plateNumber.equals(otherCar.plateNumber) && this.make.equals(otherCar.make) && this.model.equals(otherCar.model)
        		&& this.productionYear == otherCar.productionYear && this.maxPassengers == otherCar.maxPassengers) {
            return true;
        } else {
            return false;
        }
	}
	
	// OTHER METHODS
	protected String generatePlateNumber() {
		counter++;
		return "GC"+ (counter);
	}
}
