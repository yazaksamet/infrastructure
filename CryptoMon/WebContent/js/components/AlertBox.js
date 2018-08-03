var AlertBox = {};
AlertBox.Type = "info";
AlertBox.Message = "";
AlertBox.ContainerId = "";

AlertBox.Show = function(type, message, containerId) {
	if (type) {
		AlertBox.Type = type;
	}
	
	if (message) {
		AlertBox.Message = message;
	}
	
	if (containerId) {
		AlertBox.ContainerId = message;
	} else {
		AlertBox.ContainerId = "MessagePanel";
	}
	
	var boxHtml = AlertBox.GetHtml();
	var container = AlertBox.GetContainer();
	container.html(boxHtml);
};

AlertBox.Hide = function() {
	var container = AlertBox.GetContainer();
	container.html("");
};

AlertBox.GetCss = function() {
	return "message-box-" + AlertBox.Type;
	
};

AlertBox.GetContainer = function() {
	return $('#MessagePanel');
};

AlertBox.GetHtml = function() {
	var boxCss = AlertBox.GetCss();
	var boxHtml = "<div class=\"" + boxCss + "\">" + AlertBox.Message;
	boxHtml += "<button type=\"button\" class=\"close\" onClick = \"AlertBox.Hide();\" data-dismiss=\"alert\">&times;</button>"
	boxHtml += "</div>";
	
	return boxHtml;
};