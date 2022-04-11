package daos;

import model.ADTDate;

import java.util.Scanner;

public class dateDAOImpl extends dateDAO{
    private ADTDate dueDate;

    public dateDAOImpl(){
        this.dueDate = new ADTDate();
    }

    @Override
    public void setDay(int day) {
        this.dueDate.setDay(day);
    }

    @Override
    public int getDay() {
        return this.dueDate.getDay();
    }

    @Override
    public void setMonth(int month) {
        this.dueDate.setMonth(month);
    }

    @Override
    public int getMonth() {
        return this.dueDate.getMonth();
    }

    @Override
    public void setYear(int year) {
        this.dueDate.setYear(year);
    }

    @Override
    public int getYear() {
        return this.dueDate.getYear();
    }

    @Override
    public void setElapsedDays() {
        this.dueDate.setElapsedDays();
    }

    @Override
    public void setElapsedDays(int dd, int mm, int yyyy) {
        this.dueDate.setElapsedDays(dd,mm,yyyy);
    }

    @Override
    public int getElapsedDays() {
        return this.dueDate.getElapsedDays();
    }

    @Override
    public void setDate(int dd, int mm, int yyyy) {
        this.dueDate.setDate(dd,mm,yyyy);
    }

    @Override
    public boolean isLeapYear(int yyyy) {
        return this.dueDate.isLeapYear(yyyy);
    }

    @Override
    public ADTDate getDate() {
        return this.dueDate;
    }

    @Override
    public void parseDateInput(String outputMsg) {
        // Getting user input
        Scanner userInput = new Scanner(System.in);
        System.out.println(outputMsg);
        // Convert String values to Integers.
        String userInputStr = userInput.nextLine(); // Get string input from user.
        String delims = "/"; // Use this delimitor to split the string.
        String[] tokens = userInputStr.split(delims); // Create a string array for the three time values.
        this.dueDate.setDay(Integer.parseInt( tokens[0] ));
        this.dueDate.setMonth(Integer.parseInt( tokens[1] ));
        this.dueDate.setYear(Integer.parseInt( tokens[2] ));
    }

}
