package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ServidorAbstratoDAO;
import javax.servlet.http.HttpSession;
import modelo.Servidor;
import modelo.ServidorAbstrato;

public class AlterarSenhaServidor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        ServidorAbstratoDAO dao = new ServidorAbstratoDAO();
        ServidorAbstrato servidor = null;
        servidor = dao.Buscar(request.getParameter("siape"));
        servidor.setSenha(request.getParameter("nsenha"));
        boolean resultado = dao.Alterar(servidor);
        String msg;
        if (resultado == true) {
            if (servidor instanceof Servidor) {
                sessao.setAttribute("sa", servidor);
            } else {
                sessao.setAttribute("oa", servidor);
            }
            msg = "Senha Alterada com Sucesso!";
        } else {
            msg = "Falha ao tentar alterar!";
        }
        request.setAttribute("msg", msg);
        if (servidor instanceof Servidor) {
            request.getRequestDispatcher("Restrito/Servidor/VerServidor.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Restrito/Operador/VerServidor.jsp").forward(request, response);
        }

    }

}
