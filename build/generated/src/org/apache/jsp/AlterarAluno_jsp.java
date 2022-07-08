package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import modelo.Aluno;
import DAO.AlunoDAO;
import modelo.Curso;
import DAO.CursoDAO;
import DAO.TurmaDAO;
import modelo.Turma;
import java.util.Iterator;
import java.util.List;

public final class AlterarAluno_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");

    AlunoDAO adao = new AlunoDAO();
    Aluno aluno = new Aluno();
    aluno.setSage(request.getParameter("sage"));
    aluno = adao.Buscar(aluno);
    CursoDAO dao = new CursoDAO();
    List listac = dao.Listar();
    TurmaDAO tdao = new TurmaDAO();
    List listat = tdao.Listar();
    Turma TA = new Turma();
    TA.setId(aluno.getId_turma());
    TA = tdao.Buscar(TA);
    Curso CA = new Curso();
    CA.setId(TA.getId_curso());

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body  onload=\"Turma()\">\n");
      out.write("        <h2>Cadastro de Alunos</h2>\n");
      out.write("        <h2>Alterar Aluno:</h2>\n");
      out.write("        Sage: ");
      out.print(aluno.getSage());
      out.write("<br><br>\n");
      out.write("        <form action=\"AlterarAluno\" method=\"post\">\n");
      out.write("            Nome:<input type=\"text\" name=\"nome\" value=\"");
      out.print(aluno.getNome());
      out.write("\" required><br><br>\n");
      out.write("            <input type=\"text\" name=\"sage\" value=\"");
      out.print(aluno.getSage());
      out.write("\" hidden>\n");
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
      out.write("                <option class=\"sta\" value=\"Matriculado\">Matriculado</option>\n");
      out.write("                <option class=\"sta\" value=\"Cursando\">Cursando</option>\n");
      out.write("                <option class=\"sta\" value=\"Desistente\">Desistente</option>\n");
      out.write("                <option class=\"sta\" value=\"Transferido\">Transferido</option>\n");
      out.write("                <option class=\"sta\" value=\"Formado\">Formado</option>\n");
      out.write("            </select><br><br>\n");
      out.write("            Senha Antiga:<input type=\"password\"  id=\"asenha\" required><br><br>\n");
      out.write("            Nova Senha:<input type=\"password\"  id=\"nsenha\" name=\"nsenha\" required><br><br>\n");
      out.write("            Confirme a Nova Senha:<input type=\"password\"  id=\"c_senha\" required><br>\n");
      out.write("            <br>\n");
      out.write("            <input type=\"submit\" value=\"Alterar\">\n");
      out.write("        </form>\n");
      out.write("        <p id=\"demo\"></p>\n");
      out.write("    </body>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("        var asenha = document.getElementById(\"asenha\"),\n");
      out.write("                nsenha = document.getElementById(\"nsenha\"),\n");
      out.write("                c_senha = document.getElementById(\"c_senha\"),\n");
      out.write("                demo = document.getElementById(\"demo\");\n");
      out.write("\n");
      out.write("        var curso = document.getElementsByClassName(\"curso\"),\n");
      out.write("                cursos = document.getElementById(\"cursos\"),\n");
      out.write("                turma = document.getElementsByClassName(\"turma\"),\n");
      out.write("                sta = document.getElementsByClassName(\"sta\");\n");
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
      out.write("                    if (turma[i].value === \"");
      out.print(TA.getId());
      out.write("\") {\n");
      out.write("                        turma[i].selected = true;\n");
      out.write("                    } else {\n");
      out.write("                        turma[i].selected = false;\n");
      out.write("                    }\n");
      out.write("                } else {\n");
      out.write("                    turma[i].hidden = true;\n");
      out.write("                    turma[i].selected = false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        for (var i = 0; i < curso.length; i++) {\n");
      out.write("            if (curso[i].value === \"");
      out.print(CA.getId());
      out.write("\") {\n");
      out.write("                curso[i].selected = true;\n");
      out.write("            } else {\n");
      out.write("                curso[i].selected = false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        for (var i = 0; i < sta.length; i++) {\n");
      out.write("            if (sta[i].value === \"");
      out.print(aluno.getStatus());
      out.write("\") {\n");
      out.write("                sta[i].selected = true;\n");
      out.write("            } else {\n");
      out.write("                sta[i].selected = false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function validarSenha() {\n");
      out.write("            if (asenha.value !== \"");
      out.print(aluno.getSenha());
      out.write("\") {\n");
      out.write("                asenha.setCustomValidity(\"Senha invalida!\");\n");
      out.write("            } else {\n");
      out.write("                asenha.setCustomValidity('');\n");
      out.write("            }\n");
      out.write("            if (nsenha.value !== c_senha.value) {\n");
      out.write("                c_senha.setCustomValidity(\"Senhas diferentes!\");\n");
      out.write("            } else {\n");
      out.write("                c_senha.setCustomValidity('');\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("        asenha.onchange = validarSenha;\n");
      out.write("        nsenha.onchange = validarSenha;\n");
      out.write("        c_senha.onkeyup = validarSenha;\n");
      out.write("        cursos.onchange = Turma;\n");
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
