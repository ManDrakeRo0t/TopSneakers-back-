<#import "../parts/common.ftl" as c >

<@c.html>
    <#if product?has_content>
        Форма обновления товара
        <form method="post" action="/administration/product/edit/${product.id}">
            <div class="form-group">
                <label for="name">
                    Название :
                </label>
                <input type="text" name="name" value="${product.name}" class="form-control bg-dark w-25 text-light" id="name"/>
            </div>
            <div class="form-group">
                <label for="brand">
                    Бренд :
                </label>
                <select id="brand"  name="brand" class="bg-dark text-light">
                    <#if brands?has_content>
                        <#list brands as brand>
                            <option <#if product.brandName.name == brand.name>selected</#if> >${brand.name}</option>
                        </#list>
                    </#if>
                </select>
            </div>
            <div class="form-group">
                <label for="productType">
                    Тип товара :
                </label>
                <select id="productType"  name="productType" class="bg-dark text-light">
                    <#if types?has_content>
                        <#list types as type>
                            <option <#if product.productType.name() == type >selected</#if> >${type}</option>
                        </#list>
                    </#if>
                </select>
            </div>
            <div class="form-group">
                <label for="price">
                    Цена :
                </label>
                <input type="number" step="0.01" name="price" value="${product.getPriceString()}"   class="form-control bg-dark w-25 text-light" id="price"/>
            </div>
            <div class="form-group">
                <label for="sale">
                    Скидка :
                </label>
                <input type="number" name="sale" value="${product.sale}" class="form-control bg-dark w-25 text-light" id="sale"/>
            </div>
            <div class="form-group">
                <label for="count">
                    Кол-во :
                </label>
                <input type="number" name="count" value="${product.count}" class="form-control bg-dark w-25 text-light" id="count"/>
            </div>
            <div class="form-group">
                <label for="status">
                    Доступен :
                </label>
                <input type="checkbox" value="true" <#if product.status> checked </#if>  name="status" class="form-control bg-dark w-25 text-light" id="status"/>
            </div>
            <button type="submit"  class="btn btn-primary mt-3">Добавить</button><br>
        </form>
        <div id="attribute" v-bind:productId="${product.id}"></div>
        <#else >
        Такого товара не существует
    </#if>
</@c.html>
