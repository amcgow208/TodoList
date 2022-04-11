package model;

public interface ITask {
    void setTaskNumber(int taskNumber);
    int getTaskNumber();
    void setTaskName (String taskName);
    String getTaskName ();
    void setUserDetails(UserDetails userName);
    UserDetails getUserDetails();
}