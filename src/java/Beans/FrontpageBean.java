package Beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.faces.context.ExternalContext;

@ManagedBean
@RequestScoped
@Named("Frontpage")

public class FrontpageBean implements Serializable {

    private boolean loginActivated = false;
    private HttpServletRequest request;

    public void test() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        System.out.println(FacesContext.getCurrentInstance());
        if (facesContext != null) {
            System.out.println(facesContext.getExternalContext().getUserPrincipal() +"OLOLL");
            try {
                ExternalContext externalContext = facesContext.getExternalContext();
                System.out.println(facesContext.getExternalContext().getAuthType()+"OLOLLOELELELELE");
                externalContext.redirect("register.xhtml");
            } catch (IOException e) {
                System.out.println("IOException");
            }
        }
    }

    public boolean isLoginActivated() {
        return loginActivated;
    }

    public void setLoginActivated(boolean ok) {
        loginActivated = ok;
    }
}