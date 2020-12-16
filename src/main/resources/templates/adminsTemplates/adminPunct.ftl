<#import "../parts/common.ftl" as c >

<@c.html>

    <@c.header></@c.header>

    <div class="my-content">

        <div class="container">
            Форма добавления пункта доставки
            <form method="post"  action="/administration/punct">
                <div class="form-group">
                    <label for="latitude">
                        Широта :
                    </label>
                    <input type="text" name="latitude" class="form-control bg-dark w-25 text-light" id="latitude"/>
                </div>
                <div class="form-group">
                    <label for="longitude">
                        Долгота :
                    </label>
                    <input type="text" name="longitude" class="form-control bg-dark w-25 text-light" id="longitude"/>
                </div>
                <div class="form-group">
                    <label for="cityName">
                        Город :
                    </label>
                    <select id="cityName"  name="cityName" class="bg-dark text-light">
                        <#if cities?has_content>
                            <#list cities as city>
                                <option>${city.name}</option>
                            </#list>
                        </#if>
                    </select>
                </div>
                <div class="form-group">
                    <label for="address">
                        Адрес :
                    </label>
                    <input type="text"  name="address" class="form-control bg-dark w-25 text-light" id="address"/>
                </div>
                <button type="submit"  class="btn btn-primary mt-3">Добавить</button><br>
            </form>

        </div>

    </div>

    <@c.footer></@c.footer>

</@c.html>