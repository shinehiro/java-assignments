// ---------------------------------------------------------
// Assignment 1
// Written by: Neil Bryan Tchuangou, SID : 40316930
// For COMP 249 Section S – Winter 2025
// ---------------------------------------------------------

package clients; 

public class Client {
	
	// ATTRIBUTES
	protected String name;
	protected String id;
	private Lease[] leases;
	private int leaseCount;
	private static final int MAX_LEASES = 10; //change this number to set the maximum number of leases per client.
	private static int counter = 0;
	
	// CONSTRUCTORS
	public Client() {
		this.name = "Default Name";
		this.id = generateID();
		this.leases = new Lease[MAX_LEASES];
		this.leaseCount = 0;
	}
	
	public Client(String name) {
		this.name = name;
		this.id = generateID();
		this.leases = new Lease[MAX_LEASES];
		this.leaseCount = 0;
	}
	
	public Client(Client other) {
		this.name = other.name;
		this.id = other.id;
		this.leases = new Lease[MAX_LEASES];
		for (int i = 0; i < other.leaseCount ; i++) {
			Lease otherLease = other.leases[i];
			this.leases[i] = new Lease(otherLease.getClient(), otherLease.getVehicle(), otherLease.getLeaseDuration());
		}
	}
	
	// LEASING OPERATIONS
	public void addLease(Lease lease) {
		this.leases[leaseCount] = lease;
	}
	
	public void removeLease(int index) {
		//check for invalid index size
		if (index < 0 || index >= this.leases.length) {
			System.out.println("Invalid index!");
			return;
		}
		
		//shift elements left
		for(int i  = index; i < (leases.length - 1); i++) {
			leases[i] = leases[i+1];
		}
		
		leases[leases.length - 1] = null;
	}
	
	public Lease[] getLeases() {
		return this.leases;
	}
	
	// GETTERS AND SETTERS
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void setID(String newID) {
		this.id = newID;
	}
	
	public void createNewID() {
		this.id = generateID();
	}
	
	
	
	// toString() and equals()
	public String toString() {
		return "\nClient Name: " + this.name +
				"\nClient ID: " + this.id;
		
	}
	
	public boolean equals(Object otherObject) {
		if (otherObject == null) {
            return false;
        }
        if (this.getClass() != otherObject.getClass()) {
            return false;
        }

        // if yes, cast it to Client and compare
        Client otherClient = (Client) otherObject;

        // Now, compare
        if (this.name.equals(otherClient.name) && this.id.equals(otherClient.id)) {
            return true;
        } else {
            return false;
        }
	}
	
	// OTHER METHODS
	protected String generateID() {
		return "" + ++counter;
	}
	
	
}
