<template>
    <div>
        <h4>Ваша корзина на сумму {{sum}}₽  <a v-if="basketItems.length !== 0" href="/order">Перейти к оформлению заказа <i style="color: #097bfd" class="fas fa-money-bill-wave"></i></a></h4>
        <p v-if="basketItems.length === 0">Корзина пуста</p>

        <div class="d-flex flex-row flex-nowrap overflow-auto">

                <div class="col-4" v-for="(item,index) in basketItems" v-bind="index">
                    <basketItem :product-type="item.product.productType"
                                :sale="item.product.sale"
                                :brand-name="item.product.brandName.name"
                                :count="item.count"
                                :max-count="item.product.count"
                                :price="item.product.price"
                                :name="item.product.name"
                                :pictures="item.product.pictures.pictures"
                                :id="item.product.id"
                                v-on:update="sumPrice()"
                    >
                    </basketItem>
                </div>

        </div>

    </div>


</template>

<script>
    import BasketItem from "./BasketItem.vue";
    export default {
        name: "Basket",
        components: {BasketItem},
        data() {
            return {
                basketItems : null,
                username : String,
                sum : 0,
            }
        },
        methods : {
            sumPrice(){
                this.$http.get("http://localhost:8082/api/basket/total-price/" + this.username).then(r => this.sum = r.data)
            },
            loadBasket(){
                this.basketItems = [];
                this.$http.get("http://localhost:8082/user/principal")
                    .then(r =>{
                        this.username = r.data.username;
                        this.$http.get("http://localhost:8082/api/basket/" + this.username)
                            .then(r => this.basketItems = r.data);
                    })
            },
        },
        created : function () {
            this.loadBasket();
        },
    }
</script>

<style scoped>

</style>