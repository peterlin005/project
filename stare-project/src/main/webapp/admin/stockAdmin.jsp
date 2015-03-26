<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/stare-project/resource/bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/stare-project/resource/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<style type="text/css">
#my-nav-header {
	margin: 15px;
}
</style>
<script src="/stare-project/resource/jquery-1.11.2/jquery-1.11.2.min.js"></script>
<script src="/stare-project/resource/df-number-format-2.1.3/jquery.number.min.js"></script>
<script src="/stare-project/resource/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script src="/stare-project/resource/thank-1.0.0/jquery.thank.table.js"></script>
<s:if test="jsonMap != null">
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
<title>Financial report detail</title>
</head>
<body>
	<nav id="my-nav-header" role="navigation" class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" data-target="#my-nav-content" data-toggle="collapse" class="navbar-toggle">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a href="#" class="navbar-brand">Stare</a>
		</div>
		<div id="my-nav-content" class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Stock Info</a></li>
				<li><a href="#">Select</a></li>
			</ul>
			<form role="search" class="navbar-form navbar-left">
				<div class="form-group">
					<input type="text" placeholder="Search" class="form-control">
				</div>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Login</a></li>
			</ul>
		</div>
	</nav>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="#">Report</a></li>
					<li><a href="#">Ratio</a></li>
					<li><a href="#">Growth</a></li>
				</ul>
			</div>
			<div class="col-sm-9 col-md-10 main">
				<form class="form-inline" role="form" action="financialReportDetail!query.action">
					<div class="form-group">
						<div class="panel clearfix">
							<div>
								<a href="javascript:void(0)" class="btn btn-default">Stock Code</a>
								<s:select class="form-control" name="criteria.stockCode" list="stockCodes" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="panel clearfix">
							<div>
								<a href="javascript:void(0)" class="btn btn-default">Report Type</a>
								<s:select class="form-control" name="criteria.reportType" list="reportTypes" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="panel clearfix">
							<div>
								<a href="javascript:void(0)" class="btn btn-default">Year</a>
								<s:select class="form-control" name="criteria.year" list="years" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<div class="panel clearfix">
							<div>
								<a href="javascript:void(0)" class="btn btn-default">Season</a>
								<s:select class="form-control" name="criteria.season" list="seasons" />
							</div>
						</div>
					</div>
					<div class="pull-right">
						<button type="submit" class="btn btn-default">Query</button>
					</div>
				</form>
				<s:if test="jsonMap != null">
					<ul class="nav nav-tabs">
						<li class="active"><a data-toggle="tab" href="#balanceSheet">Balance Sheet</a></li>
						<li><a data-toggle="tab" href="#statementOfComprehensiveIncome">Income</a></li>
						<li><a data-toggle="tab" href="#statementOfCashFlows">Cash Flows</a></li>
						<li><a data-toggle="tab" href="#statementOfChangesInEquity">Equity</a></li>
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
					<div class="panel panel-default">
						<div class="panel-body">No data.</div>
					</div>
				</s:else>
			</div>
		</div>
	</div>
</body>
</html>