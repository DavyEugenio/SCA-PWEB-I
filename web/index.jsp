<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt">
    <head>
        <title>SCA &mdash; Ponto Virtual</title>
        <link rel="shortcut icon" href="images/SCA-logo.ico" type="image/x-icon"/>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="css/font.css" rel="stylesheet">
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
        <link rel="stylesheet" href="css/modalLogin.css">
    </head>
    <style>
        body{
            background-color: #333;
        }
    </style>
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
                            <h1 class="mb-0 site-logo"><a href="index.jsp" class="text-black h2 mb-0">SCA<span class="text-primary">.</span> </a></h1>
                        </div>
                        <div class="col-12 col-md-10 d-none d-xl-block">
                            <nav class="site-navigation position-relative text-right" role="navigation">
                                <ul class="site-menu main-menu js-clone-nav mr-auto d-none d-lg-block">
                                    <li><a href="#home-section" class="nav-link">Inicio</a></li>
                                    <li><a href="#about-section" class="nav-link">Sobre nós</a></li>
                                    <li><a href="#team-section" class="nav-link">Time</a></li>
                                    <li><a href="#contact-section" class="nav-link">Contato</a></li>
                                    <li><a href="#" onclick="document.getElementById('id01').style.display = 'block'"  class="nav-link">Login</a></li>
                                </ul>
                            </nav>
                        </div>
                        <div class="col-6 d-inline-block d-xl-none ml-md-0 py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-black float-right"><span class="icon-menu h3"></span></a> </div>
                        <div id="id01" class="modal">
                            <form method="post" action="ValidarLogin" class="modal-content animate">
                                <div class="imgcontainer">
                                    <span onclick="document.getElementById('id01').style.display = 'none'" class="close" title="Close Modal">&times;</span>
                                </div>
                                <div class="container">
                                    <label for="login"><b>Sage/Siape</b></label>
                                    <input type="text" placeholder="Coloque sua forma de login" name="login" required>
                                    <label for="senha"><b>Senha</b></label>
                                    <input type="password" placeholder="Coloque sua senha" name="senha" required><br>
                                    <input type="radio" id="aluno" name="tipo" value="A" required>
                                    <label for="aluno">Aluno</label>
                                    <input type="radio" id="professor" name="tipo" value="SA" required>
                                    <label for="professor">Servidor</label><br>
                                    <input type="submit" value="Entrar" class="btn btn-primary">
                                </div>
                            </form>
                        </div>
                    </div>
            </header>
            <div class="site-blocks-cover overlay" style="background-image: url(images/hero_2.jpg);" data-aos="fade">
                <div class="container">
                    <div class="row align-items-center justify-content-center">

                        <div class="col-md-12" data-aos="fade-up" data-aos-delay="400">

                            <div class="row mb-4">
                                <div class="col-md-6">
                                    <h1>Um projeto feito para ser simples</h1>

                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="site-section" id="about-section">
                <div class="container">
                    <div class="row align-items-lg-center">
                        <div class="col-md-6 mb-5 mb-lg-0 position-relative">
                            <img src="images/about_1.jpg" class="img-fluid" alt="Image">
                            <div class="experience">
                                <span class="year">4 anos</span>
                                <span class="caption">de experiencia</span>
                            </div>
                        </div>
                        <div class="col-md-5 ml-auto">
                            <h3 class="section-sub-title">Sobre</h3>
                            <h2 class="section-title mb-3">Seja Bem Vindo</h2>
                            <p class="mb-4">Este projeto foi desenvolvido e concebido por alunos da turma de informática 2016.1 para a disciplina de Programação Web e tem por fim atender ao propósito de facilitar a averiguação e controle da presença dos alunos nas dependências do campus. </p>
                        </div>
                    </div>
                </div>
            </div>
            <section class="site-section border-bottom" id="team-section">
                <div class="container">
                    <div class="row mb-5">
                        <div class="col-12 text-center">
                            <h3 class="section-sub-title">Time</h3>
                            <h2 class="section-title mb-3">Nosso Time</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6 col-lg-4 mb-5 mb-lg-0" data-aos="fade" data-aos-delay="100">
                            <div class="person text-center">
                                <img src="images/person_2.jpg" alt="Image" class="img-fluid rounded-circle w-50 mb-5">
                                <h3>Davy Eugênio</h3>
                                <p class="position text-muted">Principal Desenvolvedor</p>
                                <p class="mb-4">Programador, designer e idealizador.</p>
                                <ul class="ul-social-circle">
                                    <li><a href="https://www.facebook.com/davy.eugenio.n.oliveira"><span class="icon-facebook"></span> Davy Eugenio</a></li><br>
                                    <li><a href="https://twitter.com/davyeugenio"><span class="icon-twitter"></span> @davyeugenio</a></li><br>
                                    <li><a href=""><span class="icon-mail_outline"></span> davy.eugenio@hotmail.com</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <section class="site-section " id="contact-section">
                <div class="container">
                    <div class="row mb-5">
                        <div class="col-12 text-center">
                            <h3 class="section-sub-title">Contato</h3>
                            <h2 class="section-title mb-3">Nos Contate</h2>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-5">
                            <div class="p-4 mb-3 ">
                                <p class="mb-0 font-weight-bold">Endereço:</p>
                                <p class="mb-4">
                                    IF Sertão Campus Ouricuri:<br>
                                    Estrada do Tamboril, S/N
                                    CEP: 56200-000 | Ouricuri/PE - Brasil</p>
                                <p class="mb-0 font-weight-bold">Telefone:</p>
                                IF Sertão Campus Ouricuri:<br>
                                <p class="mb-4"><a href="#">(87) 98122-2215 / 98122-3778</a></p>
                                <p class="mb-0 font-weight-bold">Email:</p>
                                <p class="mb-0">Davy Eugênio:</p>
                                <p class="mb-0"><a href="">davy.eugenio@hotmail.com</a></p>
                                <p class="mb-0">IF Sertão Campus Ouricuri:</p>
                                <p class="mb-0"><a href="">co.comunicacao@ifsertao-pe.edu.br</a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

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
        </div> <!-- .site-wrap -->

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
                            var modal = document.getElementById('id01');
                            window.onclick = function (event) {
                                if (event.target === modal) {
                                    modal.style.display = "none";
                                }
                            }
        </script>
        <script>
            function Resultado() {
                var msg = <%="'" + request.getAttribute("msg") + "'"%>;
                window.history.pushState("data", "title", "/PWeb_SCA__DGJ_/");
                if (msg !== "null") {
                    alert(msg);
                }
            }
        </script>
    </body>
</html>

