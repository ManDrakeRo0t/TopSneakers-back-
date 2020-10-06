import Vue from 'vue'
import Axios from 'axios'
import messageList from './VueComponents/MessageList'

Vue.prototype.$http = Axios;

var app = new Vue({
    el: '#app',
    data: function(){
        return {

        }
    },
    components : {
        'message-list' : messageList
    },
    mounted : function(){
        // Axios.get("http://localhost:8082/user").then(r => this.message = r.data)
    }
});