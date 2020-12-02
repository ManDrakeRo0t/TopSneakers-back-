<#import "../parts/common.ftl" as c >

<@c.html>
    <div>
        <form action="/product/catalog" method="post">
            <div class="form-group">
                <label for="brandName">
                    Бренд :
                </label>
                <select id="brandName"  name="brandName" class="bg-dark text-light">
                    <#if brands?has_content>
                        <#list brands as brand>
                            <option value="${brand.name}">${brand.name}</option>
                        </#list>
                    </#if>
                    <option value="null" selected>выбрать</option>
                </select>
            </div>
            <div class="form-group">
                <label for="productType">
                    Тип товара :
                </label>
                <select id="productType"  name="productType" class="bg-dark text-light">
                    <#if types?has_content>
                        <#list types as type>
                            <option>${type}</option>
                        </#list>
                    </#if>
                    <option value="null" selected>выбрать</option>
                </select>
            </div>
            <div class="form-group">
                <label for="minPrice">
                    Минимальная цена :
                </label>
                <input type="number" name="minPrice" class="form-control bg-dark w-25 text-light" id="minPrice"/>
            </div>
            <div class="form-group">
                <label for="maxPrice">
                    Максимальная цена :
                </label>
                <input type="number" name="maxPrice" class="form-control bg-dark w-25 text-light" id="maxPrice"/>
            </div>
            <div class="form-group">
                <label for="isSale">
                    Скидка :
                </label>
                <select id="isSale"  name="isSale" class="bg-dark text-light">
                    <option value="true">есть</option>
                    <option value="null" selected>выбрать</option>
                </select>
            </div>
            <div class="form-group">
                <label for="sort">
                    Сортировать :
                </label>
                <select id="sort"  name="sort" class="bg-dark text-light">
                    <option value="lessPrice">по убыванию</option>
                    <option value="maxPrice">по возрастанию</option>
                    <option value="new">новизне</option>
                    <option value="null" selected>выбрать</option>
                </select>
            </div>
            <button type="submit"  class="btn btn-primary mt-3">Найти</button>
        </form>
    </div>
    <div>
        <#if products?has_content >
           <#list products as product >
               <div class="card md-5 mt-5">
                   <h2>${product.getBrandName().name} : ${product.getName()}</h2><br>
                   <h4>${product.getProductType()}</h4><br>
                   <p>Цена :${product.getPrice()}</p><br>
                   <p>Цена со скидкой : ${product.price / 100 * (100 - product.sale)} скидка ${product.sale}</p><br>
                   <p>Дата : ${product.getDateFormat()}</p><br>
                   <p>Кол-во : ${product.count}</p>
                   <p><a href="/product/item/${product.id}">Подробнее</a></p>
               </div>
           </#list>
            <#else >
            Товаров не найдено
        </#if>
    </div>
</@c.html>


