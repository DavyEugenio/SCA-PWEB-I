package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.CursoDAO;
import modelo.Curso;

public class AlterarCurso extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CursoDAO dao = new CursoDAO();
        Curso curso = new Curso();
        curso.setId(Integer.parseInt(request.getParameter("id")));
        curso.setNome(request.getParameter("nome"));
        curso.setModalidade(request.getParameter("modalidade"));
        Boolean resultado = dao.Alterar(curso);
        String msg;
        if(resultado==true){
            msg="Curso Alterado com Sucesso!";
        }else{
            msg="Falha ao tentar alterar";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarCursos").forward(request, response);
    }

}
