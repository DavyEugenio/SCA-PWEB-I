<%@page import="modelo.Operador"%>
<%@page import="modelo.ServidorAbstrato"%>
<%@page import="modelo.Aluno"%>
<%@page import="DAO.AlunoDAO"%>
<%@page import="modelo.Curso"%>
<%@page import="DAO.CursoDAO"%>
<%@page import="DAO.TurmaDAO"%>
<%@page import="modelo.Turma"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sessao = request.getSession(true);
    ServidorAbstrato operador = (Operador) sessao.getAttribute("oa");
    AlunoDAO adao = new AlunoDAO();
    Aluno aluno = new Aluno();
    aluno.setSage(request.getParameter("sage"));
    aluno = adao.Buscar(aluno);
    CursoDAO cdao = new CursoDAO();
    TurmaDAO tdao = new TurmaDAO();
    List listat = tdao.Listar();
    Turma TA = new Turma();
    TA.setId(aluno.getId_turma());
    TA = tdao.Buscar(TA);
    Curso CA = new Curso();
    CA.setId(TA.getId_curso());
    List lc = tdao.ListarCursos();
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
    <body data-spy="scroll" data-target=".site-navbar-target" data-offset="300" onload="Turma()">
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
                <form action="../../../AlterarAluno" method="post">
                    <div class="container">
                        <h2>Alterar Aluno:</h2>
                        <input type="text" name="sage" value="<%=aluno.getSage()%>" hidden>
                        <label><b>Sage:</b></label> <label><%=aluno.getSage()%></label><br>
                        <label><b>Nome:</b></label>
                        <input type="text" name="nome" placeholder="Digite o Nome:" value="<%=aluno.getNome()%>" required>
                        <label><b>Curso:</b></label>
                        <select id="cursos">
                            <% for (Iterator i = lc.iterator(); i.hasNext();) {
                                    Curso curso = (Curso) i.next();
                            %>
                            <option class="curso" value="<%=curso.getId()%>"><%=curso.getNome() + " - " + curso.getModalidade()%></option>
                            <%}%>
                        </select>
                        <label><b>Turma:</b></label>
                        <select name="turma">
                            <% for (Iterator i = listat.iterator(); i.hasNext();) {
                                    Turma turma = (Turma) i.next();
                                    Curso curso = new Curso();
                                    curso.setId(turma.getId_curso());
                                    curso = cdao.Buscar(curso);
                            %>
                            <option class="turma" id="<%=turma.getId_curso()%>" value="<%=turma.getId()%>"><%=turma.getAno() + "." + turma.getSemestre() + " - " + turma.getTurno()%></option>
                            <%}%>
                        </select>
                        <label><b>Status:</b></label>
                        <select name="status">
                            <option class="sta" value="Matriculado">Matriculado</option>
                            <option class="sta" value="Cursando">Cursando</option>
                            <option class="sta" value="Desistente">Desistente</option>
                            <option class="sta" value="Transferido">Transferido</option>
                            <option class="sta" value="Formado">Formado</option>
                        </select>
                        <label><b>Nova Senha:</b></label>
                        <input type="password" placeholder="Digite a nova senha"  id="nsenha" name="nsenha" value="<%=aluno.getSenha()%>" required>
                        <label><b>Confirme a Nova Senha:</b></label>
                        <input type="password" placeholder="Digite confirme a senha" value="<%=aluno.getSenha()%>" id="c_senha" required><br>
                        <input type="submit" class="registerbtn" value="Alterar">
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
                                var
                                        nsenha = document.getElementById("nsenha"),
                                        c_senha = document.getElementById("c_senha");

                                var curso = document.getElementsByClassName("curso"),
                                        cursos = document.getElementById("cursos"),
                                        turma = document.getElementsByClassName("turma"),
                                        sta = document.getElementsByClassName("sta");
                                function Curso() {
                                    for (var i = 0; i < curso.length; i++) {
                                        if (curso[i].selected === true) {
                                            return curso[i].value;
                                        }
                                    }
                                }
                                function Turma() {
                                    for (var i = 0; i < turma.length; i++) {
                                        if (turma[i].getAttribute("id") === Curso()) {
                                            turma[i].hidden = false;
                                            turma[i].selected = true;
                                        } else {
                                            turma[i].hidden = true;
                                        }
                                    }
                                }
                                for (var i = 0; i < curso.length; i++) {
                                    if (curso[i].value === "<%=CA.getId()%>") {
                                        curso[i].selected = true;
                                    } else {
                                        curso[i].selected = false;
                                    }
                                }
                                for (var i = 0; i < sta.length; i++) {
                                    if (sta[i].value === "<%=aluno.getStatus()%>") {
                                        sta[i].selected = true;
                                    } else {
                                        sta[i].selected = false;
                                    }
                                }

                                function validarSenha() {
                                    if (nsenha.value !== c_senha.value) {
                                        c_senha.setCustomValidity("Senhas diferentes!");
                                    } else {
                                        c_senha.setCustomValidity('');
                                    }
                                }
                                asenha.onchange = validarSenha;
                                nsenha.onchange = validarSenha;
                                c_senha.onkeyup = validarSenha;
                                cursos.onchange = Turma;
    </script>
</html>
