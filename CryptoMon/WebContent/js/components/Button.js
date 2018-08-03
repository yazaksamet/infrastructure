function Button(params) {
	this.params = params;
	this.SetParams();
}

Button.prototype.GetText = function() {
	return "<a id='" + this.Id + "' href='#' class='" + this.GetCssClass()
			+ "'>" + this.Name + "</a>"
}

Button.prototype.GetCssClass = function() {
	return "flat " + this.Type + " " + (this.Border ? "border-" : "")
			+ this.Color;
}

Button.prototype.Initialize = function() {

}

Button.prototype.SetParams = function() {
	this.Type = "xs";
	this.Color = "green";
	this.Border = true;
	this.Name = "";
	this.OnClick = null;
	this.ContainerId = "";
	this.Id = "";

	if (this.params.name) {
		this.Name = this.params.name;
	}

	if (this.params.id) {
		this.Id = this.params.id;
	}

	if (this.params.color) {
		this.Color = this.params.color;
	}

	if (this.params.onclick) {
		this.OnClick = this.params.onclick;
	}

	if (this.params.type) {
		this.Type = this.params.type;
	}

	if (this.params.border) {
		this.Border = this.params.border;
	}

	if (this.params.containerId) {
		this.ContainerId = this.params.containerId;
	}
}