<#import "parts/common.ftl" as c >

<@c.html>

    <@c.header></@c.header>

    <div class="my-content">
        <div class="container">
            <h3 class="text-center">Статистика магазина</h3>
            <div class="row">
                <div class="col">
                    <h4 class="text-center">Статистика популярности товаров</h4>
                    <div id="chart1"></div>
                </div>
                <div class="col">
                    <h4 class="text-center">Статистика популярности брендов</h4>
                    <div id="chart2"></div>
                </div>
            </div>
            <div class="row" >
                <div id="chart3"></div>
            </div>
        </div>
    </div>

    <@c.footer></@c.footer>

</@c.html>

