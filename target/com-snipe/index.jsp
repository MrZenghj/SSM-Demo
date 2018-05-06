<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>导入数据</title>
    <script src="http://localhost:8080/SSM-Demo/static/jquery/jquery.min.js"></script>
    <script type="text/javascript">
       //导入表单
       function importexcel(){
           var file = document.getElementById("file").files[0];
           var fm = new FormData();
           fm.append('file', file);
           $.ajax(
               {
                   url: 'http://localhost:8080/SSM-Demo/carInfo',
                   type: 'POST',
                   data: fm,
                   contentType: false, //禁止设置请求类型
                   processData: false, //禁止jquery对DAta数据的处理,默认会处理
                   //禁止的原因是,FormData已经帮我们做了处理
                   success: function (result) {
                       //测试是否成功
                       //但需要你后端有返回值
                       alert(result);
                   }
               }
           );
       }
    </script>
</head>
<body>
    <h2>Hello World!</h2>
    <form action="http://localhost:8080/SSM-Demo/Test" method="post" >
        <input name="hobbit" type="checkbox" value="篮球"/>篮球<br />
        <input name="hobbit" type="checkbox" value="足球"/>足球<br />
        <input name="hobbit" type="checkbox" value="排球"/>排球<br />
        <input name="sex" type="radio" value="男" />男<<br>
        <input name="sex" type="radio" value="女" />女<<br>
        <input type="submit" value="提交"/><br>
    </form>
    <h3>文件上传</h3>
    <h3>请选择上传的文件</h3>
    <form action="http://localhost:8080/SSM-Demo/carInfo" method="post" enctype="multipart/form-data">
        <input type="file" id="file" name="file" accept="application/vnd.ms-excel" />
        <input type="button" value="上传" onclick="importexcel()"/>
       <%-- <input type="submit" value="上传" />--%>
    </form>
</body>
</html>
