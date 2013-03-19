package Beans;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ManagedBean
@ConversationScoped
@Named("Frontpage")
public class LoginBean implements Serializable {

    private HttpServletResponse response;
    private boolean loginActivated = false;
    private HttpServletRequest request;
    private String requestedURI;
    private FacesContext facesContext = FacesContext.getCurrentInstance();
    private ExternalContext externalContext = facesContext.getExternalContext();

    public void redirect() {
        if (facesContext != null) {
            try {
                if (facesContext.getExternalContext().getUserPrincipal().getName().equals("customer")) {
                    externalContext.redirect("faces/protected/customer.xhtml");
                }
                if (facesContext.getExternalContext().getUserPrincipal().getName().equals("chef")) {
                    externalContext.redirect("faces/protected/chef.xhtml");
                }
                if (facesContext.getExternalContext().getUserPrincipal().getName().equals("salesman")) {
                    externalContext.redirect("faces/protected/salesman.xhtml");
                }
                if (facesContext.getExternalContext().getUserPrincipal().getName().equals("driver")) {
                    externalContext.redirect("faces/protected/driver.xhtml");
                }
                if (facesContext.getExternalContext().getUserPrincipal().getName().equals("admin")) {
                    externalContext.redirect("faces/protected/admin.xhtml");
                }
            } catch (IOException e) {
                System.out.println("IOException");
            }
        }
    }

    public void logout() {
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        httpSession.invalidate();
        try {
            externalContext.redirect("index.xhtml");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
