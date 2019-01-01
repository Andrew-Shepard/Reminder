import java.util.Timer;
import java.util.Scanner;
import java.util.TimerTask;

public class Reminder {
    //Sets title of the event
    private String eventName;
    private int eventTimeHours, eventTimeMinutes, eventTime;
    public final int minutesToMillaseconds = 60000;
    public void setEvent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Set the name of the Reminder: ");
        eventName = sc.nextLine();
    }
    //Sets the time of the reminder
    public void setTime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input the time until the arrival, starting with total hours then input the minutes " +
                ". \n i.e. a reminder in 30 minutes would be an input of 0 then an input of 30 " +
                "\n Hours?:");
        eventTimeHours = sc.nextInt();
        System.out.println("Minutes? ");
        eventTimeMinutes = sc.nextInt();
        //Combines time into one variable
        eventTime = eventTimeHours*60 + eventTimeMinutes;
    }
    //Counting time
    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        Scanner sc = new Scanner(System.in);
        public void run() {
            //Prints the reminder after the delay set in start() until the user inputs
            System.out.println("Reminder for " + eventName +" close program with any input");
            if(sc.nextLine().equals("null") == false){
                System.exit(0);
            }
        }
    };
    public void start(){
            //task is run, event time in millaseconds then the period isn't used because of the loop
            myTimer.scheduleAtFixedRate(task, (eventTime*minutesToMillaseconds), 1000);
    }

    //Returns variables
    public double returnTime(){
        return eventTime;
    }
    public String returnEvent(){
        return eventName;
    }


}