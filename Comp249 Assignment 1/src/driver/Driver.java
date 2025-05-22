// --------------------------------------------------------
// Assignment 1
// Written by: Neil Bryan Tchuangou, SID : 40316930
// For COMP 249 Section S – Winter 2025
// ---------------------------------------------------------

package driver;
import vehicles.*;
import clients.*;
import java.util.Scanner;

public class Driver {

	static Vehicle[] vehicles = new Vehicle[100];
	static Client[] clients = new Client[100];
	static Lease[] leases = new Lease[100];
	static DieselTruck[] dieselTrucks = new DieselTruck[100];
	static ElectricTruck[] electricTrucks = new ElectricTruck[100];
	
	static int nbOfVehicles = 0;
	static int nbOfClients = 0;		
	static int nbOfLeases = 0;
	static int nbOfDieselTrucks = 0;
	static int nbOfElectricTrucks = 0;
	
	public static void main(String[] args) {
		//initializing...
		
				
		Scanner sc = new Scanner(System.in);
		
		// Welcome message.
		System.out.println("Welcome to the RoyalRentals Management System!");
		
		//prompting for predefined scenario or manual testing via menu
		System.out.println("Choose an option:");
		System.out.println("[1]: Menu-driven interface");
		System.out.println("[2]: Predefined scenario for testing");
		int choice = sc.nextInt();
		
		switch (choice) {
		case 1:
			System.out.println("Option 1 Selected!");
			displayMenu(sc);
			break;
		case 2:
			System.out.println("Option 2 Selected!");
			testScenario();
			break;
		default:
			System.out.println("Invalid Choice! Exiting program.");
			sc.close();
			System.exit(0);
		}
		
		System.out.println("Thank you for using the RoyalRentals Management System!");
		sc.close();
		System.exit(0);		
	}
	
