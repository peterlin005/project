<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul id="stockSidebarTags" class="nav nav-pills nav-stacked">
		<li id="stockSidebarCompanyInfoTag" role="presentation"><a href="companyInfo"><span class="glyphicon glyphicon-info-sign"></span> <b><s:text name="package.companyInfo" /></b></a></li>
		<li id="stockSidebarTransactionInfoTag" role="presentation"><a href="transactionInfo"><span class="glyphicon glyphicon-signal"></span> <b><s:text name="package.transactionInfo" /></b></a></li>
		<li id="stockSidebarStatisticAnalysisTag" role="presentation"><a href="statisticAnalysis"><span class="glyphicon glyphicon-stats"></span> <b><s:text name="package.statisticAnalysis" /></b></a></li>
		<li id="stockSidebarFinancialReportTag" role="presentation" class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="javascript:void(0)"><span class="glyphicon glyphicon-list-alt"></span> <b><s:text name="package.financialReport" /> <span class="caret"></span></b></a>
			<ul class="dropdown-menu">
				<s:iterator value="reportTypes" var="var">
					<li><a href='financialReport?criteria.reportType=<s:property />'>&nbsp;&nbsp; <s:property value="%{#var.getName(getLocale())}" />
					</a></li>
				</s:iterator>
			</ul></li>
	</ul>
</div>
<script src="/stare-project/javascript/jquery-cookie-1.4.1/jquery.cookie.js"></script>
<script type="text/javascript">
	if('<s:property value="actionName"/>' == "companyInfo") {
		$("#stockSidebarCompanyInfoTag").tab("show");
	} else if('<s:property value="actionName"/>' == "transactionInfo") {
		$("#stockSidebarTransactionInfoTag").tab("show");
	} else if('<s:property value="actionName"/>' == "statisticAnalysis") {
		$("#stockSidebarStatisticAnalysisTag").tab("show");
	} else {
		$("#stockSidebarFinancialReportTag").tab("show");
	}
</script>