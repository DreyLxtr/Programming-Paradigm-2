import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManagement {
    
   public static void main(String[] args) {
        
      ArrayList <Vehicle> vehicleList = new ArrayList<>();
        
         Scanner key = new Scanner(System.in);

         int choice;
         
         String number, brand;
         int year;
         double price;
         
         do {
            System.out.println("Menu:");
            System.out.println("1. Add a vehicle");
            System.out.println("2. Display a list of vehicle details");
            System.out.println("3. Delete a vehicle");
            System.out.println("4. Sort vehicle list by age");
            System.out.println("5. Quit");
            
            System.out.println();
            
            System.out.print("Enter your choice: ");
               choice = key.nextInt();
                  key.nextLine(); 

            switch (choice) {
               case 1:
                  // enter the vehicle information
                  System.out.print ("Enter registration number: ");
                     number = key.nextLine();
                  
                  System.out.print ("Enter make: ");
                     brand = key.nextLine();
                  
                  System.out.print ("Enter year of manufacture: ");
                     year = key.nextInt();
                  
                  System.out.print ("Enter value: ");
                     price = key.nextDouble();
                  
                  Vehicle addVehicle = new Vehicle (number, brand, year, price);
                  
                  // add a vehicle in the array
                  vehicleList.add (addVehicle);
                  
                  System.out.println ("Vehicle added successfully");
                  System.out.println();
                     break;
                
                case 2:
                  // if the array is empty this code will run
                  if (vehicleList.isEmpty()){
                     System.out.print ("\nNo vehicles in the list!");
                     System.out.println(" \n");
                  }
                  
                  // code to display the list of vehicles
                  else {
                  vehicleList.forEach (t -> System.out.println (t));
                     System.out.println();
                  }
                     break;
                           
                case 3:
                  // if the array is empty this code will run
                  if (vehicleList.isEmpty()){
                     System.out.print ("\nNo vehicles in the list to delete!");
                     System.out.println(" \n");
                        break;
                  }
                  
                  // code to delete a vehicle in the list
                  System.out.print ("\nEnter the registration number of the vehicle to delete: ");
                     String regNumber = key.nextLine();
                     
                  boolean found = false;
                     
                  for (Vehicle vehicle : vehicleList){
                     if (vehicle.getRegNo().equals(regNumber)){
                        vehicleList.remove(vehicle);
                           found = true;
                              System.out.print("\nVehicle with the registration number " + regNumber + " deleted successfully");
                              System.out.println("\n");
                                 break;
                     }
                  }
                  
                  // if the inputed registration number is not on the list, this code will run
                  if (!found){
                     System.out.print("\nVehicle with the registration number " + regNumber + " is not on the list");
                     System.out.println(" \n");
                        break;
                  }
                  
                    break;
                    
                case 4:
                  // if the array is empty this code will run
                  if (vehicleList.isEmpty()){
                     System.out.print("\nNo vehicles in the list to sort");
                     System.out.println(" \n");
                        break;
                  }
                  
                  // sorting algorithm
                  int n = vehicleList.size();
                  
                  for (int i=0; i < n-1; i++){
                     for (int j=0; j < n-1; j++){
                        if (vehicleList.get(j).calculateAge(2024) > vehicleList.get(j+1).calculateAge(2024)){
                           Vehicle temp = vehicleList.get(j);
                              vehicleList.set(j, vehicleList.get(j+1));
                                 vehicleList.set(j+1, temp);
                        }
                     }
                  }
                  
                  System.out.println ("\nVehicles is now sorted by age");
                  System.out.println(" \n");
                    break;
                    
                case 5:
                    // terminate the program
                    System.out.println("Exiting program...");
                    break;
                    
                default:
                    // if the entered number is not on the menu this code will run
                    System.out.println("\nInvalid choice. Please try again.");
                    System.out.println();
            }
        } 
        
        while (choice != 5);

        key.close();
    }

}
