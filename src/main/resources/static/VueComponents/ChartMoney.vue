<template>
    <div>
        <h4 class="text-center">Статистика дохода</h4>
        От <input type="date" v-model="from">
        До <input type="date" v-model="to">
        <button @click="update">Получить</button>
        <canvas style="width: 100% " ref="canvas"></canvas>
    </div>
</template>

<script>
    import {Line} from 'vue-chartjs';
    export default {
        name: "ChartMoney",
        extends: Line,
        data() {
            return {
                from : '',
                to : '',
                data : null
            }
        },
        methods : {
            update(){
                this.$http.get("http://localhost:8082/api/stat/money/"+this.from+":"+this.to).then(r => {
                    this.data = r.data;
                    this.renderChart({
                        labels: this.data.labels,
                        datasets: [{
                            label: 'Выручка',
                            backgroundColor: '#e839f8',
                            pointBackgroundColor: 'white',
                            borderWidth: 1,
                            pointBorderColor: '#249EBF',
                            data: this.data.datasets.data,
                        }]
                    }, {
                        scales: {
                            yAxes: [{
                                ticks: {
                                    beginAtZero: true
                                },
                                gridLines: {
                                    display: true
                                }
                            }],
                            xAxes: [ {
                                gridLines: {
                                    display: false
                                }
                            }]
                        },
                        legend: {
                            display: true
                        },
                        responsive: true,
                        maintainAspectRatio: false
                    })

                })
            }
        }
    }
</script>

<style scoped>

</style>