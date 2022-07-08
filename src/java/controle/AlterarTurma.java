package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.TurmaDAO;
import modelo.Turma;


public class AlterarTurma extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TurmaDAO dao = new TurmaDAO();
        Turma turma = new Turma();
        turma.setAno(Integer.parseInt(request.getParameter("ano")));
        turma.setId_curso(Integer.parseInt(request.getParameter("curso")));
        turma.setSemestre(Integer.parseInt(request.getParameter("semestre")));
        turma.setTurno(request.getParameter("turno"));
        turma.setId(Integer.parseInt(request.getParameter("id")));
        boolean resultado = dao.Alterar(turma);
        String msg;
        if(resultado==true){
            msg="Turma Alterada com Sucesso!";
        }else{
            msg="Falha ao tentar alterar";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarTurmas").forward(request, response);
    }

}
