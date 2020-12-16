<#import "parts/common.ftl" as c >

<@c.html>

    <@c.header></@c.header>

    <div class="my-content" >
        <div class="container" >
            <#if msg?has_content>
                <h3>${msg}</h3>
                <#else >
                    <#if count == 0>
                        Ваша корзина пуста, <a href="/product/catalog">Советуем вам что нибудь добавить</a>
                    <#else >
                        <h3>Выберете дату и место доставки</h3>
                        <form action="/order" method="post">
                            <div class="form-group">
                                <label for="date">
                                    Дата :
                                </label>
                                <input name="deliverDate" type="date" class="form-control bg-dark w-25 text-light" id="dateStart"/>
                            </div>
                            <div class="form-group">
                                <label for="address">
                                    Адрес :<br>
                                </label>
                                <select id="address"  name="address" class="bg-dark text-light">
                                    <#if puncts?has_content>
                                        <#list puncts as punct>
                                            <option>${punct.city.name} - ${punct.address}</option>
                                        </#list>
                                    </#if>
                                </select>
                            </div>
                            <div><input type="submit" value="Отправить" class="btn btn-primary btn-dark"/></div>
                        </form>
                    </#if>
            </#if>

        </div>
    </div>
    <script>
        let now = new Date()
        let year  = now.getFullYear();
        let month = now.getMonth()+1;
        let day   = now.getDate();
        if(day.toString().length === 1) {
            day = '0'+day;
        }
        if(month.toString().length === 1) {
            month = '0'+month;
        }
        document.querySelector('#dateStart').min = year +'-'+ month +'-'+ day;
        document.querySelector('#dateStart').value = year +'-'+ month +'-'+ day;
    </script>

    <@c.footer></@c.footer>

</@c.html>