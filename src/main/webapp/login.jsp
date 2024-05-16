<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--    <link rel="stylesheet" href="./css/login.css">--%>
    <title>Đăng Nhập</title>
</head>

<style>
    body {
        background: radial-gradient(circle at 100%, #333, #333 50%, #eee 75%, #333 75%);
    }

    .container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .box-login {
        width: 400px;
        /* border: 1px solid #000; */
        padding: 20px;
        text-align: center;
        border-radius: 6px;
        box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
        background-color: #fff;
    }

    .box-login .title {
        margin-bottom: 10px;
    }

    .box-login .title span {
        font-weight: bold;
        font-size: 20px;
    }

    .box-login form {
        line-height: 3;
    }

    .box-login form input[type='text'],
    .box-login form input[type='password'] {
        box-sizing: border-box;
        width: 100%;
        padding: 10px;
        border: 1px solid #cccccc;
        border-radius: 4px;
        outline: none;
    }

    .box-login form input[type='submit']{
        height: 35px;
        width: 120px;
        border-radius: 4px;
        background-color: #cccccc;
        border: 1px solid #cccccc;
        font-weight: bold;
        color: #000;
        cursor: pointer;
        transition: all .3s;
    }

    .box-login form input[type='submit']:hover{
        background-color: #fff;
    }

    .registerBtn{
        float: right;
        text-decoration: none;
        color: #000;
        transition: all .3s;
    }

    .registerBtn:hover{
        text-decoration: underline;
    }

</style>

<body>
    <div class="container">
        <div class="box-login">
            <div class="title">
                <h3>ĐĂNG NHẬP</h3>
                <p></p>
            </div>
            <form action="" class="">
                <div class="form-control">
                    <!-- <lable>Tên đăng nhập</lable> -->
                    <input type="text" name="" id="username" placeholder="Nhập username...">
                </div>
                <div class="form-control">
                    <!-- <lable>Mật khẩu</lable> -->
                    <input type="password" name="" id="password" placeholder="Nhập mật khẩu">
                </div>
                <input type="submit" value="Đăng nhập">
            </form>
            <a href="register.jsp" class="registerBtn">Đăng kí tài khoản</a>
        </div>
    </div>
</body>
</html>