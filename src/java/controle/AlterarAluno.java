package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.AlunoDAO;
import modelo.Aluno;


public class AlterarAluno extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = new Aluno();
        aluno.setSage(request.getParameter("sage"));
        aluno.setNome(request.getParameter("nome"));
        aluno.setId_turma(Integer.parseInt(request.getParameter("turma")));
        aluno.setStatus(request.getParameter("status"));
        aluno.setSenha(request.getParameter("nsenha"));
        boolean resultado = dao.Alterar(aluno);
        String msg;
        if(resultado==true){
            msg="Aluno Alterado com Sucesso!";
        }else{
            msg="Falha ao tentar alterar!";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarAlunos").forward(request, response);
    }

}
