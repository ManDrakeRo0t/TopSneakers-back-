<#import "../parts/common.ftl" as c>

<@c.html>

    <@c.header>

    </@c.header>



        <div class="my-content">
            <div class="container">
                <#if msg?has_content>
                    ${msg}
                </#if>
                <form action="/registration" method="post" id="RegForm">
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="InputEmail">
<#--                                Почта :-->
                            </label>
                            <input name="username" type="email" class="form-control w-50 " id="InputEmail" aria-describedby="emailHelp" placeholder="Почта"/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="InputPassword">
<#--                                Пароль :-->
                            </label>
                            <input type="password" name="password" class="form-control  w-50 " id="InputPassword" placeholder="Пароль"/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="InputFirstName">
<#--                                Имя :-->
                            </label>
                            <input type="text" name="firstName" class="form-control w-50 " id="InputFirstName" placeholder="Имя"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="form-group">
                            <label for="InputLastName">
<#--                                Фамилия :-->
                            </label>
                            <input type="text" name="lastName" class="form-control w-50 " id="InputLastName" placeholder="Фамилия"/>
                        </div>
                    </div>
                    <div class="col">
                        <div class="form-group">
                            <label for="InputPassword2">
                                <#--                                Пароль :-->
                            </label>
                            <input type="password" name="pass2" class="form-control  w-50 " id="InputPassword2" placeholder="Повторите пароль"/>
                        </div>
                    </div>

                    <div class="col">
                        <div class="form-group">
                            <label for="InputNumber">
<#--                                Телефон :-->
                            </label>
                            <input type="number" name="number" class="form-control  w-50 " id="InputNumber" placeholder="Телефон"/>
                        </div>
                    </div>
                </div><div><input type="submit" value="Зарегистрироваться" class="btn btn-primary " id="sendForm"/></div>
                </form>
            </div>
            <script>
                let sendForm = document.querySelector('#sendForm');
                sendForm.onclick = function (event) {
                    event.preventDefault();

                    let form = document.querySelector('#RegForm');

                    let counter = 0;
                    for(let i = form.elements.length - 1;i>= 0;i--){
                        //console.log(form.elements[i]);
                        if(form.elements[i].type === 'submit' || form.elements[i].type === 'hidden'){
                            continue;
                        }
                        if(form.elements[i].name === 'username') {
                            let mail = form.elements[i].value;
                            let parts = mail.split("@");
                            if (parts.length === 2 && parts[0].length !== 0 && parts[1].length !== 0 && parts[1].includes(".") && parts[1].charAt(parts[1].length - 1) !== ".") counter++
                        }else if(form.elements[i].name === 'number'){
                                let number = form.elements[i].value;
                                if(number.length === 11 ) counter++

                        }else{
                            if(form.elements[i].value.length !== 0 && form.elements[i].value !== " ") counter++
                        }

                    }
                    console.log(counter)
                    if(counter === 6) form.submit();
                    else alert("Заполните форму корректно");
                };
            </script>
        </div>


    <@c.footer>

    </@c.footer>

</@c.html>