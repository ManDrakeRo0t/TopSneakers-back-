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
<#--        <link rel="shortcut icon" type="image/x-icon" href="/static/res/logo.ico">-->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    </head>
    <body>

    <#nested>
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<#--    <script src="https://api-maps.yandex.ru/2.1/?bbcda198-7bca-4c86-ac60-aa1f67b164f3&lang=ru_RU" type="text/javascript"></script>-->
<#--    &lt;#&ndash;<script src="search_control_ppo.js" type="text/javascript"></script>&ndash;&gt;-->
<#--    <script src="/static/Forms.js"></script>-->
<#--    <script src="/static/script.js"></script>-->

        <script src="http://localhost:8001/main.js"></script>

    </body>
    </html>
</#macro>

<#--<#macro header>-->
<#--    <nav class="navbar navbar-expand-md navbar-dark fixed-top">-->
<#--        <a class="navbar-brand" href="/"><img style="width: 110px" src="/static/res/mainLogo.png"></a>-->
<#--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">-->
<#--            <span class="navbar-toggler-icon"></span>-->
<#--        </button>-->

<#--        <div class="collapse navbar-collapse" id="navbarSupportedContent">-->
<#--            <ul class="navbar-nav mr-auto" >-->
<#--                <li class="nav-item">-->
<#--                    <a class="nav-link" href="/cars">Автомобили <span class="sr-only">(current)</span></a>-->
<#--                </li>-->
<#--                <li class="nav-item">-->
<#--                    <a class="nav-link" href="/carClasses">Классы автомобилей <span class="sr-only">(current)</span></a>-->
<#--                </li>-->
<#--                <li class="nav-item">-->
<#--                    <a class="nav-link" href="/locations">Пункты выдачи <span class="sr-only">(current)</span></a>-->
<#--                </li>-->
<#--                <#if name!="Гость">-->
<#--                    <li class="nav-item">-->
<#--                        <a class="nav-link" href="/order">Оформить заказ <span class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                    <li class="nav-item">-->
<#--                        <a class="nav-link" href="/personal">Ваш AutoRent <span class="sr-only">(current)</span></a>-->
<#--                    </li>-->
<#--                </#if>-->
<#--            </ul>-->
<#--            <div class="navbar-text">${name}<br> Добро пожаловать!-->
<#--                <div>-->
<#--                    <form action="/logout" method="post">-->
<#--                        <#if name!="Гость">-->
<#--                            <input type="submit" value="Выйти" class="btn btn-primary btn-dark"/>-->
<#--                        <#else>-->
<#--                            <a class="btn btn-primary btn-dark" href="/login">Войти</a>-->
<#--                        </#if>-->
<#--                        <input type="hidden"  name="_csrf" value="${_csrf.token}">-->
<#--                    </form>-->
<#--                </div>-->
<#--            </div>-->


<#--        </div>-->

<#--    </nav>-->
<#--</#macro>-->

<#--<#macro footer>-->
<#--    <!-- Footer &ndash;&gt;-->
<#--    <footer class="page-footer font-small unique-color-dark mt-5">-->

<#--        <div style="background-color: #6351ce;">-->
<#--            <div class="container">-->

<#--                <!-- Grid row&ndash;&gt;-->
<#--                <div class="row py-4 d-flex align-items-center text-light">-->

<#--                    <!-- Grid column &ndash;&gt;-->
<#--                    <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">-->
<#--                        <h6 class="mb-0">Присоединйся к нам в социальных сетях</h6>-->
<#--                    </div>-->
<#--                    <!-- Grid column &ndash;&gt;-->

<#--                    <!-- Grid column &ndash;&gt;-->
<#--                    <div class="col-md-6 col-lg-7 text-center text-md-right">-->

<#--                        <!-- Facebook &ndash;&gt;-->
<#--                        <a class="fb-ic">-->
<#--                            <i class="fab fa-facebook-f white-text mr-4"> </i>-->
<#--                        </a>-->
<#--                        <!-- Twitter &ndash;&gt;-->
<#--                        <a class="tw-ic">-->
<#--                            <i class="fab fa-twitter white-text mr-4"> </i>-->
<#--                        </a>-->
<#--                        <!-- Google +&ndash;&gt;-->
<#--                        <a class="gplus-ic">-->
<#--                            <i class="fab fa-google-plus-g white-text mr-4"> </i>-->
<#--                        </a>-->
<#--                        <!--Linkedin &ndash;&gt;-->
<#--                        <a class="li-ic">-->
<#--                            <i class="fab fa-linkedin-in white-text mr-4"> </i>-->
<#--                        </a>-->
<#--                        <!--Instagram&ndash;&gt;-->
<#--                        <a class="ins-ic">-->
<#--                            <i class="fab fa-instagram white-text"> </i>-->
<#--                        </a>-->

<#--                    </div>-->
<#--                    <!-- Grid column &ndash;&gt;-->

