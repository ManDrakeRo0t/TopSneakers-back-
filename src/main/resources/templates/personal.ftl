<#import "parts/common.ftl" as c >

<@c.html>

    <@c.header></@c.header>

    <div class="my-content" >
        <div class="container" >
            <h3>Личный кабинет</h3>
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
                                        <form method="post" action="/order/delete/${selling.id}" >
                                            <#if selling.isPayed()>
                                                <button type="button"  class="btn btn-primary disabled">Удалить заказ</button>
                                            <#else >
                                                <button type="submit" class="btn btn-primary">Удалить заказ</button>
                                            </#if>
                                        </form>
                                        <form action="/order/pay/${selling.id}" method="post">
                                            <#if selling.isAccepted() && !selling.isPayed()>
                                                <button type="submit" class="btn btn-primary ml-1">Оплатить заказ</button>
                                            <#else >
                                                <button type="button" class="btn btn-primary ml-1 disabled">Оплатить заказ</button>
                                            </#if>
                                        </form>
                                    </div>
                                </div>
                                <div class="col">
                                    Товары на сумму ${selling.calculatePrice()}р.
                                    Позиций ${selling.sellingEntrySet?size} шт.
                                </div>
                                <div class="col">
                                    <p style="color: #002bb8; display: inline">Статус заказа : </p><br>
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
                            </div>
                        </div>
                    </#if>
                </#list>
                <#else >
                Пусто
            </#if>

        </div>

    </div>

    <@c.footer></@c.footer>

</@c.html>