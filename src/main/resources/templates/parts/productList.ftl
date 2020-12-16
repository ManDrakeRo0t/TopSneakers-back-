<#import "../parts/common.ftl" as c >

<@c.html>

    <@c.header></@c.header>

    <div class="my-content">
        <form action="/product/catalog" method="post">
            <div class="container">
                <h2>Фильтр товаров</h2>
            <div class="row" >
                <div class="col">
                    <div class="form-group">
<#--                        <label for="brandName">-->
<#--                             -->
<#--                        </label>-->
                        <select id="brandName"  name="brandName" class="">
                            <#if brands?has_content>
                                <#list brands as brand>
                                    <option value="${brand.name}">${brand.name}</option>
                                </#list>
                            </#if>
                            <option value="null" selected>Бренд</option>
                        </select>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
<#--                        <label for="productType">-->
<#--&lt;#&ndash;                            Тип товара :&ndash;&gt;-->
<#--                        </label>-->
                        <select id="productType"  name="productType" class="">
                            <#if types?has_content>
                                <#list types as type>
                                    <option>${type}</option>
                                </#list>
                            </#if>
                            <option value="null" selected>Тип товара</option>
                        </select>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
<#--                        <label for="isSale">-->
<#--                            Скидка :-->
<#--                        </label>-->
                        <select id="isSale"  name="isSale" class="">
                            <option value="true">есть</option>
                            <option value="null" selected>Скидка</option>
                        </select>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
                        <#--                        <label for="sort">-->
                        <#--                            Сортировать :-->
                        <#--                        </label>-->
                        <select id="sort"  name="sort" class="">
                            <option value="lessPrice">по убыванию</option>
                            <option value="maxPrice">по возрастанию</option>
                            <option value="new">новизне</option>
                            <option value="null" selected>Сортировка</option>
                        </select>
                    </div>
                </div>

                <div class="col">
                    <div class="form-group">
<#--                        <label for="minPrice">-->
<#--&lt;#&ndash;                            Минимальная цена :&ndash;&gt;-->
<#--                        </label>-->
                        <input type="number" name="minPrice" class="form-control  w-60 " id="minPrice" placeholder="Минимальная цена"/>
                    </div>
                </div>
                <div class="col">
                    <div class="form-group">
<#--                        <label for="maxPrice">-->
<#--&lt;#&ndash;                            Максимальная цена :&ndash;&gt;-->
<#--                        </label>-->
                        <input type="number" name="maxPrice" class="form-control  w-60 " id="maxPrice" placeholder="Максимальная цена"/>
                    </div>
                </div>
            </div><button type="submit"  class="btn btn-primary mt-3">Найти</button>
            </div>
        </form>
    </div>
    <div class="">
        <#if products?has_content >
            <div class="container" >
                <div class="row">
                    <#list products as product >
                        <div class="col" >
                            <#if product.status != false || c.isAdmin == true >
                                <div class="card md-5 mt-5 my-card w-100" <#if products?size == 1 || (product?index == (products?size-1) && product?index % 3 == 0 )>style="width: 32% !important;" </#if>>
                                    <#if product.pictures.pictures?has_content>
                                        <#list product.pictures.pictures as img>
                                            <#if img?index == 0 >
                                                <img class="d-block w-100 img-fluid"  src="${img.source}">
                                            </#if>
                                        </#list>
                                    </#if>
                                    <#if product.sale != 0><p style="color:black;margin-top: -4%;background-color: red">-${product.sale}%</p>
                                        <p><strike>${product.getPrice()} ₽</strike> <b style="color: red;">${product.price / 100 * (100 - product.sale)} ₽</b></p>
                                    <#else >
                                        <p>${product.getPrice()}₽</p>
                                    </#if>

                                    <h6 style="display: inline">${product.productType}</h6><h3> ${product.getBrandName().name} ${product.getName()}</h3>
                                    <p class="text-right"><a href="/product/item/${product.id}">Подробнее <i class="fas fa-chevron-right " style="color: #097bfd;"></i></a></p>
                                </div>
                            </#if>
                        </div>
                        <#if product?index % 3 == 2> <div class="w-100"></div> </#if>
                    </#list>
                </div>
            </div>

            <#else >
            <div class="container"  >
                Товаров не найдено, попробуйте нажать найти без фильтров
            </div>
        </#if>
    </div>

    <@c.footer></@c.footer>
</@c.html>


