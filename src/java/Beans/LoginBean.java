package Beans;

import DB.Database;
import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

@ManagedBean
@SessionScoped
@Named("Frontpage")
public class LoginBean implements Serializable {
    private Database db = new Database();

    public void redirect() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
                System.out.println(db.getRole()); 
                String l = db.getRole();
        try {
            if (db.getRole().equals("customer")) {
                externalContext.redirect(externalContext.getRequestContextPath()+ "/faces/protected/customer/customer.xhtml");
            }
            if (db.getRole().equals("chef")) {
                externalContext.redirect(externalContext.getRequestContextPath()+ "/faces/protected/worker/chef.xhtml");
            }
            if (db.getRole().equals("salesman")) {
                externalContext.redirect(externalContext.getRequestContextPath()+ "/faces/protected/worker/salesman.xhtml");
            }
            if (db.getRole().equals("driver")) {
                externalContext.redirect(externalContext.getRequestContextPath()+ "/faces/protected/worker/driver.xhtml");
            }
            if (db.getRole().equals("admin")) {
                externalContext.redirect(externalContext.getRequestContextPath()+ "/faces/protected/admin/admin.xhtml");
            }
        } catch (IOException e) {
            System.out.println("IOException");
        }

    }

    public void logout() {
        HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        httpSession.invalidate();
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        try {
            externalContext.redirect(externalContext.getRequestContextPath() + "/faces/index.xhtml");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public boolean isLoggedIn() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        if (externalContext.getRemoteUser() != null) {
            return true;
        }
        return false;
    }
}
