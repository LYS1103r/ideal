<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">

    <!-- 如果IE版本小于9，加载以下js,解决低版本兼容问题 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="${pageContext.request.contextPath}/js/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script>
        function brfore() {
            location.href="${pageContext.request.contextPath}/index/login";
        }
        function behind() {
            location.href="${pageContext.request.contextPath}/admin/showAdmin";
        }
    </script>

</head>
<body>
<form>
    <div style="margin-top: 10%;">

        <img src="${pageContext.request.contextPath}/images/logoT.png" class="img-responsive center-block" style="width: 20%" alt="Responsive image">


        <div class="container" style="margin-top: 10px;">



            <div class="row">
                <div class="col-md-4"></div>
                <div class="form-group col-md-4">
                    <span id="msg" style="color:darkred"></span>
                </div>
                <div class="col-md-4"></div>

            </div>


        </div>


        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                &nbsp;&nbsp;&nbsp;&nbsp;<button id="loginBtn" type="button" class="btn btn-success center-block"
                                                style="width:80%;" onclick="behind()"> 管理端
            </button>
            </div>
            <div class="col-md-4"></div>

        </div>
        <div class="row">
            <div class="col-md-4"></div>
            <div class="col-md-4">
                &nbsp;&nbsp;&nbsp;&nbsp;<button  type="button" class="btn btn-success center-block"
                                                style="width:80%;" onclick="brfore()"> 客户端
            </button>
            </div>
            <div class="col-md-4"></div>

        </div>


    </div>
</form>


</body>
</html>
