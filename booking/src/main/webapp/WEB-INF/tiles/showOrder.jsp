<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="contentDiv">
		<s:if test="%{#session.user.orders.size == 0}">
			<span class="important">
				尚未有您的訂票紀錄，<br />
				請由左方樹狀選單選擇：<br />
				<ol>
					<li>網路訂票系統</li>
					<li>台灣高速鐵路</li>
					<li>查詢火車時刻表</li>
				</ol>
				<br />
				訂票。
				</span>
		</s:if>
		<s:else>
			<table>
				<tr class="tableHeader">
					<th width ="80px">日期</th>
					<th width ="50px">車次</th>
					<th width ="80px">車箱種類</th>
					<th width = "60px">起程站</th>
					<th width = "60px">到達站</th>
					<th width = "100px">全票</th>
					<th width = "100px">孩童票<br/>(6-10歲)</th>
					<th width = "100px">愛心票</th>
					<th width = "100px">敬老票<br>(65歲以上)</th>
					<th width = "60px"></th>
				</tr>
				<s:iterator id="order" value="%{#session.user.orders}"  status="status">
					<tr class="tableData">
						<td><s:date name="%{#order.date}"  format="yyyy/MM/dd" /></td>
						<td class="trainId"><s:property value="%{#order.trainId}"/></td>
						<td class="trainCompartmentClass"><s:property value="%{@idv.hsiehpinghan.thsr.enumeration.TrainCompartmentClassEnum@getEnumMap().get(#order.trainCompartmentClass)}"/></td>
						<td class="station"><s:property value="%{@idv.hsiehpinghan.thsr.enumeration.StationEnum@getEnumMap().get(#order.startStation)}"/></td>
						<td class="station"><s:property value="%{@idv.hsiehpinghan.thsr.enumeration.StationEnum@getEnumMap().get(#order.destinationStation)}"/></td>
						<td class="amount"><s:property value="%{#order.adultTicketAmount}"/></td>
						<td class="amount"><s:property value="%{#order.childTickenAmount}"/></td>
						<td class="amount"><s:property value="%{#order.disabledTicketAmount}"/></td>
						<td class="amount"><s:property value="%{#order.seniorTicketAmount}"/></td>
						<s:if test="%{#order.gotTimestamp==null}">
							<td class="button">
								<a href='<s:url action="deleteOrder"><s:param name="selectedOrderIndex"  value="%{#status.index}" /></s:url>'>刪除</a>	
							</td>	
						</s:if>
						<s:else>
							<td class="button">成功</td>
						</s:else>
					</tr>
				</s:iterator>
			</table>
		</s:else>
</div>