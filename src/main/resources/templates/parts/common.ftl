<#include "../auth/security.ftl">


<#macro html>
    <!DOCTYPE HTML>
    <html lang="ru">
    <head>
        <title>Top Sneakers</title>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="/static/res/style.css">
        <link rel="stylesheet" href="//unpkg.com/leaflet/dist/leaflet.css" />
<#--        <link rel="shortcut icon" type="image/x-icon" href="/static/res/logo.ico">-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>
    <div class="background"></div>

    <#nested>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>


        <script src="http://localhost:8001/main.js"></script>

    </body>
    </html>
</#macro>

<#macro header>
    <nav class="navbar navbar-expand-md fixed-top text-light">
        <a class="navbar-brand" href="/"><img style="width: 110px" src="/static/images/logo.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-bars" style="color: #d6d3e2"></i>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto" >
                <li class="nav-item">
                    <a class="nav-link" href="/product/catalog">Каталог <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/locations">Пункты выдачи <span class="sr-only">(current)</span></a>
                </li>
                <#if name!="Гость">
                    <li class="nav-item">
                        <a class="nav-link" href="/order">Оформить заказ <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/personal">Личный кабинет <span class="sr-only">(current)</span></a>
                    </li>
                </#if>
            </ul>
            <div class="navbar-text">
                <div class="row" >
                    <#if name!="Гость">
                        <div class="col" >
                            <button class="btn btn-primary btn-dark" type="button" data-toggle="collapse" data-target="#basketPlace" aria-expanded="false" aria-controls="basketPlace">
                                        <i class="fas fa-shopping-basket" style="color: #097bfd;"></i>

                                        <div id="basketCount"></div>


                            </button>
                        </div>
                    </#if>

                    <div class="col" >
                        ${name}
                    </div>

                    <div class="col" >
                        <form action="/logout" method="post">
                            <#if name!="Гость">
                                <input type="submit" value="Выйти" class="btn btn-primary"/>

                            <#else>
                                <a class="btn btn-primary" href="/login">Войти</a>
                            </#if>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </nav>
    <div class="collapse basketStyle"  id="basketPlace">
        <div id="basket">

        </div>
    </div>
</#macro>

<#macro footer>
    <!-- Footer -->
    <footer class="page-footer font-small unique-color-dark mt-5">

        <div >
            <div class="container">

                <!-- Grid row-->
                <div class="row py-4 d-flex align-items-center text-light">

                    <!-- Grid column -->
                    <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
                        <h6 class="mb-0">Присоединйся к нам в социальных сетях</h6>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-6 col-lg-7 text-center text-md-right">

                        <!-- Facebook -->
                        <a class="fb-ic">
                            <i class="fab fa-facebook-f white-text mr-4"> </i>
                        </a>
                        <!-- Twitter -->
                        <a class="tw-ic">
                            <i class="fab fa-twitter white-text mr-4"> </i>
                        </a>
                        <!-- Google +-->
                        <a class="gplus-ic">
                            <i class="fab fa-google-plus-g white-text mr-4"> </i>
                        </a>
                        <!--Linkedin -->
                        <a class="li-ic">
                            <i class="fab fa-linkedin-in white-text mr-4"> </i>
                        </a>
                        <!--Instagram-->
                        <a class="ins-ic">
                            <i class="fab fa-instagram white-text"> </i>
                        </a>

                    </div>
                    <!-- Grid column -->

                </div>
                <!-- Grid row-->

            </div>
            <hr color="white">
        </div>

        <!-- Footer Links -->
        <div class="container text-center text-md-left mt-5 text-light">

            <!-- Grid row -->
            <div class="row mt-3">

                <!-- Grid column -->
                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">

                    <!-- Content -->
                    <h6 class="text-uppercase font-weight-bold">Top Sneakers</h6>
                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                    <p>Только у нас вы можете преобрести самые<br>
                        лучшие модели кроссовок,и аксессуары к ним!
                    </p>

                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

                    <!-- Links -->
                    <h6 class="text-uppercase font-weight-bold">Полезные ссылки</h6>
                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                    <p>
                        <a href="#!">---</a>
                    </p>
                    <p>
                        <a href="#!">---</a>
                    </p>
                    <#if isAdmin>
                        <p>
                            <a href="/administration/stat">Статистика</a>
                        </p>
                    </#if>
                    <#if isAdmin>
                        <p>
                            <a href="/administration">Управление</a>
                        </p>
                    </#if>

                </div>
                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

                    <!-- Links -->
                    <h6 class="text-uppercase font-weight-bold">Контакты</h6>
                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
                    <p>
                        <i class="fas fa-home mr-3"></i> Москва. Радужная 13</p>
                    <p>
                        <i class="fas fa-envelope mr-3"></i> TopSneakers@gmail.com</p>
                    <p>
                        <i class="fas fa-phone mr-3"></i> 8 902 04 39 309</p>
                    <p>
                        <i class="fas fa-print mr-3"></i> 8 800 55 53 335</p>

                </div>
                <!-- Grid column -->

            </div>
            <!-- Grid row -->

        </div>
        <!-- Footer Links -->

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">© 2020 Copyright:
            <a href="#!"> TopSneakers.ru</a>
        </div>
        <!-- Copyright -->

    </footer>
    <!-- Footer -->

</#macro>
