<template>
    <l-map style="height: 400px" :zoom="zoom" :center="center">
        <l-tile-layer :url="url"></l-tile-layer>
        <l-marker v-for="punct in puncts" :lat-lng="punct.coords" >
            <l-popup>{{punct.address}}</l-popup>
        </l-marker>
    </l-map>
</template>

<script>
    import {LMap, LTileLayer, LMarker, LPopup} from 'vue2-leaflet';

    export default {
        name: "Map",
        components: {
            LMap,
            LTileLayer,
            LMarker,
            LPopup
        },
        data () {
            return {
                url: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
                zoom: 8,
                center: [51.543874174138836, 46.01166856074947],
                markerLatLng: [51.59751580824492, 45.91600274367761],
                puncts : []
            };
        },
        created : function () {
            this.loadMap()
        },
        methods : {
            loadMap(){
                this.$http.get("http://localhost:8082/api/city/puncts").then(r =>
                    this.puncts = r.data
                )
            }
        }
    }
</script>

<style scoped>

</style>