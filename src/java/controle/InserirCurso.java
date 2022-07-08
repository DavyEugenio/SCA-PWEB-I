package controle;

import DAO.CursoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;

public class InserirCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Curso curso = new Curso();
        curso.setNome(request.getParameter("nome"));
        curso.setModalidade(request.getParameter("modalidade"));
        CursoDAO dao = new CursoDAO();
        boolean resultado = dao.Inserir(curso);
        String msg;
        if (resultado == true) {
            msg = "Curso cadastrado com sucesso!";
        } else {
            msg = "Erro ao cadastrar";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarCursos").forward(request, response);
    }

}