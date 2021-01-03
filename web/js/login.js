document.querySelector('.img__btn').addEventListener('click', function () {
    document.querySelector('.content').classList.toggle('s--signup')
})

// 验证注册信息
function validate() {
    var username = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var password = document.getElementById("password").value;

    var pattern = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    //验证用户名
    if (username == "") {
        alert("用户名不能为空！");
        return false;
    }
    // 验证email
    if (email == "") {
        alert("邮箱不能为空！");
        return false;
    } else if (!pattern.test(email)) {
        alert("邮箱不合法！");
        return false;
    }
    // 验证password
    if (password == "") {
        alert("密码不能为空！");
        return false;
    } else if (password.length() < 6 || password.length() > 12) {
        alert("密码长度在6-12之间");
        return false;
    }
    return true;
}