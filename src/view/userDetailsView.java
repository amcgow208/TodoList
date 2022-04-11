package view;

import model.UserDetails;

public class userDetailsView {
    public void displayUserDetails(UserDetails aUser){
        System.out.println("User Details");
        System.out.println("-----------");
        System.out.println(String.format("User name: %s",aUser.getUsername()));
        System.out.println(String.format("Job Type: %s",aUser.getJobType()));
        System.out.println(String.format("Date Started: %02d/%02d/%02d",aUser.getDueDate().getDay(), aUser.getDueDate().getMonth(),aUser.getDueDate().getYear()));
    }
}