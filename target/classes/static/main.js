

var app = new Vue({
    el: '#app',
    data: {
        message: '-'
    },
    created : function(){
        axios.get("http://localhost:8082/message").then(r => this.messages = r.data)
    }
})