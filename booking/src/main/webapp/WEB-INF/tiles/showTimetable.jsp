<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="contentDiv">
	<s:if test="%{#session.listTrain.size == 0}">
		<span class="important">
			查無該日期的時刻表。<br />
			</span>
	</s:if>
	<s:else>
		<table>
			<tr class="tableHeader">
				<th width ="100px">日期</th>
				<th width ="70px">車次</th>
				<th width = "70px">方向</th>
				<th width = "70px">台北</th>
				<th width = "70px">板橋</th>
				<th width = "70px">桃園</th>
				<th width = "70px">新竹</th>
				<th width = "70px">台中</th>
				<th width = "70px">嘉義</th>
				<th width = "70px">台南</th>
				<th width = "70px">左營</th>
				<th width = "100px">備註</th>
				<th width = "80px"></th>
			</tr>
			<s:iterator id="train" value="%{#session.listTrain}"  status="status">
				<tr class="tableData">
					<td>
						<s:date name="%{#train.date}"  format="yyyy/MM/dd" />
					</td>
					<td class="trainId">
						<s:property value="%{#train.trainId}"/>
					</td>
					<td class="direction">
						<s:property value="%{@idv.hsiehpinghan.thsr.enumeration.DirectionEnum@getEnumMap().get(#train.direction)}"/>
					</td>
					<s:set id="i" value="0" />
					<s:iterator id="stationEnumMap" value="%{@idv.hsiehpinghan.thsr.enumeration.StationEnum@getEnumMap()}" >
						<td class="time">
							<s:if test="%{#stationEnumMap.key == #train.reachableStations[#i].station}">
								<s:date name="%{#train.reachableStations[#i].time}"  format="hh:mm"/>
								<s:set id="i" value="%{#i + 1}" />
							</s:if>
						</td>
					</s:iterator>	
					<td>
						<s:property value="%{#train.remark}"/>
					</td>	
					<td class="button">
							<a href='<s:url action="showOrderTicketPage" ><s:param name="selectedTrainIndex"  value="%{#status.index}" /></s:url>'>訂票</a>			
					</td>	
				</tr>
			</s:iterator>
		</table>
	</s:else>
</div>