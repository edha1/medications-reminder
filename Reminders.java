import java.time.*;
import java.util.List;

public class Reminders {
    public void startReminders(List<Medication> meds) {

        // for each medication, start a new thread and run schedule reminder for that medication 
        for (Medication med : meds) {
            new Thread(() -> scheduleReminder(med)).start();
        }
    }

    /**
     * Scheduling reminders for that medicine 
     * @param med
     */
    private void scheduleReminder(Medication med) {
        try {

            // start an infinite loop so that reminder is continuously sent 
            while (true) {
                LocalTime now = LocalTime.now(); 
                long delay = Duration.between(now, med.getTime()).toMillis(); // get the time difference between now and when med should be taken 

                if (delay < 0) {
                    delay += 24 * 60 * 60 * 1000; // schedule for next day
                }

                Thread.sleep(delay); // thread will sleep for the delay time 
                
                System.out.println("\n🔔 REMINDER: Take " + med.getName() + " (" + med.getDosage() + ") now!\n");

                Thread.sleep(60 * 1000); // wait 1 min before rescheduling
            }
        } catch (InterruptedException e) {
            System.out.println("Error" );
        }
    }
}
