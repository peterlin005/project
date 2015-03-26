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
<script src="/stare-project/javascript/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script src="/stare-project/javascript/jquery-cookie-1.4.1/jquery.cookie.js"></script>
<script src="/stare-project/javascript/thank-1.0.0/jquery.thank.base.js"></script>
<script src="/stare-project/javascript/thank-1.0.0/jquery.thank.form.js"></script>
<script type="text/javascript">
	$(function() {
		$("#detail").on("click", function() {
			thankForm.dynamicallySubmit({
				"action" : 'financialReportDetail.action'
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
				<form class="form-inline" role="form" action="statisticAnalysis!query.action">
					<div class="form-group">
						<div class="panel clearfix">
							<div class="col-xs-2 col-sm-2 col-md-1 col-lg-1">
								<a href="javascript:void(0)" class="btn btn-danger disabled"><s:text name="action.year" /></a>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-2 col-lg-2">
								<s:select class="form-control" name="criteria.year" list="years" value="stockBag.year" />
							</div>
							<div class="col-xs-3 col-sm-3 col-md-1 col-lg-1">
								<a href="javascript:void(0)" class="btn btn-danger disabled"><s:text name="action.season" /></a>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-2 col-lg-2">
								<s:select class="form-control" name="criteria.season" list="seasons" value="stockBag.season" />
							</div>
							<div class="clearfix visible-xs-block"></div>
							<div class="clearfix visible-sm-block"></div>
							<div class="col-xs-2 col-sm-2 col-md-1 col-lg-1">
								<a href="javascript:void(0)" class="btn btn-danger disabled"><s:text name="action.reportType" /></a>
							</div>
							<div class="col-xs-4 col-sm-4 col-md-2 col-lg-2">
								<select class="form-control" name="criteria.reportType">
									<s:iterator value="reportTypes" var="var">
										<s:if test="%{#var == stockBag.getReportType()}">
											<option value='<s:property />' selected="selected"><s:property value="%{#var.getName(getLocale())}" /></option>							
										</s:if>
										<s:else>
											<option value='<s:property />'><s:property value="%{#var.getName(getLocale())}" /></option>
										</s:else>
									</s:iterator>
								</select>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-1 col-lg-1">
								<a href="javascript:void(0)" class="btn btn-danger disabled"><s:text name="action.pValue" /></a>
							</div>
							<div class="col-xs-3 col-sm-3 col-md-2 col-lg-2">
								<s:select class="form-control" name="criteria.pValue" list="pValues" value="stockBag.pValue" />
							</div>
							<div class="clearfix visible-xs-block"></div>
							<div class="clearfix visible-sm-block"></div>
							<div class="clearfix visible-md-block"></div>
							<div class="clearfix visible-lg-block"></div>
						</div>
					</div>
					<div class="pull-right">
						<button id="detail" type="button" class="btn btn-warning">
							<s:text name="action.detail" />
						</button>
						<button type="submit" class="btn btn-success">
							<s:text name="action.query" />
						</button>
					</div>
				</form>
				<div style="clear: both;"></div>
				<ul id="financialReportDetailTags" class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#ratioDifference"><b><s:text name="action.ratioTTest" /></b></a></li>
				</ul>
				<div class="tab-content">
					<div id="ratioDifference" class="tab-pane fade in active">
						<s:include value="include/statisticAnalysisMainRatioAnalysisTab.jsp" />
					</div>
				</div>
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