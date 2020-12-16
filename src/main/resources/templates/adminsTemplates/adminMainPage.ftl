<#import "../parts/common.ftl" as c >

<@c.html>

    <@c.header></@c.header>


    <div class="container my-content">

        <div class="row" >
            <div class="col">
                <h3>Добавлние брендов</h3>
                <div id="brandsComp">
                </div>

                <p><a href="/administration/product">Добавить товар</a></p>

            </div>
            <div class="col">
                <h3>Добавление городов</h3>
                <div id="cityComp">
                </div>
                <p><a href="/administration/punct">Добавить пункт выдачи</a></p>
            </div>
        </div>
        <#if sellings?has_content >
            <h4 class="text-center" >Список заказов</h4>
            <#list sellings as selling>
                <#if !selling.deleted >
                    <br><br>
                    <div class="card">
                        <div class="row">
                            <div class="col">
                                <p><strong>Номер</strong> ${selling.id} ,     Детали заказа : ${selling.details} <a href="/order/${selling.id}">Чек заказа</a> </p>
                                <div style="display: flex" >
                                    <form method="post" action="/order/delete/${selling.id}" ><button type="submit" class="btn btn-primary">Удалить заказ</button></form>
                                </div>
                            </div>
                            <div class="col">
                                Товары на сумму ${selling.calculatePrice()}р.
                                Позиций ${selling.sellingEntrySet?size} шт.
                            </div>
                            <div class="col">
                                <p style="color: #17a2b8; display: inline">Статус заказа : </p><br>
                                <#if selling.isAccepted()>
                                    <p style="color: #3db82e;display: inline"><i class="fas fa-check-circle"></i> Принят<br></p>
                                <#else >
                                    <p style="color: #d1172f;display: inline"><i class="fas fa-times-circle"></i> Не Принят<br></p>
                                </#if>
                                <#if selling.isPayed()>
                                    <p style="color: #3db82e"><i class="fas fa-check-circle"></i> Оплачен</p>
                                <#else >
                                    <p style="color: #d1172f"><i class="fas fa-times-circle"></i> Не Оплачен</p>
                                </#if>
                            </div>
                            <div class="col">
                                <form method="post" action="/order/edit/${selling.id}">
                                    <div class="form-group">
                                        <label for="details" class="text-center">
                                            Детали заказа :
                                        </label>
                                        <input type="text" name="details" class="form-control" id="details" value="${selling.details}"/>
                                    </div>
                                    <label for="status" class="text-center">
                                        Принять заказ :
                                    </label>
                                    <input type="checkbox" name="status" class="form-control bg-dark text-light" id="status"/>
                                    <input type="submit" value="Отправить" class="btn btn-primary mr-5" style="float: right"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </#if>
            </#list>
        <#else >
            Пусто
        </#if>

    </div>


    <@c.footer></@c.footer>

</@c.html>