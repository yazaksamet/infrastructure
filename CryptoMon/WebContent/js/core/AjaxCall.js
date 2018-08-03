var AjaxCall = {};
AjaxCall.Get = function(params) {
	if (params && params.ShowLoading) {
		page.SetPageLoading();
	}
	
	$.ajax({
			method: params.Method ? params.Method : "GET",
			url: params.Url,
			timeout: params.Timeout ? params.Timeout : 0,
			async: params.Async !== undefined ? params.Async : true,
			data: params.Data ? params.Data : null
		})
		.done(function( msg ) {
			console.log( "ajax call success:", params.Url );
			
			if (params.ShowAlert) {
				AlertBox.Show("success", "Process is successful.", "");
			}
			
			if (params.OnSuccess) {
				params.OnSuccess(msg);
			}
		})
		.fail(function(msg) {
			console.log( "ajax call fail:", params.Url );
			console.log( "ajax call fail msg:", msg );
			if (params.ShowAlert) {
				AlertBox.Show("error", msg.responseText ? msg.responseText : "A error has occured.", "");
			}
		})
		.always(function() {
			console.log( "ajax call always:", params.Url );
			page.RemovePageLoading();
	});
};

