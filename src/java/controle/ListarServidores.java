package controle;

import DAO.ServidorAbstratoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ListarServidores extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getAttribute("msg") != null) {
            String msg = "" + request.getAttribute("msg");
            request.setAttribute("msg", msg);
        }
        ServidorAbstratoDAO dao = new ServidorAbstratoDAO();
        List lista = dao.Listar();
        request.setAttribute("lista", lista);
        request.getRequestDispatcher("Restrito/Operador/Servidor/Servidores.jsp").forward(request, response);
    }
}