<#--                </div>-->
<#--                <!-- Grid row&ndash;&gt;-->

<#--            </div>-->
<#--        </div>-->

<#--        <!-- Footer Links &ndash;&gt;-->
<#--        <div class="container text-center text-md-left mt-5 text-light">-->

<#--            <!-- Grid row &ndash;&gt;-->
<#--            <div class="row mt-3">-->

<#--                <!-- Grid column &ndash;&gt;-->
<#--                <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">-->

<#--                    <!-- Content &ndash;&gt;-->
<#--                    <h6 class="text-uppercase font-weight-bold">AutoRent</h6>-->
<#--                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">-->
<#--                    <p>Самый доступный способ-->
<#--                        почувствовать себя королем дороги.<br>-->
<#--                        Только самые попуполярные и лучшие модели.-->
<#--                    </p>-->

<#--                </div>-->
<#--                <!-- Grid column &ndash;&gt;-->

<#--                <!-- Grid column &ndash;&gt;-->
<#--                <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">-->

<#--                    <!-- Links &ndash;&gt;-->
<#--                    <h6 class="text-uppercase font-weight-bold">Полезные ссылки</h6>-->
<#--                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">-->
<#--                    <p>-->
<#--                        <a href="#!">---</a>-->
<#--                    </p>-->
<#--                    <p>-->
<#--                        <a href="#!">---</a>-->
<#--                    </p>-->
<#--                    <p>-->
<#--                        <a href="#!">---</a>-->
<#--                    </p>-->
<#--                    <#if isAdmin>-->
<#--                        <p>-->
<#--                            <a href="/administration">Управление</a>-->
<#--                        </p>-->
<#--                    </#if>-->

<#--                </div>-->
<#--                <!-- Grid column &ndash;&gt;-->

<#--                &lt;#&ndash;                <!-- Grid column &ndash;&gt;&ndash;&gt;-->
<#--                &lt;#&ndash;                <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">&ndash;&gt;-->

<#--                &lt;#&ndash;                    <!-- Links &ndash;&gt;&ndash;&gt;-->
<#--                &lt;#&ndash;                    <h6 class="text-uppercase font-weight-bold">Useful links</h6>&ndash;&gt;-->
<#--                &lt;#&ndash;                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">&ndash;&gt;-->
<#--                &lt;#&ndash;                    <p>&ndash;&gt;-->
<#--                &lt;#&ndash;                        <a href="#!">Your Account</a>&ndash;&gt;-->
<#--                &lt;#&ndash;                    </p>&ndash;&gt;-->
<#--                &lt;#&ndash;                    <p>&ndash;&gt;-->
<#--                &lt;#&ndash;                        <a href="#!">Become an Affiliate</a>&ndash;&gt;-->
<#--                &lt;#&ndash;                    </p>&ndash;&gt;-->
<#--                &lt;#&ndash;                    <p>&ndash;&gt;-->
<#--                &lt;#&ndash;                        <a href="#!">Shipping Rates</a>&ndash;&gt;-->
<#--                &lt;#&ndash;                    </p>&ndash;&gt;-->
<#--                &lt;#&ndash;                    <p>&ndash;&gt;-->
<#--                &lt;#&ndash;                        <a href="#!">Help</a>&ndash;&gt;-->
<#--                &lt;#&ndash;                    </p>&ndash;&gt;-->

<#--                &lt;#&ndash;                </div>&ndash;&gt;-->
<#--                &lt;#&ndash;                <!-- Grid column &ndash;&gt;&ndash;&gt;-->

<#--                <!-- Grid column &ndash;&gt;-->
<#--                <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">-->

<#--                    <!-- Links &ndash;&gt;-->
<#--                    <h6 class="text-uppercase font-weight-bold">Контакты</h6>-->
<#--                    <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">-->
<#--                    <p>-->
<#--                        <i class="fas fa-home mr-3"></i> Москва. Радужная 13</p>-->
<#--                    <p>-->
<#--                        <i class="fas fa-envelope mr-3"></i> autorent@gmail.com</p>-->
<#--                    <p>-->
<#--                        <i class="fas fa-phone mr-3"></i> 8 902 04 39 309</p>-->
<#--                    <p>-->
<#--                        <i class="fas fa-print mr-3"></i> 8 800 55 53 335</p>-->

<#--                </div>-->
<#--                <!-- Grid column &ndash;&gt;-->

<#--            </div>-->
<#--            <!-- Grid row &ndash;&gt;-->

<#--        </div>-->
<#--        <!-- Footer Links &ndash;&gt;-->

<#--        <!-- Copyright &ndash;&gt;-->
<#--        <div class="footer-copyright text-center py-3">© 2020 Copyright:-->
<#--            <a href="#!"> AutoRent.ru</a>-->
<#--        </div>-->
<#--        <!-- Copyright &ndash;&gt;-->

<#--    </footer>-->
<#--    <!-- Footer &ndash;&gt;-->

<#--</#macro>-->
