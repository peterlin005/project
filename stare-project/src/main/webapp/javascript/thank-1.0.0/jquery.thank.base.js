$(function() {
	$(".coloredNumber").each(function() {
		var $this = $(this);
		var html = $this.html();
		var num = parseFloat(html);
		if (num > 0) {
			$this.css("color", "darkRed");
		} else if (num < 0) {
			$this.css("color", "darkGreen");
		}
	});
});