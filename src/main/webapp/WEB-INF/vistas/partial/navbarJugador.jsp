
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
</header>

