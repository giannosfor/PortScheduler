package portscheduler;

import java.util.Arrays;
import java.util.Random;

public class Schedule {

    private int PORTS;
    private int DAYS;
    private int SHIPS;
    private String[][] schedule;
    private String[] PORT;
    private Random random = new Random();

    public Schedule(int ports, int days, int ships) {
        PORTS = ports;
        DAYS = days;
        SHIPS = ships;
        schedule = new String[SHIPS][DAYS];
        PORT = new String[PORTS];
        fillPorts();
        fillArray(schedule.length, schedule);
    }

    public Schedule(int ports, int days) {
        this(ports, days, ports);
    }

    public void createSchedule() {
        System.out.println(" Creating schedules... ");
        for (int j = 0; j < getSchedule().length; j++) {
            setRandom(PORTS, schedule[j]);
        }

    }

    private void setRandom(int randonumbers, String schedule[]) {
        for (int j = 0; j < randonumbers; j++) {
            findRandom(PORT[j], schedule);
        }
    }

    private void findRandom(String port, String[] schedule) {
        int randomday;
        do {
            randomday = random.nextInt(schedule.length);
        } while (!isSea(schedule[randomday]));
        schedule[randomday] = port;
    }

    public void checkItsDay() {
        System.out.println(" Change days... ");
        for (int i = 0; i < schedule[0].length; i++) {
            for (int j = 0; j < schedule.length; j++) {
                if (!isSea(schedule[j][i])) {
                    findSame(schedule[j][i], i);
                }
            }
        }
        printAll();
    }

    private void findSame(String port, int i) {
        int count = 0;
        for (int j = 0; j < schedule.length; j++) {
            if (schedule[j][i].equals(port)) {
                count++;
                if (count > 1) {
                    changeDay(schedule[j][i], j, i);
                }
            }
        }
    }

    private void changeDay(String port, int j, int i) {
        printAll();
        findTheRandom(port, schedule[j]);
        schedule[j][i] = "sea";
    }

    private void findTheRandom(String port, String[] sche) {
        int randomday = random.nextInt(sche.length);
        while (!isSea(sche[randomday]) || hasEqual(port, randomday)) {
            randomday = random.nextInt(sche.length);
        }
        sche[randomday] = port;
    }

    private boolean hasEqual(String port, int i) {
        int count = 0;
        for (int j = 0; j < schedule.length; j++) {
            if (schedule[j][i].equals(port)) {
                count++;
                if (count > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSea(String day) {
        if (day.equals("sea")) {
            return true;
        }
        return false;
    }

    private static void fillArray(int lenght, String schedule[][]) {
        for (int j = 0; j < lenght; j++) {
            Arrays.fill(schedule[j], 0, schedule[j].length, "sea");
        }
    }

    private void fillPorts() {
        for (int i = 0; i < getPORT().length; i++) {
            PORT[i] = String.format("P%d", i + 1);
        }
    }

    public void printAll() {
        for (String[] sch : getSchedule()) {
            for (String day : sch) {
                System.out.printf("%3s ", day);
            }
            System.out.println();
        }
        System.out.println("\n");
    }

    public int getPORTS() {
        return PORTS;
    }

    public void setPORTS(int PORTS) {
        this.PORTS = PORTS;
    }

    public int getDAYS() {
        return DAYS;
    }

    public int getSHIPS() {
        return SHIPS;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public String[] getPORT() {
        return PORT;
    }
}
