package controle;

import DAO.ServidorAbstratoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Operador;
import modelo.Servidor;
import modelo.ServidorAbstrato;

public class InserirServidor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServidorAbstrato servidor;
        if(request.getParameter("tipo").equals("servidor")){
            servidor = new Servidor();
        } else {
            servidor = new Operador();
        }
        servidor.setNome(request.getParameter("nome"));
        servidor.setSiape(request.getParameter("siape"));
        servidor.setSenha(request.getParameter("senha"));
        servidor.setFuncao(request.getParameter("funcao"));
        ServidorAbstratoDAO dao = new DAO.ServidorAbstratoDAO();
        boolean resultado = dao.Inserir(servidor);
        String msg;
        if (resultado == true) {
            msg = "Servidor Cadastrado com Sucesso!";
        } else {
            msg = "Erro ao Cadastrar";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarServidores").forward(request, response);
    }

}