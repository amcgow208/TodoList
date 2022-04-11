package view;

import model.ADTDate;

public class dateDetailsView {
    public void displayDateDetails(ADTDate aDate){
        System.out.println("Due Date Details");
        System.out.println("--------------------");
        System.out.println(String.format("Date Started: %02d/%02d/%02d",aDate.getDay(),aDate.getMonth(),aDate.getYear()));
        System.out.println(String.format("Days Elapsed: %d",aDate.getElapsedDays()));
    }
}