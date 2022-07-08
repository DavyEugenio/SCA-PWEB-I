package controle;

import DAO.TurmaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Turma;

public class ExcluirTurma extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TurmaDAO dao = new TurmaDAO();
        Turma turma = new Turma();
        turma.setId(Integer.parseInt(request.getParameter("id")));
        Boolean resultado = dao.Excluir(turma);
        String msg;
        if(resultado==true){
            msg="Turma Excluída com Sucesso!";
        }else{
            msg="Falha ao tentar excluir";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarTurmas").forward(request, response);
    }    
}
