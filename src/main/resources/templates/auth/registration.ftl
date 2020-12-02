<#import "../parts/common.ftl" as c>

<@c.html>
    <#if msg?has_content>
        ${msg}
    </#if>
    <form action="/registration" method="post">
        <div class="form-group">
            <label for="InputEmail">
                Почта :
            </label>
            <input name="username" type="email" class="form-control bg-dark w-25 text-light" id="InputEmail" aria-describedby="emailHelp"/>
        </div>
        <div class="form-group">
            <label for="InputPassword">
                Пароль :
            </label>
            <input type="password" name="password" class="form-control bg-dark w-25 text-light" id="InputPassword"/>
        </div>
        <div class="form-group">
            <label for="InputFirstName">
                Имя :
            </label>
            <input type="text" name="firstName" class="form-control bg-dark w-25 text-light" id="InputFirstName"/>
        </div>
        <div class="form-group">
            <label for="InputLastName">
                Фамилия :
            </label>
            <input type="text" name="lastName" class="form-control bg-dark w-25 text-light" id="InputLastName"/>
        </div>
        <div class="form-group">
            <label for="InputNumber">
                Телефон :
            </label>
            <input type="number" name="number" class="form-control bg-dark w-25 text-light" id="InputNumber"/>
        </div>
        <div><input type="submit" value="Зарегистрироваться" class="btn btn-primary btn-dark"/></div>
    </form>
</@c.html>