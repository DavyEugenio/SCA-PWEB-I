package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Curso;
import DAO.CursoDAO;
import DAO.TurmaDAO;
import modelo.Turma;
import java.util.Iterator;
import java.util.List;

public final class InserirAluno_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    CursoDAO dao = new CursoDAO();
    List listac = dao.Listar();
    TurmaDAO turmadao = new TurmaDAO();
    List listat = turmadao.Listar();


      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body  onload=\"Turma()\">\n");
      out.write("        <h2>Cadastro de Alunos</h2>\n");
      out.write("        <h2>Inserir novo Aluno:</h2>\n");
      out.write("        <form action=\"InserirAluno\" method=\"post\" required>\n");
      out.write("            Nome:<input type=\"text\" name=\"nome\" required><br><br>\n");
      out.write("            Sage:<input type=\"text\" name=\"sage\" required><br><br>\n");
      out.write("            Curso:\n");
      out.write("            <select id=\"cursos\">\n");
      out.write("                ");
 for (Iterator i = listac.iterator(); i.hasNext();) {
                        Curso curso = (Curso) i.next();
                
      out.write("\n");
      out.write("                <option class=\"curso\" value=\"");
      out.print(curso.getId());
      out.write('"');
      out.write('>');
      out.print(curso.getNome() + " - " + curso.getModalidade());
      out.write("</option>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </select><br><br>\n");
      out.write("            Turma:\n");
      out.write("            <select name=\"turma\">\n");
      out.write("                ");
 for (Iterator i = listat.iterator(); i.hasNext();) {
                        Turma turma = (Turma) i.next();
                        Curso curso = new Curso();
                        curso.setId(turma.getId_curso());
                        curso = dao.Buscar(curso);
                
      out.write("\n");
      out.write("                <option class=\"turma\" id=\"");
      out.print(turma.getId_curso());
      out.write("\" value=\"");
      out.print(turma.getId());
      out.write('"');
      out.write('>');
      out.print(turma.getAno() + "." + turma.getSemestre() + " - " + turma.getTurno());
      out.write("</option>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </select><br><br>\n");
      out.write("            Status:\n");
      out.write("            <select name=\"status\">\n");
      out.write("                <option value=\"Matriculado\" selected>Matriculado</option>\n");
      out.write("                <option value=\"Cursando\">Cursando</option>\n");
      out.write("                <option value=\"Desistente\">Desistente</option>\n");
      out.write("                <option value=\"Transferido\">Transferido</option>\n");
      out.write("                <option value=\"Formado\">Formado</option>\n");
      out.write("            </select><br><br>\n");
      out.write("            Senha:<input type=\"password\"  id=\"senha\" name=\"senha\" required><br><br>\n");
      out.write("            Confirme Senha:<input type=\"password\"  id=\"c_senha\" required><br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\" value=\"Cadastrar\">\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        var senha = document.getElementById(\"senha\"), c_senha = document.getElementById(\"c_senha\");\n");
      out.write("        var curso = document.getElementsByClassName(\"curso\"), cursos = document.getElementById(\"cursos\"), turma = document.getElementsByClassName(\"turma\");\n");
      out.write("        function Curso() {\n");
      out.write("            for (var i = 0; i < curso.length; i++) {\n");
      out.write("                if (curso[i].selected === true) {\n");
      out.write("                    return curso[i].value;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        function Turma() {\n");
      out.write("            for (var i = 0; i < turma.length; i++) {\n");
      out.write("                if (turma[i].getAttribute(\"id\") === Curso()) {\n");
      out.write("                    turma[i].hidden = false;\n");
      out.write("                    turma[i].selected = true;\n");
      out.write("                } else {\n");
      out.write("                    turma[i].hidden = true;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        function validarSenha() {\n");
      out.write("            if (senha.value !== c_senha.value) {\n");
      out.write("                c_senha.setCustomValidity(\"Senhas diferentes!\");\n");
      out.write("            } else {\n");
      out.write("                c_senha.setCustomValidity('');\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        cursos.onchange = Turma;\n");
      out.write("        senha.onchange = validarSenha;\n");
      out.write("        c_senha.onkeyup = validarSenha;\n");
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
