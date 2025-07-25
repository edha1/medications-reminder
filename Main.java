import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Medication> currMeds = Storage.getMeds(); 
        Reminders reminderManager = new Reminders(); 

        reminderManager.startReminders(currMeds); // start the reminders for the medications 

        // infinite loop, will always show this 
        while (true) {
            System.out.println("\n💊 Medication Reminder App");
            System.out.println("1. View Medications");
            System.out.println("2. Add Medication");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear newline

            switch (choice) {
                case 1:
                    if (currMeds.isEmpty()){
                        System.out.println("No current medications");
                    }else{
                        for (Medication m : currMeds){
                            System.out.println("- " + m.getName());
                        }
                    }   break;
                case 2:
                    System.out.print("Enter name of medication: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter dosage of medication: ");
                    String dosage = scanner.nextLine();
                    System.out.print("Enter time to take medication (HH:mm): ");
                    LocalTime time = LocalTime.parse(scanner.nextLine());
                    Medication med = new Medication(name, dosage, time);
                    currMeds.add(med);
                    Storage.saveMedications(currMeds);
                    new Thread(() -> reminderManager.startReminders(List.of(med))).start(); // schedule immediately
                    System.out.println("Medication added.");
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    break; 
            }
        }
    }
}
