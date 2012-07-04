package portscheduler;

import java.util.Arrays;

public class Scheduler {

    private final String SEA = "sea";
    private final int UNDEFINED = -1;
    static String[] portsn;
    private int days[];
    private String[][] schedule;
    private Schedule scheduleObj;

    public Scheduler(Schedule sch) {
        scheduleObj = sch;
        schedule = scheduleObj.getSchedule();
        portsn = scheduleObj.getPORT();
        days = new int[portsn.length];
        
        if (portsn.length < days.length) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        
        Arrays.fill(days, UNDEFINED);

        printAll();
    }

    public void fixSchedules() {
        System.out.println(" Fix Scheduling start.. ");
        
        do {
            printAll();
            for (int j = 0; j < schedule.length; j++) {
                if (days[j] == UNDEFINED) {
                    days[j] = findLatest(j);
                }
            }
        } while (!isComplete());
    }

    public void printAll() {
        for (int i = 0; i < schedule.length; i++) {
            System.out.printf("Ploio%d : {", i);
            for (int j = 0; j < schedule[i].length; j++) {
                System.out.printf("%4s", schedule[i][j]);
            }
            System.out.printf(" }\n");
        }
        System.out.println();
    }

    private boolean isComplete() {
        boolean flag = true;
        for (int j = 0; j < days.length; j++) { //4
            if (days[j] != UNDEFINED) {
                for (int i = 0; i < days.length; i++) {
                    if (days[i] != UNDEFINED && i != j) {
                        if (schedule[j][days[j]].equals(schedule[i][days[i]])) {
                            flag = false;

                            if (days[j] < days[i]) {
                                schedule[i][days[i]] = SEA;
                                days[i] = UNDEFINED;

                            } else {
                                schedule[j][days[j]] = SEA;
                                days[j] = UNDEFINED;
                                break;
                            }

                        }
                    }
                }
            }
        }
        return flag;
    }

    private int findLatest(int i) {
        for (int j = schedule[0].length - 1; j > -1; j--) {
            if (!schedule[i][j].equals(SEA)) {
                return j;
            }
        }
        return UNDEFINED;
    }
}
