<template>
    <div>
        <ul>
            <li v-for="brand in brands" v-bind:key="brand.id">{{brand.name}}</li>
        </ul>
        <label>
            <input type="text" v-model="name">
        </label>
        <button type="button" class="btn btn-primary" @click="addBrand">Добавить бренд</button>
    </div>
</template>

<script>
    export default {
        name: "BrandComponent",
        props : {
            name : String ,
            brands : null
        },
        methods : {
            getBrands(){
                this.$http.get("http://localhost:8082/api/brands").then(r => this.brands = r.data)

            },
            addBrand(){
                    this.$http.post("http://localhost:8082/api/brands",this.name,{
                        headers : {
                            'Content-Type' : 'application/json;charset=UTF-8'
                        }
                    }).then( () => this.getBrands())
                this.name = ''
            }
        },
        created : function () {
            this.getBrands();
        }
    }
</script>

<style scoped>

</style>