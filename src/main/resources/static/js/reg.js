$(function(){
    var data4Vue = {
        uri:'register',
        result: [],
        user:{userName:'',
            telephone:'',
            sector:'',
            partition:'',
            pwd:'',
        }
    };
    //ViewModel
    var vue = new Vue({
        el: '#register',
        data: data4Vue,
        mounted:function(){
        },
        methods: {
            reg:function(){
                var url =  this.uri;
                if(0==this.user.userName.length){
                    $("span.errorMessage").html("请输入用户名");
                    //  $("div.loginErrorMessageDiv").css("visibility","visible");
                    return;
                }
                if(0==this.user.pwd.length){
                    $("span.errorMessage").html("请输入密码");
                    //   $("div.loginErrorMessageDiv").css("visibility","visible");
                    return;
                }

                axios.post(url,this.user).then(function(response) {
                    var result = response.data;
                    if(result.code==0){
                        location.href="login";
                        alert(result.date);
                    }
                    else{
                       alert(result.date);
                    }
                });
            }
        }
    });

})