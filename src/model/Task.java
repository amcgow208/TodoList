package model;

public class Task implements Comparable<Task>, ITask{
    private int TaskNumber;
    private String TaskName;
    private UserDetails UserName;

    public Task(){
        this.TaskNumber = 1;
        this.TaskName = "Create Javascript";
        this.UserName = new UserDetails();
    }


    @Override
    public void setTaskNumber(int taskNumber) {
        this.TaskNumber = taskNumber;
    }

    @Override
    public int getTaskNumber() {
        return this.TaskNumber;
    }

    @Override
    public void setTaskName(String taskName) {
        this.TaskName = taskName;
    }

    @Override
    public String getTaskName() {
        return this.TaskName;
    }

    @Override
    public void setUserDetails(UserDetails myUser) {
        this.UserName = myUser;
    }

    @Override
    public UserDetails getUserDetails() {
        return this.UserName;
    }

    public String CSVFormat(){
        String outputStr = this.TaskNumber + "," + this.TaskName + "," + this.UserName;
        return outputStr;
    }

    @Override
    public String toString(){
        String msg = "";
        msg = String.format("%d,%s,%s",this.getTaskNumber(),this.getTaskName(), this.getUserDetails().toString());
        return msg;
    }

    @Override
    public int compareTo(Task aTask){
        if(this.TaskNumber == aTask.TaskNumber)
            return 0;
        else if(this.TaskNumber > aTask.TaskNumber)
            return 1;
        else
            return -1;
    }

}