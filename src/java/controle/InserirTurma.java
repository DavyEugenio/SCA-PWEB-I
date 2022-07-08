package controle;

import DAO.TurmaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Turma;

public class InserirTurma extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Turma turma = new Turma();
        turma.setAno(Integer.parseInt(request.getParameter("ano")));
        turma.setId_curso(Integer.parseInt(request.getParameter("curso")));
        turma.setSemestre(Integer.parseInt(request.getParameter("semestre")));
        turma.setTurno(request.getParameter("turno"));
        TurmaDAO dao = new TurmaDAO();
        boolean resultado = dao.Inserir(turma);
        String msg;
        if (resultado == true) {
            msg = "Turma Cadastrada com Sucesso!";
        } else {
            msg = "Erro ao Cadastrar";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarTurmas").forward(request, response);
    }
}