<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    $(function(){
        $('#album').treegrid({
            url:'${pageContext.request.contextPath}/album/query',
			method:"post",
            fit:true,
            fitColumns:true,
            idField:'id',
            treeField:'title',
            onDblClickRow:function (rowData) {
                console.log(rowData)
                $("#player").dialog("open");
                $("#audio")[0].play();//play()是js中的自动播放音频的方法，需要将jQuery对象转换为js对象
            },
            toolbar: [{
                iconCls: 'icon-edit',
                text:"专辑详情",
                handler: function(){alert('专辑详情')}
            },'-',{
                iconCls: 'icon-add',
                text:"添加专辑",
                handler: function(){
                    $("#addAlb").dialog("open");
                }
            },'-',{
                iconCls: 'icon-add',
                text:"添加章节",
                handler: function(){
                    $("#addCh").dialog("open");
                    $('#albumId').combobox({
                        url:"${pageContext.request.contextPath}/album/getAlbum",
                        valueField:'id',
                        textField:'title'
                    });
                }
            },'-',{
                iconCls: 'icon-download',
                text:"下载音频",
                handler: function(){
                    var obj=$('#album').treegrid("getSelected");
                    console.log(obj);
                    if(isNaN(obj.id)){
                        $.ajax({
                            url:"${pageContext.request.contextPath}/chapter/download",
                            data:{"url":obj.url}
                        });
                    }else {
                        alert("请选择要下载的章节");
                    }
                }
            }],
            columns:[[
                {title:'名字',field:'title',width:180},
                {field:'url',title:'路径',width:60,align:'right'},
                {field:'size',title:'大小',width:80},
                {field:'duration',title:'时长',width:80}
            ]]
        });
        $("#addAlb").dialog({
            title:"添加专辑",
            closed:true,
            width:200,
            height:400
        })
        $("#addCh").dialog({
            title:"添加章节",
            closed:true,
            width:200,
            height:400
        });
        $("#player").dialog({
            title:"在线播放",
            closed:true,
            width:200,
            height:400
        });
    })
    function addChapter() {
        $("#addCh").dialog("close");
        $("#addChapter").form("submit",{
            url:"${pageContext.request.contextPath}/chapter/add",
            success:function (data) {
                if(data==true){
                    alert("添加成功");
                }else {
                    alert("添加失败");
                }
            }
        })
    }
    function addAlbum() {
        $("#addAlb").dialog("close");
        $("#addAlbum").form("submit",{
            url:"${pageContext.request.contextPath}/album/add",
            success:function (data) {
                if(data==true){
                    alert("添加成功");
                }else {
                    alert("添加失败");
                }
            }
        })
    }
</script>
<table id="album"></table>
<div id="addCh">
    <form id="addChapter" method="post" enctype="multipart/form-data">
        请选择文件：<input type="file" name="audio"><br>
        请选择所属专辑：<input id="albumId" name="alId" value="qq">
        <a class="easyui-linkbutton" onclick="addChapter()">立即添加</a>
    </form>
<div id="player">
    <audio id="audio" controls="controls" preload="auto">
        <source src="${pageContext.request.contextPath}/audio/1540471717256mp3" type="audio/ogg" />
    </audio>
</div>
</div>
<div id="addAlb">
    <form id="addAlbum" method="post" enctype="multipart/form-data">
        专辑名：<input type="text" name="title"><br/>
        播音人：<input type="text" name="broadCast"><br/>
        简介：<input type="text" name="brief"><br/>
        作者：<input type="text" name="author"><br/>
        请选择封面图片：<input type="file" name="img"><br/>
        <a class="easyui-linkbutton" onclick="addAlbum()">立即添加</a>
    </form>
</div>
