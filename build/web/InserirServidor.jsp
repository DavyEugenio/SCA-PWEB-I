<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Cadastro de Servidores</h2>
        <h2>Inserir novo servidor:</h2>
        <form action="InserirServidor" method="post" required>
            Nome:<input type="text" name="nome" required><br><br>
            Siape:<input type="text" name="siape" required><br><br>
            Senha:<input type="password"  id="senha" name="senha" required><br><br>
            Confirme Senha:<input type="password"  id="c_senha" required><br>
            <br>
            <input type="submit" value="Cadastrar">
        </form>
    </body>
    <script type="text/javascript">
        var senha = document.getElementById("senha") , c_senha = document.getElementById("c_senha");
        function validarSenha() {
            if (senha.value !== c_senha.value) {
                c_senha.setCustomValidity("Senhas diferentes!");
            } else {
                c_senha.setCustomValidity('');
            }
        }
        senha.onchange = validarSenha;
        c_senha.onkeyup = validarSenha;
    </script>
</html>
