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
                var url =  this.uri + "?pageNo="+pageNo+"&code="+2;
                axios.get(url).then(function(response) {
                    vue.inputApplies = response.data.date.inputApplyPageInfo.list;
                    vue.pages =  response.data.date.inputApplyPageInfo;
                });
            },
            updateInputStatus:function(inputId){
                var url = this.uri + "/" + inputId + "?status=" + "已退回";
                axios.put(url).then(function(response){
                    if (response.data.code == 0){
                        vue.list(1);
                    }else {
                        alert(response.data.msg);
                    }
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