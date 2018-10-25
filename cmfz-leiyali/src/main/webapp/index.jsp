<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="themes/IconExtension.css">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    function toUpdate(rowData){
        $("#updateDiv").dialog("open");
    }
    $(function(){
        $("#aa").click(function(){
            $("#addDia").dialog("open");
        });
        //修改对话框
        $("#addDia").dialog({
            closed:true,
            buttons:"#updateSubmitBtn",
            width:300,
            title:"修改数据"
        });
        //修改对话框 ====END===
    })
</script>
<body><button id="aa">aa</button>
<!-- 修改对话框 -->
<div id="addDia">
    <form id="addForm" method="post" enctype="multipart/form-data">
        请选择上传的图片：<input type="file" name="img"><br>
        图片名：<input type="text" name="name"><br>
        描述：<input type="text" name="description"><br>
    </form>
</div>
<!-- 修改对话框=====END==== -->

<div id="updateSubmitBtn">
    <a class="easyui-linkbutton" onclick="doUpdate()">立即修改</a>
</div>
</body>
</html>
