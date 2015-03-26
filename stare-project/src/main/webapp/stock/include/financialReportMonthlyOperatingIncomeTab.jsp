<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="monthlyOperatingIncomes.size() > 0">
	<div id="monthlyOperatingIncomeChart"></div>
	<script type="text/javascript">
		var monthlyOperatingIncomeChartParam = {
			bindto : "#monthlyOperatingIncomeChart",
			data : {
				xFormat : "%Y/%m",
				names : {
					data1 : '<s:text name="action.currentMonth" />',
					data2 : '<s:text name="action.currentMonthOfLastYear" />'
				},
				rows : [
						[ 'x', 'data1', 'data2' ],
						<s:iterator value="monthlyOperatingIncomes">[
								'<s:property value="rowKey.year" />/<s:property value="rowKey.month" />',
								<s:property value="incomeFamily.currentMonth" />,
								<s:property value="incomeFamily.currentMonthOfLastYear" />],
						</s:iterator> ]
			},
			axis : {
				x : {
					tick : {
						format : "%Y/%m"
					}
				}
			}
		}
		timeseriesAreaStepChart(monthlyOperatingIncomeChartParam);
	</script>
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><s:text name="action.year" /></th>
					<th><s:text name="action.month" /></th>
					<th><s:text name="action.currency" /></th>
					<th><s:text name="action.currentMonth" /></th>
					<th><s:text name="action.currentMonthOfLastYear" /></th>
					<th><s:text name="action.differentAmount" /></th>
					<th><s:text name="action.differentPercent" /></th>
					<th><s:text name="action.cumulativeAmountOfThisYear" /></th>
					<th><s:text name="action.cumulativeAmountOfLastYear" /></th>
					<th><s:text name="action.cumulativeDifferentAmount" /></th>
					<th><s:text name="action.cumulativeDifferentPercent" /></th>
					<%-- 										<th><s:text name="action.exchangeRateOfCurrentMonth" /></th> --%>
					<%-- 										<th><s:text name="action.cumulativeExchangeRateOfThisYear" /></th> --%>
					<%-- 										<th><s:text name="action.comment" /></th> --%>
				</tr>
			</thead>
			<tbody align="right">
				<s:iterator value="monthlyOperatingIncomes" begin="%{monthlyOperatingIncomes.length-1}" end="%{monthlyOperatingIncomes.length-13}" step="-1">
					<tr>
						<td><s:property value="rowKey.year" /></td>
						<td><s:property value="rowKey.month" /></td>
						<td><s:property value="%{rowKey.currency.getName(getLocale())}" /></td>
						<td><s:number name="incomeFamily.currentMonth" /></td>
						<td><s:number name="incomeFamily.currentMonthOfLastYear" /></td>
						<td class="coloredNumber"><s:number name="incomeFamily.differentAmount" /></td>
						<td class="coloredNumber"><s:property value="incomeFamily.differentPercent" /></td>
						<td><s:number name="incomeFamily.cumulativeAmountOfThisYear" /></td>
						<td><s:number name="incomeFamily.cumulativeAmountOfLastYear" /></td>
						<td class="coloredNumber"><s:number name="incomeFamily.cumulativeDifferentAmount" /></td>
						<td class="coloredNumber"><s:property value="incomeFamily.cumulativeDifferentPercent" /></td>
						<%-- 											<td><s:property value="incomeFamily.exchangeRateOfCurrentMonth" /></td> --%>
						<%-- 											<td><s:property value="incomeFamily.cumulativeExchangeRateOfThisYear" /></td> --%>
						<%-- 											<td><s:property value="incomeFamily.comment" /></td> --%>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</s:if>
<s:else>
	<s:include value="noDataDiv.jsp" />
</s:else>
