package calenderview;


import exception.CalenderException;
import task.Task;
import ui.Ui;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.LinkedList;

import static ui.Constants.MULTIPLE_WHITE_SPACES;

//@@author NizarMohd
/**
 * This class deals with converting Tasks into Calender view.
 */

public class CalenderView {
    private HashMap<Integer, LinkedList<Task>> map;
    private  LocalDate firstDay;
    public  int month;
    public  int year;
    private  int lastDay;
    private  int[] daysOfMonths = new int[35];
    public static final String DIVIDER = "-----------------------------------------------------------------------"
            + "----------------------------------------------------------------------------------------------------"
            + "---------------------------";
    public static final String[] DAYS = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    public static final String SPACES = "\t\t\t\t\t\t ";
    public static final String COL = "|";
    public static final String PADDING = "    ";
    public static final String PADDING2 = "   ";
    public static final String PADDING3 = "  ";
    public static final String SPACE = " ";

    /**
     * This constructs the class.
     * @param ui allows for interaction with the user.
     */
    public CalenderView(Ui ui) {
        getInput(ui);
        this.firstDay = YearMonth.of(this.year, this.month).atDay(1);
        this.lastDay = this.firstDay.getMonth().length(this.firstDay.isLeapYear());
        processDates();
    }

    /**
     * This sets the mapping between days to Tasks.
     * @param inMap this is the incoming created by CalenderCommand.
     */
    public void setMap(HashMap<Integer, LinkedList<Task>> inMap) {
        this.map = inMap;
    }

    /**
     * This print the days header.
     */
    public void printDays() {
        System.out.println(DIVIDER);
        for (int i = 0; i < 7; i++) {
            System.out.print(COL + DAYS[i] + SPACES);
        }
        System.out.println(COL);
        System.out.println(DIVIDER);
    }

    /**
     * This process the dates of the month into its supposed box.
     */
    public void processDates() {
        int index = this.firstDay.getDayOfWeek().getValue();
        index = index % 7;
        for (int i = 1; i <= this.lastDay; i++) {
            if (index >= 35) {
                index = 0;
            }
            this.daysOfMonths[index] = i;
            index++;
        }
    }

    /**
     * This prints the content to be displayed in the box.
     * @param row this is the row the box is at.
     * @param i this is the height of the box that is currently being printed.
     * @param j this is the day which the box is at.
     */
    public void printContent(int row, int i, int j) {
        int index = row * 7 + j;
        int day = daysOfMonths[index];
        if (i == 0) {
            if (this.daysOfMonths[index] == 0) {
                System.out.print(COL + SPACES + PADDING);
            } else if (this.daysOfMonths[index] > 9) {
                System.out.print(COL + SPACES + PADDING3 + this.daysOfMonths[index]);
            } else {
                System.out.print(COL + SPACES + PADDING2 + this.daysOfMonths[index]);
            }
        } else {
            if (map.containsKey(day)) {
                if (map.get(day).isEmpty()) {
                    System.out.print(COL + SPACES + PADDING);
                } else {
                    LinkedList<Task> tasks = map.get(day);
                    Task task = tasks.get(0);
                    tasks.removeFirst();
                    System.out.print(COL + SPACE + task.getCalenderTaskDetails() + SPACE);
                }
            } else {
                System.out.print(COL + SPACES + PADDING);
            }
        }
    }

    /**
     * This method prints the box itself.
     * @param row this is the row that the box is currently being printed.
     */
    public void printBox(int row) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                printContent(row, i, j);
            }
            System.out.println(COL);
        }
        System.out.println(DIVIDER);
    }

    /**
     * This prints the month which the calendar is being printed.
     */
    public void printCurrentMonth() {
        System.out.println("Tasks for: " + this.firstDay.getMonth().toString() + ", " +  this.firstDay.getYear());
    }

    /**
     * This checks if the month entered by user is correct.
     * @param in this is the input by user.
     * @throws CalenderException this is the exception thrown when user entered the month wrongly.
     */
    public void checkMonth(String in) throws CalenderException {
        try {
            int inMonth = Integer.parseInt(in);
            if (inMonth < 1 || inMonth > 12) {
                throw new CalenderException("Invalid Month");
            }
            this.month = inMonth;
        } catch (NumberFormatException e) {
            throw new CalenderException("Month is not integer");
        }
    }

    /**
     * This method checks the year entered by the user.
     * @param in This is the input entered by the user.
     * @throws CalenderException is thrown when user enters the year wrongly.
     */
    public void checkYear(String in) throws CalenderException {
        try {
            int inYear = Integer.parseInt(in);
            if (inYear < 2020) {
                throw new CalenderException("Invalid Year");
            }
            this.year = inYear;
        } catch (NumberFormatException e) {
            throw new CalenderException("Year is not integer");
        }
    }

    /**
     * This method gets the input from the user.
     * @param ui this allows for interaction with the user.
     */
    public void getInput(Ui ui) {
        ui.printMessage("Enter the month and year that you wish to see: ");
        String temp = ui.getUserIn();
        String[] input = temp.split(MULTIPLE_WHITE_SPACES);
        if (input[0].equals("now")) {
            this.month = LocalDate.now().getMonthValue();
            this.year = LocalDate.now().getYear();
        } else {
            try {
                checkMonth(input[0]);
                checkYear(input[1]);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    /**
     * This method prints the calendar.
     */
    public void printCalender() {
        printCurrentMonth(); // to remove constructor later
        printDays();
        for (int i = 0; i < 5; i++) {
            printBox(i);
        }
    }

}
