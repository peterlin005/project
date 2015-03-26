<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><s:text name="action.htmlHeadTitle" /></title>
<link rel="stylesheet" href="/stare-project/javascript/bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/stare-project/javascript/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<script src="/stare-project/javascript/jquery-1.11.2/jquery-1.11.2.min.js"></script>
<script src="/stare-project/javascript/df-number-format-2.1.3/jquery.number.min.js"></script>
<script src="/stare-project/javascript/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script src="/stare-project/javascript/jquery-cookie-1.4.1/jquery.cookie.js"></script>
<script src="/stare-project/javascript/stock-1.0.0/jquery.thank.financialReportDetail.js"></script>
<script src="/stare-project/javascript/thank-1.0.0/jquery.thank.form.js"></script>
<s:if test="financialReportDetailJsonMap != null">
	<script type="text/javascript">
		$(function() {
			$("#balanceSheetTable")
					.generateTable(
							{
								"json" : '<s:property value="balanceSheetJson" escapeHtml="false" />'
							});
			$("#statementOfComprehensiveIncomeTable")
					.generateTable(
							{
								"json" : '<s:property value="statementOfComprehensiveIncomeJson" escapeHtml="false" />'
							});
			$("#statementOfCashFlowsTable")
					.generateTable(
							{
								"json" : '<s:property value="statementOfCashFlowsJson" escapeHtml="false" />'
							});
			$("#statementOfChangesInEquityTable")
					.generateTable(
							{
								"json" : '<s:property value="statementOfChangesInEquityJson" escapeHtml="false" />'
							});
		});
	</script>
</s:if>
<script type="text/javascript">
	$(function() {
		$("#back").on("click", function() {
			thankForm.dynamicallySubmit({
				"action" : 'financialReport.action'
			});
		});
	});
</script>
</head>
<body>
	<s:include value="include/stockHeader.jsp" />
	<div class="container-fluid">
		<div class="row">
			<s:include value="include/stockSidebar.jsp" />
			<div class="col-sm-9 col-md-10 main">
				<form class="form-inline" role="form" action="financialReportDetail!query.action">
					<div class="form-group">
						<div class="panel clearfix">
							<div class="col-xs-2">
								<a href="javascript:void(0)" class="btn btn-danger disabled"><s:text name="action.year" /></a>
							</div>
							<div class="col-xs-4">
								<s:select class="form-control" name="criteria.year" list="years" value="stockBag.year" />
							</div>
							<div class="col-xs-3">
								<a href="javascript:void(0)" class="btn btn-danger disabled"><s:text name="action.season" /></a>
							</div>
							<div class="col-xs-3">
								<s:select class="form-control" name="criteria.season" list="seasons" value="stockBag.season" />
							</div>
						</div>
					</div>
					<div class="pull-right">
						<button id="back" type="button" class="btn btn-warning">
							<s:text name="action.back" />
						</button>
						<button type="submit" class="btn btn-success">
							<s:text name="action.query" />
						</button>
					</div>
				</form>
				<div style="clear: both;"></div>
				<s:if test="financialReportDetailJsonMap != null">
					<ul id="financialReportDetailTags" class="nav nav-tabs">
						<li><a data-toggle="tab" href="#balanceSheet"><b><s:text name="action.balanceSheet" /></b></a></li>
						<li><a data-toggle="tab" href="#statementOfComprehensiveIncome"><b><s:text name="action.statementOfComprehensiveIncome" /></b></a></li>
						<li><a data-toggle="tab" href="#statementOfCashFlows"><b><s:text name="action.statementOfCashFlows" /></b></a></li>
						<li><a data-toggle="tab" href="#statementOfChangesInEquity"><b><s:text name="action.statementOfChangesInEquity" /></b></a></li>
					</ul>
					<div class="tab-content">
						<div id="balanceSheet" class="tab-pane fade in active">
							<div class="table-responsive">
								<table id="balanceSheetTable" class="table table-hover">
								</table>
							</div>
						</div>
						<div id="statementOfComprehensiveIncome" class="tab-pane fade">
							<div class="table-responsive">
								<table id="statementOfComprehensiveIncomeTable" class="table table-hover">
								</table>
							</div>
						</div>
						<div id="statementOfCashFlows" class="tab-pane fade">
							<div class="table-responsive">
								<table id="statementOfCashFlowsTable" class="table table-hover">
								</table>
							</div>
						</div>
						<div id="statementOfChangesInEquity" class="tab-pane fade">
							<div class="table-responsive">
								<table id="statementOfChangesInEquityTable" class="table table-hover">
								</table>
							</div>
						</div>
					</div>
				</s:if>
				<s:else>
					<s:include value="include/noDataDiv.jsp" />
				</s:else>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	// Reference financial report tag index as financial report detail tag index
	var FINANCIAL_REPORT_TAG_INDEX = "financialReportTagIndex";
	var financialReportTagIndex = $.cookie(FINANCIAL_REPORT_TAG_INDEX) == null ? 0
			: $.cookie(FINANCIAL_REPORT_TAG_INDEX);
	var financialReportDetailTagIndex = financialReportTagIndex - 2;
	$(
			"#financialReportDetailTags li:eq('"
					+ financialReportDetailTagIndex + "') a").tab("show");
</script>
</html>