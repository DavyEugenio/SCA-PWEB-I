package controle;

import DAO.CursoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;

public class ExcluirCurso extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CursoDAO dao = new CursoDAO();
        Curso curso = new Curso();
        curso.setId(Integer.parseInt(request.getParameter("id")));
        Boolean resultado = dao.Excluir(curso);
        String msg;
        if(resultado==true){
            msg="Curso Excluído com Sucesso!";
        }else{
            msg="Falha ao tentar excluir";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarCursos").forward(request, response);
    }

    
}
