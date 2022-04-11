package daos;

import datastructures.ADTSingleLinkedList;
import model.Task;
import model.UserDetails;

public abstract class taskDAO<E> {
    public abstract void setTaskNumber(int taskNumber);
    public abstract int getTaskNumber();
    public abstract void setTaskName (String theTaskName);
    public abstract String getTaskName ();
    public abstract void setUserName(UserDetails myUser);
    public abstract UserDetails getUserName();
    public abstract Task getTaskDetails();
    public abstract ADTSingleLinkedList<E> readDataFromFile();
    public abstract void writeDataToFile(ADTSingleLinkedList<Task> myTasks);
    public abstract void writeDataToDoing(ADTSingleLinkedList<Task> myTasks);
}