package controle;

import DAO.AlunoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListarAlunos extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getAttribute("msg") != null) {
            String msg = "" + request.getAttribute("msg");
            request.setAttribute("msg", msg);
        }
        AlunoDAO dao = new AlunoDAO();
        List lista = dao.Listar();
        request.setAttribute("lista", lista);
        HttpSession sessao = request.getSession(true);
        if (sessao.getAttribute("sa") != null) {
            request.getRequestDispatcher("Restrito/Servidor/Aluno/Alunos.jsp").forward(request, response);
        } else {
            if (sessao.getAttribute("oa") != null) {
                request.getRequestDispatcher("Restrito/Operador/Aluno/Alunos.jsp").forward(request, response);
            }
        }
        
    }

}
