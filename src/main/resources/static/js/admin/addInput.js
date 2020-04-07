//axios.defaults.withCredentials = true
$(function () {
    var vue = new Vue({
        el: '#addInput',
        data: {
            inputURL: 'InputApply/listInputApply',
            uri: 'Sneakers/listSneakers',
            listApplyUserURL:'listApplyUser',
            sneaker: {
                sneakersId: 0
            },
            sneakers: [],
            inputApplies: [],
            listApplyUsers:[],
            InputApply: {
                sneakersId: 0,
                color: '',
                size: '',
                num: 1,
                numUnit: '',
                price: 1.0,
                totalPrice: 0.0,
                netWeight: 0.0,
                invoiceNumber: '',
                applicantId: 0,
                supplierId: 0,
                position: '',
                status: ''
            }
        },
        computed:{
            totalPrice:function() {
                return  this.InputApply.num * this.InputApply.price;
            },
        },
        mounted: function () {
            this.listSneakers(999);
            this.listApplyUser();
        }
        ,
        methods: {
            listSneakers: function (pageNo) {
                var url = this.uri + "?pageNo=" + pageNo;
                axios.get(url).then(function (response) {
                    vue.sneakers = response.data.sneakersList;
                });
            },
            listApplyUser:function(){
                var url = this.listApplyUserURL;
                axios.get(url).then(function (response) {
                    vue.listApplyUsers = response.data.date;
                });
            },

            jump: function (page) {
                jumpPage(page, vue);
            },
            jumpByNumber: function (start) {
                jumpNum(start, vue);
            },
            deleteInput: function (id) {
                var url = this.uri + "/" + id;
                axios.delete(url).then(function (response) {
                    if (0 != response.data.length) {
                        alert(response.data);
                    } else {
                        vue.list(1);
                    }
                });
            },

        }
    });

    layui.use('form', function () {

        var form = layui.form;

        var url = vue.inputURL;
        //监听提交
        form.on('submit(formDemo)', function (data) {
            let datas =data.field;
            axios({
                headers: {
                    'Content-Type': 'application/json;'
                },
                method: 'post',
                transformRequest: [function (data) {
                    // 对 data 进行任意转换处理
                    return JSON.stringify(datas)
                }],
                url: url,
                params: datas
            }).then(function(res){
                    if (res.data.code == 0){
                        alert("申请成功");
                        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        parent.layer.close(index); //再执行关闭

                      //  location.origin="/sneakerWarehouse/inputApply";
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
        });

        form.render('select')
    });

});