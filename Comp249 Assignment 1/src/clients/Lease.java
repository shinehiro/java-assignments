package clients;

import vehicles.*;

public class Lease {
	
	// ATTRIBUTES
	protected Client client;
	protected Vehicle vehicle;
	private int leaseDuration; //in months.
	private String leaseID;
	private static int counter;
	
	// CONSTRUCTORS
	public Lease() {
		this.client = null;
		this.vehicle = null;
		this.leaseDuration = 0;
		this.leaseID = "";
	}
	
	public Lease(Client client, Vehicle vehicle, int leaseDuration) {
		this.client = client;
		client.addLease(this);
		this.vehicle = vehicle;
		vehicle.leaseVehicle();
		this.leaseDuration = leaseDuration;
		this.leaseID = generateLeaseID();
		
	}
	
	public Lease(Lease other) {
		this.client = other.client;
		this.vehicle = other.vehicle;
		this.leaseDuration = other.leaseDuration;
		this.leaseID = other.leaseID;
	}
	
	// GETTERS AND SETTERS
	public Client getClient() {
		return this.client;
	}
	
	public Vehicle getVehicle() {
		return this.vehicle;
	}
	
	public int getLeaseDuration() {
		return this.leaseDuration;
	}
	
	public void setClient (Client otherClient) {
		this.client = otherClient;
	}
	
	public void setVehicle (Vehicle otherVehicle) {
		this.vehicle = otherVehicle;
	}
	
	public void setLeaseDuration(int newLeaseDuration) {
		this.leaseDuration = newLeaseDuration;
	}
	
	// toString() and equals()
	public String toString() {
		return "\n" + this.leaseID +
				"\nClient: " + this.client.name +
				this.vehicle.toString();
				
	}
	
	public boolean equals(Object otherObject) {
	    // Check for same object
	    if (this == otherObject) return true;

	    // Check for same class
	    if (otherObject == null || getClass() != otherObject.getClass()) return false;

	    // If yes, cast to Lease
	    Lease otherLease = (Lease) otherObject;

	    // Now, compare.
	    return this.leaseDuration == otherLease.leaseDuration &&
	           (client != null ? client.equals(otherLease.client) : otherLease.client == null) &&
	           (vehicle != null ? vehicle.equals(otherLease.vehicle) : otherLease.vehicle == null);
	}

	
	// OTHER METHODS
	private String generateLeaseID() {
		return "L" + ++counter;
	}

}
