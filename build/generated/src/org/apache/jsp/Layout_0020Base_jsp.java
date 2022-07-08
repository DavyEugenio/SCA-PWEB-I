package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Layout_0020Base_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"pt\">\n");
      out.write("    <head>\n");
      out.write("        <title>SCA &mdash; ");
/*aluno.getNome()*/
      out.write("</title>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("        <link href=\"css/font.css\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/icomoon/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery-ui.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/jquery.fancybox.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/bootstrap-datepicker.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"fonts/flaticon/font/flaticon.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/aos.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/paginas_restritas.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/conteudo-index.css\">\n");
      out.write("    </head>\n");
      out.write("    <body data-spy=\"scroll\" data-target=\".site-navbar-target\" data-offset=\"300\" onload=\"Resultado()\">\n");
      out.write("        <div class=\"site-wrap\">\n");
      out.write("            <div class=\"site-mobile-menu site-navbar-target\">\n");
      out.write("                <div class=\"site-mobile-menu-header\">\n");
      out.write("                    <div class=\"site-mobile-menu-close mt-3\">\n");
      out.write("                        <span class=\"icon-close2 js-menu-toggle\"></span>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"site-mobile-menu-body\"></div>\n");
      out.write("            </div>\n");
      out.write("            <header class=\"site-navbar py-4 bg-white js-sticky-header site-navbar-target\" role=\"banner\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row align-items-center\">\n");
      out.write("                        <div class=\"col-6 col-xl-2\">\n");
      out.write("                            <h1 class=\"mb-0 site-logo text-black h2\"><a href=\"index.jsp\" class=\"text-black h2 mb-0\">SCA<span class=\"text-primary\">.</span></a><br>(Tipo de Usuario)</h1>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-12 col-md-10 d-none d-xl-block\">\n");
      out.write("                            <nav class=\"site-navigation position-relative text-right\" role=\"navigation\">\n");
      out.write("                                <ul class=\"site-menu main-menu js-clone-nav mr-auto d-none d-lg-block\">\n");
      out.write("                                    <li><a href=\"index.jsp\" class=\"nav-link\">Inicio</a></li>\n");
      out.write("                                    <li><a href=\"VerAluno.jsp\" class=\"nav-link\">Seus Dados</a></li>\n");
      out.write("                                        \n");
      out.write("                                </ul>\n");
      out.write("                            </nav>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-6 d-inline-block d-xl-none ml-md-0 py-3\" style=\"position: relative; top: 3px;\"><a href=\"#\" class=\"site-menu-toggle js-menu-toggle text-black float-right\"><span class=\"icon-menu h3\"></span></a> </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </header>\n");
      out.write("            <div id=\"conteudo\">\n");
      out.write("                <br>\n");
      out.write("                <h2>Seja Bem Vindo/a, ");
/*aluno.getNome() + "(Sage:" + aluno.getSage() + ")"*/
      out.write("</h2>\n");
      out.write("            </div>\n");
      out.write("            <footer class=\"site-footer\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                        <div class=\"col-md-8 col-sm-6 col-xs-12\">\n");
      out.write("                            <p class=\"copyright-text\">\n");
      out.write("                                Copyright &copy; <script>document.write(new Date().getFullYear());</script> All Rights Reserved by \n");
      out.write("                                <a href=\"#\">Scanfcode</a>.\n");
      out.write("                            </p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("            </footer>\n");
      out.write("        </div> \n");
      out.write("        <script src=\"js/jquery-3.3.1.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-migrate-3.0.1.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery-ui.js\"></script>\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.stellar.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.countdown.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-datepicker.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.easing.1.3.js\"></script>\n");
      out.write("        <script src=\"js/aos.js\"></script>\n");
      out.write("        <script src=\"js/jquery.fancybox.min.js\"></script>\n");
      out.write("        <script src=\"js/jquery.sticky.js\"></script>\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("        <script>\n");
      out.write("        function Resultado() {\n");
      out.write("            var msg = ");
      out.print("'" + request.getAttribute("msg") + "'");
      out.write(";\n");
      out.write("            var body = document.getElementsByTagName('body');\n");
      out.write("            /*window.history.pushState(\"data\", \"title\", \"/PWeb_SCA__DGJ_/Restrito/Aluno/\");*/\n");
      out.write("            if (msg !== \"null\") {\n");
      out.write("                alert(msg);\n");
      out.write("                location.reload();\n");
      out.write("            } else {\n");
      out.write("                body[0].style.display = \"inline\";\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        </script>\t\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
