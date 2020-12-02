import Vue from 'vue'
import Axios from 'axios'
import App from './VueComponents/App.vue'
import MessageList from "MessageList.vue";
import BootstrapVue from "bootstrap-vue";
import Authentication from "./VueComponents/Authentication.vue";
import BrandComponent from "./VueComponents/BrandComponent.vue";
import Attribute from  "./VueComponents/Attribute.vue";


Vue.prototype.$http = Axios;
Vue.use(BootstrapVue);

new Vue({
    render : h => h(App)
}).$mount('#app')

new Vue({
    render : h => h(MessageList)
}).$mount('#a')

// new Vue({
//     render : h => h(Authentication)
// }).$mount('#auth')

new Vue({
    render : h => h(BrandComponent)
}).$mount('#brandsComp')

new Vue({
    render : h => h(Attribute)
}).$mount('#attribute')

