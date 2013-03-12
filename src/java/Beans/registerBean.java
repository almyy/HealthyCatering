package Beans;

import DB.Database;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import Java.User;


@SessionScoped
@ManagedBean(name="Register")
public class registerBean implements Serializable {
    private User user = new User();
    Database db = new Database();

    public void validateUsername(FacesContext context, UIComponent component, Object value) {
        String message = "";
        String username = (String) value;
        if(db.userExist(username) || username.length() < 5) {
            ((UIInput)component).setValid(false);
            message = "The username already exists, or your username is shorter than 5 characters";
            context.addMessage(component.getClientId(context), new FacesMessage(message));
        }
    }
    
    public void validatePassword(FacesContext context, UIComponent component, Object value) {
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
    public User getUser() {
        return user;
    }
    public void apply() {
        db.newUser(user);
    }
}