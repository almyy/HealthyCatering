package Beans;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.faces.context.ExternalContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

@ManagedBean
@ConversationScoped
@Named("Frontpage")
public class FrontpageBean implements Serializable {

    private HttpServletResponse response;
    private boolean loginActivated = false;
    private HttpServletRequest request;
    private String requestedURI;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void test() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            try {
                ExternalContext externalContext = facesContext.getExternalContext();
                if (facesContext.getExternalContext().getUserPrincipal().getName().equals("customer")) {
                    externalContext.redirect("faces/protected/employee.xhtml");
                }
                if (facesContext.getExternalContext().getUserPrincipal().getName().equals("worker")) {
                    externalContext.redirect("faces/protected/chef.xhtml");
                }
                if (facesContext.getExternalContext().getUserPrincipal().getName().equals("admin")) {
                    externalContext.redirect("faces/protected/admin.xhtml");
                }
            } catch (IOException e) {
                System.out.println("IOException");
            }
        }
    }

  /*  @PostConstruct
    public void init() {
        requestedURI = (String) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);

        if (requestedURI == null) {
            requestedURI = "register.xhtml";
        }
    }

    public void submit() throws IOException {
        // ...

        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            try {
                ExternalContext externalContext = facesContext.getExternalContext();
                request.login(username, password);
                externalContext.redirect(requestedURI);
            } catch (Exception e) {
                System.out.println("Bad login");
                        
            }
        }
    } */

    public boolean isLoginActivated() {
        return loginActivated;
    }

    public void setLoginActivated(boolean ok) {
        loginActivated = ok;
    }
}