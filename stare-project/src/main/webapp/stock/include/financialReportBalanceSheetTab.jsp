<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="financialReportBalanceSheetDtos.size() > 0">
	<div id="balanceSheetChart"></div>
	<script type="text/javascript">
		var balanceSheetChartParam = {
			"bindto" : "#balanceSheetChart",
			data : {
				names : {
					data1 : '<s:text name="action.currentAssets" />',
					data2 : '<s:text name="action.noncurrentAssets" />',
					data3 : '<s:text name="action.currentLiabilities" />',
					data4 : '<s:text name="action.noncurrentLiabilities" />',
					data5 : '<s:text name="action.equity" />'
				},
				rows : [
						[ 'x', 'data1', 'data2', 'data3', 'data4', 'data5' ],
						<s:iterator value="financialReportBalanceSheetDtos">[
								'<s:date name="instantDate" format="yyyy/MM/dd" />',
								<s:property value="currentAssets" />,
								<s:property value="noncurrentAssets" />,
								<s:property value="currentLiabilities" />,
								<s:property value="noncurrentLiabilities" />,
								<s:property value="equity" />], </s:iterator> ],
				groups : [ [ 'data1', 'data2' ], [ 'data3', 'data4', 'data5' ] ]
			}
		}
		timeseriesBarChart(balanceSheetChartParam);
	</script>
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><s:text name="action.period" /></th>
					<th><s:text name="action.currentAssets" /></th>
					<th><s:text name="action.noncurrentAssets" /></th>
					<th><s:text name="action.currentLiabilities" /></th>
					<th><s:text name="action.noncurrentLiabilities" /></th>
					<th><s:text name="action.equity" /></th>
				</tr>
			</thead>
			<tbody align="right">
				<s:iterator value="financialReportBalanceSheetDtos" begin="%{financialReportBalanceSheetDtos.length-1}" end="%{financialReportBalanceSheetDtos.length-13}" step="-1">
					<tr>
						<td><a href='financialReportDetail?criteria.year=<s:property value="year"/>&criteria.season=<s:property value="season"/>'><s:date name="instantDate" format="yyyy/MM/dd" /> </a></td>
						<td><s:number name="currentAssets" /></td>
						<td><s:number name="noncurrentAssets" /></td>
						<td><s:number name="currentLiabilities" /></td>
						<td><s:number name="noncurrentLiabilities" /></td>
						<td><s:number name="equity" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</s:if>
<s:else>
	<s:include value="noDataDiv.jsp" />
</s:else>
