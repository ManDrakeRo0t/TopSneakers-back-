const path = require('path');
const VueLoaderPlugin = require('vue-loader/lib/plugin');


module.exports = {
    mode: 'development',
    devtool: 'source-map',
    entry: path.join(__dirname, 'src', 'main', 'resources', 'static', 'index.js'),
    devServer: {
        contentBase: './dist',
        compress: true,
        port: 8001,
        allowedHosts: [
            'localhost:8082'
        ]
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.css$/,
                use: [
                    'vue-style-loader',
                    'css-loader'
                ]
            }
        ]
    },
    plugins: [
        new VueLoaderPlugin()
    ],
    resolve: {
        alias: {
            vue: 'vue/dist/vue.js'
        },
        modules: [
            path.join(__dirname, 'src', 'main', 'resources', 'static'),
            path.join(__dirname, 'src', 'main', 'resources', 'static','VueComponents'),
            path.join(__dirname, 'node_modules'),
        ],
    }
}