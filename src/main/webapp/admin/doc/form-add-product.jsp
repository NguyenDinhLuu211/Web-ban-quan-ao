<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Thêm sản phẩm | Quản trị Admin</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
    <!-- or -->
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
    <link rel="stylesheet" type="text/css"
          href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
    <script src="http://code.jquery.com/jquery.min.js" type="text/javascript"></script>
    <script>
        function readURL(input, thumbimage) {
            if (input.files && input.files[0]) { //Sử dụng  cho Firefox - chrome
                var reader = new FileReader();
                reader.onload = function (e) {
                    $("#thumbimage").attr('src', e.target.result);
                }
                reader.readAsDataURL(input.files[0]);
            } else { // Sử dụng cho IE
                $("#thumbimage").attr('src', input.value);

            }
            $("#thumbimage").show();
            $('.filename').text($("#uploadfile").val());
            $('.Choicefile').css('background', '#14142B');
            $('.Choicefile').css('cursor', 'default');
            $(".removeimg").show();
            $(".Choicefile").unbind('click');

        }

        $(document).ready(function () {
            $(".Choicefile").bind('click', function () {
                $("#uploadfile").click();

            });
            $(".removeimg").click(function () {
                $("#thumbimage").attr('src', '').hide();
                $("#myfileupload").html('<input type="file" id="uploadfile"  onchange="readURL(this);" />');
                $(".removeimg").hide();
                $(".Choicefile").bind('click', function () {
                    $("#uploadfile").click();
                });
                $('.Choicefile').css('background', '#14142B');
                $('.Choicefile').css('cursor', 'pointer');
                $(".filename").text("");
            });
        })

        // 5. Kiem tra du lieu
        function validateForm(event) {
            const form = document.querySelector('form');
            const inputs = form.querySelectorAll('input[required], select[required], textarea[required]');
            let isValid = true;

            inputs.forEach(input => {
                if (!input.value.trim()) {
                    isValid = false;
                    // 5.1 Thong Bao loi
                    alert(`Please fill in the ${input.name} field.`);
                    input.focus();
                    return false; // Break out of the forEach loop
                }
            });

            if (!isValid) {
                event.preventDefault();
            }
        }
    </script>
</head>

<body class="app sidebar-mini rtl">
<style>
    .Choicefile {
        display: block;
        background: #14142B;
        border: 1px solid #fff;
        color: #fff;
        width: 150px;
        text-align: center;
        text-decoration: none;
        cursor: pointer;
        padding: 5px 0px;
        border-radius: 5px;
        font-weight: 500;
        align-items: center;
        justify-content: center;
    }

    .Choicefile:hover {
        text-decoration: none;
        color: white;
    }

    #uploadfile,
    .removeimg {
        display: none;
    }

    #thumbbox {
        position: relative;
        width: 100%;
        margin-bottom: 20px;
    }

    .removeimg {
        height: 25px;
        position: absolute;
        background-repeat: no-repeat;
        top: 5px;
        left: 5px;
        background-size: 25px;
        width: 25px;
        /* border: 3px solid red; */
        border-radius: 50%;

    }

    .removeimg::before {
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
        content: '';
        border: 1px solid red;
        background: red;
        text-align: center;
        display: block;
        margin-top: 11px;
        transform: rotate(45deg);
    }

    .removeimg::after {
        /* color: #FFF; */
        /* background-color: #DC403B; */
        content: '';
        background: red;
        border: 1px solid red;
        text-align: center;
        display: block;
        transform: rotate(-45deg);
        margin-top: -2px;
    }
</style>
<!-- Navbar-->
<header class="app-header">
    <!-- Sidebar toggle button--><a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
                                    aria-label="Hide Sidebar"></a>
    <!-- Navbar Right Menu-->
    <ul class="app-nav">


        <!-- User Menu-->
        <li><a class="app-nav__item" href="/login.html"><i class='bx bx-log-out bx-rotate-180'></i> </a></li>
    </ul>
</header>
<!-- Sidebar menu-->
<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="../images/hay.jpg" width="50px"
                                        alt="User Image">
        <div>
            <p class="app-sidebar__user-name"><b>Nguyễn Vĩ Khang</b></p>
            <p class="app-sidebar__user-designation">Chào mừng bạn trở lại</p>
        </div>
    </div>
    <hr>
    <ul class="app-menu">
        <li><a class="app-menu__item " href="index-admin.html"><i class='app-menu__icon bx bx-tachometer'></i><span
                class="app-menu__label">Bảng điều khiển</span></a></li>
        <li><a class="app-menu__item " href="table-data-table.html"><i class='app-menu__icon bx bx-id-card'></i>
            <span class="app-menu__label">Quản lý nhân viên</span></a></li>
        <li><a class="app-menu__item active" href="table-data-product.jsp"><i
                class='app-menu__icon bx bx-purchase-tag-alt'></i><span class="app-menu__label">Quản lý sản phẩm</span></a>
        </li>
        <li><a class="app-menu__item" href="table-data-oder.html"><i class='app-menu__icon bx bx-task'></i><span
                class="app-menu__label">Quản lý đơn hàng</span></a></li>
        <li><a class="app-menu__item" href="table-data-banned.html"><i class='app-menu__icon bx bx-run'></i><span
                class="app-menu__label">Quản lý nội bộ
          </span></a></li>
        <li><a class="app-menu__item" href="table-data-money.html"><i class='app-menu__icon bx bx-dollar'></i><span
                class="app-menu__label">Bảng kê lương</span></a></li>
        <li><a class="app-menu__item" href="quan-ly-bao-cao.html"><i
                class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>
        </li>
    </ul>
