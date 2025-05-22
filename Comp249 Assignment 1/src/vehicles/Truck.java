package vehicles;

public class Truck extends Vehicle {
	
	// ATTRIBUTES
	protected int maxWeightCapacity;
	
	// CONSTRUCTORS
	public Truck() {
		super();
		this.plateNumber = "";
		this.maxWeightCapacity = 0;
	}
	
	public Truck(String make, String model, int productionYear, int maxWeightCapacity) {
		super(make, model, productionYear);
		this.maxWeightCapacity = maxWeightCapacity;
		this.plateNumber = generatePlateNumber();
	}
	
	public Truck(Truck other) {
		super(other.make, other.model, other.productionYear);
		this.maxWeightCapacity = other.maxWeightCapacity;
		this.plateNumber = generatePlateNumber();
	}
	
	// GETTERS AND SETTERS
	public int getMaxWeightCapacity() {
		return this.maxWeightCapacity;
	}
	
	public void setMaxWeightCapacity(int newMaxWeightCapacity) {
		this.maxWeightCapacity = newMaxWeightCapacity;
	}
	
	// toString() and equals()
	@Override
	public String toString() {
		return super.toString() +
				"\nMax Weight Capacity: " + this.maxWeightCapacity;
		
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
        Truck otherTruck = (Truck) otherObject;

        // Now, compare
        if (this.plateNumber.equals(otherTruck.plateNumber) && this.make.equals(otherTruck.make) && this.model.equals(otherTruck.model)
        		&& this.productionYear == otherTruck.productionYear && this.maxWeightCapacity == otherTruck.maxWeightCapacity) {
            return true;
        } else {
            return false;
        }
	}
	
	// OTHER METHODS

	@Override
	protected String generatePlateNumber() {
		return "TT" +  (counter++);
	}

	

}
