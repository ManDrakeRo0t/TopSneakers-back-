<template>
    <div>
        {{count}}
    </div>
</template>

<script>
    export default {
        name: "BasketCount",
        data() {
            return {
                username : undefined,
                count: 0
            }
        },
        created : function () {
             //setInterval(() => {this.load()},2000)
        },
        methods : {
            load(){
                this.$http.get("http://localhost:8082/user/principal")
                    .then(r =>{
                        this.username = r.data.username;
                        this.$http.get("http://localhost:8082/api/basket/count/" + this.username)
                            .then(r => this.count = r.data);
                    })
            }
        }

    }
</script>

<style scoped>

</style>