<%--
  Created by IntelliJ IDEA.
  User: vikha
  Date: 5/15/2024
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng kí tài khoản</title>
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
                <span>ĐĂNG KÍ</span>
        </div>
        <form action="RegisterController" class="">
            <div class="form-control">
                <!-- <lable>Tên đăng nhập</lable> -->
                <input type="text" name="username" id="username" placeholder="Nhập username...">
            </div>
            <div class="form-control">
                <!-- <lable>Tên đăng nhập</lable> -->
                <input type="text" name="email" id="email" placeholder="Nhập email...">
            </div>
            <div class="form-control">
                <!-- <lable>Mật khẩu</lable> -->
                <input type="password" name="password" id="password" placeholder="Nhập mật khẩu">
            </div>
<%--            <div class="form-control">--%>
<%--                <!-- <lable>Mật khẩu</lable> -->--%>
<%--                <input type="password" name="" id="re-password" placeholder="Nhập lại mật khẩu">--%>
<%--            </div>--%>
            <input type="submit" value="Đăng nhập">
        </form>
        <a href="login.jsp" class="registerBtn">Đăng nhập</a>
    </div>
</div>

</body>

</html>
