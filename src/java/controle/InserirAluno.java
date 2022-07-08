package controle;

import DAO.AlunoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;

public class InserirAluno extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Aluno aluno = new Aluno();
        aluno.setNome(request.getParameter("nome"));
        aluno.setSage(request.getParameter("sage"));
        aluno.setSenha(request.getParameter("senha"));
        aluno.setId_turma(Integer.parseInt(request.getParameter("turma")));
        aluno.setStatus(request.getParameter("status"));
        AlunoDAO dao = new DAO.AlunoDAO();
        boolean resultado = dao.Inserir(aluno);
        String msg;
        if (resultado == true) {
            msg = "Aluno(a) cadastrado com sucesso!";
        } else {
            msg = "Erro ao cadastrar!";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarAlunos").forward(request, response);
    }
}
