package controle;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class FiltroSegurancaOperador implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        String url = servletRequest.getRequestURI();
        HttpSession sessao = servletRequest.getSession();
        if (sessao.getAttribute("oa") != null
                || url.lastIndexOf("index.jsp") > -1
                || url.lastIndexOf("validarLogin") > -1) {
            chain.doFilter(request, response);
        } else {
            String msg = "É preciso estar \"logado\" operador para acessar esta página!";
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }
}
