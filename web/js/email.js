// $(function () {
//     $("#email_id").keyup(function () {
//         const email = $(this).val();
//         $.post("/pet/EmailServlet", {email: email}, function (data) {
//             const email = $("#ajax");
//             email.html(data);
//             if (data === '验证通过') {
//                 email.css("color", "green");
//             } else {
//                 email.css("color", "red");
//             }
//         }, "json");
//     })
// });

// document.getElementById("email_id").onkeypress(
//     function () {
//         //1.创建XMLHttpRequest对象
//         var xhr;
//         if (window.XMLHttpRequest) {
//             xhr = new XMLHttpRequest();
//         } else {
//             xhr = ActiveXObject("Microsoft.XMLHTTP");
//         }
//
//         //2.设置回调函数
//         xhr.onreadystatechange = callback;
//
//         //3.使用open方法与服务器建立连接
//         xhr.open("post", "/pet/EmailServlet", true);
//         xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//
//         //4.向服务器发送数据
//         var email = document.getElementById("email_id").value;
//         xhr.send("email=" + email);
//
//         // 5.在回调函数中针对不同的响应状态进行处理
//         function callback() {
//             //判断异步对象的状态
//             if (xhr.readyState == 4) {
//                 //判断交互是否成功
//                 if (xhr.status == 200) {
//                     //获得服务器响应的数据
//                     var res = xhr.responseText;
//                     //处理数据
//                     var agax = document.getElementById("ajax");
//                     agax.innerText = res;
//                 }
//             }
//         }
//     });
$(function () {
    $("#email_id").keyup(function () {
        const email = $("#email_id").val();
        $.ajax({
            url: "/pet/EmailServlet",
            data: "email=" + email,
            datatype: "json",//请求页面返回的数据类型
            type: "POST",
            // contentType: "application/json",//注意请求页面的contentType 要于此处保持一致
            success: function (data) {//这里的data是由请求页面返回的数据
                const dataJson = JSON.parse(data);
                $("#ajax").html(dataJson.info);
                if(dataJson.flag === true ){
                    $("#ajax").css("color","green");
                }else{
                    $("#ajax").css("color","red");
                }
            }, error: function (XMLHttpRequest, textStatus, errorThrown) {
                $("#show").html("error");
            }
        })
    });
});