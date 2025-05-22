// ---------------------------------------------------------
// Assignment 1
// ---------------------------------------------------------

package vehicles;

public class Car extends Vehicle {
	// plateNumber, make, model, year, isLeased is inherited.
	protected int maxPassengers;
	
	// CONSTRUCTORS
	public Car() {
		super();
		this.maxPassengers = 0;
		this.plateNumber = "";
	}
	
	public Car(String make, String model, int productionYear, int maxPassengers) {
		super(make, model, productionYear);
		this.maxPassengers =  maxPassengers;
		this.plateNumber = generatePlateNumber();
	}
	
	public Car(Car other) {
		super(other.make, other.model, other.productionYear);
		this.maxPassengers = other.maxPassengers;
	}
	
	// GETTERS AND SETTERS
	public int getMaxPassengers() {
		return this.maxPassengers;
	}
	
	public void setMaxPassengers(int newMaxPassengers) {
		this.maxPassengers = newMaxPassengers;
	}
	
	// toString() and equals()
	@Override
	public String toString() {
		return super.toString() + 
		"\nMax Passengers: " +  this.maxPassengers;
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
        Car otherCar = (Car) otherObject;

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
		return "CC" + (counter);
	}
	
	
}
