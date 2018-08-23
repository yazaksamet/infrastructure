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
<meta charset="ISO-8859-1">
<title><fmt:message key="label.homePage" /></title>
<%@ include file="./common/head.jsp" %>
</head>
<body>
<div class=".se-pre-con"></div>
<div class="page-wrapper">
	<%@ include file="./common/top_nav.jsp" %>	
	
	<div class="third">
		<div class="container">
			<div id="MessagePanel"></div>
			<div class="row">
				<div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
		            <div class="box-style cont-pad">
		            	<h2><fmt:message key="label.mainWelcomeText" /></h2>
		                <hr class="colorgraph">
		            </div>
		        </div>
		     </div>
		 </div>
	</div>
</div>

<%@ include file="./common/js.jsp" %>

<script type="text/javascript">
page.GetFormData = function(form) {
	return null;
};

page.GetValidationData = function() {
	return null;
};

</script>

</body>
</html>