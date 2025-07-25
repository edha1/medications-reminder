import java.io.*;
import java.time.LocalTime;
import java.util.*;

public class Storage {
    private static final String FILE = "medications.csv";

    /**
     * Get the meds from the file 
     * @return
     */
    public static List<Medication> getMeds() {
        List<Medication> meds = new ArrayList<>(); 

        File file = new File(FILE); // create a file object 

        // if the file doesn't exist, return empty arraylist 
        if (!file.exists()){
            return  meds; 
        }

        try (BufferedReader br = new BufferedReader(new FileReader(FILE))){
            String line; 

            while ((line = br.readLine()) != null){
                String[] parts = line.split(","); 
                String name = parts[0];
                String dosage = parts[1];
                LocalTime time = LocalTime.parse(parts[2]);
                Medication med = new Medication(name, dosage, time); 
                meds.add(med); 
            }
        }catch (IOException e){
            System.out.println("Error");
        }

        return meds; 
    }

    /**
     * Save the medications to the file 
     * @param meds
     */
    public static void saveMedications(List<Medication> meds) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE))) {
            for (Medication m : meds) {
                pw.println(m.getName() + "," + m.getDosage() + "," + m.getTime());
            }
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
