import Vue from 'vue'
import Axios from 'axios'
import BootstrapVue from "bootstrap-vue";
import BrandComponent from "./VueComponents/BrandComponent.vue";
import Attribute from  "./VueComponents/Attribute.vue";
import Basket from "./VueComponents/Basket.vue"
import CityComponent from "./VueComponents/CityComponent.vue"
import BasketCount from "./VueComponents/BasketCount.vue";
import Map from "./VueComponents/Map.vue";
import Chart from "./VueComponents/Chart.vue";
import ChartBrands from "./VueComponents/ChartBrands.vue";
import ChartMoney from "./VueComponents/ChartMoney.vue";
Vue.prototype.$http = Axios;
Vue.use(BootstrapVue);
new Vue({
    render : h => h(ChartMoney)
}).$mount('#chart3')

new Vue({
    render : h => h(Chart)
}).$mount('#chart1')

new Vue({
    render : h => h(ChartBrands)
}).$mount('#chart2')

new Vue({
    render : h => h(BasketCount)
}).$mount('#basketCount')

new Vue({
    render : h => h(Map)
}).$mount('#VueMap')

new Vue({
    render : h => h(BrandComponent)
}).$mount('#brandsComp')

new Vue({
    render : h => h(Attribute)
}).$mount('#attribute')

new Vue({
    render : h => h(Basket)
}).$mount("#basket")

new Vue({
    render : h => h(CityComponent)
}).$mount("#cityComp")

