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
        <h2>Cadastro de Servidores</h2>
        <h2>Inserir novo servidor:</h2>
        <form action="AlterarServidor" method="post" required>
            <input type="text" hidden name="siape" value="<%=servidor.getSiape()%>">
            Siape:<%=servidor.getSiape()%><br><br>
            Nome:<input type="text" name="nome" value="<%=servidor.getNome()%>" required><br><br>
            Senha Antiga:<input type="password"  id="asenha" required><br><br>
            Nova Senha:<input type="password"  id="nsenha" name="nsenha" required><br><br>
            Confirme a Nova Senha:<input type="password"  id="c_senha" required><br>
            <br>
            <input type="submit" value="Alterar">
        </form>
    </body>
    <script type="text/javascript">
        var asenha = document.getElementById("asenha"), senha = document.getElementById("nsenha"), c_senha = document.getElementById("c_senha");
        function validarSenha() {
            if (asenha.value !== "<%=servidor.getSenha()%>") {
                asenha.setCustomValidity("Senha invalida!");
            } else {
                asenha.setCustomValidity('');
            }
            if (senha.value !== c_senha.value) {
                c_senha.setCustomValidity("Senhas diferentes!");
            } else {
                c_senha.setCustomValidity('');
            }
        }
        asenha.onchange = validarSenha;
        senha.onchange = validarSenha;
        c_senha.onkeyup = validarSenha;
    </script>
</html>
