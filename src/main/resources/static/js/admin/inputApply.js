axios.defaults.withCredentials = true
$(function(){
    var vue = new Vue({
        el: '#inputApply',
        data: {
            uri:'InputApply/listInputApply',
            inputApplies: [],
            pages:[],
        },
        mounted:function(){
            this.list(1);
        },
        methods: {
            list:function(pageNo){
                var url =  this.uri + "?pageNo="+pageNo+"&code="+1;
                axios.get(url).then(function(response) {
                    vue.inputApplies = response.data.date.inputApplyPageInfo.list;
                    vue.pages =  response.data.date.inputApplyPageInfo;
                });
            },
            jump: function(page){
                jumpPage(page,vue);
            },
            jumpByNumber: function(start){
                jumpNum(start,vue);
            },
            deleteInput:function (id) {
                var url = this.uri+"/"+id;
                axios.delete(url).then(function(response){
                    if(0!=response.data.length){
                        alert(response.data);
                    }
                    else{
                        vue.list(1);
                    }
                });
            }


        }
    });


});