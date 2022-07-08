<%@page import="modelo.Aluno"%>
<%@page import="DAO.AlunoDAO"%>
<%@page import="modelo.Operador"%>
<%@page import="DAO.CursoDAO"%>
<%@page import="modelo.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Turma"%>
<%@page import="DAO.TurmaDAO"%>
<%
    HttpSession sessao = request.getSession(true);
    Operador operador = (Operador) sessao.getAttribute("oa");
    TurmaDAO dao = new TurmaDAO();
    Turma turma = new Turma();
    turma.setId(Integer.parseInt(request.getParameter("id")));
    turma = dao.Buscar(turma);
    Curso curso = new Curso();
    curso.setId(turma.getId_curso());
    CursoDAO cursodao = new CursoDAO();
    curso = cursodao.Buscar(curso);
    String nome = curso.getNome() + " - " + curso.getModalidade();
    AlunoDAO adao = new AlunoDAO();
    List<Aluno> alunos = adao.ListarPorTurma(turma.getId());
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
        <link rel="stylesheet" href="../../../css/paginas_restritas_ver_aluno.css">
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
                <div id="dados">
                    <br>
                    <h2>Dados da turma:</h2>
                    ID: <%=turma.getId()%><br>
                    Curso: <a href="/PWeb_SCA__DGJ_/Restrito/Operador/Curso/VerCurso.jsp?id=<%=curso.getId()%>"><%=nome%></a><br>
                    Ano: <%=turma.getAno()%><br>
                    Semestre: <%=turma.getSemestre()%>º<br>
                    Turno: <%=turma.getTurno()%>
                <br><br>
                    <h2>Alunos</h2>
                </div>
                <table class="table">
                    <thead class="thead-light"><tr><th></th><th>Sage</th><th>Nome</th><th>Status</th><th>Opções</th></tr></thead>
                    <tbody>
                        <% for (Iterator i = alunos.iterator(); i.hasNext();) {
                                Aluno aluno = (Aluno) i.next();
                                curso.setId(turma.getId_curso());
                        %>
                        <tr class="alunos" id="<%=curso.getId()%>">
                            <td></td>
                            <td><%=aluno.getSage()%></td>
                            <td><a href="/PWeb_SCA__DGJ_/Restrito/Operador/Aluno/VerAluno.jsp?sage=<%=aluno.getSage()%>"><%=aluno.getNome()%></a></td>
                            <td><%=aluno.getStatus()%></td>
                            <td><a href="/PWeb_SCA__DGJ_/Restrito/Operador/Aluno/AlterarAluno.jsp?sage=<%=aluno.getSage()%>" class="btn btn-info">Alterar</a> <button class="btn btn-danger" onclick="Confirmar('<%=aluno.getSage()%>', '<%=aluno.getNome()%>')">Apagar</button></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
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
    <script>
        function Confirmar(id, nome) {
            if (confirm("Deseja excluir o aluno: " + nome + "?")) {
                window.location.replace("../../../ExcluirAluno?id=" + id);
            }
        }
    </script>
</html>
