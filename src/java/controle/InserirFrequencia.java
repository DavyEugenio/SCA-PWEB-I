package controle;

import DAO.FrequenciaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Frequencia;

public class InserirFrequencia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Frequencia frequencia = new Frequencia();
        frequencia.setEntrada(request.getParameter("entrada"));
        frequencia.setSage_aluno(request.getParameter("sage"));
        FrequenciaDAO dao = new FrequenciaDAO();
        boolean resultado = dao.Inserir(frequencia);
        String msg;
        if (resultado == true) {
            msg = "Frequêcia iniciada com sucesso!";
        } else {
            msg = "Erro ao registrar!";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("Restrito/Aluno/index.jsp").forward(request, response);
    }
}
