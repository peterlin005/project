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
<link rel="stylesheet" href="/stare-project/javascript/c3-0.4.9/c3.css">
<script src="/stare-project/javascript/jquery-1.11.2/jquery-1.11.2.min.js"></script>
<script src="/stare-project/javascript/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script src="/stare-project/javascript/d3-3.5.5/d3.min.js"></script>
<script src="/stare-project/javascript/c3-0.4.9/c3.min.js"></script>
<script src="/stare-project/javascript/thank-1.0.0/jquery.thank.base.js"></script>
</head>
<body>
	<script type="text/javascript" src="/stare-project/javascript/thank-1.0.0/c3.thank.chartBase.js"></script>
	<script type="text/javascript" src="/stare-project/javascript/thank-1.0.0/c3.thank.timeseriesCombinationChart.js"></script>
	<s:include value="include/stockHeader.jsp" />
	<div class="container-fluid">
		<div class="row">
			<s:include value="include/stockSidebar.jsp" />
			<div class="col-sm-9 col-md-10 main">
				<ul class="nav nav-tabs">
					<li class="active"><a data-toggle="tab" href="#closingCondition"><b><span class="glyphicon glyphicon-stats"></span> <s:text name="action.closingCondition" /></b></a></li>
				</ul>
				<div class="tab-content">
					<div id="closingCondition" class="tab-pane fade in active">
						<div id="closingConditionChart"></div>
						<script type="text/javascript">
							var closingConditionChartParam = {
								"bindto" : "#closingConditionChart",
								data : {
									names : {
										data1 : '<s:text name="action.closingPrice" />',
										data2 : '<s:text name="action.moneyAmount" />'
									},
									rows : [
											[ 'x', 'data1', 'data2' ],
											<s:iterator value="stockClosingConditions">[
													'<s:date name="rowKey.date" format="yyyy/MM/dd" />',
													<s:property value="closingConditionFamily.closingPrice" />,
													<s:property value="closingConditionFamily.moneyAmount" />],
											</s:iterator> ],
									types : {
										data2 : 'bar'
									},
									axes : {
										data2 : 'y2'
									}
								}
							}
							timeseriesCombinationChart(closingConditionChartParam);
						</script>
						<div class="table-responsive">
							<table class="table table-hover">
								<thead>
									<tr>
										<th><s:text name="action.date" /></th>
										<th><s:text name="action.openingPrice" /></th>
										<th><s:text name="action.closingPrice" /></th>
										<th><s:text name="action.change" /></th>
										<th><s:text name="action.highestPrice" /></th>
										<th><s:text name="action.lowestPrice" /></th>
										<th><s:text name="action.finalPurchasePrice" /></th>
										<th><s:text name="action.finalSellingPrice" /></th>
										<th><s:text name="action.stockAmount" /></th>
										<th><s:text name="action.moneyAmount" /></th>
										<th><s:text name="action.transactionAmount" /></th>
									</tr>
								</thead>
								<tbody align="right">
									<s:iterator value="stockClosingConditions" begin="%{stockClosingConditions.length-1}" end="%{stockClosingConditions.length-10}" step="-1">
										<tr>
											<td><s:date name="rowKey.date" format="yyyy/MM/dd" /></td>
											<td><s:number name="closingConditionFamily.openingPrice" minimumFractionDigits="2" maximumFractionDigits="2" /></td>
											<td><s:number name="closingConditionFamily.closingPrice" minimumFractionDigits="2" maximumFractionDigits="2" /></td>
											<td class="coloredNumber"><s:number name="closingConditionFamily.change" minimumFractionDigits="2" maximumFractionDigits="2" /></td>
											<td><s:number name="closingConditionFamily.highestPrice" minimumFractionDigits="2" maximumFractionDigits="2" /></td>
											<td><s:number name="closingConditionFamily.lowestPrice" minimumFractionDigits="2" maximumFractionDigits="2" /></td>
											<td><s:number name="closingConditionFamily.finalPurchasePrice" minimumFractionDigits="2" maximumFractionDigits="2" /></td>
											<td><s:number name="closingConditionFamily.finalSellingPrice" minimumFractionDigits="2" maximumFractionDigits="2" /></td>
											<td><s:number name="closingConditionFamily.stockAmount" /></td>
											<td><s:number name="closingConditionFamily.moneyAmount" /></td>
											<td><s:number name="closingConditionFamily.transactionAmount" /></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>