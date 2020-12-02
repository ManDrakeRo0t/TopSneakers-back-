<#import "../parts/common.ftl" as c >

<@c.html>
<#if !msg?has_content>
    <div class="card md-5 mt-5">
            <p><a href="/product/catalog">Назад</a></p>
                   <h2>${product.getBrandName().name} : ${product.getName()}</h2><br>
                   <h4>${product.getProductType()}</h4><br>
                   <p>Цена :${product.getPrice()}</p><br>
                   <p>Цена со скидкой : ${product.price / 100 * (100 - product.sale)} скидка ${product.sale}</p><br>
                   <p>Дата : ${product.getDateFormat()}</p><br>
                   <p>Кол-во : ${product.count}</p>
                   <div class="container mt-5 md-5 text-light">
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
                           <div class="carousel-inner mt-5 md-5">
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
                    <#if product.attributesValues?has_content>
                        <#list product.attributesValues as value>
                            Аттрибут : ${value.attribute.getName()} - Значение : ${value.stringValue}<br>
                        </#list>
                    </#if>
                </div>
                <p><a href="http://localhost:8082/administration/product/edit/${product.id}">Редактировать товар</a></p>
            <#else >
            ${msg}
        </#if>
</@c.html>