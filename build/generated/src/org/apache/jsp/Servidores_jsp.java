package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.ServidorAbstrato;
import modelo.Servidor;
import java.util.List;
import java.util.Iterator;

public final class Servidores_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <style>\n");
      out.write("        table {\n");
      out.write("\n");
      out.write("            border: 1px solid black;\n");
      out.write("            border-collapse: collapse;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        tr {\n");
      out.write("            border: 1px solid black;\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        td,th{\n");
      out.write("            border: 1px solid black;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    <body onload=\"Resultado()\">\n");
      out.write("        <h2>Cadastro de Servidor</h2>\n");
      out.write("        <ul>\n");
      out.write("            <li style=\"display: inline\"><a href=\"index.html\">Home</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <h2>Lista de Servidor:</h2>\n");
      out.write("        ");
 List lista = (List)request.getAttribute("lista"); 
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr><th>Nome</th><th>Siape</th><th>Senha</th><th colspan=\"3\">Opções</th></tr>    \n");
      out.write("        ");
 for(Iterator i=lista.iterator(); i.hasNext();){
                ServidorAbstrato servidor =(ServidorAbstrato)i.next();
        
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(servidor.getNome());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(servidor.getSiape());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(servidor.getSenha());
      out.write("</td>\n");
      out.write("                <td><a href=\"VerServidor.jsp?siape=");
      out.print(servidor.getSiape());
      out.write("\">Ver</a>\n");
      out.write("                </td>\n");
      out.write("                <td><a href=\"AlterarServidor.jsp?siape=");
      out.print(servidor.getSiape());
      out.write("\">Alterar</a></td>\n");
      out.write("                <td><a href=\"ExcluirServidor?siape=");
      out.print(servidor.getSiape());
      out.write("\"> Apagar </a></td>\n");
      out.write("            </tr>\n");
      out.write("               \n");
      out.write("        ");
}
      out.write("\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        function Resultado() {\n");
      out.write("            var msg = ");
      out.print("'" + request.getAttribute("msg") + "'");
      out.write(";\n");
      out.write("            window.history.pushState(\"data\", \"title\", \"/PWeb_SCA__DGJ_/ListarServidores\");\n");
      out.write("            if (msg !== \"null\") {\n");
      out.write("                alert(msg);\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        function Confirmar(id, nome) {\n");
      out.write("            if (confirm(\"Deseja excluir a turma: \" + nome + \"?\")) {\n");
      out.write("                window.location.replace(\"ExcluirTurma?id=\" + id);\n");
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
