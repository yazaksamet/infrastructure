<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register now</title>
<%@ include file="./common/head.jsp" %>
</head>
<body>
<div class="se-pre-con"></div>
<div class="page-wrapper">
	<%@ include file="./common/top_nav.jsp" %>
	
	<div class="third">
		<h2 class="section-title">Register now</h2>
		<div class="container">
			<div id="MessagePanel"></div>
			<div class="row">
				<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		            <div class="box-style cont-pad">
		              <form class="row form1">
		              	<input type="hidden" value="registerHandler" id="formActionType" />
		                <h2>Please Sign Up <small>It's free and always will be.</small></h2>
		                <hr class="colorgraph">
		                <div class="row">
		                  <div class="col-xs-6 col-sm-6 col-md-6">
		                    <div class="form-group">
		                      <label class="name col-md-12">
		                      	<input type="text" name="first_name" id="first_name" class="form-control input-lg" placeholder="First Name" tabindex="1">
		                      	<span class="error">*This is not a valid first name.</span> <span class="empty">*This field is required.</span> 
		                      </label>
		                    </div>
		                  </div>
		                  <div class="col-xs-6 col-sm-6 col-md-6">
		                    <div class="form-group">
		                      <label class="name col-md-12">
		                      	<input type="text" name="last_name" id="last_name" class="form-control input-lg" placeholder="Last Name" tabindex="2">
		                      	<span class="error">*This is not a valid last name.</span> <span class="empty">*This field is required.</span>
		                      </label>
		                    </div>
		                  </div>
		                </div>
		                <div class="form-group">
		                  <label class="name col-md-12">
		                  	<input type="text" name="login_name" id="login_name" class="form-control input-lg" placeholder="Login Name" tabindex="3">
		                  	<span class="error">*This is not a valid login name.</span> <span class="empty">*This field is required.</span>
		                  </label>
		                </div>
		                <div class="form-group">
		                  <label class="email col-md-12">
		                  	<input type="email" name="email" id="email" class="form-control input-lg" placeholder="Email Address" tabindex="4">
		                  	<span class="error">*This is not a valid email.</span> <span class="empty">*This field is required.</span>
		                  </label>
		                </div>
		                <div class="row">
		                  <div class="col-xs-6 col-sm-6 col-md-6">
		                    <div class="form-group">
		                      <label class="password col-md-12">
		                      	<input type="password" name="password" id="password" class="form-control input-lg" placeholder="Password" tabindex="5">
		                      	<span class="error">*Password should be at least 8 characters long and contain at least 1 lower case, 1 upper case, 1 number and 1 special char(@, #, $, %, *, ;, ., &) .</span> <span class="empty">*This field is required.</span>
		                      </label>
		                    </div>
		                  </div>
		                  <div class="col-xs-6 col-sm-6 col-md-6">
		                    <div class="form-group">
		                      <label class="password col-md-12">
		                      	<input type="password" name="password_confirmation" id="password_confirmation" class="form-control input-lg" placeholder="Confirm Password" tabindex="6">
		                      	<span class="error">*This is not a valid password.</span> <span class="empty">*This field is required.</span>
		                      </label>
		                    </div>
		                  </div>
		                </div>
		                <div class="row">
		                  <div class="col-xs-1 col-sm-1 col-md-1"> <span class="button-checkbox">
		                    <input type="checkbox" name="t_and_c" id="t_and_c" class="o-hidden" value="1">
		                    </span> </div>
		                  <div class="col-xs-11 col-sm-11 col-md-11">
		                    <p>By clicking <strong class="label label-primary">Register</strong>, you agree to the <a href="#" data-toggle="modal" data-target="#t_and_c_m">Terms and Conditions</a> set out by this site, including our Cookie Use.</p>
		                  </div>
		                </div>
		                <hr class="colorgraph">
		                <div class="row">
		                  <div class="col-xs-6 col-md-6">
		                    <a class="btn btn-primary btn-block btn-lg" href="#" data-type="submit">Register</a>
		                  </div>
		                  <div class="col-xs-6 col-md-6"><a href="#" class="btn btn-success btn-block btn-lg">Sign In</a></div>
		                </div>
		              </form>
		            </div>
		          </div>
			</div>
		</div>
	</div>
</div>

<%@ include file="./common/js.jsp" %>

<script type="text/javascript">
page.GetFormData = function(form) {
	return {
		loginName: $('#login_name').val(),
		firstName: $('#first_name').val(),
		email: $('#email').val(),
		lastName: $('#last_name').val(),
		password: $('#password').val(),
		passwordConfirmation: $('#password_confirmation').val(),
		action: $("#formActionType").val()
	};
};

page.GetValidationData = function() {
	return {
		".name":{rx:/^[a-zA-Z'][a-zA-Z-' ]+[a-zA-Z']?$/,target:'input'},
		".password":{rx:/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*\;\.\,])(?=.{8,})/i,target:'input'},
		".email":{rx:/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i,target:'input'}
	};
};

page.FormOnSuccess = function() {
	window.location = "login.jsp";
};

</script>

</body>
</html>