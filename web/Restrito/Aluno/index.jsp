<%@page import="modelo.Frequencia"%>
<%@page import="DAO.FrequenciaDAO"%>
<%@page import="modelo.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sessao = request.getSession(true);
    Aluno aluno = (Aluno) sessao.getAttribute("aa");
%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>SCA &mdash; <%=aluno.getNome()%></title>
        <link rel="shortcut icon" href="../../images/SCA-logo.ico" type="image/x-icon"/>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="../../css/font.css" rel="stylesheet">
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
        <link rel="stylesheet" href="../../css/conteudo-index.css">
        <link rel="stylesheet" href="../../css/paginas_restritas.css">
        <link rel="stylesheet" href="../../css/relogio.css">
        <style>
            body{
                display: none;
            }
        </style>
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
                            <h1 class="mb-0 site-logo text-black h2"><a href="../../index.jsp" class="text-black h2 mb-0">SCA<span class="text-primary">.</span></a><br>(Alunos)</h1>
                        </div>
                        <div class="col-12 col-md-10 d-none d-xl-block">
                            <nav class="site-navigation position-relative text-right" role="navigation">
                                <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                                    <li><a href="index.jsp" class="nav-link">Inicio</a></li>
                                    <li><a href="VerAluno.jsp" class="nav-link">Seus Dados</a></li>
                                    <li><a href="../../SairLogin" class="nav-link"><button type="button" class="btn btn-primary">Sair</button></a></li>
                                </ul>
                            </nav>
                        </div>
                        <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black float-right"><span class="icon-menu h3"></span></a> </div>
                    </div>
                </div>
            </header>
            <div id="conteudo">
                <br>
                <br>
                <div class="relogio">
                    <div class="horas">
                        <div class="rc"></div>
                        <div class="esp"></div>
                        <div class="rc"></div>
                    </div>
                    <div class="pontos">:</div>
                    <div class="minutos">
                        <div class="rc"></div>
                        <div class="esp"></div>
                        <div class="rc"></div>
                    </div>
                    <div class="pontos">:</div>
                    <div class="segundos">
                        <div class="rc"></div>
                        <div class="esp"></div>
                        <div class="rc"></div>
                    </div>
                </div>
                <div class="titulo"><h2>Seja Bem Vindo/a, <%=aluno.getNome() + "  (Sage:" + aluno.getSage() + ")"%></h2></div>
                <%if (aluno != null) {
                        FrequenciaDAO dao = new FrequenciaDAO();
                        Frequencia frequencia = dao.BuscarUltima(aluno.getSage());
                        if (frequencia == null) {
                %>
                <br>
                <form method="post" action="../../InserirFrequencia">
                    <input type="text" name="sage" value="<%=aluno.getSage()%>" hidden="true">
                    <input id="datahora" type="text" name="entrada" hidden="true">
                    <input type="submit" class="btn btn-info" value="Marcar Entrada">
                </form>
                <%} else {%>
                <br>
                <form method="post" action="../../AlterarFrequencia">
                    <input type="text" name="sage" value="<%=aluno.getSage()%>" hidden="true">
                    <input type="text" name="id" value="<%=frequencia.getId()%>" hidden="true">
                    <input type="text" name="entrada" value="<%=frequencia.getEntrada()%>" hidden="true">
                    <input id="datahora" type="text" name="saida" hidden="true">
                    <input type="submit" class="btn btn-info" value="Marcar Saida">
                </form>
                <%}%>
                <%}%>
            </div>
            <footer class="site-footer footer navbar-fixed-bottom">
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
        <script src="../../js/relogio.js"></script>
        <script>
                                    function Resultado() {
                                        var msg = <%="'" + request.getAttribute("msg") + "'"%>;
                                        var body = document.getElementsByTagName('body');
                                        window.history.pushState("data", "title", "/PWeb_SCA__DGJ_/Restrito/Aluno/");
                                        if (msg !== "null") {
                                            alert(msg);
                                            location.reload();
                                        } else {
                                            body[0].style.display = "inline";
                                        }
                                    }
                                    function atualizaRelogio() {
                                        var horadata = new Date();
                                        var h = horadata.getHours();
                                        var min = horadata.getMinutes();
                                        var s = horadata.getSeconds();
                                        var d = horadata.getDate();
                                        var m = horadata.getMonth() + 1;
                                        var a = horadata.getFullYear();
                                        if (h < 10) {
                                            h = "0" + h;
                                        }
                                        if (s < 10) {
                                            s = "0" + s;
                                        }
                                        if (m < 10) {
                                            m = "0" + m;
                                        }
                                        if (min < 10) {
                                            min = "0" + min;
                                        }
                                        if (d < 10) {
                                            d = "0" + d;
                                        }
                                        data = a + "-" + m + "-" + d;
                                        hora = h + ":" + min + ":" + s;
                                        var dt = data + " " + hora;
                                        document.getElementById("datahora").value = dt;
                                        setTimeout("atualizaRelogio()", 500);
                                    }
                                    atualizaRelogio();
        </script>	
    </body>
</html>