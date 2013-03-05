package Beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@SessionScoped
@Named("Register")
class registerBean implements Serializable {
    private String tempUsername;
    private String tempPassword;
    private String tempRepeatPass;
    private String tempAddress;
    private String tempFirstName;
    private String tempSurname;
    private String tempEmail;
    private int tempPhone;
    
    public boolean validatePasswords() {
        if(tempPassword.equals(tempRepeatPass)) {
            return true;
        }
        return false;
    }
    public String getTempUsername() {
        return tempUsername;
    }
    public void setTempUsername(String tempUsername) {
        this.tempUsername = tempUsername;
    }
    public String getTempPassword() {
        return tempPassword;
    }
    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }
    public String getTempRepeatPass() {
        return tempRepeatPass;
    }
    public void setTempRepeatPass(String tempRepeatPass) {
        this.tempRepeatPass = tempRepeatPass;
    }
    public String getTempAddress() {
        return tempAddress;
    }
    public void setTempAddress(String tempAddress) {
        this.tempAddress = tempAddress;
    }
    public String getTempFirstName() {
        return tempFirstName;
    }
    public void setTempFirstName(String tempFirstName) {
        this.tempFirstName = tempFirstName;
    }
    public String getTempSurname() {
        return tempSurname;
    }
    public void setTempSurname(String tempSurname) {
        this.tempSurname = tempSurname;
    }
    public String getTempEmail() {
        return tempEmail;
    }
    public void setTempEmail(String tempEmail) {
        this.tempEmail = tempEmail;
    }
    public int getTempPhone() {
        return tempPhone;
    }
    public void setTempPhone(int tempPhone) {
        this.tempPhone = tempPhone;
    }
}