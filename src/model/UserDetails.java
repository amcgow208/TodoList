package model;

public class UserDetails implements IUserDetails{
    private String theUserName;
    private String theJobType;
    private ADTDate theDueDate;

    public UserDetails(){
        this.theUserName = "Velma Dinkley";
        this.theJobType = "DEVELOPER";
        this.theDueDate = new ADTDate();
    }

    public UserDetails(String aUserName, String aJobType, int day, int month, int year){
        this.theUserName = aUserName;
        this.theJobType = aJobType;
        this.theDueDate = new ADTDate(day, month, year);
    }


    @Override
    public void setUserName(String theUserName) {
        this.theUserName = theUserName;
    }

    @Override
    public String getUsername() {
        return this.theUserName;
    }

    @Override
    public void setJobType(String theJobType) {
        this.theJobType = theJobType;
    }

    @Override
    public String getJobType() {
        return this.theJobType;
    }

    @Override
    public void setDueDate(ADTDate myUser) {
        this.theDueDate = myUser;
    }

    @Override
    public ADTDate getDueDate() {
        return this.theDueDate;
    }

    @Override
    public String toString(){
        String msg = "";
        msg = String.format("%s,%s,%s",this.getUsername(),this.getJobType(), this.getDueDate().toString());
        return msg;
    }

}
