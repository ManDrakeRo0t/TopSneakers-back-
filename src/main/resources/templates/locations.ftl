<#import "parts/common.ftl" as c >

<@c.html>

    <@c.header></@c.header>


        <div class="my-content" >
            <div class="container" >
                <h4>Вы можете получить в пунтке выдачи по этим адресам:</h4><br>
                <#list puncts as punct>
                    Город ${punct.city.name} - ${punct.address}<br>
                </#list>

                <div id="VueMap">

                </div>
            </div>
        </div>


    <@c.footer></@c.footer>

    </@c.html>