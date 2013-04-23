package Language;

import java.io.Serializable;
import java.util.Locale;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean(name="Lang")
@SessionScoped

public class LangChange implements Serializable{

    private FacesContext context = FacesContext.getCurrentInstance();
    private Locale locale =  context.getViewRoot().getLocale();

    public Locale getLocale() {
        return locale;
    }

    private void setLang(String lang) {
        locale  = new Locale(lang);
        context.getViewRoot().setLocale(new Locale(lang));
    }
    
    public void setEng(){
        setLang("en");
    }

    public void setNo(){
        setLang("no");
    }
}
