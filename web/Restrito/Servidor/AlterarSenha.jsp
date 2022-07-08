<%@page import="modelo.ServidorAbstrato"%>
<%@page import="modelo.Servidor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sessao = request.getSession(true);
    ServidorAbstrato servidor = (Servidor) sessao.getAttribute("sa");
%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>SCA &mdash; <%=servidor.getNome()%></title>
        <link rel="shortcut icon" href="../../images/SCA-logo.ico" type="image/x-icon"/>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="../../css/font.css">
        <link rel="stylesheet" href="../../fonts/icomoon/style.css">
        <link rel="stylesheet" href="../../css/bootstrap.min.css">
        <link rel="stylesheet" href="../../css/jquery-ui.css">
        <link rel="stylesheet" href="../../css/owl.carousel.min.css">
        <link rel="stylesheet" href="../../css/owl.theme.default.min.css">
        <link rel="stylesheet" href="../../css/owl.theme.default.min.css">
        <link rel="stylesheet" href="../../css/jquery.fancybox.min.css">
        <link rel="stylesheet" href="../../css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="../../fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="../../css/aos.css">
        <link rel="stylesheet" href="../../css/style.css">
        <link rel="stylesheet" href="../../css/forms.css">
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
                            <h1 class="mb-0 site-logo text-black h2"><a href="index.jsp" class="text-black h2 mb-0">SCA<span class="text-primary">.</span></a><br>(Servidores)</h1>
                        </div>
                        <div class="col-12 col-md-10 d-none d-xl-block">
                            <nav class="site-navigation position-relative text-right" role="navigation">
                                <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                                    <li><a href="index.jsp" class="nav-link">Inicio</a></li>
                                    <li><a href="VerServidor.jsp" class="nav-link">Seus Dados</a></li>
                                    <li>
                                        <div class="dropdown">
                                            <a class=" dropdown-toggle mr-4 nav-link" data-toggle="dropdown" aria-haspopup="true"
                                               aria-expanded="false">Listar</a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="../../ListarCursos">Cursos</a>
                                                <a class="dropdown-item" href="../../ListarTurmas">Turmas</a>
                                                <a class="dropdown-item" href="../../Listarservidors">servidors</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li><a href="../../SairLogin" class="nav-link"><button type="button" class="btn btn-primary">Sair</button></a></li>
                                </ul>
                            </nav>
                        </div>
                        <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black float-right"><span class="icon-menu h3"></span></a> </div>
                    </div>
                </div>
            </header>
            <div id="conteudo">
                <form action="./../../AlterarSenhaServidor" method="post">
                    <div class="container">
                        <h2>Alterar Senha:</h2>
                        <input type="text" name="siape" value="<%=servidor.getSiape()%>" hidden>
                        <label><b>Siape: </b></label> <label> <%=servidor.getSiape()%></label><br>
                        <label><b>Nome: </b></label> <label> <%=servidor.getNome()%></label><br>
                        <label for="psw"><b>Senha Antiga</b></label>
                        <input type="password" placeholder="Digite a senha antiga:" id="asenha" required>
                        <label for="psw"><b>Nova Senha</b></label>
                        <input type="password" placeholder="Digite a nova senha" id="nsenha" required>
                        <label for="psw-repeat"><b>Confirme a Nova Senha</b></label>
                        <input type="password" placeholder="Confirme a senha" id="c_senha" name="nsenha" required>
                        <button type="submit" class="registerbtn">Alterar Senha</button>
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
        <script src="../../js/jquery-3.3.1.min.js"></script>
        <script src="../../js/jquery-migrate-3.0.1.min.js"></script>
        <script src="../../js/jquery-ui.js"></script>
        <script src="../../js/popper.min.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
        <script src="../../js/owl.carousel.min.js"></script>
        <script src="../../js/jquery.stellar.min.js"></script>
        <script src="../../js/jquery.countdown.min.js"></script>
        <script src="../../js/bootstrap-datepicker.min.js"></script>
        <script src="../../js/jquery.easing.1.3.js"></script>
        <script src="../../js/aos.js"></script>
        <script src="../../js/jquery.fancybox.min.js"></script>
        <script src="../../js/jquery.sticky.js"></script>
        <script src="./../../js/main.js"></script>
        <script type="text/javascript">
                                function Resultado() {
                                    var msg = <%="'" + request.getAttribute("msg") + "'"%>;
                                    var body = document.getElementsByTagName('body');
                                    if (msg !== "null") {
                                        alert(msg);
                                        location.reload();
                                    } else {
                                        body[0].style.display = "inline";
                                    }
                                }
        </script>
        <script type="text/javascript">
            var asenha = document.getElementById("asenha"),
                    nsenha = document.getElementById("nsenha"),
                    c_senha = document.getElementById("c_senha");
            function validarSenha() {
                if (asenha.value !== "<%=servidor.getSenha()%>") {
                    asenha.setCustomValidity("Senha invalida!");
                } else {
                    asenha.setCustomValidity('');
                }
                if (nsenha.value !== c_senha.value) {
                    c_senha.setCustomValidity("Senhas diferentes!");
                } else {
                    c_senha.setCustomValidity('');
                }
            }
            asenha.onchange = validarSenha;
            nsenha.onchange = validarSenha;
            c_senha.onkeyup = validarSenha;
        </script>
    </body>
</html>
