<template>
    <div>
        <h5>{{brandName}} {{name}}</h5>
        <div class="row" >
            <div class="col" >
                <img class="image-v" v-bind:src=pictures[0].source>
            </div>
            <div class="col" >
                Цена : {{price}}₽ Скидка : {{sale}} %<br>
                На складе : {{maxCount}} шт.<br>
                В коризне : {{count}} шт.<br>
                Сумма : {{totalPrice}} <br>
                <p><input type="number" size="3" min="1" :max="maxCount" v-model="MyCount"></p>
                <p><button class="btn btn-primary btn-dark" @click="deleteItem">Удалить</button></p>
            </div>

        </div>
    </div>
</template>

<script>
    export default {
        name: "BasketItem",
        props : {
            id : Number,
            name : String,
            brandName : String,
            price : Number,
            count : Number,
            maxCount : Number,
            productType : String,
            sale : Number,
            pictures : null,

        },
        data() {
            return {
                totalPrice : Number,
                MyCount : this.count,
            }
        },
        watch : {
            MyCount : function () {
                this.$emit("update");
                if(this.MyCount  <= 0 || this.MyCount > this.MyCount) return;
                this.totalPrice = this.price / 100 * (100 - this.sale) * this.MyCount;
                this.$http.post("http://localhost:8082/api/basket",
                    {
                            username : this.$parent.username,
                            count : this.MyCount,
                            id : this.id
                    },
                    {
                        headers: {
                            'Content-Type': 'application/json;charset=UTF-8'
                        }
                    }).then(this.$emit("update"));
            },
        },
        created : function(){
            this.totalPrice = this.price / 100 * (100 - this.sale) * this.count;
            this.$emit("update")
        },
        methods : {

            deleteItem(){
                this.$parent.loadBasket();
                this.$http.post("http://localhost:8082/api/basket/delete",
                    {
                        username : this.$parent.username,
                        id : this.id
                    },
                    {
                        headers: {
                            'Content-Type': 'application/json;charset=UTF-8'
                        }
                    });

            }
        }
    }
</script>

<style scoped>

</style>