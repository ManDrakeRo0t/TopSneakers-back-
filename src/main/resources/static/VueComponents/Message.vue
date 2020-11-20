<template>
    <div>
        <input type="text" v-model="text"/>
        <button type="button" @click="deleteMessage">Удалить</button>
        <button type="button" @click="editMessage">Изменить</button>
    </div>
</template>

<script>
    export default {
        name: "Message",
        props : {
            id : Number,
            text : String
        },
        methods : {
            deleteMessage(){
                this.$http.delete('http://localhost:8082/message/'+this.id).then(() => this.$parent.loadMessages())
            },
            editMessage(){
                this.$http.put('http://localhost:8082/message/'+this.id,this.text,{
                    headers : {
                        'Content-Type' : 'application/json;charset=UTF-8'
                    }})
            },
        }
    }
</script>

<style scoped>

</style>