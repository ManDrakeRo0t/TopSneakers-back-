<#import "../parts/common.ftl" as c>

<@c.html>

    <@c.header>

    </@c.header>

    <div class="container my-content" >
        <h4>Войдите</h4>
        <form action="/login" method="post">
            <div class="form-group">
                <label for="exampleInputEmail1">
                    Почта :
                </label>
                <input name="username" type="email" class="form-control w-25 text-light" id="exampleInputEmail1" aria-describedby="emailHelp"/>
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">
                    Пароль :
                </label>
                <input type="password" name="password" class="form-control  w-25" id="exampleInputPassword1"/>
            </div>
            <div><input type="submit" value="Войти" class="btn btn-primary"/></div>
        </form>
        <h5>Впервые у нас?</h5>
        <a href="/registration"><p>Зарегистрироваться</p></a>
    </div>
    <@c.footer>

    </@c.footer>

</@c.html>