package controle;

import DAO.AlunoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;

public class ExcluirAluno extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = new Aluno();
        aluno.setSage(request.getParameter("sage"));
        Boolean resultado = dao.Excluir(aluno);
        String msg;
        if(resultado==true){
            msg="Aluno(a) Excluído com Sucesso!";
        }else{
            msg="Falha ao tentar excluir";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarAlunos").forward(request, response);
    }

    
}
