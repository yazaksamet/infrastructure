<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="true" %>

<fmt:setLocale value="${cookie['lang'].value}"/>
<fmt:setBundle basename="messages"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<%@ include file="./common/head.jsp" %>
</head>
<body>
<div class="se-pre-con"></div>

<div class="page-wrapper">
	<%@ include file="./common/top_nav.jsp" %>
	
	<div class="third">
		<div class="container">
			<div id="MessagePanel"></div>
			<div class="row">
				<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		            <div class="box-style cont-pad">
		              <form class="row form1">
		                	<h2><fmt:message key="label.loginHeader" /></h2>
		                	<hr class="colorgraph">
		                  <fieldset>
		                  <input type="hidden" value="loginHandler" id="formActionType" />
		                  <label class="name col-md-12">
		                  <input type="text" value="<fmt:message key="label.loginName" />:">
		                  <span class="error"><fmt:message key="label.invalidLoginName" /></span> <span class="empty"><fmt:message key="label.requiredField" /></span> </label>
		                  <label class="password col-md-12">
		                  <input type="password" value="<fmt:message key="label.password" />:">
		                  <span class="error"><fmt:message key="label.invalidPassword" /></span> <span class="empty"><fmt:message key="label.requiredField" /></span> </label>
		                  <div class="clear"></div>
		                  <div class="link-form col-md-12"> <a class="btn style1" href="#" data-type="submit"><fmt:message key="label.login" /></a> <a class="btn style4" href="forgetpassword.jsp"><fmt:message key="label.forgetPassword" /></a>  
		                  	<a href="register.jsp"><fmt:message key="label.register" /></a>
		                  </div>
		                  </fieldset>
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
		loginName:form.getValFromLabel($('.name',form.form)),
		password:form.getValFromLabel($('.password',form.form)),
		action: $("#formActionType").val()
	};
};

page.GetValidationData = function() {
	return {
		".name":{rx:/^[a-zA-Z'][a-zA-Z-' ]+[a-zA-Z']?$/,target:'input'},
		".password":{rx:/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%\^&\*\;\.\,])(?=.{8,})/i,target:'input'},
		".state":{rx:/^[a-zA-Z'][a-zA-Z-' ]+[a-zA-Z']?$/,target:'input'},
		".email":{rx:/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i,target:'input'},
		".phone":{rx:/^\+?(\d[\d\-\+\(\) ]{5,}\d$)/,target:'input'},
		".fax":{rx:/^\+?(\d[\d\-\+\(\) ]{5,}\d$)/,target:'input'},
		".message":{rx:/.{20}/,target:'textarea'}
	};
};

page.FormOnSuccess = function() {
	window.location = "myaccount.jsp";
};

</script>

</body>
</html>