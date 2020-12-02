<template>
    <div>
        <ul>
            <li v-for="msg in messages" v-bind:key="msg.id"><Message :id="msg.id"  :text="msg.text"/></li>
        </ul>
        <label>
            <input type="text" v-model="text">
        </label>
        <button type="button" @click="addNewMessage">Добавить</button>
        <button type="button" @click="loadMessages">обновить сообщения</button>
    </div>
</template>

<script>
    import Message from "./Message.vue";

    export default {
        name: "MessageList",
        components: {Message},
        data() {
            return {
                text : '',
                messages : null
            }
        },
        methods : {
            addNewMessage(){
                this.$http.post("http://localhost:8082/message",this.text,{
                    headers : {
                        'Content-Type' : 'application/json;charset=UTF-8'
                    }
                }).then(() => this.loadMessages())

            },
            loadMessages(){ //todo filter)
                this.$http.get("http://localhost:8082/message").then(r => {
                    if(true) {this.messages = r.data}
                });
                this.text = ''
            }
        }
    }
</script>

<style scoped>

</style>