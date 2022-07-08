<%@page import="modelo.ServidorAbstrato"%>
<%@page import="modelo.Servidor"%>
<%@page import="modelo.Operador"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sessao = request.getSession(true);
    ServidorAbstrato operador = (Operador) sessao.getAttribute("oa");
    List lista = (List) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>SCA &mdash; <%=operador.getNome()%></title>
        <meta charset="utf-8">
        <link rel="shortcut icon" href="images/SCA-logo.ico" type="image/x-icon"/>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="css/font.css">
        <link rel="stylesheet" href="fonts/icomoon/style.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/jquery-ui.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/owl.theme.default.min.css">
        <link rel="stylesheet" href="css/jquery.fancybox.min.css">
        <link rel="stylesheet" href="css/bootstrap-datepicker.css">
        <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
        <link rel="stylesheet" href="css/aos.css">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/paginas_restritas_listas.css">
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
                            <h1 class="mb-0 site-logo text-black h2"><a href="index.jsp" class="text-black h2 mb-0">SCA<span class="text-primary">.</span></a><br>(Operadores)</h1>
                        </div>
                        <div class="col-12 col-md-10 d-none d-xl-block">
                            <nav class="site-navigation position-relative text-right" role="navigation">
                                <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                                    <li><a href="Restrito/Operador/index.jsp" class="nav-link">Inicio</a></li>
                                    <li><a href="Restrito/Operador/VerServidor.jsp" class="nav-link">Seus Dados</a></li>
                                    <li>
                                        <div class="dropdown">
                                            <a class=" dropdown-toggle mr-4 nav-link" data-toggle="dropdown" aria-haspopup="true"
                                               aria-expanded="false">Cadastrar</a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item nav-link" href="Restrito/Operador/Servidor/InserirServidor.jsp">Servidor</a>
                                                <a class="dropdown-item nav-link" href="Restrito/Operador/Curso/InserirCurso.jsp">Curso</a>
                                                <a class="dropdown-item nav-link" href="Restrito/Operador/Turma/InserirTurma.jsp">Turma</a>
                                                <a class="dropdown-item nav-link" href="Restrito/Operador/Aluno/InserirAluno.jsp">Aluno</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="dropdown">
                                            <a class=" dropdown-toggle mr-4 nav-link" data-toggle="dropdown" aria-haspopup="true"
                                               aria-expanded="false">Listar</a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item nav-link" href="ListarServidores">Servidores</a>
                                                <a class="dropdown-item nav-link" href="ListarCursos">Cursos</a>
                                                <a class="dropdown-item nav-link" href="ListarTurmas">Turmas</a>
                                                <a class="dropdown-item nav-link" href="ListarAlunos">Alunos</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li><a href="SairLogin" class="nav-link"><button type="button" class="btn btn-primary">Sair</button></a></li>
                                </ul>
                            </nav>
                        </div>
                        <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black float-right"><span class="icon-menu h3"></span></a> </div>
                    </div>
                </div>
            </header>
            <br>
            <div id="conteudo">
                <div id="dados">
                    <h2>Lista de Operadores:</h2>
                </div>
                <table class="table">
                    <thead class="thead-light"><tr><th></th><th></th><th>Nome</th><th>Siape</th><th>Função</th><th>Opções</th></tr></thead>
                    <tbody>        
                        <% for (Iterator i = lista.iterator(); i.hasNext();) {
                                ServidorAbstrato servidor = (ServidorAbstrato) i.next();
                                if (servidor instanceof Operador) {
                        %>
                        <tr>
                            <td></td>
                            <td></td>
                            <td><a href="/PWeb_SCA__DGJ_/Restrito/Operador/Servidor/VerServidor.jsp?siape=<%=servidor.getSiape()%>"><%=servidor.getNome()%></a></td>
                            <td><%=servidor.getSiape()%></td>
                            <td><%=servidor.getFuncao()%></td>
                            <td><a href="/PWeb_SCA__DGJ_/Restrito/Operador/Servidor/AlterarServidor.jsp?siape=<%=servidor.getSiape()%>" class="btn btn-info">Alterar</a> <button class="btn btn-danger" onclick="Confirmar('<%=servidor.getSiape()%>', '<%=servidor.getNome()%>')">Apagar</button></td>
                        </tr>

                        <%}
                            }%>
                    </tbody>
                </table>
                <div id="dados">
                    <h2>Lista de Servidores:</h2>
                </div>
                <table class="table">
                    <thead class="thead-light"><tr><th></th><th></th><th>Nome</th><th>Siape</th><th>Função</th><th colspan="2">Opções</th></tr></thead>    
                    <tbody>            
                        <% for (Iterator i = lista.iterator(); i.hasNext();) {
                                ServidorAbstrato servidor = (ServidorAbstrato) i.next();
                                if (servidor instanceof Servidor) {
                        %>
                        <tr>
                            <td></td>
                            <td></td>
                            <td><a href="/PWeb_SCA__DGJ_/Restrito/Operador/Servidor/VerServidor.jsp?siape=<%=servidor.getSiape()%>"><%=servidor.getNome()%></a></td>
                            <td><%=servidor.getSiape()%></td>
                            <td><%=servidor.getFuncao()%></td>
                            <td><a href="/PWeb_SCA__DGJ_/Restrito/Operador/Servidor/AlterarServidor.jsp?siape=<%=servidor.getSiape()%>" class="btn btn-info">Alterar</a> <button class="btn btn-danger" onclick="Confirmar('<%=servidor.getSiape()%>', '<%=servidor.getNome()%>')">Apagar</button></td>
                        </tr>
                        <%}
                        }%>
                    </tbody>
                </table>
            </div>
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
        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery-migrate-3.0.1.min.js"></script>
        <script src="js/jquery-ui.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>
        <script src="js/jquery.countdown.min.js"></script>
        <script src="js/bootstrap-datepicker.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/aos.js"></script>
        <script src="js/jquery.fancybox.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/main.js"></script>
        <script>
                                function Resultado() {
                                    var msg = <%="'" + request.getAttribute("msg") + "'"%>;
                                    var body = document.getElementsByTagName('body');
                                    body[0].style.display = 'none';
                                    if (msg !== "null") {
                                        alert(msg);
                                        location.reload();
                                    } else {
                                        body[0].style.display = "inline";
                                    }
                                }
        </script>
    </body>
    <script>
        window.history.pushState("data", "title", "/PWeb_SCA__DGJ_/ListarServidores");
    </script>
    <script>
        function Confirmar(id, nome) {
            if (confirm("Deseja excluir o/a servidor(a): " + nome + "?")) {
                window.location.replace("ExcluirServidor?siape=" + id);
            }
        }
    </script>
</html>
