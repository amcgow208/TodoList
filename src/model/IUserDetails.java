package model;

public interface IUserDetails {
    void setUserName (String theUserName);
    String getUsername ();
    void setJobType (String theJobType);
    String getJobType ();
    void setDueDate(ADTDate myUser);
    ADTDate getDueDate();
}