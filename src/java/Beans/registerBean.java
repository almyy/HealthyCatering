package Beans;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.inject.Named;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@ManagedBean
@SessionScoped
@Named("Register")
class registerBean implements Serializable {
    private String tempUsername;
    private String tempPassword;
    private String tempRepeatPass;
    private String tempAddress;
    private int tempPostnumber;
    private String tempCity;
    private String tempFirstName;
    private String tempSurname;
    private String tempEmail;
    private long tempPhone;
    
    public void validateUsername(FacesContext context, UIComponent component, Object value) {
        String message = "";
        String username = (String) value;
        if(username == null || username.equals("")) {
            ((UIInput)component).setValid(false);
            message = "Enter a username";
            context.addMessage(component.getClientId(context), new FacesMessage(message));
        }
    }
    
    public void validatePasswords(FacesContext context, UIComponent component, Object value) {
        String message = "";
        String password = (String) value;
        boolean hasNumber = false;
        for(int i = 0; i < password.length(); i++) {
            if(Character.isDigit(password.charAt(i))) {
                hasNumber = true;
            }
        }
        if(!hasNumber && password.length() < 8) {
            ((UIInput)component).setValid(false);
            message = "You need to have at least one number and the password must be atleast 8 characters long";
            context.addMessage(component.getClientId(context), new FacesMessage(message));
        }
        else tempPassword = password;
    }
    
    public void validateRepPassword(FacesContext context, UIComponent component, Object value) {
        String message = "";
        String repPassword = (String) value;
        if(!repPassword.equals(tempPassword)) {
            ((UIInput)component).setValid(false);
            message = "The passwords don't match.";
            context.addMessage(component.getClientId(context), new FacesMessage(message));
        }
        
    }
    public void validate(FacesContext context, UIComponent component, Object value) {
        String message = "";
        String stringValue = (String) value;
        if(stringValue == null || stringValue.equals("")) {
            ((UIInput)component).setValid(false);
            message = "The field cannot be empty";
            context.addMessage(component.getClientId(context), new FacesMessage(message));
        }
    }
    public void validatePostnumber(FacesContext context, UIComponent component, Object value) {
        String message = "";
        try {
          Integer postnumber = (Integer) value;
        } catch (Exception e) {
            ((UIInput)component).setValid(false);
            message = "The postnumber can only be numbers";
            context.addMessage(component.getClientId(context), new FacesMessage(message));
        }
    }
    public void validateEmail(FacesContext context, UIComponent component, Object value) {
        String message = "";
        try {
            InternetAddress email = new InternetAddress((String) value);
            email.validate();
        } catch(AddressException ae) {
            ((UIInput)component).setValid(false);
            message = "Type a valid email address";
            context.addMessage(component.getClientId(context), new FacesMessage(message));
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
    public long getTempPhone() {
        return tempPhone;
    }
    public void setTempPhone(long tempPhone) {
        this.tempPhone = tempPhone;
    }
    public int getTempPostnumber() {
        return tempPostnumber;
    }

    public void setTempPostnumber(int tempPostnumber) {
        this.tempPostnumber = tempPostnumber;
    }

    public String getTempCity() {
        return tempCity;
    }

    public void setTempCity(String tempCity) {
        this.tempCity = tempCity;
    }
}