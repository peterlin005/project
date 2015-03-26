<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="financialReportStatementOfComprehensiveIncomeDtos.size() > 0">
	<div id="statementOfComprehensiveIncomeChart"></div>
	<script type="text/javascript">
		var statementOfComprehensiveIncomeChartParam = {
			"bindto" : "#statementOfComprehensiveIncomeChart",
			data : {
				names : {
					data1 : '<s:text name="action.briefGrossProfitLossFromOperationsNet" />',
					data2 : '<s:text name="action.briefNetOperatingIncomeLoss" />',
					data3 : '<s:text name="action.briefNonoperatingIncomeAndExpenses" />',
					data4 : '<s:text name="action.briefIncomeTaxExpenseContinuingOperations" />',
					data5 : '<s:text name="action.briefProfitLossFromContinuingOperations" />',
					data6 : '<s:text name="action.briefDilutedEarningsLossPerShare" />'
				},
				rows : [
						[ 'x', 'data1', 'data2', 'data3', 'data4', 'data5',
								'data6' ],
						<s:iterator value="financialReportStatementOfComprehensiveIncomeDtos">[
								'<s:date name="endDate" format="yyyy/MM/dd" />',
								<s:property value="grossProfitLossFromOperationsNet" />,
								<s:property value="netOperatingIncomeLoss" />,
								<s:property value="nonoperatingIncomeAndExpenses" />,
								<s:property value="incomeTaxExpenseContinuingOperations" />,
								<s:property value="profitLossFromContinuingOperations" />,
								<s:property value="dilutedEarningsLossPerShare" />],
						</s:iterator> ]
			}
		}
		timeseriesAreaSplineChart(statementOfComprehensiveIncomeChartParam);
	</script>
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><s:text name="action.period" /></th>
					<th><s:text name="action.grossProfitLossFromOperationsNet" /></th>
					<th><s:text name="action.netOperatingIncomeLoss" /></th>
					<th><s:text name="action.nonoperatingIncomeAndExpenses" /></th>
					<th><s:text name="action.incomeTaxExpenseContinuingOperations" /></th>
					<th><s:text name="action.profitLossFromContinuingOperations" /></th>
					<th><s:text name="action.dilutedEarningsLossPerShare" /></th>
				</tr>
			</thead>
			<tbody align="right">
				<s:iterator value="financialReportStatementOfComprehensiveIncomeDtos" begin="%{financialReportStatementOfComprehensiveIncomeDtos.length-1}" end="%{financialReportStatementOfComprehensiveIncomeDtos.length-13}" step="-1">
					<tr>
						<td><a href='financialReportDetail?criteria.year=<s:property value="year"/>&criteria.season=<s:property value="season"/>'><s:date name="startDate" format="yyyy/MM/dd" /><br>~<s:date name="endDate" format="yyyy/MM/dd" /></a></td>
						<td class="coloredNumber"><s:number name="grossProfitLossFromOperationsNet" /></td>
						<td class="coloredNumber"><s:number name="netOperatingIncomeLoss" /></td>
						<td class="coloredNumber"><s:number name="nonoperatingIncomeAndExpenses" /></td>
						<td class="coloredNumber"><s:number name="incomeTaxExpenseContinuingOperations" /></td>
						<td class="coloredNumber"><s:number name="profitLossFromContinuingOperations" /></td>
						<td class="coloredNumber"><s:number name="dilutedEarningsLossPerShare" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</s:if>
<s:else>
	<s:include value="noDataDiv.jsp" />
</s:else>
