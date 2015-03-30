<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="contentDiv">
	<s:form action="orderTicket">
		<s:token />
		<s:label value="訂票" />
		<s:radio  key="trainCompartmentClass"  label="車箱種類" list="%{@idv.hsiehpinghan.thsr.enumeration.TrainCompartmentClassEnum@getEnumMap()}"  value="%{@idv.hsiehpinghan.thsr.enumeration.TrainCompartmentClassEnum@STANDARD}"/>
		<s:select key="adultTicketAmount" label="全票" list='#{0:0, 1:1, 2:2, 3:3, 4:4, 5:5, 6:6, 7:7, 8:8, 9:9 }'  value="%{1}"/>
		<s:select key="childTickenAmount" label="孩童票(6-10歲)" list='#{0:0, 1:1, 2:2, 3:3, 4:4, 5:5, 6:6, 7:7, 8:8, 9:9 }' />
		<s:select key="disabledTicketAmount" label="愛心票" list='#{0:0, 1:1, 2:2, 3:3, 4:4, 5:5, 6:6, 7:7, 8:8, 9:9 }' />
		<s:select key="seniorTicketAmount" label="敬老票(65歲以上)" list='#{0:0, 1:1, 2:2, 3:3, 4:4, 5:5, 6:6, 7:7, 8:8, 9:9 }' />
		<s:submit value="送出" />
	</s:form>
</div>