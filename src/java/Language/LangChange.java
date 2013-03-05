package Language;

import java.util.Locale;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("Lang")
@Dependent
public class LangChange {

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
