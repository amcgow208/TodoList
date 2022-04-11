package view;

import datastructures.ADTSingleLinkedList;
import datastructures.listNode;
import model.Task;

public class taskView {
    public void displayTaskDetails(Task aTask){
        System.out.println("Task Details");
        System.out.println("----------------");
        System.out.println(String.format("Task Number: %05d",aTask.getTaskNumber()));
        System.out.println(String.format("Task name: %s",aTask.getTaskName()));
        System.out.println(String.format("Allocated to: %s",aTask.getUserDetails().getUsername()));
    }

    public void displayTaskDetails(listNode<Task> aTask){
        System.out.println("Task Details");
        System.out.println("----------------");
        System.out.println(String.format("Task Number: %05d",aTask.getNodeData().getTaskNumber()));
        System.out.println(String.format("Task name: %s",aTask.getNodeData().getTaskName()));
        System.out.println(String.format("Allocated to: %s",aTask.getNodeData().getUserDetails().getUsername()));
    }


    public void displayTodoList(ADTSingleLinkedList<Task> allTasks){
        System.out.println("Todo List");
        System.out.println("--------------------");
        System.out.println(String.format("| %5s | %-15s | %-10s | %-8s | %-12s |", "#", "Task name", "Allocated to", "Job Type","Due Date"));
        System.out.println("----------------------------------------------------------------------------------");

        listNode<Task> tmp = allTasks.front();
        while (tmp != null) {
            System.out.println( String.format("| %5s | %-15s | %-10s | %-8s | %-12s |", tmp.getNodeData().getTaskNumber(), tmp.getNodeData().getTaskName(), tmp.getNodeData().getUserDetails().getUsername(),tmp.getNodeData().getUserDetails().getJobType(),tmp.getNodeData().getUserDetails().getDueDate().toString()));
            tmp = tmp.getNextNode();
        }
        System.out.println("------------------------------------------------------------------------------------");
    }
}
