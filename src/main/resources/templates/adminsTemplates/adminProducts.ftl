<#import "../parts/common.ftl" as c >

<@c.html>
    <div id="brandsComp">

    </div>
    Форма добавления товара
    <form method="post" enctype="multipart/form-data" action="/administration/product">
        <div class="form-group">
            <label for="name">
                Название :
            </label>
            <input type="text" name="name" class="form-control bg-dark w-25 text-light" id="name"/>
        </div>
        <div class="form-group">
            <label for="brand">
                Бренд :
            </label>
            <select id="brand"  name="brand" class="bg-dark text-light">
                <#if brands?has_content>
                    <#list brands as brand>
                        <option>${brand.name}</option>
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
                        <option>${type}</option>
                    </#list>
                </#if>
            </select>
        </div>
        <div class="form-group">
            <label for="price">
                Цена :
            </label>
            <input type="number" step="0.01" name="price" class="form-control bg-dark w-25 text-light" id="price"/>
        </div>
        <div class="form-group">
            <label for="sale">
                Скидка :
            </label>
            <input type="number" name="sale" class="form-control bg-dark w-25 text-light" id="sale"/>
        </div>
        <div class="form-group">
            <label for="count">
                Кол-во :
            </label>
            <input type="number" name="count" class="form-control bg-dark w-25 text-light" id="count"/>
        </div>
        <div>
            <p>Загрузите фото товара</p>
            <p><input type="file" name="file" multiple accept="image/*,image/jpeg">
        </div>
        <button type="submit"  class="btn btn-primary mt-3">Добавить</button><br>
    </form>

    <div id="products"></div>

</@c.html>