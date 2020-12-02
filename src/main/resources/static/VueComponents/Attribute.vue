<template>
    <div>
        <div class="form-group" v-for="(input,k) in inputs" :key="k" >
            <input type="text" class="form-control" v-model="input.name">
            <input type="text" class="form-control" v-model="input.value">
            <span>
                <i class="fas fa-minus-circle" @click="remove(k)" v-show="k || ( !k && inputs.length > 1)">Удалить</i>
                <i class="fas fa-plus-circle" @click="add(k)" v-show="k === inputs.length-1">Добавить поле</i>
            </span>
        </div>
        <button @click="addAttributes">Обновить</button>
    </div>
</template>

<script>
    export default {
        name: "Attribute",
        data() {
            return {
                inputs: [{
                    name: '',
                    value: ''
                }]
            }
        },
        props : {
            productId : String
        },
        created : function(){
            this.productId = window.location.href.split('edit/')[1];
            this.loadAttributes();
        },
        methods : {
            addNotNull(name,value){
                this.inputs.push({
                    name : name,
                    value : value
                });
            },
            add(){
                this.inputs.push({
                    name : '',
                    value : ''
                });
                console.log(this.inputs)
            },
            remove (index) {
                this.inputs.splice(index,1)
            },

            addAttributes(){
                this.$http.post('http://localhost:8082/api/attribute/'+this.productId,{
                    attributes : JSON.stringify(this.inputs)
                },{
                    headers : {
                        'Content-Type' : 'application/json;charset=UTF-8'
                    }
                }).then( () => {
                    this.loadAttributes()
                })
            },

            loadAttributes(){
                this.$http.get("http://localhost:8082/api/attribute/"+this.productId).then(r => {if(r.data.length !== 0){
                    this.inputs.splice(0,this.inputs.length)
                    for(let i = 0;i < r.data.length;i++){
                        let name = r.data[i].attribute.name;
                        let value = r.data[i].stringValue;
                        this.addNotNull(name,value)
                    }
                }
                })
            }
        }

    }
</script>

<style scoped>

</style>