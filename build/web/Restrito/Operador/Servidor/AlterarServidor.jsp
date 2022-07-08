<%@page import="modelo.Operador"%>
<%@page import="modelo.ServidorAbstrato"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Servidor"%>
<%@page import="DAO.ServidorAbstratoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sessao = request.getSession(true);
    Operador operador = (Operador) sessao.getAttribute("oa");
    ServidorAbstratoDAO dao = new ServidorAbstratoDAO();
    ServidorAbstrato servidor;
    servidor = dao.Buscar(request.getParameter("siape"));
    String tipo;
    if(servidor instanceof Servidor){
        tipo = "servidor";
    } else {
        tipo = "operador";
    }
%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>SCA &mdash; <%=operador.getNome()%></title>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="../../../images/SCA-logo.ico" type="image/x-icon"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="../../../css/font.css">
        <link rel="stylesheet" href="../../../fonts/icomoon/style.css">
        <link rel="stylesheet" href="../../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../../css/jquery-ui.css">
        <link rel="stylesheet" href="../../../css/owl.carousel.min.css">
        <link rel="stylesheet" href="../../../css/owl.theme.default.min.css">
        <link rel="stylesheet" href="../../../css/owl.theme.default.min.css">
        <link rel="stylesheet" href="../../../css/jquery.fancybox.min.css">
        <link rel="stylesheet" href="../../../css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="../../../fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="../../../css/aos.css">
        <link rel="stylesheet" href="../../../css/style.css">
        <link rel="stylesheet" href="../../../css/forms.css">
    </head>
    <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300" onload="Resultado()">
        <div class="site-wrap">
            <div class="site-mobile-menu site-navbar-target">
                <div class="site-mobile-menu-header">
                    <div class="site-mobile-menu-close mt-3">
                        <span class="icon-close2 js-menu-toggle"></span>
                    </div>
                </div>
                <div class="site-mobile-menu-body"></div>
            </div>
            <header class="site-navbar py-4 bg-white js-sticky-header site-navbar-target" role="banner">
                <div class="container">
                    <div class="row align-items-center">
                        <div class="col-6 col-xl-2">
                            <h1 class="mb-0 site-logo text-black h2"><a href="index.jsp" class="text-black h2 mb-0">SCA<span class="text-primary">.</span></a><br>(Operadores)</h1>
                        </div>
                        <div class="col-12 col-md-10 d-none d-xl-block">
                            <nav class="site-navigation position-relative text-right" role="navigation">
                                <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                                    <li><a href="../index.jsp" class="nav-link">Inicio</a></li>
                                    <li><a href="../VerServidor.jsp" class="nav-link">Seus Dados</a></li>
                                    <li>
                                        <div class="dropdown">
                                            <a class=" dropdown-toggle mr-4 nav-link" data-toggle="dropdown" aria-haspopup="true"
                                               aria-expanded="false">Cadastrar</a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item nav-link" href="../Servidor/InserirServidor.jsp">Servidor</a>
                                                <a class="dropdown-item nav-link" href="../Curso/InserirCurso.jsp">Curso</a>
                                                <a class="dropdown-item nav-link" href="../Turma/InserirTurma.jsp">Turma</a>
                                                <a class="dropdown-item nav-link" href="../Aluno/InserirAluno.jsp">Aluno</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="dropdown">
                                            <a class=" dropdown-toggle mr-4 nav-link" data-toggle="dropdown" aria-haspopup="true"
                                               aria-expanded="false">Listar</a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item nav-link" href="../../../ListarServidores">Servidores</a>
                                                <a class="dropdown-item nav-link" href="../../../ListarCursos">Cursos</a>
                                                <a class="dropdown-item nav-link" href="../../../ListarTurmas">Turmas</a>
                                                <a class="dropdown-item nav-link" href="../../../ListarAlunos">Alunos</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li><a href="../../../SairLogin" class="nav-link"><button type="button" class="btn btn-primary">Sair</button></a></li>
                                </ul>
                            </nav>
                        </div>
                        <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black float-right"><span class="icon-menu h3"></span></a> </div>
                    </div>
                </div>
            </header>
            <div id="conteudo">
                <form action="../../../AlterarServidor" method="post">
                    <div class="container">
                        <h2>Alterar Servidor:</h2>
                        <input type="text" hidden name="siape" value="<%=servidor.getSiape()%>">
                        <label><b>Siape: </b></label><label> <%=servidor.getSiape()%></label><br>
                        <label><b>Nome:</b></label><br>
                        <input type="text" name="nome" placeholder="Digite o Nome:" value="<%=servidor.getNome()%>" required>
                        <label><b>Função:</b></label><br>
                        <input type="text" placeholder="Digite a Função" name="funcao" value="<%=servidor.getFuncao()%>" required>
                        <label for="psw"><b>Nova Senha</b></label>
                        <input type="password" placeholder="Digite a senha" value="<%=servidor.getSenha()%>" name="nsenha" id="nsenha" required>
                        <label for="psw-repeat"><b>Confirme a Senha</b></label>
                        <input type="password" placeholder="Confirme a senha" id="c_senha" value="<%=servidor.getSenha()%>" required>
                        <label><b>Tipo:</b></label><br>
                        <table>
                            <tr><td><label class="labels">Servidor:</label></td><td><input class="tipo" type="radio" name="tipo" value="servidor"></td></tr>
                            <tr><td><label class="labels">Operador:</label></td><td><input class="tipo" type="radio" name="tipo" value="operador"></td></tr>
                        </table>
                        <button type="submit" class="registerbtn">Alterar</button>
                    </div>
                </form>
            </div>
            <br>
            <footer class="site-footer">
                <div class="container">
                    <div class="col-md-8 col-sm-6 col-xs-12">
                        <p class="copyright-text">IF Campus Ouricuri - Informática 2016.1</p>
                        <p class="copyright-text">Copyright &copy; <script>document.write(new Date().getFullYear());</script> All Rights Reserved by
                            <a href="#">Scanfcode</a>.
                        </p>
                        <p class="copyright-text">*Para mais informação acerca dos indivíduos registrados, consulte o Controle Acadêmico do campus ou a plataforma <a href="https://sage.ouricuri.ifsertao-pe.edu.br/">SAGE</a></p>
                    </div>
                </div>
            </footer>
        </div> 
        <script src="../../../js/jquery-3.3.1.min.js"></script>
        <script src="../../../js/jquery-migrate-3.0.1.min.js"></script>
        <script src="../../../js/jquery-ui.js"></script>
        <script src="../../../js/popper.min.js"></script>
        <script src="../../../js/bootstrap.min.js"></script>
        <script src="../../../js/owl.carousel.min.js"></script>
        <script src="../../js/jquery.stellar.min.js"></script>
        <script src="../../../js/jquery.countdown.min.js"></script>
        <script src="../../../js/bootstrap-datepicker.min.js"></script>
        <script src="../../../js/jquery.easing.1.3.js"></script>
        <script src="../../../js/aos.js"></script>
        <script src="../../../js/jquery.fancybox.min.js"></script>
        <script src="../../../js/jquery.sticky.js"></script>
        <script src="../../../js/main.js"></script>
    </body>
    <script type="text/javascript">
                                var nsenha = document.getElementById("nsenha"), c_senha = document.getElementById("c_senha"), tipo = document.getElementsByClassName('tipo');
                                for (var i = 0; i < tipo.length; i++) {
                                    if (tipo[i].value === "<%=tipo%>") {
                                        tipo[i].checked = true;
                                    } else {
                                        tipo[i].checked = false;
                                    }
                                }
                                function validarSenha() {
                                    if (nsenha.value !== c_senha.value) {
                                        c_senha.setCustomValidity("Senhas diferentes!");
                                    } else {
                                        c_senha.setCustomValidity('');
                                    }
                                }
                                nsenha.onchange = validarSenha;
                                c_senha.onkeyup = validarSenha;
    </script>
</html>