	// the following methods are menu submethods for the sake of organization.
	public static void displayMenu(Scanner sc) {
	    while (true) {
	        System.out.println("\nPlease select an operation:");
	        System.out.println("[1]: Vehicle Management");
	        System.out.println("[2]: Client Management");
	        System.out.println("[3]: Leasing Operations");
	        System.out.println("[4]: Additional Operations");
	        System.out.println("[5]: Exit");

	        int choice = sc.nextInt();
	        sc.nextLine();

	        switch (choice) {
	            case 1:
	                // Goes to Vehicle Management submenu
	                vehicleManagement(sc);
	                break;
	            case 2:
	                // Goes to Client Management submenu
	                clientManagement(sc);
	                break;
	            case 3:
	                // Goes to Leasing Operations submenu
	                leasingOperations(sc);
	                break;
	            case 4:
	                // Goes to Additional Operations submenu
	                additionalOperations(sc);
	                break;
	            case 5:
	                return; // Exit the menu
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }
	}
	
	// vehicle management methods and submethods are next.
	public static void vehicleManagement(Scanner sc) {
	    while (true) {
	        System.out.println("\nVehicle Management:");
	        System.out.println("[1]: Add a vehicle");
	        System.out.println("[2]: Delete a vehicle");
	        System.out.println("[3]: Update vehicle information");
	        System.out.println("[4]: List all vehicles by category");
	        System.out.println("[5]: Return to main menu");

	        int choice = sc.nextInt();
	        sc.nextLine();

	        switch (choice) {
	            case 1:
	                // Call method to add a vehicle
	                addVehicle(sc);
	                break;
	            case 2:
	                // Call method to delete a vehicle
	                deleteVehicle(sc);
	                break;
	            case 3:
	                // Call method to update vehicle information
	            	updateVehicle(sc);
	                break;
	            case 4:
	                // Call method to list vehicles by category
	                listVehiclesByCategory(sc);
	                break;
	            case 5:
	                return; // Return to main menu
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }
	}
	
	public static void addVehicle(Scanner sc) {
	    System.out.println("Enter vehicle type (1. Electric Truck, 2. Diesel Truck, 3. Electric Car, 4. Gasoline Car):");
	    int type = sc.nextInt();
	    sc.nextLine(); // Consume newline
	    if (type > 4 || type < 0)
	    	return;

	    System.out.println("Enter make:");
	    String make = sc.nextLine();

	    System.out.println("Enter model:");
	    String model = sc.nextLine();

	    System.out.println("Enter production year:");
	    int year = sc.nextInt();
	    sc.nextLine();
	    
	    // Entering additional information depending on vehicle type
	    if (type == 1) { // Electric Truck (max weight, max autonomy range)
	    	System.out.println("Enter max weight:");
	    	int maxWeight = sc.nextInt();
	    	sc.nextLine();
	    	
	    	System.out.println("Enter max autonomy range:");
	    	int maxRange = sc.nextInt();
	    	sc.nextLine();
	    	
	    	ElectricTruck newTruck = new ElectricTruck(make, model, year, maxWeight, maxRange);
	    	System.out.println(newTruck.getPlateNumber());
	    	vehicles[nbOfVehicles] = newTruck; // for tracking the array of vehicles.
	    	electricTrucks[nbOfElectricTrucks] = newTruck; // for tracking the array of electric trucks.
	    	nbOfVehicles++; 
	    	nbOfElectricTrucks++;
	    }
	    
	    if (type == 2) { // Diesel Truck (max weight, max fuel capacity)
	    	System.out.println("Enter max weight:");
	    	int maxWeight = sc.nextInt();
	    	sc.nextLine();
	    	
	    	System.out.println("Enter max fuel capacity:");
	    	int maxFuel = sc.nextInt();
	    	sc.nextLine();
	    	
	    	DieselTruck newTruck = new DieselTruck(make, model, year, maxWeight, maxFuel);
	    	vehicles[nbOfVehicles] = newTruck;
	    	dieselTrucks[nbOfDieselTrucks] = newTruck;
	    	nbOfVehicles++;
	    	nbOfDieselTrucks++;
	    }
	    
	    if (type == 3) { // Electric Car (max passengers, max autonomy range)
	    	System.out.println("Enter the maximum number of passengers:");
	    	int maxPassengers = sc.nextInt();
	    	sc.nextLine();
	    	
	    	System.out.println("Enter max autonomy range:");
	    	int maxRange = sc.nextInt();
	    	sc.nextLine();
	    	
	    	ElectricCar newCar = new ElectricCar(make, model, year, maxPassengers, maxRange);
	    	vehicles[nbOfVehicles] = newCar;
	    	nbOfVehicles++;
	    }
	    
	    if (type == 4) { //Gasoline Car (max passengers)
	    	System.out.println("Enter the maximum number of passengers:");
	    	int maxPassengers = sc.nextInt();
	    	sc.nextLine();
	    	
	    	GasolineCar newCar = new GasolineCar(make, model, year, maxPassengers);
	    	vehicles[nbOfVehicles] = newCar;
	    	nbOfVehicles++;
	    }
	    
	    System.out.println("New vehicle added!");
	    return;
	}
	
	public static void deleteVehicle(Scanner sc) {
		
		int selected = 0;
		do {
		    System.out.println("Please input the index of the vehicle array you want to delete:");
		    int index = sc.nextInt();
		    sc.nextLine();

		    if (index < 0 || index >= vehicles.length || vehicles[index] == null) {
		        System.out.println("Invalid index! Null vehicle or out-of-bounds index.");
		    } else {
		        System.out.println("Vehicle found!");
		        System.out.println(vehicles[index]);
		        System.out.println("Is it the vehicle you want to delete?");
		        
		        int input;
		        do {
		            System.out.println("[1]: Delete the vehicle");
		            System.out.println("[2]: Select another index");
		            System.out.println("[3]: Cancel deletion");

		            input = sc.nextInt();
		            sc.nextLine();

		            if (input == 1) {
		                System.out.println("Vehicle deleted successfully.");
		                for(int i  = index; i < (vehicles.length - 1); i++) {
		        			vehicles[i] = vehicles[i+1];
		        		}
		                
		                if (vehicles[index] instanceof ElectricTruck) {
		                	int truckIndex = 0;
		                	for (int i = 0; i < electricTrucks.length; i++) {
		                		if (vehicles[index].getPlateNumber() == electricTrucks[i].getPlateNumber()) {
		                			truckIndex = i;
		                		}
		                	}
		                	
		                	for (int i = truckIndex; i < (electricTrucks.length - 1); i++) {
		                		electricTrucks[i] = electricTrucks[i+1];
		                	}
		                	electricTrucks[electricTrucks.length - 1] = null;
		                }
		                
		                if (vehicles[index] instanceof DieselTruck) {
		                	int truckIndex = 0;
		                	for (int i = 0; i < dieselTrucks.length; i++) {
		                		if (vehicles[index].getPlateNumber() == dieselTrucks[i].getPlateNumber()) {
		                			truckIndex = i;
		                		}
		                	}
		                	
		                	for (int i = truckIndex; i < (dieselTrucks.length - 1); i++) {
		                		dieselTrucks[i] = dieselTrucks[i+1];
		                	}
		                	dieselTrucks[dieselTrucks.length - 1] = null;
		                }
		        		
		        		vehicles[vehicles.length - 1] = null;
		                selected = 1; // Exit the loop after deletion
		            } else if (input == 2) {
		                System.out.println("Please select another index.");
		            } else if (input == 3) {
		                System.out.println("Deletion canceled.");
		                selected = 1; // Exit loop
		            } else {
		                System.out.println("Invalid choice! Please enter 1, 2, or 3.");
		            }
		        } while (input != 1 && input != 3); // Repeat only for invalid inputs
		    }
		} while (selected != 1);

	}

	public static void updateVehicle(Scanner sc) {
	    System.out.println("Enter the plate number of the vehicle you want to update:");
	    String plateNumber = sc.nextLine();

	    // Search for the vehicle by plate number
	    Vehicle vehicleToUpdate = null;
	    for (int i = 0 ; i < vehicles.length ; i++) {
	    	if (vehicles[i] == null)
				continue;
	        if (vehicles[i] != null && vehicles[i].getPlateNumber().equals(plateNumber)) {
	            vehicleToUpdate = vehicles[i];
	            break;
	        }
	    }

	    if (vehicleToUpdate == null) {
	        System.out.println("Vehicle with plate number " + plateNumber + " not found.");
	        return;
	    }

	    // Display current information of the vehicle
	    System.out.println("Current vehicle information:");
	    System.out.println(vehicleToUpdate.toString());

	    // Prompt user for new information
	    System.out.println("Enter new make (or press Enter to keep current):");
	    String newMake = sc.nextLine();
	    if (!newMake.isEmpty()) {
	        vehicleToUpdate.setMake(newMake);
	    }

	    System.out.println("Enter new model (or press Enter to keep current):");
	    String newModel = sc.nextLine();
	    if (!newModel.isEmpty()) {
	        vehicleToUpdate.setModel(newModel);
	    }

	    System.out.println("Enter new year of production (or press Enter to keep current):");
	    String newYearStr = sc.nextLine();
	    if (!newYearStr.isEmpty()) {
	        int newYear = Integer.parseInt(newYearStr);
	        vehicleToUpdate.setYear(newYear);
	    }

	    // Update specific attributes based on vehicle type
	    if (vehicleToUpdate instanceof Truck) {
	        System.out.println("Enter new maximum capacity (or press Enter to keep current):");
	        String newCapacityStr = sc.nextLine();
	        if (!newCapacityStr.isEmpty()) {
	            int newCapacity = Integer.parseInt(newCapacityStr);
	            ((Truck) vehicleToUpdate).setMaxWeightCapacity(newCapacity);
	        }
	    }

	    if (vehicleToUpdate instanceof ElectricTruck) {
	        System.out.println("Enter new maximum autonomy range (or press Enter to keep current):");
	        String newAutonomyStr = sc.nextLine();
	        if (!newAutonomyStr.isEmpty()) {
	            int newAutonomy = Integer.parseInt(newAutonomyStr);
	            ((ElectricTruck) vehicleToUpdate).setMaxAutonomyRange(newAutonomy);
	        }
	    }
	    
	    if (vehicleToUpdate instanceof ElectricCar) {
	        System.out.println("Enter new maximum autonomy range (or press Enter to keep current):");
	        String newAutonomyStr = sc.nextLine();
	        if (!newAutonomyStr.isEmpty()) {
	            int newAutonomy = Integer.parseInt(newAutonomyStr);
	            ((ElectricCar) vehicleToUpdate).setMaxAutonomyRange(newAutonomy);
	        }

	    if (vehicleToUpdate instanceof DieselTruck) {
	        System.out.println("Enter new fuel tank capacity (or press Enter to keep current):");
	        String newFuelTankStr = sc.nextLine();
	        if (!newFuelTankStr.isEmpty()) {
	            int newFuelTank = Integer.parseInt(newFuelTankStr);
	            ((DieselTruck) vehicleToUpdate).setMaxFuelCapacity(newFuelTank);
	        }
	    }

	    if (vehicleToUpdate instanceof Car) {
	        System.out.println("Enter new maximum number of passengers (or press Enter to keep current):");
	        String newPassengersStr = sc.nextLine();
	        if (!newPassengersStr.isEmpty()) {
	            int newPassengers = Integer.parseInt(newPassengersStr);
	            ((Car) vehicleToUpdate).setMaxPassengers(newPassengers);
	        }
	    }

	    System.out.println("Vehicle information updated successfully:");
	    System.out.println(vehicleToUpdate.toString());
	}
}
	
	public static void listVehiclesByCategory(Scanner sc) {
		System.out.println("Select what type of vehicle you want to search:");
		System.out.println("[1]: Cars");
		System.out.println("[2]: Trucks");
		System.out.println("[3]: Gasoline Cars");
		System.out.println("[4]: Electric Cars");
		System.out.println("[5]: Diesel Trucks");
		System.out.println("[6]: Electric Trucks");
		
		int choice = sc.nextInt();
		sc.nextLine();
		int vehiclesFound = 0;
		
		switch (choice) {
		case 1:
			System.out.println("Choice " + choice + " selected!");
			for (int i = 0; i < vehicles.length; i++) {
				if (vehicles[i] instanceof Car) {
					System.out.println(vehicles[i]);
					vehiclesFound++;
				}
				
				if (vehiclesFound == 0) 
					System.out.println("No vehicles of this type found!");
			}
			break;
		case 2:
			System.out.println("Choice " + choice + " selected!");
			for (int i = 0; i < vehicles.length; i++) {
				if (vehicles[i] instanceof Truck) {
					System.out.println(vehicles[i]);
					vehiclesFound++;
				}
			}
			if (vehiclesFound == 0) 
				System.out.println("No vehicles of this type found!");
			
			break;
		case 3:
			System.out.println("Choice " + choice + " selected!");
			for (int i = 0; i < vehicles.length; i++) {
				if (vehicles[i] instanceof GasolineCar) {
					System.out.println(vehicles[i]);
					vehiclesFound++;
				}
			}
			if (vehiclesFound == 0) 
				System.out.println("No vehicles of this type found!");
			break;
		case 4:
			System.out.println("Choice " + choice + " selected!");
			for (int i = 0; i < vehicles.length; i++) {
				if (vehicles[i] instanceof ElectricCar) {
					System.out.println(vehicles[i]);
					vehiclesFound++;
				}
			}
			if (vehiclesFound == 0) 
				System.out.println("No vehicles of this type found!");
			break;
		case 5:
			System.out.println("Choice " + choice + " selected!");
			for (int i = 0; i < vehicles.length; i++) {
				if (vehicles[i] instanceof DieselTruck) {
					System.out.println(vehicles[i]);
					vehiclesFound++;
				}
			}
			if (vehiclesFound == 0) 
				System.out.println("No vehicles of this type found!");
			break;
		case 6:
			System.out.println("Choice " + choice + " selected!");
			for (int i = 0; i < vehicles.length; i++) {
				if (vehicles[i] instanceof ElectricTruck) {
					System.out.println(vehicles[i]);
					vehiclesFound++;
				}
			}
			if (vehiclesFound == 0) 
				System.out.println("No vehicles of this type found!");
			break;
		default:
			System.out.println("Invalid input chosen!");
			break;
		}
	}
	
	// client management methods and submethods are next.
	public static void clientManagement(Scanner sc) {
	    while (true) {
	        System.out.println("\nClient Management:");
	        System.out.println("[1]: Add a client");
	        System.out.println("[2]: Edit a client");
	        System.out.println("[3]: Delete a client");
	        System.out.println("[4]: Return to menu");

	        int choice = sc.nextInt();
	        sc.nextLine();

	        switch (choice) {
	            case 1:
	                // Call method to add a client
	                addClient(sc);
	                break;
	            case 2:
	                // Call method to edit a client
	                editClient(sc);
	                break;
	            case 3:
	                // Call method to delete a client
	            	deleteClient(sc);
	                break;
	            case 4:
	                return; // Return to main menu
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }
	}
	
	public static void addClient(Scanner sc) {
		System.out.println("Enter the Client's name:");
		String clientName = sc.nextLine();
		clients[nbOfClients] = new Client(clientName);
		nbOfClients++;
		System.out.println("Client added.");
	}
	
	public static void editClient(Scanner sc) {
		System.out.println("Enter the client's ID:");
		String searchedID = sc.nextLine();
		boolean foundClient = false;
		int index = 0;
		for (int i = 0; i < clients.length ; i++) {
			if (clients[i] == null)
				continue;
			if (clients[i].getID().equals(searchedID)) {
				index = i;
				System.out.println("Client found!");
				foundClient = true;
				break;
			}
		}
		if (!foundClient) {
			System.out.println("Couldn't find a client by this ID.");
			return;
		}
		
		System.out.println(clients[index]);
		System.out.println("Input the client's new name: ");
		String newName = sc.nextLine();
		clients[index].setName(newName);
		System.out.println("New name set.");
	}
	
	public static void deleteClient(Scanner sc) {
		System.out.println("Enter the ID of the client you want to delete:");
		String searchedID = sc.nextLine();
		boolean foundClient = false;
		int index = 0;
		for (int i = 0; i < clients.length ; i++) {
			if (clients[i] == null)
				continue;
			if (clients[i].getID().equals(searchedID)) {
				index = i;
				System.out.println("Client found!");
				foundClient = true;
				break;
			}
		}
		if (!foundClient) {
			System.out.println("Couldn't find a client by this ID.");
			return;
		}
		
		System.out.println(clients[index]);
		boolean correct = false;
		do {
		System.out.println("Do you want to delete this client?");
		System.out.println("[1]: Yes");
		System.out.println("[2]: No");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			System.out.println("Client deleted successfully.");
            for(int i  = index; i < (clients.length - 1); i++) {
    			clients[i] = clients[i+1];
    		}
    		
    		clients[clients.length - 1] = null;
            correct = true;
		case 2:
			System.out.println("Quitting this menu!");
			break;
		default:
			System.out.println("Invalid choice!");
			break;
		}
		} while (!correct);
	}
	
	// leasing operation methods and submethods are next.
	public static void leasingOperations (Scanner sc) {
		while (true) {
	        System.out.println("\nLeasing Operations:");
	        System.out.println("[1]: Lease a vehicle to a client");
	        System.out.println("[2]: Return a vehicle from a client");
	        System.out.println("[3]: Show all leased vehicles from a client");
	        System.out.println("[4]: Show all leased vehicles");
	        System.out.println("[5]: Return to main menu");

	        int choice = sc.nextInt();
	        sc.nextLine();

	        switch (choice) {
	            case 1:
	                // Call method to lease a vehicle to a client
	                leaseVehicle(sc);
	                break;
	            case 2:
	                // Call method to return a leased vehicle to a client
	            	returnVehicle(sc);
	                break;
	            case 3:
	                // Call method to display leased vehicles from a client
	            	displayClientLeasedVehicles(sc);
	                break;
	            case 4:
	                // Call method to list all leased vehicles
	                displayLeasedVehicles(sc);
	                break;
	            case 5:
	                return; // Return to main menu
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	    }
	}
	
	public static void leaseVehicle(Scanner sc) {
		System.out.println("Enter the plate number of the vehicle you want to lease:");
		String searchedPlateNum = sc.nextLine();
		
		Vehicle vehicleToLease = null;
	    for (int i = 0 ; i < vehicles.length ; i++) {
	    	if (vehicles[i] == null)
				continue;
	        if (vehicles[i] != null && vehicles[i].getPlateNumber().equals(searchedPlateNum)) {
	            vehicleToLease = vehicles[i];
	            break;
	        }
	    }

	    if (vehicleToLease == null) {
	        System.out.println("Vehicle with plate number " + searchedPlateNum + " not found.");
	        return;
	    }
	    
	    if (vehicleToLease.getLeaseStatus() == true) {
	    	System.out.println("This vehicle is already leased.");
	    	return;
	    }
	    
	 // Display current information of the vehicle
	    System.out.println("Current vehicle information:");
	    System.out.println(vehicleToLease.toString());
	   
	    System.out.println("Would you like to lease this vehicle?");
	    System.out.println("[1]: Yes");
	    System.out.println("[2]: No");
	    
	    int choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			System.out.println("Enter the client's ID:");
			String searchedID = sc.nextLine();
			boolean foundClient = false;
			
			int index = 0;
			for (int i = 0; i < clients.length ; i++) {
				if (clients[i] == null)
					continue;
				if (clients[i].getID().equals(searchedID)) {
					index = i;
					System.out.println("Client found!");
					foundClient = true;
					break;
				}
			}
			if (!foundClient) {
				System.out.println("Couldn't find a client by this ID.");
				return;
			}
			
			Client clientToLease = clients[index];
			
			System.out.println(clientToLease);
			
			System.out.println("Do you want to lease this vehicle to this client?");
			System.out.println("[1]: Yes");
			System.out.println("[2]: No");
			
			int confirmation = sc.nextInt();
			sc.nextLine();
			if (confirmation == 1) {
				System.out.println("How many months will the leasing period last?");
				int leaseDuration = sc.nextInt();
				sc.nextLine();
				leases[nbOfLeases] = new Lease(clientToLease, vehicleToLease, leaseDuration);
				nbOfLeases++;
				System.out.println("Leasing done!");
				System.out.println(leases[nbOfLeases-1]);
			}
			else return;
			break;
		case 2:
			System.out.println("Quitting this menu!");
			break;
		default:
			System.out.println("Invalid choice!");
			break;
		}
	    
	    
	}

	public static void returnVehicle(Scanner sc) {
	    System.out.println("Enter the plate number of the leased vehicle:");
	    String searchedPlateNum = sc.nextLine();

	    // Find the leased vehicle
	    Vehicle leasedVehicle = null;
	    for (int i = 0; i < vehicles.length; i++) {
	        if (vehicles[i] != null && vehicles[i].getPlateNumber().equals(searchedPlateNum)) {
	            leasedVehicle = vehicles[i];
	            break;
	        }
	    }

	    if (leasedVehicle == null) {
	        System.out.println("Vehicle with plate number " + searchedPlateNum + " not found.");
	        return;
	    }

	    if (!leasedVehicle.getLeaseStatus()) {
	        System.out.println("This vehicle isn't leased to anyone.");
	        return;
	    }

	    // Find the lease associated with the vehicle
	    Lease vehicleLease = null;
	    for (int i = 0; i < leases.length; i++) {
	        if (leases[i] != null && leases[i].getVehicle().equals(leasedVehicle)) {
	            vehicleLease = leases[i];
	            break;
	        }
	    }

	    if (vehicleLease == null) {
	        System.out.println("No lease found for this vehicle.");
	        return;
	    }

	    //  Remove the lease from the Client
	    Client client = vehicleLease.getClient();
	    for (int i = 0; i < client.getLeases().length; i++) {
	        if (client.getLeases()[i] != null && client.getLeases()[i].equals(vehicleLease)) {
	            client.removeLease(i); // Remove the lease from the client
	            break;
	        }
	    }

	    // Step 4: Update the Vehicle to mark it as returned
	    leasedVehicle.returnVehicle();

	    // Step 5: Remove the lease from the leases array
	    for (int i = 0; i < leases.length; i++) {
	        if (leases[i] != null && leases[i].equals(vehicleLease)) {
	            leases[i] = null; // Remove the lease from the leases array
	            break;
	        }
	    }

	    System.out.println("Vehicle with plate number " + searchedPlateNum + " has been successfully returned.");
	}
	
	public static void displayClientLeasedVehicles(Scanner sc) {
		System.out.println("Enter the client's ID:");
		String searchedID = sc.nextLine();
		boolean foundClient = false;
		
		int index = 0;
		for (int i = 0; i < clients.length ; i++) {
			if (clients[i] == null)
				continue;
			if (clients[i].getID().equals(searchedID)) {
				index = i;
				System.out.println("Client found!");
				foundClient = true;
				break;
			}
		}
		if (!foundClient) {
			System.out.println("Couldn't find a client by this ID.");
			return;
		}
		
		Client clientToSearch = clients[index];
		Lease[] clientLeases = clientToSearch.getLeases();
		
		boolean foundVehicles = false;
		
		System.out.println("Displaying leased vehicles...");
		for (int i = 0; i < clientLeases.length; i++) {
			if (clientLeases[i] == null)
				continue;

			Vehicle vehicle = clientLeases[i].getVehicle();

			if (vehicle.getLeaseStatus() == true) {
				foundVehicles = true;
				System.out.println(vehicle);
			}
		}
		if (!foundVehicles) {
			System.out.println("This client doesn't have any leased vehicles.");
		}
	}
	
	public static void displayLeasedVehicles(Scanner sc) {
		boolean foundVehicles = false;
		System.out.println("Displaying all currently leased vehicles...");
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] == null)
				continue;
			if (vehicles[i].getLeaseStatus() == true) {
				System.out.println(vehicles[i]);
				foundVehicles = true;
			}
		}
		
