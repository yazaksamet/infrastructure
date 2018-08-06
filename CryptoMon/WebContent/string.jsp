<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./common/session.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Type" content="text/html charset=UTF-8" />
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0" />

<title>Mutli Language String Definition</title>
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
		              	<input type="hidden" value="mlstringHandler" id="formActionType" />
		                <h2>Add/update <small>multi language definition</small></h2>
		                <hr class="colorgraph">
		                
		                
		                <div class="form-group">
		                  <label class="text col-md-12">
		                  	<input type="text" name="ml_key" id="ml_key" class="form-control input-lg" placeholder="ML Key" tabindex="1">
		                  	<span class="error">*This is not a valid text.</span> <span class="empty">*This field is required.</span>
		                  </label>
		                </div>
		                <div class="form-group">
		                  <label class="text col-md-12">
		                  	<input type="text" name="ml_lang" id="ml_lang" class="form-control input-lg" placeholder="Language" tabindex="2">
		                  	<span class="error">*This is not a valid text.</span> <span class="empty">*This field is required.</span>
		                  </label>
		                </div>
		                <div class="form-group">
		                  <label class="text col-md-12">
		                  	<input type="text" name="ml_value" id="ml_value" class="form-control input-lg" placeholder="ML Value" tabindex="3">
		                  	<span class="error">*This is not a valid text.</span> <span class="empty">*This field is required.</span>
		                  </label>
		                </div>
		                
		                <hr class="colorgraph">
		                <div class="row">
		                  <div class="col-xs-6 col-md-6">
		                    <a class="btn btn-primary btn-block btn-lg" href="#" data-type="submit">Save</a>
		                  </div>
		                  <div class="col-xs-6 col-md-6"><a href="#" class="btn btn-success btn-block btn-lg" data-type="reset">Clear</a></div>
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
		mlKey: $('#ml_key').val(),
		mlLang: $('#ml_lang').val(),
		mlVal: $('#ml_value').val(),
		action: $("#formActionType").val()
	};
};

page.GetValidationData = function() {
	return {
		".text":{rx:/^[ A-Za-z0-9_@./#&+-<>?!*]*$/,target:'input'}
	};
};

page.FormOnSuccess = function() {
};

</script>

</body>
</html>