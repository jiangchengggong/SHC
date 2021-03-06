<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../include/common.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>HTML5拖拽文件上传</title>
<script src="${jspath}/jquery-2.0.3.min.js"></script>
<style>
.dashboard_target_box {
    width: 250px;
    height: 105px;
    border: 3px dashed #E5E5E5;
    text-align: center;
    position: absolute;
    z-index: 2000;
    top: 0;
    left: 0;
    cursor: pointer
}
  
.dashboard_target_box.over {
    border: 3px dashed #000;
    background: #ffa
}
  
.dashboard_target_messages_container {
    display: inline-block;
    margin: 12px 0 0;
    position: relative;
    text-align: center;
    height: 44px;
    overflow: hidden;
    z-index: 2000
}
  
.dashboard_target_box_message {
    position: relative;
    margin: 4px auto;
    font: 15px/18px helvetica, arial, sans-serif;
    font-size: 15px;
    color: #999;
    font-weight: normal;
    width: 150px;
    line-height: 20px
}
  
.dashboard_target_box.over #dtb-msg1 {
    color: #000;
    font-weight: bold
}
  
.dashboard_target_box.over #dtb-msg3 {
    color: #ffa;
    border-color: #ffa
}
  
#dtb-msg2 {
    color: orange
}
  
#dtb-msg3 {
    display: block;
    border-top: 1px #EEE dotted;
    padding: 8px 24px
}
</style>
<script>
    $(document).ready(function() {
        //设计一段比较流行的滑动样式
        $('#drop_zone_home').hover(function() {
            $(this).children('p').stop().animate({
                top : '0px'
            }, 200);
        }, function() {
            $(this).children('p').stop().animate({
                top : '-44px'
            }, 200);
        });
  
        //要想实现拖拽，首页需要阻止浏览器默认行为，一个四个事件。
        $(document).on({
            dragleave : function(e) { //拖离
                e.preventDefault();
                $('.dashboard_target_box').removeClass('over');
            },
            drop : function(e) { //拖后放
                e.preventDefault();
            },
            dragenter : function(e) { //拖进
                e.preventDefault();
                $('.dashboard_target_box').addClass('over');
            },
            dragover : function(e) { //拖来拖去
                e.preventDefault();
                $('.dashboard_target_box').addClass('over');
            }
        });
  
        //================上传的实现
        var box = document.getElementById('target_box'); //获得到框体
        box.addEventListener("drop", function(e) {
            e.preventDefault(); //取消默认浏览器拖拽效果
          
            var fileList = e.dataTransfer.files; //获取文件对象
            //fileList.length 用来获取文件的长度（其实是获得文件数量）
            //检测是否是拖拽文件到页面的操作
            if (fileList.length == 0) {
                $('.dashboard_target_box').removeClass('over');
                return;
            }
            //检测文件是不是图片
            /*if (fileList[0].type.indexOf('image') === -1) {
                $('.dashboard_target_box').removeClass('over');
                return;
            }*/
  
            //var img = window.webkitURL.createObjectURL(fileList[0]);
            //拖拉图片到浏览器，可以实现预览功能
            xhr = new XMLHttpRequest();
            xhr.open("post", "/upload", true);
            xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
  
            var fd = new FormData();
            fd.append('files', fileList[0]);
  
            xhr.send(fd);
        }, false);
    });
</script>
</head>
  
<body>
    <div id="target_box" class="dashboard_target_box">
        <div id="drop_zone_home" class="dashboard_target_messages_container">
            <p id="dtb-msg2" class="dashboard_target_box_message"
                style="top: -44px">
                选择你的图片<br> 开始上传
            </p>
            <p id="dtb-msg1" class="dashboard_target_box_message"
                style="top: -44px">
                拖动图片到<br> 这里
            </p>
        </div>
    </div>
</body>
</html>