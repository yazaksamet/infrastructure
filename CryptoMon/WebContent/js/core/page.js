var page = {};
page.Identity = "blank";
page.Data = {};
page.ApplicationDomain = "/Infrastructure/";
page.FormHasInitial = false;

page.SetPageLoading = function() {
	$(".se-pre-con").show();;
};

page.RemovePageLoading = function() {
	$(".se-pre-con").fadeOut("slow");
};

page.InitializePage = function() {
	page.SetPageLoading();
	page.LoadPageInitials();
	page.PreparePage();
	page.RemovePageLoading();
};

page.LoadPageInitials = function() {
	var params = {};
	params.Url = page.ApplicationDomain + "pageload";
	params.Async = false;
	params.Data = {};
	params.Data.pageIdentity = page.Identity;
	params.OnSuccess = page.SetData; 
	AjaxCall.Get(params);
};

page.SetData = function(data) {
	page.Data = eval(data);
};

page.PreparePage = function() {
	
};

page.GetFormData = function(form) {
	return null;
};

page.GetValidationData = function() {
	return null;
};

page.FormOnSuccess = function() {
	return null;
};