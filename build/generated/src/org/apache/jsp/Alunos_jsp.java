package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import DAO.TurmaDAO;
import DAO.CursoDAO;
import modelo.Curso;
import modelo.Turma;
import modelo.Aluno;
import java.util.List;
import java.util.Iterator;

public final class Alunos_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <body>\n");
      out.write("        <h2>Cadastro de aluno</h2>\n");
      out.write("        <ul>\n");
      out.write("            <li style=\"display: inline\"><a href=\"index.html\">Home</a></li>\n");
      out.write("            <li style=\"display: inline\"><a href=\"Inseriraluno.jsp\">Cadastrar aluno</a></li>\n");
      out.write("        </ul>\n");
      out.write("        <h2>Lista de alunos:</h2>\n");
      out.write("        ");
 List lista = (List) request.getAttribute("lista"); 
      out.write("\n");
      out.write("        <table>\n");
      out.write("            <tr><th>Sage</th><th>Nome</th><th>Turma</th><th>Curso</th><th>Status</th><th  colspan=\"3\">Opções</th></tr>    \n");
      out.write("                    ");
 for (Iterator i = lista.iterator(); i.hasNext();) {
                            Aluno aluno = (Aluno) i.next();
                            Turma turma = new Turma();
                            turma.setId(aluno.getId_turma());
                            TurmaDAO tdao = new TurmaDAO();
                            turma = tdao.Buscar(turma);
                            Curso curso = new Curso();
                            curso.setId(turma.getId_curso());
                            CursoDAO dao = new CursoDAO();
                            curso = dao.Buscar(curso);
                            String nome = curso.getNome() + " - " + curso.getModalidade();
                    
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(aluno.getSage());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(aluno.getNome());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(turma.getAno() + "." + turma.getSemestre() + " - " +turma.getTurno());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(nome);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(aluno.getStatus());
      out.write("</td>\n");
      out.write("                <td><a href=\"/PWeb_SCA__DGJ_/VerAluno.jsp?id=");
      out.print(aluno.getSage());
      out.write("\"><button>Ver</button></a>\n");
      out.write("                </td>\n");
      out.write("                <td>  <a href=\"/PWeb_SCA__DGJ_/AlterarAluno.jsp?id=");
      out.print(aluno.getSage());
      out.write("\"><button>Alterar</button></a></td>\n");
      out.write("                <td> <button onclick=\"Confirmar(");
      out.print(aluno.getSage());
      out.write(", '");
      out.print(aluno.getNome());
      out.write("')\">Apagar</button></td>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("        function Confirmar(id, nome) {\n");
      out.write("            if (confirm(\"Deseja excluir a aluno: \" + nome + \"?\")) {\n");
      out.write("                window.location.replace(\"ExcluirAluno?id=\" + id);\n");
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
