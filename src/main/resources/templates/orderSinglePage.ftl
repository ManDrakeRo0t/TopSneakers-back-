<#import "parts/common.ftl" as c >

<@c.html>

    <@c.header></@c.header>

    <div class="my-content" >
        <div class="container" >
            <#if order?has_content>
                <button class="btn btn-primary" onclick="f()">печать</button>

                <h3>Заказ номер : ${order.id}</h3>

                <p>Заказ оформен : ${order.user.firstName} ${order.user.lastName}</p>

                <p>Дата достивки : ${order.deliverDate} по адресу Город ${order.deliverPunct.city.name} - ${order.deliverPunct.address}</p>

                <p>Детали заказа : ${order.details}</p>

                <p>Стутус оформления : <#if !order.isAccepted() >не</#if> принят</p>

                <p>Статус оплаты : <#if !order.isPayed() >не</#if> оплачен</p>

                <h3 class="text-center">Состав заказа : </h3>
                <hr color="black">

                <#list order.sellingEntrySet as entry >
                    <div class="row mb-2">
                        <div class="col" >
                            <#if entry.product.pictures.pictures?has_content>
                                <#list entry.product.pictures.pictures as img>
                                    <#if img?index == 0 >
                                        <img class="d-block img-fluid" style="width: 150px;"  src="${img.source}">
                                    </#if>
                                </#list>
                            </#if>
                        </div>
                        <div class="col" >
                            ${entry.product.productType.name()} ${entry.product.brandName.name} ${entry.product.name} x ${entry.count}
                        </div>
                        <div class="col" >
                            <p>Цена : <strong>${entry.price}р.</strong></p>
                            <p>Стоимость без скидки : <strong>${entry.price * entry.count}р.</strong></p>
                            <p>Стоимость со скидкой : <strong>${entry.price * entry.count * (1 - (entry.sale / 100))}р.</strong></p>
                        </div>
                    </div>
                    <hr color="black">
                </#list>

                <h3>Итог : ${order.calculatePrice()}р.</h3>

                <hr color="black">

            <#else >

                <h3>Мы не смогли найти этот заказ</h3>

            </#if>
        </div>

    </div>

    <script>
        function f() {
            print();
        }
    </script>


</@c.html>