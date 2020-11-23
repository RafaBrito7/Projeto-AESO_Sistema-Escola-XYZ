// vue.config.js
module.exports = {
    "devServer":{
        "proxy": {
          "/api": {
          "target": 'https://my-target.com',
          "pathRewrite": { '^/api': '' },
          "changeOrigin": true,
          "secure": false
          }
        }
      }
  }