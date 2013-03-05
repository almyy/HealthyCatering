package Beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@ManagedBean
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
    
    public void validatePasswords(FacesContext context, UIComponent component, Object value) {
        String message = "";
        String password = (String) value;
        if(!tempPassword.equals(password)) {
            ((UIInput)component).setValid(false);
            message = "The passwords doesn't match, please retype";
            context.addMessage(component.getClientId(context), new FacesMessage(message));
        }
        else {
            tempRepeatPass = password;
        }
    }
    public void validateUsername(FacesContext context, UIComponent component, Object value) {
        String message = "";
        String username = (String) value;
        if(username == ,null || username.equals("")) {
            ((UIInput)component).setValid(false);
            message = "Enter a username";
            context.addMessage(component.getClientId(context), new FacesMessage(message));
        }
        else {
            tempUsername = username;
        }
        
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