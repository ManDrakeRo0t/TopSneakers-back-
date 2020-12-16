
<script>
    import { Pie } from 'vue-chartjs'
    export default {
        name: "Chart",
        extends: Pie,
        data() {
            return {
                dataSet : null
            }
        },
        methods : {
            loadData(){
                this.$http.get("http://localhost:8082/api/stat/products").then(r => {this.dataSet = r.data;
                    this.renderChart({
                        labels: this.dataSet.labels,
                        datasets: [{
                            data: this.dataSet.datasets.data,
                            backgroundColor: this.dataSet.datasets.backgroundColor,
                        }]
                    }, {
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                }
                            }]
                        }
                    })
                })
            }
        },
        created : function () {
            this.loadData();
        },
    }
</script>

<style scoped>

</style>


