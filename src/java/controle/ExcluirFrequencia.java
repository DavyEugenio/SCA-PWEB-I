package controle;

import DAO.FrequenciaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Frequencia;

public class ExcluirFrequencia extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FrequenciaDAO dao = new FrequenciaDAO();
        Frequencia frequencia = new Frequencia();
        frequencia.setId(Integer.parseInt(request.getParameter("id")));
        Boolean resultado = dao.Excluir(frequencia);
        String sage = request.getParameter("sage");
        String msg;
        if(resultado==true){
            msg="Frequencia Excluída com Sucesso!";
        }else{
            msg="Falha ao tentar excluir";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/Restrito/Operador/Aluno/VerAluno.jsp?sage="+ sage).forward(request, response);
    }    
}