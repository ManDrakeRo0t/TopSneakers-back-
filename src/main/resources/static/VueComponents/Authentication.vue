<template>
    <div>
        <p v-if="username === 'anonymousUser'">Привет, Гость</p>
        <p v-else>Привет, {{username}}</p>

        <div v-if="username === 'anonymousUser'"><a href="http://localhost:8082/login">Войти</a></div>
        <div v-else>
            <form action="http://localhost:8082/logout">
                <button type="submit">Выйти</button>
            </form>
        </div>



    </div>
</template>

<script>


    export default {
        name: "Authentication",
        props : {
            username : 'anonymousUser',
            isAdmin : false
        },
        created : function(){
            this.loadUser();
        },
        methods : {
            loadUser(){
                this.$http.get("http://localhost:8082/user/principal")
                .then(r => {
                    this.username = r.data.username;
                    this.isAdmin = r.data.active
                })
            }
        }
    }
</script>

<style scoped>

</style>