</aside>
<main class="app-content">
    <div class="app-title">
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item">Danh sách sản phẩm</li>
            <li class="breadcrumb-item"><a href="#">Thêm sản phẩm</a></li>
        </ul>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="tile">

                <h3 class="tile-title">Tạo mới sản phẩm</h3>
                <div class="tile-body">
                    <div class="row element-button">
                    </div>
                    <%--Goi toi controller--%>
                    <form class="row" method="post" action="AddProductController">
                        <%--Nhap du lieu--%>
                        <div class="form-group col-md-3">
                            <label class="control-label">Tên Sản Phẩm</label>
                            <input class="form-control" type="text" placeholder="" name="name" required>
                        </div>

                        <div class="form-group col-md-3 ">
                            <label for="exampleSelect1" class="control-label">Danh Mục</label>
                            <select class="form-control" id="exampleSelect1" name="category" required>
                                <option value="1">T-Shirt</option>
                                <option value="2">Baby-Tee</option>
                                <option value="3">Polo</option>
                                <option value="4">Dress-Shirt</option>
                                <option value="5">Jecket</option>
                                <option value="6">Hoodie</option>
                                <option value="7">pants</option>
                                <option value="8">woman-pants</option>
                            </select>
                        </div>

                        <div class="form-group col-md-3 ">
                            <label for="exampleSelect1" class="control-label">Màu Sắc</label>
                            <select class="form-control" id="exampleSelect1" name="color" required>
                                <option value="1">Đen</option>
                                <option value="2">Ghi</option>
                                <option value="3">Xanh ve chai</option>
                                <option value="4">Trắng</option>
                                <option value="5">Be</option>
                                <option value="6">Xám khói</option>
                                <option value="7">Nâu</option>
                                <option value="8">Xám chì</option>
                                <option value="9">Xanh rêu</option>
                            </select>
                        </div>

                        <div class="form-group col-md-3 ">
                            <label for="exampleSelect1" class="control-label">Kích Cỡ</label>
                            <select class="form-control" id="exampleSelect1" name="size" required>
                                <option value="1">M</option>
                                <option value="2">L</option>
                                <option value="3">XL</option>
                            </select>
                        </div>

                        <div class="form-group  col-md-3">
                            <label class="control-label">Số lượng</label>
                            <input class="form-control" type="number" name="quantity" required>
                        </div>

                        <div class="form-group col-md-3">
                            <label class="control-label">Giá bán</label>
                            <input class="form-control" type="text" name="price" required>
                        </div>

                        <div class="form-group col-md-12">
                            <label class="control-label">Ảnh sản phẩm</label>
                            <div id="myfileupload">
                                <input type="file" id="uploadfile" name="ImageUpload" onchange="readURL(this);"
                                       required/>
                            </div>
                            <div id="thumbbox">
                                <img height="450" width="400" alt="Thumb image" id="thumbimage" style="display: none"/>
                                <a class="removeimg" href="javascript:"></a>
                            </div>
                            <div id="boxchoice">
                                <a href="javascript:" class="Choicefile"><i class="fas fa-cloud-upload-alt"></i> Chọn
                                    ảnh</a>
                                <p style="clear:both"></p>
                            </div>

                        </div>
                        <div class="form-group col-md-12">
                            <label class="control-label">Mô tả sản phẩm</label>
                            <textarea class="form-control" name="mota" id="mota"></textarea>
                            <script>
                                CKEDITOR.replace('mota');
                            </script>
                        </div>
                        <%--Chon nut "Luu lai"--%>
                        <input class="btn btn-save" type="submit" value="Lưu lại"/>
                        <a class="btn btn-cancel" href="table-data-product.jsp">Hủy bỏ</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>


<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>
<script src="js/plugins/pace.min.js"></script>
<script>
    const inpFile = document.getElementById("inpFile");
    const loadFile = document.getElementById("loadFile");
    // const previewContainer = document.getElementById("imagePreview");
    // const previewContainer = document.getElementById("imagePreview");
    const previewImage = previewContainer.querySelector(".image-preview__image");
    const previewDefaultText = previewContainer.querySelector(".image-preview__default-text");
    inpFile.addEventListener("change", function () {
        const file = this.files[0];
        if (file) {
            const reader = new FileReader();
            previewDefaultText.style.display = "none";
            previewImage.style.display = "block";
            reader.addEventListener("load", function () {
                previewImage.setAttribute("src", this.result);
            });
            reader.readAsDataURL(file);
        }
    });
</script>
<script>

</script>
</body>

</html>