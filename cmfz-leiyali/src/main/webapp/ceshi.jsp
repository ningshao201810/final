<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>持名法州后台管理中心</title>
			
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="icon" href="img/favicon.jpg" type="image/x-icon" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/IconExtension.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/jquery-1.11.1.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.edatagrid.js"></script>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/themes/icon.css">
	<script type="text/javascript">
        $(function(){
            $("#list").datagrid({
				title:"sda",
                url:"${pageContext.request.contextPath}/banner/query",
                fit: true,
                method:"get",
                fitColumns: true,
                pagination: true,
                columns:[[
                    /*{checkbox:true},*/
                    {field:"oldname",title:"图片名"},
                    {field:"url",title:"图片路径"},
                    {field:"status",title:"图片状态"},
                    {field:"createDate",title:"创建日期"},
                    {field:"description",title:"描述"}
                ]],
            });
        });
	</script>
</head>
<body><div>
	<table id="list"></table>
</div>
</body>
</html>