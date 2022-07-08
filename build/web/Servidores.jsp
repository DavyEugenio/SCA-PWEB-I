<%@page import="modelo.Servidor"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Cadastro de Servidor</h2>
        <ul>
            <li style="display: inline"><a href="index.html">Home</a></li>
        </ul>
        <h2>Lista de Servidor:</h2>
        <% List lista = (List)request.getAttribute("lista"); %>
        <table border="solid red 2px">
            <tr><td>Nome</td><td>Siape</td><td>Senha</td></tr>    
        <% for(Iterator i=lista.iterator(); i.hasNext();){
                Servidor servidor =(Servidor)i.next();
        %>
            <tr>
                <td><%=servidor.getNome()%></td>
                <td><%=servidor.getSiape()%></td>
                <td><%=servidor.getSenha()%></td>
                <td><a href="/PWeb_SCA__DGJ_/VerServidor.jsp?siape=<%=servidor.getSiape()%>">Ver</a>
                </td>
                <td><a href="/PWeb_SCA__DGJ_/AlterarServidor.jsp?siape=<%=servidor.getSiape()%>">Alterar</a></td>
                <td><a href="/PWeb_SCA__DGJ_/ExcluirServidor?siape=<%=servidor.getSiape()%>"> Apagar </a></td>
            </tr>
               
        <%}%>
        </table>
    </body>
</html>