		if (foundVehicles == false)
			System.out.println("There are currently no leased vehicles.");
		
	}

	// additional operations are next.
	public static void additionalOperations(Scanner sc) {
		 while (true) {
		        System.out.println("\nVehicle Management:");
		        System.out.println("[1]: Display the truck with the largest capacity");
		        System.out.println("[2]: Create a copy of the electric trucks array");
		        System.out.println("[3]: Return to main menu");

		        int choice = sc.nextInt();
		        sc.nextLine();

		        switch (choice) {
		            case 1:
		                // Call method to display the truck with the largest capacity
		                displayLargestTruck(dieselTrucks);
		                break;
		            case 2:
		                // Call method to create a copy of the electric trucks array
		                createElectricTruckCopy(electricTrucks);
		                break;
		            case 3:
		                return; // Return to main menu
		            default:
		                System.out.println("Invalid choice. Please try again.");
		        }
		
	}
}

	public static DieselTruck displayLargestTruck(DieselTruck[] dieselTrucks) {
		System.out.println("Finding largest truck...");
		int maxTruckIndex = 0;
		for (int i = 0; i < dieselTrucks.length; i++) {
			if (dieselTrucks[i].getMaxWeightCapacity() >= dieselTrucks[maxTruckIndex].getMaxFuelCapacity()) {
				maxTruckIndex = i;
			}
			
		}
		
		DieselTruck largestTruck = dieselTrucks[maxTruckIndex];
		return largestTruck;
	}
	
	public static ElectricTruck[] createElectricTruckCopy(ElectricTruck[] electricTrucks) {
		System.out.println("Creating electric truck copy...");
		ElectricTruck[] deepCopy = new ElectricTruck[electricTrucks.length];
		for (int i = 0; i < deepCopy.length; i++) {
			if (electricTrucks[i] == null)
				deepCopy[i] = null;
			deepCopy[i] = new ElectricTruck(electricTrucks[i]);
		}
		
		return deepCopy;
		
	}
	
	//predefined scenario method.
	public static void testScenario() {
		 System.out.println("\nRunning Predefined Scenario for Testing...");

		    // Step 1: Create at least 3 objects of each vehicle type and 3 clients
		    ElectricTruck et1 = new ElectricTruck("Tesla", "Semi", 2023, 1500, 500);
		    ElectricTruck et2 = new ElectricTruck("Rivian", "R1T", 2022, 1200, 400);
		    ElectricTruck et3 = new ElectricTruck("Ford", "F-150 Lightning", 2023, 1300, 450);

		    DieselTruck dt1 = new DieselTruck("Freightliner", "Cascadia", 2021, 2000, 300);
		    DieselTruck dt2 = new DieselTruck("Volvo", "VNL", 2022, 1800, 350);
		    DieselTruck dt3 = new DieselTruck("Kenworth", "T680", 2023, 1900, 400);

		    ElectricCar ec1 = new ElectricCar("Tesla", "Model S", 2023, 6, 600);
		    ElectricCar ec2 = new ElectricCar("Nissan", "Leaf", 2022, 5, 300);
		    ElectricCar ec3 = new ElectricCar("Chevrolet", "Bolt", 2023, 5, 400);

		    GasolineCar gc1 = new GasolineCar("Toyota", "Corolla", 2022, 5);
		    GasolineCar gc2 = new GasolineCar("Honda", "Civic", 2023, 5);
		    GasolineCar gc3 = new GasolineCar("Ford", "Mustang", 2021, 4);

		    Client client1 = new Client("John Doe");
		    Client client2 = new Client("Jane Doe");
		    Client client3 = new Client("Jack Doe");

		    // Step 2: Display the information of these objects using toString()
		    System.out.println("\nElectric Trucks:");
		    System.out.println(et1);
		    System.out.println(et2);
		    System.out.println(et3);

		    System.out.println("\nDiesel Trucks:");
		    System.out.println(dt1.toString());
		    System.out.println(dt2.toString());
		    System.out.println(dt3.toString());

		    System.out.println("\nElectric Cars:");
		    System.out.println(ec1.toString());
		    System.out.println(ec2.toString());
		    System.out.println(ec3.toString());

		    System.out.println("\nGasoline Cars:");
		    System.out.println(gc1.toString());
		    System.out.println(gc2.toString());
		    System.out.println(gc3.toString());

		    System.out.println("\nClients:");
		    System.out.println(client1.toString());
		    System.out.println(client2.toString());
		    System.out.println(client3.toString());

		    // Step 3: Test the equals() method
		    System.out.println("\nTesting equals() method:");

		    // Case 1: Compare two objects from different classes
		    System.out.println("Case 1: Compare ElectricTruck and DieselTruck (should be false): " + et1.equals(dt1));

		    // Case 2: Compare two objects of the same class with different attribute values
		    System.out.println("Case 2: Compare two ElectricTrucks with different attributes (should be false): " + et1.equals(et2));

		    // Case 3: Compare two objects of the same class with identical attribute values
		    ElectricTruck etCopy = new ElectricTruck(et1); // Create a copy of et1
		    System.out.println("Case 3: Compare two ElectricTrucks with identical attributes (should be true): " + et1.equals(etCopy));

		    // Step 4: Create arrays for each type of vehicle and an array for all vehicles
		    ElectricTruck[] electricTrucks = {et1, et2, et3};
		    DieselTruck[] dieselTrucks = {dt1, dt2, dt3};
		    ElectricCar[] electricCars = {ec1, ec2, ec3};
		    GasolineCar[] gasolineCars = {gc1, gc2, gc3};

		    Vehicle[] allVehicles = new Vehicle[12];
		    System.arraycopy(electricTrucks, 0, allVehicles, 0, 3);
		    System.arraycopy(dieselTrucks, 0, allVehicles, 3, 3);
		    System.arraycopy(electricCars, 0, allVehicles, 6, 3);
		    System.arraycopy(gasolineCars, 0, allVehicles, 9, 3);

		    // Step 5: Call getLargestTruck() and display the result
		    DieselTruck largestTruck = displayLargestTruck(dieselTrucks);
		    System.out.println("\nDiesel Truck with the largest capacity:");
		    System.out.println(largestTruck.toString());

		    // Step 6: Call copyVehicles() on the array of electric trucks
		    ElectricTruck[] copiedElectricTrucks = createElectricTruckCopy(electricTrucks);
		    System.out.println("\nCopied Electric Trucks:");
		    for (ElectricTruck truck : copiedElectricTrucks) {
		        System.out.println(truck.toString());
		    }

		    System.out.println("\nPredefined scenario completed.");
	}
}
	
	
