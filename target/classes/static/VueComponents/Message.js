import Vue from 'vue'


export default Vue.component("message",{
    template : '<div>\n' +
        '        <input type="text" v-model="text"/>\n' +
        '        <button type="button" @click="deleteMessage">Удалить</button>\n' +
        '        <button type="button" @click="editMessage">Изменить</button>\n' +
        '    </div>',

    props : {
        id : Number,
        text : String
    },
    comments : {

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
})

