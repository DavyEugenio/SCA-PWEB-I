<%@page import="DAO.TurmaDAO"%>
<%@page import="modelo.Servidor"%>
<%@page import="modelo.ServidorAbstrato"%>
<%@page import="DAO.CursoDAO"%>
<%@page import="modelo.Curso"%>
<%@page import="modelo.Turma"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sessao = request.getSession(true);
    ServidorAbstrato servidor = (Servidor) sessao.getAttribute("sa");
    List lista = (List) request.getAttribute("lista");
    CursoDAO dao = new CursoDAO();
    List lc = dao.Listar();
    TurmaDAO tdao = new TurmaDAO();
%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>SCA &mdash; <%=servidor.getNome()%></title>
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
                                    <li><a href="/PWeb_SCA__DGJ_/Restrito/Servidor/index.jsp" class="nav-link">Inicio</a></li>
                                    <li><a href="/PWeb_SCA__DGJ_/Restrito/Servidor/VerServidor.jsp" class="nav-link">Seus Dados</a></li>
                                    <li>
                                        <div class="dropdown">
                                            <a class=" dropdown-toggle mr-4 nav-link" data-toggle="dropdown" aria-haspopup="true"
                                               aria-expanded="false">Listar</a>
                                            <div class="dropdown-menu">
                                                <a class="dropdown-item" href="ListarCursos">Cursos</a>
                                                <a class="dropdown-item" href="ListarTurmas">Turmas</a>
                                                <a class="dropdown-item" href="ListarAlunos">Alunos</a>
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
            <div id="conteudo">
                <br>
                <div id="dados">
                    <h2>Lista de turmas:</h2>
                    Semestres: 
                    <select id="semestres">
                        <option value="todos" selected>Todos</option>
                        <option class="semestres" value="1">1</option>
                        <option class="semestres" value="2">2</option>
                    </select>
                    Turno:
                    <select id="turnos">
                        <option value="todos" selected>Todos</option>
                        <option value="Matutino">Matutino</option>
                        <option value="Vespertino">Vespertino</option>
                        <option value="Noturno">Noturno</option>
                    </select>
                    Cursos:
                    <select id="cursos">
                        <option value="todos" selected>Todos</option>
                        <% for (Iterator i = lc.iterator(); i.hasNext();) {
                                Curso curso = (Curso) i.next();
                        %>
                        <option class="curso" value="<%=curso.getId()%>"><%=curso.getNome() + " - " + curso.getModalidade()%></option>
                        <%
                            };
                        %>
                    </select><br>
                </div>
                <table class="table">
                    <thead class="thead-light"><tr><th></th><th>ID</th><th>Ano</th><th>Semestre</th><th>Turno</th><th>Curso</th></tr></thead>    
                    <tbody>
                        <% for (Iterator i = lista.iterator(); i.hasNext();) {
                                Turma turma = (Turma) i.next();
                                Curso curso = new Curso();
                                curso.setId(turma.getId_curso());
                                curso = dao.Buscar(curso);
                                String nome = curso.getNome() + " - " + curso.getModalidade();
                        %>
                        <tr class="turmas" id="<%=curso.getId()%>" align="<%=turma.getAno()%>" char="<%=turma.getSemestre()%>" valign="<%=turma.getTurno()%>">
                            <td></td>
                            <td><a href="/PWeb_SCA__DGJ_/Restrito/Servidor/Turma/VerTurma.jsp?id=<%=turma.getId()%>"><%=turma.getId()%></a></td>
                            <td><%=turma.getAno()%></td>
                            <td><%=turma.getSemestre()%></td>
                            <td><%=turma.getTurno()%></td>
                            <td><a href="/PWeb_SCA__DGJ_/Restrito/Servidor/Curso/VerCurso.jsp?id=<%=curso.getId()%>"><%=nome%></a></td>
                        </tr>
                        <%}%>
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
    </body>
    <script>
                            window.history.pushState("data", "title", "/PWeb_SCA__DGJ_/ListarTurmas");
    </script>
    <script>
        var turmas = document.getElementsByClassName("turmas"), cursos = document.getElementById("cursos"), anos = document.getElementById("anos"), semestres = document.getElementById("semestres"), turnos = document.getElementById("turnos");
        function Cursos() {
            for (var i = 0; i < turmas.length; i++) {
                if (cursos.value === "todos") {
                    turmas[i].style.display = "table-row";
                } else {
                    if (cursos.value === turmas[i].getAttribute("id")) {
                        turmas[i].style.display = "table-row";
                    } else {
                        if (turmas[i].getAttribute("id") === cursos.value) {
                            turmas[i].style.display = "table-row";
                        } else {
                            turmas[i].style.display = "none";
                        }
                    }
                }
            }
        }
        function Anos() {
            for (var i = 0; i < turmas.length; i++) {
                if (anos.value === "todos") {
                    turmas[i].style.display = "table-row";
                } else {
                    if (anos.value === turmas[i].getAttribute("align")) {
                        turmas[i].style.display = "table-row";
                    } else {
                        if (turmas[i].getAttribute("align") === anos.value) {
                            turmas[i].style.display = "table-row";
                        } else {
                            turmas[i].style.display = "none";
                        }
                    }
                }
            }
        }
        function Semestres() {
            for (var i = 0; i < turmas.length; i++) {
                if (semestres.value === "todos") {
                    turmas[i].style.display = "table-row";
                } else {
                    if (semestres.value === turmas[i].getAttribute("char")) {
                        turmas[i].style.display = "table-row";
                    } else {
                        if (turmas[i].getAttribute("char") === semestres.value) {
                            turmas[i].style.display = "table-row";
                        } else {
                            turmas[i].style.display = "none";
                        }
                    }
                }
            }
        }
        function Turnos() {
            for (var i = 0; i < turmas.length; i++) {
                if (turnos.value === "todos") {
                    turmas[i].style.display = "table-row";
                } else {
                    if (turnos.value === turmas[i].getAttribute("valign")) {
                        turmas[i].style.display = "table-row";
                    } else {
                        if (turmas[i].getAttribute("valign") === turnos.value) {
                            turmas[i].style.display = "table-row";
                        } else {
                            turmas[i].style.display = "none";
                        }
                    }
                }
            }
        }
        turnos.onchange = Turnos;
        semestres.onchange = Semestres;
        anos.onchange = Anos;
        cursos.onchange = Cursos;
    </script>
</html>
