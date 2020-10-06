import message from './Message'
import Vue from 'vue'


export default Vue.component("message-list",{
    template : '<div>лист сообщений\n' +
        '        <ul>\n' +
        '            <li v-for="msg in messages" v-bind:key="msg.id"><message :id="msg.id"  :text="msg.text"/></li>\n' +
        '        </ul>\n' +
        '          <label>\n' +
        '              <input type="text" v-model="text">\n' +
        '          </label>\n' +
        '          <button type="button" @click="addNewMessage">Добавить</button>\n' +
        '          <button type="button" @click="loadMessages">обновить сообщения</button>\n' +
        '      </div>',

    data : function() {
        return{
            messages : '',
            text : ''
        }
    },
    components : {
        'message' : message
    },
    methods : {
        addNewMessage(){
            this.$http.post("http://localhost:8082/message",this.text,{
                headers : {
                    'Content-Type' : 'application/json;charset=UTF-8'
                }
            }).then(() => this.loadMessages())

        },
        loadMessages(){
            this.$http.get("http://localhost:8082/message").then(r => this.messages = r.data)
            this.text = ''
        }
    }
})

