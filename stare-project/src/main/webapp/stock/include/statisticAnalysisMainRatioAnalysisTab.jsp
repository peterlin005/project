<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="statisticAnalysisMainRatioAnalysisDtos != null && statisticAnalysisMainRatioAnalysisDtos.size() > 0">
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><s:text name="action.elementName" /></th>
					<th><s:text name="action.pValue" /></th>
					<%-- 					<th><s:text name="action.statistic" /></th> --%>
					<th><s:text name="action.degreeOfFreedom" /></th>
					<%-- 									<th><s:text name="action.confidenceInterval" /></th> --%>
					<th><s:text name="action.sampleMean" /></th>
					<th><s:text name="action.hypothesizedMean" /></th>
				</tr>
			</thead>
			<tbody align="right">
				<s:iterator value="statisticAnalysisMainRatioAnalysisDtos" var="var">
					<tr>
						<td align="left"><s:property value="%{#var.getName(getLocale())}" /></td>
						<td><s:number name="pValue" minimumFractionDigits="2" maximumFractionDigits="2" /></td>
						<%-- 						<td class="coloredNumber"><s:number name="statistic" minimumFractionDigits="2" maximumFractionDigits="2" /></td> --%>
						<td><s:number name="degreeOfFreedom" /></td>
						<%-- 										<td><s:number name="confidenceInterval" /></td> --%>
						<td class="coloredNumber"><s:number name="sampleMean" minimumFractionDigits="2" maximumFractionDigits="2" /></td>
						<td class="coloredNumber"><s:number name="hypothesizedMean" minimumFractionDigits="2" maximumFractionDigits="2" /></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
</s:if>
<s:else>
	<s:include value="noDataDiv.jsp" />
</s:else>
