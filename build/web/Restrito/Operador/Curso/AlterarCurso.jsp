<%@page import="modelo.Operador"%>
<%@page import="modelo.ServidorAbstrato"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Curso"%>
<%@page import="DAO.CursoDAO"%>
<%
    HttpSession sessao = request.getSession(true);
    ServidorAbstrato operador = (Operador) sessao.getAttribute("oa");
    CursoDAO dao = new CursoDAO();
    Curso curso = new Curso();
    curso.setId(Integer.parseInt(request.getParameter("id")));
    curso = dao.Buscar(curso);
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
                <form action="../../../AlterarCurso" method="post" required>
                    <div class="container">
                        <input type="text" hidden name="id" value="<%=curso.getId()%>">
                        <h2>Alterar Curso:</h2>
                        <label><b>ID: </b></label> <label> <%=curso.getId()%></label><br>
                        <label><b>Nome:</b></label>
                        <input type="text" name="nome" placeholder="Digite o Nome:" value="<%=curso.getNome()%>" required><br>
                        <label><b>Modalidade:</b></label>
                        <select name="modalidade">
                            <option value="Medio Integrado">Médio Integrado</option>
                            <option value="Subsequente">Subsequente</option>
                            <option value="Subsequente EaD">Subsequente EaD</option>
                            <option value="Proeja">Proeja</option>
                            <option value="Superior">Superior</option>
                        </select><br>
                        <input class="registerbtn" type="submit" value="Alterar">
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
        <script src="../../../js/jquery.stellar.min.js"></script>
        <script src="../../../js/jquery.countdown.min.js"></script>
        <script src="../../../js/bootstrap-datepicker.min.js"></script>
        <script src="../../../js/jquery.easing.1.3.js"></script>
        <script src="../../../js/aos.js"></script>
        <script src="../../../js/jquery.fancybox.min.js"></script>
        <script src="../../../js/jquery.sticky.js"></script>
        <script src="../../../js/main.js"></script>
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
