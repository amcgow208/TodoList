package daos;

import app.TodoListApp;
import datastructures.ADTSingleLinkedList;
import datastructures.listNode;
import model.ADTDate;
import model.Task;
import model.UserDetails;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class taskDAOImpl<E> extends taskDAO<E>{
    private Task theTask;
    public static final char DELIMITER = ',';
    public static final char EOLN='\n';
    public static final String QUOTE="\"";
    public static final String USERDIRECTORY = System.getProperty("user.dir");

    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }

    public taskDAOImpl() { this.theTask = new Task(); }

    @Override
    public void setTaskNumber(int taskNumber) {
        this.theTask.setTaskNumber(taskNumber);
    }

    @Override
    public int getTaskNumber() {
        return this.theTask.getTaskNumber();
    }

    @Override
    public void setTaskName(String taskName) { this.theTask.setTaskName(taskName); }

    @Override
    public String getTaskName() {
        return this.theTask.getTaskName();
    }


    @Override
    public void setUserName(UserDetails myUser) {
        this.theTask.setUserDetails(myUser);
    }

    @Override
    public UserDetails getUserName() {
        return this.theTask.getUserDetails();
    }

    @Override
    public Task getTaskDetails() {
        return this.theTask;
    }

    @Override
    public ADTSingleLinkedList<E> readDataFromFile() {
        ADTSingleLinkedList<E> dataList = new ADTSingleLinkedList<>();
        String transactionFile = USERDIRECTORY +"\\TaskListData.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(transactionFile))) {
            int taskNumber;
            String taskName;
            String userName;
            String userJob;
            String dueDate;

            String[] temp;
            String line = br.readLine();
            while(line!=null){
                temp=line.split(Character.toString(DELIMITER));
                taskNumber = Integer.parseInt(temp[0]);
                taskName = temp[1];
                userName = temp[2];
                userJob = temp[3];
                dueDate = temp[4];
                Task theTask = new Task();
                theTask.setTaskNumber(taskNumber);
                theTask.setTaskName(taskName);
                UserDetails theUserDetails = new UserDetails();
                theUserDetails.setUserName(userName);
                theUserDetails.setJobType(userJob);
                String delims = "/"; // Use this delimitor to split the string.
                String[] tokens = dueDate.split(delims); // Create a string array for the three time values.
                ADTDate dateDue = new ADTDate(Integer.parseInt( tokens[0] ), Integer.parseInt( tokens[1] ),Integer.parseInt( tokens[2] ));
                theUserDetails.setDueDate(dateDue);
                theTask.setUserDetails(theUserDetails);
                dataList.insert((E)theTask);
                line = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(TodoListApp.class.getName()).log(Level.INFO, null, ex);
        }
        return dataList;
    }
    @Override
    public void writeDataToFile(ADTSingleLinkedList<Task> myTasks) {
        try {
            File myFile = new File(USERDIRECTORY +"\\TaskListData.txt");

            if(myFile.exists()){
                myFile.delete();
                System.out.println("File deleted: " + myFile.getName());
            }
            else if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myFile = new File(USERDIRECTORY +"\\TaskListData.txt");
            FileWriter myWriter = new FileWriter(myFile.getName());
            listNode<Task> tmp = myTasks.front();
            while (tmp != null) {
                if(tmp.getNextNode() == null){
                    myWriter.write(tmp.getNodeData().CSVFormat());
                }
                else {
                    myWriter.write(tmp.getNodeData().CSVFormat() + "\n");
                }
                tmp = tmp.getNextNode();
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    @Override
    public void writeDataToDoing(ADTSingleLinkedList<Task> myDoingTask) {
        try {
            File myFile = new File(USERDIRECTORY +"\\DoingList.txt");

            if(myFile.exists()){
                myFile.delete();
                System.out.println("File deleted: " + myFile.getName());
            }
            else if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            File myFile = new File(USERDIRECTORY +"\\DoingList.txt");
            FileWriter myWriter = new FileWriter(myFile.getName());
            listNode<Task> tmp = myDoingTask.front();
            while (tmp != null) {
                if(tmp.getNextNode() == null){
                    myWriter.write(tmp.getNodeData().CSVFormat());
                }
                else {
                    myWriter.write(tmp.getNodeData().CSVFormat() + "\n");
                }
                tmp = tmp.getNextNode();
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
