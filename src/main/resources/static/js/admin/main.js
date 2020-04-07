
$(function(){
    var vue = new Vue({
        el: '#main',
        data: {
            uri:'InputApply/mainInputApply',
            lastWeekInput:[],
            lastWeekInputPages:[],
            lastWeekInputNum :'0',

            totalInput: [],
            totalInputPages:[],
            totalInputNum :'0',
        },
        mounted:function(){
            this.list(1);
        },
        methods: {
            list:function(pageNo){
                var url =  this.uri + "?pageNo="+pageNo;
                axios.get(url).then(function(response) {
                    vue.lastWeekInputNum = response.data.inputApplyList.lastWeekInputNum;
                    vue.lastWeekInputPages =response.data.inputApplyList.lastWeekInput;

                    vue.totalInputNum = response.data.inputApplyList.totalInputNum;
                    vue.totalInputPages = response.data.inputApplyList.totalInputPages;
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

var myChart = echarts.init(document.getElementById('larry-seo-stats'));
option = {
    title : {
        text: '各地库存',
/*
        subtext: '纯属虚构',
*/
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient: 'vertical',
        left: 'left',
        data: ['广东','浙江','四川','北京','上海']
    },
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'广东'},
                {value:310, name:'浙江'},
                {value:234, name:'四川'},
                {value:135, name:'北京'},
                {value:1548, name:'上海'}
            ],
            itemStyle: {
                emphasis: {
                    shadowBlur: 10,
                    shadowOffsetX: 0,
                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                }
            }
        }
    ]
};
myChart.setOption(option);
