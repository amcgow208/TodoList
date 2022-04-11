package controllers;

import daos.taskDAOImpl;
import daos.dateDAOImpl;
import daos.userDetailsDAOImpl;
import datastructures.ADTSingleLinkedList;
import datastructures.listNode;
import helpers.InputHelper;
import model.Task;
import view.dateDetailsView;
import view.taskView;
import view.userDetailsView;

import java.time.LocalDate;

public class controller {
    private final taskDAOImpl<Task> aTaskDAO;
    private final taskDAOImpl<Task> aDoingDAO;
    private final userDetailsDAOImpl aUserDetails;
    private final dateDAOImpl aDueDate;
    private final taskView aTaskView;
    private final userDetailsView userView;
    private final dateDetailsView dateView;
    private final InputHelper inputHelper;
    private ADTSingleLinkedList<Task> taskLL;
    private ADTSingleLinkedList<Task> doingLL;
    private int counter;

    /**
     * Initializes the DAOs
     */
    public controller() {
        this.aTaskDAO = new taskDAOImpl<>();
        this.aDoingDAO = new taskDAOImpl<>();
        this.aUserDetails = new userDetailsDAOImpl();
        this.aDueDate = new dateDAOImpl();
        this.aTaskView = new taskView();
        this.userView = new userDetailsView();
        this.dateView = new dateDetailsView();
        this.inputHelper = new InputHelper();
        this.taskLL = new ADTSingleLinkedList<Task>();
        this.doingLL = new ADTSingleLinkedList<Task>();
        this.counter = this.aTaskDAO.readDataFromFile().length();
    }

    /**
     * Displays the menu and uses an InputHelper object
     * to accept valid user choice.
     * An appropriate private method is called to implement the choice.
     */
    public void run() {
        boolean finished = false;

        int iChoice = 0;

        do {
            theMenu();
            iChoice = inputHelper.readInt("Enter choice", 7, 1);
            switch (iChoice) {
                case 1:
                    displayTodoList();
                    System.out.println();
                    break;
                case 2:
                    addTask();
                    System.out.println();
                    break;
                case 3:
                    getDetailsFromFile();
                    System.out.println();
                    break;
                case 4:
                    moveToDoingList();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("All done! Bye ...");
                    finished = true;
                    break;
                default: // invalid option
                    System.out.println("Oops! Something has went wrong!");
                    break;
            }
        } while (!finished);
    }

    private void theMenu() {
        // Print menu to console
        System.out.println("Todo List");
        System.out.println("-----------------------");
        System.out.println("1: Display Todo List");
        System.out.println("2: Enter New Task and Allocate to User");
        System.out.println("3: Read todo list from file");
        System.out.println("4: Move Task to Doing List");
        System.out.println("5: Exit");
        System.out.println();
    }

    private void displayTodoList() {
        System.out.println("Todo List");
        System.out.println("-----------------------------------");
        this.aTaskView.displayTodoList(this.taskLL);
    }

    private void addTask() {
        System.out.println("Enter New Task and Allocate to User");
        System.out.println("------------------------------");
        this.counter += 1;
        this.aTaskDAO.setTaskNumber(this.counter);
        this.aTaskDAO.setTaskName(this.inputHelper.readString("Please enter the task name"));
        this.aUserDetails.setUserName(this.inputHelper.readString("Please enter the allocated user"));
        this.aUserDetails.setJobType(this.inputHelper.readString("Please enter user's job type"));
        this.aDueDate.parseDateInput("Please enter the due date in the format dd/mm/yyyy: ");
        this.aDueDate.setElapsedDays();
        LocalDate currentDate = LocalDate.now();
        this.aDueDate.setElapsedDays(currentDate.getDayOfMonth(), currentDate.getMonthValue(), currentDate.getYear());
        this.aUserDetails.setDueDate(this.aDueDate.getDate());
        this.aTaskDAO.setUserName(aUserDetails.getUserDetails());
        this.taskLL.insert(this.aTaskDAO.getTaskDetails());
        aTaskDAO.writeDataToFile(this.taskLL);
    }

    private void getDetailsFromFile() {
        System.out.println("Loading Todo List");
        System.out.println("------------------------------------------");
        this.taskLL = this.aTaskDAO.readDataFromFile();
        this.aTaskView.displayTodoList(this.taskLL);
        listNode<Task> theData = this.taskLL.find("TEST");
        aTaskView.displayTaskDetails(theData);
    }

    private void moveToDoingList() {
        ADTSingleLinkedList<Task> tmpLL = new ADTSingleLinkedList<>();
        System.out.println("Move Task to doing list");
        System.out.println("------------------------");
        String taskName = inputHelper.readString("Please enter the name of the task you wish to move ");
        listNode<Task> aTask = this.taskLL.find(taskName);
        if (aTask == null) {
            System.out.format("%s was not found in the list.", taskName);
        } else {
            System.out.println("Moving task to Doing List");
            System.out.println("------------------------");
            return this.aTaskDAO.getTaskDetails();
            this.taskLL.remove(this.aTaskDAO.getTaskDetails());
            aTaskDAO.writeDataToDoing(this.doingLL);

        }
    }

}
