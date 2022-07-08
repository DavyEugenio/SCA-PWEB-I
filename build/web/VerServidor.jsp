<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Servidor"%>
<%@page import="DAO.ServidorDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ServidorDAO dao = new ServidorDAO();
    Servidor servidor = new Servidor();
    servidor.setSiape(request.getParameter("siape"));
    servidor = dao.Buscar(servidor);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Dados do Servidor</h2>
        Siape: <%=servidor.getSiape()%><br><br>
        Nome: <%=servidor.getNome()%><br><br>
        Senha: <%=servidor.getSenha()%>
    </body>
</html>
