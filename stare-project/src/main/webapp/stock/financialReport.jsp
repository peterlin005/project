<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/stare-project/javascript/bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/stare-project/javascript/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="/stare-project/javascript/c3-0.4.9/c3.css">
<script src="/stare-project/javascript/jquery-1.11.2/jquery-1.11.2.min.js"></script>
<script src="/stare-project/javascript/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script src="/stare-project/javascript/jquery-cookie-1.4.1/jquery.cookie.js"></script>
<script src="/stare-project/javascript/d3-3.5.5/d3.min.js"></script>
<script src="/stare-project/javascript/c3-0.4.9/c3.min.js"></script>
<script src="/stare-project/javascript/thank-1.0.0/jquery.thank.base.js"></script>
<title><s:text name="action.htmlHeadTitle" /></title>
</head>
<body>
	<script type="text/javascript" src="/stare-project/javascript/thank-1.0.0/c3.thank.chartBase.js"></script>
	<script type="text/javascript" src="/stare-project/javascript/thank-1.0.0/c3.thank.timeseriesAreaStepChart.js"></script>
	<script type="text/javascript" src="/stare-project/javascript/thank-1.0.0/c3.thank.timeseriesBarChart.js"></script>
	<script type="text/javascript" src="/stare-project/javascript/thank-1.0.0/c3.thank.timeseriesAreaSplineChart.js"></script>
	<s:url action="financialReportDetail" var="financialReportDetail" />
	<s:include value="include/stockHeader.jsp" />
	<div class="container-fluid">
		<div class="row">
			<s:include value="include/stockSidebar.jsp" />
			<div class="col-sm-9 col-md-10 main">
				<ul id="financialReportTags" class="nav nav-tabs">
					<li><a data-toggle="tab" href="#monthlyOperatingIncome"><b><span class="glyphicon glyphicon-indent-right"></span> <s:text name="action.monthlyOperatingIncome" /></b></a></li>
					<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#"><b><span class="glyphicon glyphicon-list"></span> <s:text name="action.financialReport" /> <b class="caret"></b></b></a>
						<ul class="dropdown-menu">
							<li><a data-toggle="tab" href="#balanceSheet"><b><span class="glyphicon glyphicon-align-justify"></span> <s:text name="action.balanceSheet" /></b></a></li>
							<li><a data-toggle="tab" href="#statementOfComprehensiveIncome"><b><span class="glyphicon glyphicon-align-left"></span> <s:text name="action.statementOfComprehensiveIncome" /></b></a></li>
							<li><a data-toggle="tab" href="#statementOfCashFlows"><b><span class="glyphicon glyphicon-align-center"></span> <s:text name="action.statementOfCashFlows" /></b></a></li>
							<li><a data-toggle="tab" href="#statementOfChangesInEquity"><b><span class="glyphicon glyphicon-align-right"></span> <s:text name="action.statementOfChangesInEquity" /></b></a></li>
						</ul></li>
				</ul>
				<div class="tab-content">
					<div id="monthlyOperatingIncome" class="tab-pane fade in active">
						<s:include value="include/financialReportMonthlyOperatingIncomeTab.jsp" />
					</div>
					<div id="balanceSheet" class="tab-pane fade">
						<s:include value="include/financialReportBalanceSheetTab.jsp" />
					</div>
					<div id="statementOfComprehensiveIncome" class="tab-pane fade">
						<s:include value="include/financialReportStatementOfComprehensiveIncomeTab.jsp" />
					</div>
					<div id="statementOfCashFlows" class="tab-pane fade">
						<s:include value="include/financialReportStatementOfCashFlowsTab.jsp" />
					</div>
					<div id="statementOfChangesInEquity" class="tab-pane fade">
						<s:include value="include/financialReportStatementOfChangesInEquityTab.jsp" />
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var FINANCIAL_REPORT_TAG_INDEX = "financialReportTagIndex";
	var financialReportTagIndex = $.cookie(FINANCIAL_REPORT_TAG_INDEX) == null ? 0 : $.cookie(FINANCIAL_REPORT_TAG_INDEX);
	$("#financialReportTags li:eq('" + financialReportTagIndex + "') a").tab("show");
    $("#financialReportTags li").not('.dropdown').on("click", function() {
    	$.cookie(FINANCIAL_REPORT_TAG_INDEX, $("#financialReportTags li:not([class='dropdown'])").index(this));
    });
</script>
</html>