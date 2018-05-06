<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据的导入</title>
<script src="http://localhost:8080/SSM-Demo/static/jquery/jquery.min.js"></script>
<script type="text/javascript">
	//导入表单
	function importexcel(){						    
	    var carinfo = document.getElementById("carinfo").files[0];
	    var fm = new FormData();	   
	    fm.append('carinfo', carinfo);
	    $.ajax(
	        {
	           url: 'http://localhost:8080/SSM-Demo/car/importFile/',
	           type: 'POST',
	           data: fm,
	           contentType: false, //禁止设置请求类型
	           processData: false, //禁止jquery对DAta数据的处理,默认会处理
	           //禁止的原因是,FormData已经帮我们做了处理
	           success: function (result) {
	              //测试是否成功
	              //但需要你后端有返回值
	              alert(result.message);
			   }
	        }
	    );
	}
</script>
</head>
<body>
	<h1>请选择需要导入的文件</h1>	
	<form id="excelform" enctype="multipart/form-data">
		<input id="carinfo" type="file" name="carinfo" />
		<input  type="button" value="导入Excel" onclick="importexcel()"/><br/>
	</form>	
</body>
</html>