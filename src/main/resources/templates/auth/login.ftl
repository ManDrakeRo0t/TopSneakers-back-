<#import "../parts/common.ftl" as c>

<@c.html>
    <form action="/login" method="post">
        <div class="form-group">
            <label for="exampleInputEmail1">
                Почта :
            </label>
            <input name="username" type="email" class="form-control bg-dark w-25 text-light" id="exampleInputEmail1" aria-describedby="emailHelp"/>
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">
                Пароль :
            </label>
            <input type="password" name="password" class="form-control bg-dark w-25 text-light" id="exampleInputPassword1"/>
        </div>
        <div><input type="submit" value="Войти" class="btn btn-primary btn-dark"/></div>
    </form>
    <a href="/registration"><p>Зарегистрироваться</p></a>
</@c.html>