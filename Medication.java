import java.time.LocalTime; 

public class Medication { 

    private String name; 
    private String dosage; 
    private LocalTime time; 

    public Medication(String name, String dosage, LocalTime time){
        this.name = name; 
        this.dosage = dosage; 
        this.time = time; 
    }

    public String getName(){
        return this.name; 
    }

    public String getDosage(){
        return  this.dosage; 
    }

    public LocalTime getTime(){
        return this.time; 
    }

    public void setTime(LocalTime time){
        this.time = time; 
    }

    public void setName(String name){
        this.name = name; 
    }

    public void setDosage(String dosage){
        this.dosage = dosage; 
    }

    @Override
    public String toString() {
        return name + " (" + dosage + ") at " + time;
    }
}