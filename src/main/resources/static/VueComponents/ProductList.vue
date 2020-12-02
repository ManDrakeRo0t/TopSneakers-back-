<template>
    <div>
        <div v-for="product in products" v-bind="product.id"><Product
            :id = product.id
            :attributes-values = product.attributesValues
            :brand-name="product.brandName"
            :count="product.count"
            :name="product.name"
            :pictures="product.pictures"
            :price="product.price"
            :sale="product.sale"
            :status="product.status"
            :creation-date="product.creationDate"
            :product-type="product.productType"
        ></Product>
        </div>
    </div>
</template>

<script>
   import Product from "./Product.vue";

    export default {
        name: "ProductList",
        components: {Product },
        props : {
            products : []
        },
        methods : {
            getProducts(){
                this.$http.get("http://localhost:8082/api/product").then(r => this.products = r.data )
            }
        },
        created : function () {
            this.getProducts();
        }
    }
</script>

<style scoped>

</style>