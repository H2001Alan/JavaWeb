<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
	<%--静态包含base标签，css,jquery文件--%>
	<%@include file="/pages/common/head.jsp"%>

	<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
	<script type="text/javascript">
		$(function () {
			$("#username").blur(function () {
				var username=this.value;
				$.getJSON("http://localhost:8080/book/userServlet","action=ajaxExistsUsername&username="+username,function (data) {
					if (data.exist){
						$("span.errorMsg").text("用户名已存在!");
					}else {
						$("span.errorMsg").text("用户名可用!");
					}

				});
			});
			$("#code_img").click(function () {
				this.src="${basePath}/kaptcha.jpg"+new Date();
			});
			//给注册绑定单击事件
			$("#sub_btn").click(function () {
				var name=$("#username").val();
				var patt1=/^\w{5,12}$/;
				if(!patt1.test(name)){
					$(".errorMsg").text("*用户名不合法");
					return false;
				}

				var password1=$("#password").val();
				var patt2=/^\w{5,12}$/;
				if (!patt2.test(password1)){
					$(".errorMsg").text("*密码格式不合法");
					return false;
				}

				var password2=$("#repwd").val();
				if(password1!=password2){
					$(".errorMsg").text("*两次密码不一致");
					return false;
				}

				var emailLocal=$("#email").val();
				var patt3=/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
				if (!patt3.test(emailLocal)){
					$(".errorMsg").text("*邮箱格式有误")
					return false;
				}
				var yzm1=$("#code").val();
				var yzm=$.trim(yzm1);
				if(yzm==null||yzm==""){
					$(".errorMsg").text("*验证码错误")
					return false;
				}
			})
		})
	</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   autocomplete="off" tabindex="1" name="username" id="username"
									value="${requestScope.username}"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码"
										   autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码"
										   autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址"
										   autocomplete="off" tabindex="1" name="email" id="email"
										   value="${requestScope.email}"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 80px;" id="code" name="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px;width:110px;height: 30px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" /><br/>
									<input type="hidden" name="action" value="regist">
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%--静态包含页脚内容--%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>