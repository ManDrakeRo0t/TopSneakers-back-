// import Vue from 'vue'
// import Axios from 'axios'
//
// var MessageList = Vue.component( "MessageList",{
//     data : {
//         text : '',
//         messages : null
//     },
//     methods : {
//         addNewMessage(){
//             Axios.post("http://localhost:8082/message",this.text,{
//                 headers : {
//                     'Content-Type' : 'application/json;charset=UTF-8'
//                 }
//             }).then(() => this.loadMessages())
//
//         },
//         loadMessages(){
//             Axios.get("http://localhost:8082/message").then(r => this.messages = r.data)
//             this.text = ''
//         }
//     },
//     mounted() {
//         Axios.get("http://localhost:8082/message").then(r => this.messages = r.data)
//     }
//
// })
// export {MessageList}