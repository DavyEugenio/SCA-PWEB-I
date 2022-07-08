package org.apache.jsp.Turma;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import modelo.Curso;
import java.util.List;
import DAO.CursoDAO;

public final class InserirTurma_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    List lista = dao.Listar();

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h2>Cadastro de Turma</h2>\n");
      out.write("        <h2>Inserir novo turma:</h2>\n");
      out.write("        <form action=\"InserirTurma\" method=\"post\">\n");
      out.write("            Ano: <input type=\"number\" name=\"ano\" value=\"2019\" max=\"2100\" min=\"2010\" style=\"width:50px\"><br><br>\n");
      out.write("            Semestre:\n");
      out.write("            <select name=\"semestre\">\n");
      out.write("                <option value=\"1\" selected=>1</option>\n");
      out.write("                <option value=\"2\">2</option>\n");
      out.write("            </select><br><br>\n");
      out.write("            Turno:\n");
      out.write("            <select name=\"turno\">\n");
      out.write("                <option value=\"Matutino\" selected=>Matutino</option>\n");
      out.write("                <option value=\"Vespertino\">Vespertino</option>\n");
      out.write("                <option value=\"Noturno\">Noturno</option>\n");
      out.write("            </select><br><br>\n");
      out.write("            Curso:\n");
      out.write("            <select name=\"curso\">\n");
      out.write("            ");
 for(Iterator i=lista.iterator(); i.hasNext();){
                Curso curso =(Curso)i.next();
            
      out.write("\n");
      out.write("                <option value=\"");
      out.print(curso.getId());
      out.write('"');
      out.write('>');
      out.print(curso.getNome() + " - " + curso.getModalidade());
      out.write("</option>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            </select><br><br>\n");
      out.write("            <input type=\"submit\" value=\"Cadastrar\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
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
