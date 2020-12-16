<#import "../parts/common.ftl" as c >

<@c.html>

    <@c.header></@c.header>

    <div class="my-content">
         <div class="container">
             <p><a href="/product/catalog"><i class="far fa-arrow-alt-circle-left" style="color: #097bfd"></i>Назад</a></p>
             <#if !msg?has_content>
                 <div class="row ">
                     <div class=" col-lg-8">
                         <div class="container text-light">
                             <div id="carouselExampleIndicators${product.id}" class="carousel slide" data-ride="carousel">
                                 <ol class="carousel-indicators">
                                     <#if product.pictures.pictures?has_content>
                                         <#list 1..product.pictures.pictures?size as x >
                                             <#if x == 1>
                                                 <li data-target="#carouselExampleIndicators${product.id}" data-slide-to="0" class="active"></li>
                                             <#else >
                                                 <li data-target="#carouselExampleIndicators${product.id}" data-slide-to="3"></li>
                                             </#if>
                                         </#list>
                                     </#if>
                                 </ol>
                                 <div class="carousel-inner mt-5 md-5 w-75 ">
                                     <#if product.pictures.pictures?has_content>
                                         <#list product.pictures.pictures as img>
                                             <#if img?index == 0 >
                                                 <div class="carousel-item active">
                                                     <img class="d-block w-100 img-fluid" src="${img.source}" alt="Первый слайд">
                                                 </div>
                                             <#else >
                                                 <div class="carousel-item">
                                                     <img class="d-block w-100 img-fluid" src="${img.source}" alt="Первый слайд">
                                                 </div>
                                             </#if>
                                         </#list>
                                     </#if>
                                     <a class="carousel-control-prev" href="#carouselExampleIndicators${product.id}" role="button" data-slide="prev">
                                         <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                         <span class="sr-only">Previous</span>
                                     </a>
                                     <a class="carousel-control-next" href="#carouselExampleIndicators${product.id}" role="button" data-slide="next">
                                         <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                         <span class="sr-only">Next</span>
                                     </a>
                                 </div>
                             </div>
                         </div>
                     </div>
                     <div>
                     </div>
                     <div class="col ">
                         <div>
                             <br><br><br>
                             <h2>${product.getBrandName().name} ${product.getName()}</h2>
                             <h4>${product.getProductType()}</h4>
                             <p>Цена : ${product.getPrice()}₽</p>
                             <p>Цена со скидкой : <i style="color: red;">${product.price / 100 * (100 - product.sale)}₽</i></p>
                             <p>Дата : ${product.getDateFormat()}</p>
                             <p>Кол-во : ${product.count}</p><br>

                             <#if product.attributesValues?has_content>
                                 <#list product.attributesValues as value>
                                      <b>${value.attribute.getName()}</b> - ${value.stringValue}<br>
                                 </#list>
                             </#if>
                             <p><i class="fas fa-shopping-basket" style="color: #097bfd;"></i><a href="/basket/add/${product.id}"> Добавить в корзину</a></p>
<#--                             <div class="alert alert-success" role="alert">-->
<#--                                 Это уведомление об успехе — check it out!-->
<#--                             </div>-->
                             <#if c.isAdmin><p><a href="http://localhost:8082/administration/product/edit/${product.id}">Редактировать товар</a></p> </#if>
                         </div>
                     </div>
                 </div>
                     <div class="">
                         <h4>Похожие товары</h4><br><br>
                         <div class="d-flex flex-row flex-nowrap overflow-auto">
                             <#if addProduct?has_content >
                                 <#list addProduct as prod >
                                    <div class="col-4">
                                            <div class="card card-block">
                                                <#if prod.pictures.pictures?has_content>
                                                    <#list prod.pictures.pictures as img>
                                                        <#if img?index == 0 >
                                                            <img class="d-block img-fluid"  src="${img.source}">
                                                        </#if>
                                                    </#list>
                                                </#if>
                                                <#if prod.sale != 0>
                                                    <p><strike>${prod.getPrice()} ₽</strike> <b style="color: red;">${prod.price / 100 * (100 - prod.sale)} ₽</b></p>
                                                <#else >
                                                    <p>${prod.getPrice()}₽</p>
                                                </#if>
                                                <p class="text-right"><a href="/product/item/${prod.id}">Подробнее <i class="fas fa-chevron-right " style="color: #097bfd;"></i></a>
                                                </p>
                                            </div>
                                    </div>
                                 </#list>
                             <#else>
                                 Мы не смогли найти похожие товары
                             </#if>
                         </div>
                     </div>
             <#else >
                 ${msg}
             </#if>
         </div>
    </div>

    <script>

    </script>

    <@c.footer></@c.footer>

</@c.html>