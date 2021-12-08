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
                    <div class="logo-header mostion"><a href="index.html"><img src="images/logo.png" width="193" height="89" alt=""></a></div>
                    <!-- nav toggle button -->
                    <button class="navbar-toggler collapsed navicon justify-content-end" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                        <span></span>
                        <span></span>
                        <span></span>
                    </button>
                    <!-- extra nav -->
                    <div class="extra-nav">
                        <div class="extra-cell">
                            <button id="quik-search-btn" type="button" class="site-button radius-xl"><i class="fa fa-search"></i></button>
                        </div>
                    </div>
                    <!-- Quik search -->
                    <div class="dez-quik-search bg-primary-dark">
                        <form action="#">
                            <input name="search" value="" type="text" class="form-control" placeholder="Type to search">
                            <span  id="quik-search-remove"><i class="fa fa-remove"></i></span>
                        </form>
                    </div>
                    <!-- main nav -->
                    <div class="header-nav navbar-collapse collapse justify-content-end"  id="navbarNavDropdown">
                        <ul class=" nav navbar-nav">
                            <li class="active"> <a href="javascript:;">Home<i class="fa fa-chevron-down"></i></a>
                                <ul class="sub-menu">
                                    <li><a href="index.html">Home 1</a> </li>
                                    <li><a href="index-2.html">Home 2</a></li>
                                    <li><a href="index-3.html">Home 3</a></li>
                                    <li><a href="index-4.html">Home 4</a></li>
                                </ul>
                            </li>
                            <li> <a href="javascript:;">Features<i class="fa fa-chevron-down"></i></a>
                                <ul class="sub-menu">
                                    <li> <a href="javascript:;">Header Style Light<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="header-style-1.html">Header 1</a></li>
                                            <li><a href="header-style-2.html">Header 2</a></li>
                                            <li><a href="header-style-3.html">Header 3</a></li>
                                            <li><a href="header-style-4.html">Header 4</a></li>
                                            <li><a href="header-style-5.html">Header 5</a></li>
                                            <li><a href="header-style-6.html">Header 6</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Header Style Dark<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="header-style-1-dark.html">Header 1</a></li>
                                            <li><a href="header-style-2-dark.html">Header 2</a></li>
                                            <li><a href="header-style-3-dark.html">Header 3</a></li>
                                            <li><a href="header-style-4-dark.html">Header 4</a></li>
                                            <li><a href="header-style-5-dark.html">Header 5</a></li>
                                            <li><a href="header-style-6-dark.html">Header 6</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Footer<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="footer-1.html">Footer 1 </a></li>
                                            <li><a href="footer-2.html">Footer 2</a></li>
                                            <li><a href="footer-3.html">Footer 3</a></li>
                                            <li><a href="footer-4.html">Footer 4</a></li>
                                            <li><a href="footer-5.html">Footer 5</a></li>
                                            <li><a href="footer-6.html">Footer 6</a></li>
                                            <li><a href="footer-7.html">Footer 7</a></li>
                                            <li><a href="footer-8.html">Footer 8</a></li>
                                            <li><a href="footer-9.html">Footer 9</a></li>
                                            <li><a href="footer-10.html">Footer 10</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li> <a href="javascript:;">Pages<i class="fa fa-chevron-down"></i></a>
                                <ul class="sub-menu">
                                    <li> <a href="javascript:;">About us<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="about-1.html">About us 1</a></li>
                                            <li><a href="about-2.html">About us 2</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">FAQ<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="faq-1.html">FAQ 1</a></li>
                                            <li><a href="faq-2.html">FAQ 2</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Services<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="services-1.html">Services 1</a></li>
                                            <li><a href="services-2.html">Services 2</a></li>
                                            <li><a href="services-3.html">Services 3</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="career.html">Career</a></li>
                                    <li><a href="who-we-are.html">Who we are</a></li>
                                    <li><a href="help.html">Help Desk</a></li>
                                    <li><a href="privacy-policy.html">Privacy Policy</a></li>
                                    <li> <a href="javascript:;">Portfolio<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="portfolio-1.html">Portfolio 1</a></li>
                                            <li><a href="portfolio-2.html">Portfolio 2</a></li>
                                            <li><a href="portfolio-3.html">Portfolio 3</a></li>
                                            <li><a href="portfolio-details.html">portfolio-details</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Gallery<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="full-page-gallery-dark.html">Gallery Full Page Style 1</a></li>
                                            <li><a href="full-page-gallery-light.html">Gallery Full Page Style 2</a></li>
                                            <li><a href="gallery-grid-2.html">Galley Grid 2</a></li>
                                            <li><a href="gallery-grid-3.html">Galley Grid 3</a></li>
                                            <li><a href="gallery-grid-4.html">Galley Grid 4</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Error<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="error-403.html">Error 403</a></li>
                                            <li><a href="error-404.html">Error 404</a></li>
                                            <li><a href="error-405.html">Error 405</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Coming Soon<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="coming-soon-1.html">Coming Soon 1</a></li>
                                            <li><a href="coming-soon-2.html">Coming Soon 2</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Login Page<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu">
                                            <li><a href="login-1.html">Login 1</a></li>
                                            <li><a href="login-2.html">Login 2</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li> <a href="javascript:;">Shop<i class="fa fa-chevron-down"></i></a>
                                <ul class="sub-menu">
                                    <li><a href="product.html">Product</a></li>
                                    <li><a href="product-details.html">Product details</a></li>
                                </ul>
                            </li>
                            <li> <a href="javascript:;">Blog<i class="fa fa-chevron-down"></i></a>
                                <ul class="sub-menu">
                                    <li> <a href="javascript:;">Default<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu right">
                                            <li><a href="blog-half-img.html">Half image</a></li>
                                            <li><a href="blog-half-img-sidebar.html">Half image sidebar</a></li>
                                            <li><a href="blog-half-img-left-sidebar.html">Half image sidebar left</a></li>
                                            <li><a href="blog-large-img.html">Large image</a></li>
                                            <li><a href="blog-large-img-sidebar.html">Large image sidebar</a></li>
                                            <li><a href="blog-large-img-left-sidebar.html">Large image sidebar left</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Grid<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu right">
                                            <li><a href="blog-grid-2.html">Grid 2</a></li>
                                            <li><a href="blog-grid-2-sidebar.html">Grid 2 sidebar</a></li>
                                            <li><a href="blog-grid-2-sidebar-left.html">Grid 2 sidebar left</a></li>
                                            <li><a href="blog-grid-3.html">Grid 3</a></li>
                                            <li><a href="blog-grid-3-sidebar.html">Grid 3 sidebar</a></li>
                                            <li><a href="blog-grid-3-sidebar-left.html">Grid 3 sidebar left</a></li>
                                            <li><a href="blog-grid-4.html">Grid 4</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Single<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu right">
                                            <li><a href="blog-single.html">Single</a></li>
                                            <li><a href="blog-single-sidebar.html">Single sidebar</a></li>
                                            <li><a href="blog-single-left-sidebar.html">Single sidebar right</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Full Page Blog<i class="fa fa-chevron-down"></i></a>
                                        <ul class="sub-menu right">
                                            <li><a href="blog-full-grid-dark-style-1.html">Dark Style 1</a></li>
                                            <li><a href="blog-full-grid-dark-style-2.html">Dark Style 2</a></li>
                                            <li><a href="blog-full-grid-dark-style-3.html">Dark Style 3</a></li>
                                            <li><a href="blog-full-grid-light-style-1.html">Light Style 1</a></li>
                                            <li><a href="blog-full-grid-light-style-2.html">Light Style 2</a></li>
                                            <li><a href="blog-full-grid-light-style-3.html">Light Style 3</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="has-mega-menu "> <a href="javascript:;">Shortcodes<i class="fa fa-chevron-down"></i></a>
                                <ul class="mega-menu">
                                    <li> <a href="javascript:;">Shortcodes</a>
                                        <ul>
                                            <li><a href="shortcode-buttons.html">Buttons</a></li>
                                            <li><a href="shortcode-icon-box-styles.html">Icon box styles</a></li>
                                            <li><a href="shortcode-pricing-table.html">Pricing table</a></li>
                                            <li><a href="shortcode-toggles.html">Toggles</a></li>
                                            <li><a href="shortcode-team.html">Team</a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Shortcodes</a>
                                        <ul>
                                            <li><a href="shortcode-carousel-sliders.html">Carousel sliders</a></li>
                                            <li><a href="shortcode-image-box-content.html">Image box content</a></li>
                                            <li><a href="shortcode-tabs.html">Tabs</a></li>
                                            <li><a href="shortcode-counters.html">Counters</a></li>
                                            <li><a href="shortcode-light-box.html">Light Gallery <span class="new-page">New</span></a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Shortcodes</a>
                                        <ul>
                                            <li><a href="shortcode-accordians.html">Accordians</a></li>
                                            <li><a href="shortcode-dividers.html">Dividers</a></li>
                                            <li><a href="shortcode-images-effects.html">Images effects</a></li>
                                            <li><a href="shortcode-testimonials.html">Testimonials</a></li>
                                            <li><a href="shortcode-magnific-popup.html">Magnific Gallery <span class="new-page">New</span></a></li>
                                        </ul>
                                    </li>
                                    <li> <a href="javascript:;">Shortcodes</a>
                                        <ul>
                                            <li><a href="shortcode-alert-box.html">Alert box</a></li>
                                            <li><a href="shortcode-icon-box.html">Icon-box</a></li>
                                            <li><a href="shortcode-list-group.html">List group</a></li>
                                            <li><a href="shortcode-title-separators.html">title-separators</a></li>
                                            <li><a href="shortcode-all-widgets.html">Widgets</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li> <a href="javascript:;">Contact us <i class="fa fa-chevron-down"></i></a>
                                <ul class="sub-menu right">
                                    <li><a href="contact.html">Contact us 1</a></li>
                                    <li><a href="contact-2.html">Contact us 2</a></li>
                                    <li><a href="contact-3.html">Contact us 3</a></li>
                                    <li><a href="contact-4.html">Contact us 4</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- main header END -->
</header>
<!-- header END -->
