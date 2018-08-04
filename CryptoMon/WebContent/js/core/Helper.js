var Helper = {
	getValFromLabel:function(label){
		var val=$('input,textarea',label).val()
			,defVal=label.data('defVal')								
		return label.length?val==defVal?'nope':val:'nope'
	}	
};
