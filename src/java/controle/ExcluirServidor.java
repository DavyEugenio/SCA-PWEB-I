package controle;

import DAO.ServidorAbstratoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Servidor;

public class ExcluirServidor extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServidorAbstratoDAO dao = new ServidorAbstratoDAO();
        Servidor servidor = new Servidor();
        servidor.setSiape(request.getParameter("siape"));
        Boolean resultado = dao.Excluir(servidor);
        String msg;
        if(resultado==true){
            msg="Servidor Excluído com Sucesso!";
        }else{
            msg="Falha ao tentar excluir";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarServidores").forward(request, response);
    }

    
}
