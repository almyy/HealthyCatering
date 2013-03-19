package Beans;

import java.io.IOException;
import java.io.Serializable;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ManagedBean
// @ConversationScoped
@SessionScoped
@Named("Frontpage")
public class LoginBean implements Serializable {

    private boolean test;

    public void test() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        System.out.println(facesContext.getExternalContext().getUserPrincipal().getName());
    }

    public void redirect() {
        //       HttpServletResponse response;
        //     HttpServletRequest request;
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        if (facesContext != null) {
            try {
                if (externalContext.getUserPrincipal().getName().equals("customer")) {
                    externalContext.redirect("faces/protected/customer.xhtml");
                }
                if (externalContext.getUserPrincipal().getName().equals("chef")) {
                    externalContext.redirect("faces/protected/chef.xhtml");
                }
                if (externalContext.getUserPrincipal().getName().equals("salesman")) {
                    externalContext.redirect("faces/protected/salesman.xhtml");
                }
                if (externalContext.getUserPrincipal().getName().equals("driver")) {
                    externalContext.redirect("faces/protected/driver.xhtml");
                }
                if (externalContext.getUserPrincipal().getName().equals("admin")) {
                    externalContext.redirect("faces/protected/admin.xhtml");
                }
                test = true;
            } catch (IOException e) {
                System.out.println("IOException");
            }
        }
    }

    public String logout() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(false);
        httpSession.invalidate();
        return "../index.xhtml?faces-redirect=true";
    }

    public boolean isTest() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        System.out.println(facesContext.getExternalContext());
        System.out.println(externalContext.getUserPrincipal());
        if(externalContext.getUserPrincipal() != null){
            return true;
        }
        return false;
    }
}
