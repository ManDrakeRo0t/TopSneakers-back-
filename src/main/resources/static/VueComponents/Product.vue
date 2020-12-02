<template>
    <div>
        <h1 class="font-red" >{{productType}}</h1>
        <h3>{{brandName.name}} : {{name}}</h3>
        <div v-for="img in pictures.pictures">
            <img class="image" v-bind:src=img.source>
        </div>
        price - {{price}}
        count = {{count}}
        date - {{creationDate}}
        sale - {{sale}}
        status - {{status}}
        att - {{attributesValues}}
        <p class="font-red">qwerghjk,mngfn</p>
    </div>
</template>

<script>
    export default {
        name: "Product",
        props : {
            id : Number,
            name : String,
            brandName : String,
            price : Float32Array,
            count : Number,
            productType : String,
            creationDate : Date,
            sale : Number,
            attributesValues : [],
            pictures : null,
            status : Boolean,
        }
    }
</script>

<style scoped >
    .image{
        width : 100px;
    }
    .font-red{
        color: blueviolet;
    }
</style>