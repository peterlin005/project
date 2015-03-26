<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="financialReportStatementOfCashFlowsDtos.size() > 0">
	<div id="statementOfCashFlowsChart"></div>
	<script type="text/javascript">
		var statementOfCashFlowsChartParam = {
			"bindto" : "#statementOfCashFlowsChart",
			data : {
				names : {
					data1 : '<s:text name="action.briefCashFlowsFromUsedInOperatingActivities" />',
					data2 : '<s:text name="action.briefNetCashFlowsFromUsedInInvestingActivities" />',
					data3 : '<s:text name="action.briefCashFlowsFromUsedInFinancingActivities" />'
				},
				rows : [
						[ 'x', 'data1', 'data2', 'data3' ],
						<s:iterator value="financialReportStatementOfCashFlowsDtos">[
								'<s:date name="endDate" format="yyyy/MM/dd" />',
								<s:property value="cashFlowsFromUsedInOperatingActivities" />,
								<s:property value="netCashFlowsFromUsedInInvestingActivities" />,
								<s:property value="cashFlowsFromUsedInFinancingActivities" />],
						</s:iterator> ],
				groups : [ [ 'data1', 'data2', 'data3' ] ]
			}
		}
		timeseriesAreaSplineChart(statementOfCashFlowsChartParam);
	</script>
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><s:text name="action.period" /></th>
					<th><s:text name="action.cashFlowsFromUsedInOperatingActivities" /></th>
					<th><s:text name="action.netCashFlowsFromUsedInInvestingActivities" /></th>
					<th><s:text name="action.cashFlowsFromUsedInFinancingActivities" /></th>
				</tr>
			</thead>
			<tbody align="right">
				<s:iterator value="financialReportStatementOfCashFlowsDtos" begin="%{financialReportStatementOfCashFlowsDtos.length-1}" end="%{financialReportStatementOfCashFlowsDtos.length-13}" step="-1">
					<tr>
						<td><a href='financialReportDetail?criteria.year=<s:property value="year"/>&criteria.season=<s:property value="season"/>'><s:date name="startDate" format="yyyy/MM/dd" /><br>~<s:date name="endDate" format="yyyy/MM/dd" /></a></td>
						<td class="coloredNumber"><s:number name="cashFlowsFromUsedInOperatingActivities" /></td>
						<td class="coloredNumber"><s:number name="netCashFlowsFromUsedInInvestingActivities" /></td>
						<td class="coloredNumber"><s:number name="cashFlowsFromUsedInFinancingActivities" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</s:if>
<s:else>
	<s:include value="noDataDiv.jsp" />
</s:else>
