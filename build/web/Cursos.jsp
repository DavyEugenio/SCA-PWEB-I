<%@page import="modelo.Curso"%>
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
        <h2>Cadastro de Curso</h2>
        <ul>
            <li style="display: inline"><a href="index.html">Home</a></li>
            <li style="display: inline"><a href="inserircurso.jsp">Cadastrar Usuário</a></li>
            <li style="display: inline"><a href="Listarcursos">Listar Usuários</a></li>
        </ul>
        <h2>Lista de Cursos:</h2>
        <% List lista = (List)request.getAttribute("lista"); %>
        <table border="solid red 2px">
            <tr><td>ID</td><td>Nome</td><td>Modalidade</td></tr>    
        <% for(Iterator i=lista.iterator(); i.hasNext();){
                Curso curso =(Curso)i.next();
        %>
            <tr>
                <td><%=curso.getId()%></td>
                <td><%=curso.getNome()%></td>
                <td><%=curso.getModalidade()%></td>
                <td><a href="/PWeb_SCA__DGJ_/VerCurso.jsp?id=<%=curso.getId()%>">Ver</a>
                </td>
                <td><a href="/PWeb_SCA__DGJ_/AlterarCurso.jsp?id=<%=curso.getId()%>">Alterar</a></td>
                <td><a href="/PWeb_SCA__DGJ_/ExcluirCurso?id=<%=curso.getId()%>"> Apagar </a></td>
            </tr>
               
        <%}%>
        </table>
    </body>
</html>