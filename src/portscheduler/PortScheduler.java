package portscheduler;

public class PortScheduler {

    public static void main(String[] args) {           
        Schedule schedule = new Schedule(6,12,4);
        schedule.createSchedule();
        schedule.checkItsDay();
        Scheduler scheduler = new Scheduler(schedule);
        scheduler.fixSchedules();
    }
}
