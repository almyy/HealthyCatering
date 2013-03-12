package Login;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.faces.bean.ManagedProperty;

public class LoginFilter implements Filter {

    private FilterConfig filterConfig = null;
    @ManagedProperty(value="#{param.from}")
    private String from;

    public LoginFilter() {
    } 

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
        throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse)response;
        if (req.getUserPrincipal() == null) {
            System.out.println(req.getUserPrincipal());
            req.getSession().setAttribute("from", req.getRequestURI());
            res.sendRedirect("/login.jsf");
        } else {
            System.out.println(req.getUserPrincipal());
            chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() { 
    }

    @Override
    public void init(FilterConfig filterConfig) { 
        this.filterConfig = filterConfig;
    }

}
