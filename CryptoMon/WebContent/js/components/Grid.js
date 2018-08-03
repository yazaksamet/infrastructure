var Grid = {};
Grid.Columns = {};
Grid.Rows = {};
Grid.ContainerId = "";
Grid.Buttons = [];

Grid.Initialize = function(params) {
	if (params.Columns) {
		Grid.Columns = params.Columns;
	}
	
	if (params.Rows) {
		Grid.Rows = params.Rows;
	}
	
	if (params.ContainerId) {
		Grid.ContainerId = params.ContainerId;
	}
	
	if (params.Buttons) {
		Grid.Buttons = [];
		for (var button in params.Buttons) {
			params.Buttons[button].id = Grid.ContainerId + "_" + params.Buttons[button].name; 
			Grid.Buttons.push(new Button(params.Buttons[button]));
		}
	}
	
	Grid.Bind();
}

Grid.Bind = function() {
	if (Grid.ContainerId) {
		var buttonText = Grid.GetButtons();
		
		var gridText = "<table class='products-table'>";
		gridText += Grid.GetHeader();
		gridText += Grid.GetRows();
		gridText += "</table>";
		$("#" + Grid.ContainerId).html(buttonText + gridText);
		Grid.AssignButtonEvents();
	}
}

Grid.AssignButtonEvents = function() {
	if (Grid.Buttons) {
		for (var button in Grid.Buttons) {
			$('#' + Grid.Buttons[button].Id).click(Grid.Buttons[button].OnClick);
		}
	}
};

Grid.GetButtons = function() {
	var buttonText = "<table><tr>";
	if (Grid.Buttons) {
		for (var button in Grid.Buttons) {
			buttonText += "<td>";
			buttonText += Grid.Buttons[button].GetText();
			buttonText += "</td>";
		}
	}
	buttonText += "</tr></table>";
	return buttonText;
};

Grid.GetHeader = function() {
	var headerText = "";
	if (Grid.Columns) {
		headerText += "<thead><tr>";
		for(var col in Grid.Columns) {
			headerText += "<th>" + Grid.Columns[col] + "</th>";
		}
		headerText += "</tr></thead>";
	}
	return headerText;
}

Grid.GetRows = function() {
	var rowText = "";
	if (Grid.Rows) {
		rowText += "<tbody>";
		for(var row in Grid.Rows) {
			rowText += "<tr>";
			for(var col in Grid.Columns) {
				rowText += "<td>" + Grid.Rows[row][Grid.Columns[col]] + "</td>";
			}
			rowText += "</tr>";
		}
		rowText += "</tbody>";
	}
	return rowText;
}