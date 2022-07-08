package controle;

import DAO.FrequenciaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Frequencia;

public class AlterarFrequencia extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Frequencia frequencia = new Frequencia();
        frequencia.setEntrada(request.getParameter("entrada"));
        frequencia.setSaida(request.getParameter("saida"));
        frequencia.setSage_aluno(request.getParameter("sage"));
        frequencia.setId(Integer.parseInt(request.getParameter("id")));
        FrequenciaDAO dao = new FrequenciaDAO();
        boolean resultado = dao.Alterar(frequencia);
        String msg;
        if (resultado == true) {
            msg = "Frequêcia encerrada com sucesso!";
        } else {
            msg = "Erro ao registrar!";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("Restrito/Aluno/index.jsp").forward(request, response);
    }
}
