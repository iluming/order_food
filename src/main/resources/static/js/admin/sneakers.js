$(function(){
    var vue = new Vue({
        el: '#sneakers',
        data: {
            uri:'Sneakers/listSneakers',
            sneakers: [],
            pages:[]
        },
        mounted:function(){
            this.list(1);
        },
        methods: {
            list:function(pageNo){
                var url =  this.uri + "?pageNo="+pageNo;
                axios.get(url).then(function(response) {
                    vue.sneakers = response.data.listSneakers;
                    vue.pages =  response.data.sneakersPageInfo;
                });
            },
            jump: function(page){
                jumpPage(page,vue);
            },
            jumpByNumber: function(start){
                jumpNum(start,vue);
            }

        }
    });



});

