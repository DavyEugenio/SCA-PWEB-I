package org.apache.jsp.Curso;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import modelo.Curso;
import DAO.CursoDAO;

public final class AlterarCurso_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    CursoDAO dao = new CursoDAO();
    Curso curso = new Curso();
    curso.setId(Integer.parseInt(request.getParameter("id")));
    curso = dao.Buscar(curso);

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Cadastro de Curso</h2>\n");
      out.write("        <h2>Inserir novo curso:</h2>\n");
      out.write("        ID: ");
      out.print(curso.getId());
      out.write("<br>\n");
      out.write("        <form action=\"/AlterarCurso\" method=\"post\" required>\n");
      out.write("            <input type=\"text\" hidden name=\"id\" value=\"");
      out.print(curso.getId());
      out.write("\">\n");
      out.write("            Nome:<input type=\"text\" name=\"nome\" value=\"");
      out.print(curso.getNome());
      out.write("\" required><br><br>\n");
      out.write("            Modalidade:\n");
      out.write("            <select name=\"modalidade\">\n");
      out.write("                <option value=\"Medio Integrado\">Médio Integrado</option>\n");
      out.write("                <option value=\"Subsequente\">Subsequente</option>\n");
      out.write("                <option value=\"Subsequente EaD\">Subsequente EaD</option>\n");
      out.write("                <option value=\"Proeja\">Proeja</option>\n");
      out.write("                <option value=\"Superior\">Superior</option>\n");
      out.write("            </select><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Alterar\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        var modalidade = document.getElementsByTagName(\"option\");\n");
      out.write("        for (var i = 0; i < modalidade.length; i++) {\n");
      out.write("            if (modalidade[i].value === \"");
      out.print(curso.getModalidade());
      out.write("\") {\n");
      out.write("                modalidade[i].selected = true;\n");
      out.write("            } else {\n");
      out.write("                modalidade[i].selected = false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("</html>\n");
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
