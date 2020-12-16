<template>
    <div>
        <ul>
            <li v-for="brand in cities" v-bind:key="brand.id">{{brand.name}}</li>
        </ul>
        <label>
            <input type="text" v-model="name">
        </label>
        <button type="button" class="btn btn-primary" @click="addCity">Добавить город</button>
    </div>
</template>

<script>
    export default {
        name: "CityComponent",
        props : {
            name : String ,
            cities : null
        },
        methods : {
            getCities(){
                this.$http.get("http://localhost:8082/api/city").then(r => this.cities = r.data)

            },
            addCity(){
                this.$http.post("http://localhost:8082/api/city",this.name,{
                    headers : {
                        'Content-Type' : 'application/json;charset=UTF-8'
                    }
                }).then( () => this.getCities())
                this.name = ''
            }
        },
        created : function () {
            this.getCities();
        }
    }
</script>

<style scoped>

</style>