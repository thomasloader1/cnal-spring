<%--
<header>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="/proyecto_limpio_spring_war_exploded/index-jugador">ClubNoAtleticoList</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                    aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="unirmeDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Unirme a
                        </a>
                        <div class="dropdown-menu" aria-labelledby="unirmeDropdown">
                            <a class="dropdown-item" href="/proyecto_limpio_spring_war_exploded/unirme-al-partido">Partido</a>
                            <a class="dropdown-item" href="/proyecto_limpio_spring_war_exploded/unirme-a-equipo">Equipo</a>
                            <a class="dropdown-item" href="/proyecto_limpio_spring_war_exploded/unirme-a-torneo">Torneo</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="crearDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Crear
                        </a>
                        <div class="dropdown-menu" aria-labelledby="crearDropdown">
                            <a class="dropdown-item" href="/proyecto_limpio_spring_war_exploded/unirme-al-partido">Partido</a>
                            <a class="dropdown-item" href="/proyecto_limpio_spring_war_exploded/registro-equipo">Equipo</a>
                            <a class="dropdown-item" href="/proyecto_limpio_spring_war_exploded/registro-torneo">Torneo</a>
                            <a class="dropdown-item" href="/proyecto_limpio_spring_war_exploded/torneos-crear-fixture">Fixture</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/buscar-cancha">Buscar cancha</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/proyecto_limpio_spring_war_exploded/torneos-crear-fixture">Torneos</a>
                    </li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownUser" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-user"></i> ${user.getNombre()}
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownUser">
                            <h6 class="dropdown-header">Cuenta:  ${user.getRol()}</h6>
                            <a class="dropdown-item" href="/proyecto_limpio_spring_war_exploded/ir-a-perfil-jugador">Perfil</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/proyecto_limpio_spring_war_exploded/cerrarSesion">Cerrar sesion</a>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>--%>

<!-- header -->
<header class="site-header header-style-6 dark mo-left ">
    <!-- main header -->
    <div class=" sticky-header main-bar-wraper navbar-expand-lg navbar-expand-lg">
        <div class="main-bar clearfix ">
            <div class="top-bar">
                <div class="container top-bar-crve">
                    <div class="row justify-content-between">
                        <div class="dez-topbar-left">
                            <ul class="social-line text-center pull-right">
                                <li><a href="javascript:void(0);"><i class="fa fa-envelope-o"></i> <span> contacto@cnal.com.ar </span> </a></li>
                                <li><a href="javascript:void(0);"><i class="fa fa-phone"></i> <span> (732) 803-010-03 </span> </a></li>
                            </ul>
                        </div>
                        <div class="dez-topbar-right ">
                            <ul class="social-line text-center pull-right">
                                <li><a href="javascript:void(0);" class="fa fa-facebook"></a></li>
                                <li><a href="javascript:void(0);" class="fa fa-twitter"></a></li>
                                <li><a href="javascript:void(0);" class="fa fa-linkedin"></a></li>
                                <%--<li><a href="javascript:void(0);" class="fa fa-google-plus"></a></li>--%>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="header-bar">
                <div class="container clearfix">
                    <!-- website logo -->
                    <div class="logo-header mostion"><a href="/proyecto_limpio_spring_war_exploded/index-jugador"><img src="images/logo.png" width="193" height="89" alt=""></a></div>
                    <!-- nav toggle button -->
                    <button class="navbar-toggler collapsed navicon justify-content-end" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span></span>
                        <span></span>
                        <span></span>
                    </button>
                    <!-- extra nav -->
                    <%--<div class="extra-nav">
                        <div class="extra-cell">
                            <button id="quik-search-btn" type="button" class="site-button radius-xl"><i class="fa fa-search"></i></button>
                        </div>
                    </div>--%>
                    <!-- Quik search -->
                    <%--<div class="dez-quik-search bg-primary-dark">
                        <form action="#">
                            <input name="search" value="" type="text" class="form-control" placeholder="Type to search">
                            <span  id="quik-search-remove"><i class="fa fa-remove"></i></span>
                        </form>
                    </div>--%>
                    <!-- main nav -->
                    <div class="header-nav navbar-collapse collapse justify-content-end"  id="navbarNavDropdown">
                        <ul class=" nav navbar-nav">

                            <li > <a href="javascript:;">Unirme a<i class="fa fa-chevron-down"></i></a>
                                <ul class="sub-menu">
                                    <li><a href="/proyecto_limpio_spring_war_exploded/unirme-al-partido">Partido</a> </li>
                                    <li><a href="/proyecto_limpio_spring_war_exploded/unirme-a-equipo">Equipo</a></li>
                                    <li><a href="/proyecto_limpio_spring_war_exploded/unirme-a-torneo">Torneo</a></li>
                                </ul>
                            </li>

                            <li> <a href="javascript:;">Crear<i class="fa fa-chevron-down"></i></a>

                                        <ul class="sub-menu">
                                            <li><a href="/proyecto_limpio_spring_war_exploded/unirme-al-partido">Partido</a></li>
                                            <li><a href="/proyecto_limpio_spring_war_exploded/registro-equipo">Equipo</a></li>
                                            <li><a href="/proyecto_limpio_spring_war_exploded/registro-torneo">Torneo</a></li>
                                            <li><a href="/proyecto_limpio_spring_war_exploded/torneos-crear-fixture">Fixture</a></li>
                                        </ul>

                            </li>

                            <li> <a href="/proyecto_limpio_spring_war_exploded/buscar-cancha">Buscar cancha</a></li>
                            <li> <a href="/proyecto_limpio_spring_war_exploded/torneos-crear-fixture">Torneos</a></li>

                            <li> <a href="javascript:;"><i class="fa fa-user"></i> ${user.getNombre()}</i></a>

                                <ul class="sub-menu">
                                    <li><h6 >Cuenta:  ${user.getRol()}</h6></li>
                                    <li><a  href="/proyecto_limpio_spring_war_exploded/ir-a-perfil-jugador">Perfil</a></li>
                                    <li><a  href="/proyecto_limpio_spring_war_exploded/cerrarSesion">Cerrar sesion</a></li>
                                </ul>

                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- main header END -->
</header><!-- header END -->
