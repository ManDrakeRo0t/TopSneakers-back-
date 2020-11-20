import Vue from 'vue'
import Axios from 'axios'
import App from './VueComponents/App.vue'
import MessageList from "MessageList.vue";


Vue.prototype.$http = Axios;


new Vue({
    render : h => h(App)
}).$mount('#app')

new Vue({
    render : h => h(MessageList)
}).$mount('#a')

