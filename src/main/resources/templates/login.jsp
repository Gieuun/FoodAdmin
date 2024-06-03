<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>영화관리 | 로그인</title>

	<%@ include file="./inc/header_link.jsp" %>
	
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
	<!-- Content Wrapper. Contains page content -->
	
		<div class="card card-info mt-5 ml-5 mr-5">
		    <div class="card-header">
		        <h3 class="card-title">관리자 로그인</h3>
		    </div>
		    <!-- /.card-header -->
		    <!-- form start -->
		    
		    <form class="form-horizontal">
		        <div class="card-body">
		            <div class="form-group row">
		                <label for="inputEmail3" class="col-sm-2 col-form-label">ID</label>
		                <div class="col-sm-10">
		                    <input type="text" class="form-control" placeholder="Your ID" name="admin_id">
		                </div>
		            </div>
		            <div class="form-group row">
		                <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
		                <div class="col-sm-10">
		                    <input type="password" class="form-control" placeholder="Password" name="admin_pwd">
		                </div>
		            </div>
		            
		            
		        </div>
		        <!-- /.card-body -->
		        <div class="card-footer">
		            <button type="button" class="btn btn-info" id="bt_login">로그인</button>
		            <button type="button" class="btn btn-info" id="bt_regist">관리자 등록</button>
		            
		        </div>
		        <!-- /.card-footer -->
		    </form>
		
		
		</div>		
	
	<!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->
	
<%@ include file="./inc/footer_link.jsp" %>	

</body>
</html>
<script type="text/javascript">
	
	//비동기로 로그인 요청
	function login(){
		$.ajax({
			url:"/auth/admin",
			type:"post",
			data:$("form").serialize(),
			success:function(result, status, xhr){
				alert("인증 성공");
				location.href="/";
			},
			error:function(xhr, status, err){
				alert("인증실패");
			}
			
		});	
	}
	
	$(function(){
		$("#bt_login").click(function(){
			login();
		});
		
		$("#bt_regist").click(function(){
			location.href="/admin/registform";
		});
		
		
	});
</script>