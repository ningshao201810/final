<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    $(function(){
        $("#list").edatagrid({
            updateUrl:"${pageContext.request.contextPath}/banner/update",
            url:"${pageContext.request.contextPath}/banner/query",
            fit: true,
            method:"post",
            /*rownumbers:true,*/
            fitColumns:true,
            pagination:true,
            toolbar:[{
                iconCls: 'icon-add',
                text:"添加",
                handler: function(){
                    $("#addDia").dialog("open");
                }
            },'-',{
                iconCls: 'icon-edit',
                text:"修改",
                handler: function(){
                    var row=$("#list").edatagrid("getSelected");
                    if(row==null){
                        alert("请先选择行");
                    }else {
                        var index=$("#list").edatagrid("getRowIndex",row);
                        $("#list").edatagrid("editRow",index);
                    }
                }
            },'-',{
                iconCls: 'icon-remove',
                text:"删除",
                handler: function(){
                    var row=$("#list").edatagrid("getSelected");
                    $.ajax({
                        url:"${pageContext.request.contextPath}/banner/delete?id="+row.id,
                        success:function(data){
                            if(data){
                                alert("删除成功");
                                $("#list").edatagrid("reload");
                            }else{
                                alert("删除失败");
                            }
                        }
                    });
                }
            },'-',{
                iconCls: 'icon-save',
                text:"保存",
                handler: function(){
                    $("#list").edatagrid("saveRow");
                }
            }],
            columns:[[
                /*{checkbox:true},*/
                {field:"oldname",title:"图片名"},
                {field:"url",title:"图片路径"},
                {field:"status",title:"图片状态",editor:{
                        type:"text",
                        options:{required:true}
                    }},
                {field:"createDate",title:"创建日期"},
                {field:"description",title:"描述"}
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="../' + rowData.url + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.name + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            }
        });
        $("#addDia").dialog({
            closed:true,
            /*buttons:"#but",*/
            width:300,
            title:"添加轮播图"
        })
    });
    function add() {
        $("#addDia").dialog("close");
        $("#addForm").form("submit",{
            url:"${pageContext.request.contextPath}/banner/add",
            success:function(data){
                if(data){
                    alert("添加成功");
                    $("#list").edatagrid("reload");
                }else {
                    alert("添加失败");
                }
            }
        });
    }
</script>
<div id="addDia">
	<form id="addForm" method="post" enctype="multipart/form-data">
		请选择上传的图片：<input type="file" name="img"><br>
		图片名：<input type="text" name="name"><br>
		描述：<input type="text" name="description"><br>
		<a onclick="add()" class="easyui-linkbutton">立即添加</a>
	</form>
</div>
<table id="list"></table>
