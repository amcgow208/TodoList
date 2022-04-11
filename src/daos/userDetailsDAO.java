package daos;

import model.ADTDate;
import model.UserDetails;

public abstract class userDetailsDAO {
    public abstract void setUserName (String theUsername);
    public abstract String getUserName ();
    public abstract void setJobType (String theJobType);
    public abstract String getJobType ();
    public abstract void setDueDate(ADTDate myUser);
    public abstract ADTDate getDueDate();
    public abstract UserDetails getUserDetails();
}