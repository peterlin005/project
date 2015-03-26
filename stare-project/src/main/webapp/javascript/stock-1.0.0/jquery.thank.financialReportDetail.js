// Need include df-number-format-2.1.3/jquery.number.min.js
(function($) {
	$.fn.generateTable = function(p) {
		var defaultParam = {
			"json" : {},
			"title" : "title",
			"deep" : "deep",
			"label" : "label"
		}

		var param = $.extend(defaultParam, p);
		var $json = jQuery.parseJSON(param.json);
		var periods = getPeriods(param, $json);
		var titleHtml = generateTitle(param, $json, periods);
		var contentHtml = generateContent(param, $json, periods);
		this.html(titleHtml + contentHtml);
		return this;
	};

	function generateContent(param, $json, periods) {
		var html = "";
		html += "<tbody>";
		for ( var key in $json) {
			if (param.title == key) {
				continue;
			}
			var accObj = $json[key];
			var deep = accObj[param.deep];
			html += "<tr>";
			html += "<td>";
			html += getPadding(deep);
			html += accObj[param.label];
			html += "</td>";
			for (var i = 0, size = periods.length; i < size; ++i) {
				html += "<td align='right'>";
				html += modifyAccountValue(accObj[periods[i]]);
				html += "</td>";
			}
			html += "</tr>";
		}
		html += "</tbody>";
		return html;
	}

	function modifyAccountValue(accountValue) {
		if (typeof accountValue === 'undefined') {
			return "";
		}
		return $.number(accountValue / 1000, 0);
	}

	function getPadding(deep) {
		var padding = "";
		for (i = 0; i < deep; ++i) {
			padding += "&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		return padding;
	}

	function generateTitle(param, $json, periods) {
		var titleJson = $json[param.title];
		var html = "";
		html += "<thead>";
		html += "<tr>";
		html += "<th></th>";
		for (var i = 0, size = periods.length; i < size; ++i) {
			var period = periods[i];
			html += "<th>";
			html += titleJson[period];
			html += "</th>";
		}
		html += "</tr>";
		html += "</thead>";
		return html;
	}

	function getPeriods(param, $json) {
		var i = 0;
		var arr = [];
		for ( var key in $json[param.title]) {
			arr[i] = key;
			++i;
		}
		return arr;
	}
}(jQuery));
