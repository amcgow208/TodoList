package daos;

import model.ADTDate;
import model.UserDetails;

public class userDetailsDAOImpl extends userDetailsDAO {
    private UserDetails theUserDetails;

    public userDetailsDAOImpl() {
        this.theUserDetails = new UserDetails();
    }


    @Override
    public void setUserName(String theUserName) {
        this.theUserDetails.setUserName(theUserName);
    }

    @Override
    public String getUserName() {
        return this.theUserDetails.getUsername();
    }

    @Override
    public void setJobType(String theJobType) {
        this.theUserDetails.setJobType(theJobType);
    }

    @Override
    public String getJobType() {
       return this.theUserDetails.getJobType();
    }

    @Override
    public void setDueDate(ADTDate myUser) {
        this.theUserDetails.setDueDate(myUser);
    }

    @Override
    public ADTDate getDueDate() {
        return this.theUserDetails.getDueDate();
    }

    @Override
    public UserDetails getUserDetails() {
        return this.theUserDetails;
    }
}