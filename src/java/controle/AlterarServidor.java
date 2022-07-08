package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ServidorAbstratoDAO;
import modelo.Operador;
import modelo.Servidor;
import modelo.ServidorAbstrato;


public class AlterarServidor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServidorAbstratoDAO dao = new ServidorAbstratoDAO();
        ServidorAbstrato servidor;
        if(request.getParameter("tipo").equals("servidor")){
            servidor = new Servidor();
        } else {
            servidor = new Operador();
        }
        servidor.setSiape(request.getParameter("siape"));
        servidor.setNome(request.getParameter("nome"));
        servidor.setFuncao(request.getParameter("funcao"));
        servidor.setSenha(request.getParameter("nsenha"));
        Boolean resultado = dao.Alterar(servidor);
        String msg;
        if(resultado==true){
            msg="Servidor Alterado com Sucesso!";
        }else{
            msg="Falha ao tentar alterar";
        }
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("/ListarServidores").forward(request, response);
    }

}
