package controle;

import DAO.AlunoDAO;
import DAO.ServidorAbstratoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Aluno;
import modelo.Servidor;
import modelo.ServidorAbstrato;

public class ValidarLogin extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String tipo = request.getParameter("tipo");
        switch (tipo) {
            case "SA":
                ServidorAbstratoDAO sadao = new ServidorAbstratoDAO();
                ServidorAbstrato saa = sadao.login(login, senha);
                if (saa != null) {
                    HttpSession sessao = request.getSession();
                    if (saa instanceof Servidor) {
                        sessao.setAttribute("sa", saa);
                        ((HttpServletResponse) response).sendRedirect("Restrito/Servidor/");
                    } else {
                        sessao.setAttribute("oa", saa);
                        ((HttpServletResponse) response).sendRedirect("Restrito/Operador/");
                    }
                } else {
                    request.setAttribute("msg", "Siape e/ou senha incorreto/s!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
            case "A":
                AlunoDAO adao = new AlunoDAO();
                Aluno aluno = new Aluno();
                aluno.setSage(login);
                aluno.setSenha(senha);
                Aluno aa = adao.Login(aluno);
                if (aa != null) {
                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("aa", aa);
                    ((HttpServletResponse) response).sendRedirect("Restrito/Aluno/");
                } else {
                    request.setAttribute("msg", "Sage e/ou senha incorreto/s!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;
        }
    }
}
