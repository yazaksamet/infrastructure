var page = {};
page.Identity = "blank";
page.Data = {};
page.ApplicationDomain = "/CryptoMon/";

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
}

page.PreparePage = function() {
	
};

page.ShowMessage = function(messageType, messageText) {
	switch(messageType) {
	case "error":
		page.ShowError(messageText);
		break;
	case "info":
		page.ShowInfo(messageText);
		break;
	case "success":
		page.ShowSuccess(messageText);
		break;
	case "warning":
		page.ShowWarning(messageText);
		break;
	}
}

page.ShowError = function(messageText) {
	
}

page.ShowInfo = function(messageText) {
	
}

page.ShowWarning = function(messageText) {
	
}

page.ShowSuccess = function(messageText) {
	
}