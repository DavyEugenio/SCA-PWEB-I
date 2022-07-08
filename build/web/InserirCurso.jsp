<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Cadastro de Curso</h2>
        <h2>Inserir novo curso:</h2>
        <form action="InserirCurso" method="post" required>
            Nome:<input type="text" name="nome" required><br><br>
            Modalidade:
            <select name="modalidade">
                <option value="Medio Integrado" selected="">Médio Integrado</option>
                <option value="Subsequente">Subsequente</option>
                <option value="Subsequente EaD">Subsequente EaD</option>
                <option value="Proeja">Proeja</option>
                <option value="Superior">Superior</option>
            </select><br><br>
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
