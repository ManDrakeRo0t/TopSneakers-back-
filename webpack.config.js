module.exports = {
    entry: './src/main/resources/static/index.js',
    output: {
        filename: "bundle.js",
        path: "/Users/danilbogatov/IdeaProjects/VueApp/src/main/resources/static"
    },
    resolve: {
        alias: {
            vue: 'vue/dist/vue.js'
        }
    }
}