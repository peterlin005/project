<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="financialReportStatementOfChangesInEquityDtos.size() > 0">
	<div id="statementOfChangesInEquityChart"></div>
	<script type="text/javascript">
		var statementOfChangesInEquityChartParam = {
			"bindto" : "#statementOfChangesInEquityChart",
			data : {
				names : {
					data1 : '<s:text name="action.profitLoss" />',
					data2 : '<s:text name="action.otherComprehensiveIncome" />'
				},
				rows : [
						[ 'x', 'data1', 'data2' ],
						<s:iterator value="financialReportStatementOfChangesInEquityDtos">[
								'<s:date name="endDate" format="yyyy/MM/dd" />',
								<s:property value="profitLoss" />,
								<s:property value="otherComprehensiveIncome" />],
						</s:iterator> ],
				groups : [ [ 'data1', 'data2' ] ]
			}
		}
		timeseriesAreaSplineChart(statementOfChangesInEquityChartParam);
	</script>
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><s:text name="action.period" /></th>
					<th><s:text name="action.profitLoss" /></th>
					<th><s:text name="action.otherComprehensiveIncome" /></th>
				</tr>
			</thead>
			<tbody align="right">
				<s:iterator value="financialReportStatementOfChangesInEquityDtos" begin="%{financialReportStatementOfChangesInEquityDtos.length-1}" end="%{financialReportStatementOfChangesInEquityDtos.length-13}" step="-1">
					<tr>
						<td><a href='financialReportDetail?criteria.year=<s:property value="year"/>&criteria.season=<s:property value="season"/>'><s:date name="startDate" format="yyyy/MM/dd" /><br>~<s:date name="endDate" format="yyyy/MM/dd" /></a></td>
						<td class="coloredNumber"><s:number name="profitLoss" /></td>
						<td class="coloredNumber"><s:number name="otherComprehensiveIncome" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</s:if>
<s:else>
	<s:include value="noDataDiv.jsp" />
</s:else>
