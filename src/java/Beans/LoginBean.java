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

@ManagedBean
@ConversationScoped
@Named("Frontpage")
public class LoginBean implements Serializable {

    private HttpServletResponse response;
    private boolean loginActivated = false;
    private HttpServletRequest request;
    private String requestedURI;

    public void redirect() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            try {
                ExternalContext externalContext = facesContext.getExternalContext();
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

    /*
     * @PostConstruct public void init() { requestedURI = (String)
     * FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(RequestDispatcher.FORWARD_REQUEST_URI);
     *
     * if (requestedURI == null) { requestedURI = "register.xhtml"; } }
     *
     * public void submit() throws IOException { // ...
     *
     * FacesContext facesContext = FacesContext.getCurrentInstance(); if
     * (facesContext != null) { try { ExternalContext externalContext =
     * facesContext.getExternalContext(); request.login(username, password);
     * externalContext.redirect(requestedURI); } catch (Exception e) {
     * System.out.println("Bad login");
     *
     * }
     * }
     * }
     */
}
