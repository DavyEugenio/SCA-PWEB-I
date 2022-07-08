package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.AlunoDAO;
import javax.servlet.http.HttpSession;
import modelo.Aluno;


public class AlterarSenhaAluno extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        AlunoDAO dao = new AlunoDAO();
        Aluno aluno = new Aluno();
        aluno.setSage(request.getParameter("sage"));
        aluno = dao.Buscar(aluno);
        aluno.setSenha(request.getParameter("nsenha"));
        boolean resultado = dao.Alterar(aluno);
        String msg;
        if(resultado==true){
            sessao.setAttribute("aa", aluno);
            msg="Senha Alterada com Sucesso!";
        }else{
            msg="Falha ao tentar alterar!";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("Restrito/Aluno/index.jsp").forward(request, response);
    }

}
