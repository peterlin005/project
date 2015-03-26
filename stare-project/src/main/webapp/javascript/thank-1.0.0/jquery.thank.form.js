thankForm = {
	dynamicallySubmit : function(p) {
		var defaultParam = {}
		$.extend(p, defaultParam);
		$('<form>', {
			"action" : p.action
		}).appendTo(document.body).submit();
	}
}
