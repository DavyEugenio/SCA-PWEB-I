<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Curso"%>
<%@page import="DAO.CursoDAO"%>
<%
    CursoDAO dao = new CursoDAO();
    Curso curso = new Curso();
    curso.setId(Integer.parseInt(request.getParameter("id")));
    curso = dao.Buscar(curso);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Cadastro de Curso</h2>
        <h2>Inserir novo curso:</h2>
        ID: <%=curso.getId()%><br>
        <form action="AlterarCurso" method="post" required>
            <input type="text" hidden name="id" value="<%=curso.getId()%>">
            Nome:<input type="text" name="nome" value="<%=curso.getNome()%>" required><br><br>
            Modalidade:
            <select name="modalidade">
                <option value="Medio Integrado">Médio Integrado</option>
                <option value="Subsequente">Subsequente</option>
                <option value="Subsequente EaD">Subsequente EaD</option>
                <option value="Proeja">Proeja</option>
                <option value="Superior">Superior</option>
            </select><br><br>
            <input type="submit" value="Alterar">
        </form>
    </body>
    <script type="text/javascript">
        var modalidade = document.getElementsByTagName("option");
        for (var i = 0; i < modalidade.length; i++) {
            if (modalidade[i].value === "<%=curso.getModalidade()%>") {
                modalidade[i].selected = true;
            } else {
                modalidade[i].selected = false;
            }
        }
    </script>
</html>
