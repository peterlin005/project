<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<div class="contentDiv">
	<s:form action="queryTimetable">
		<s:token />
		<s:label value="查詢時刻表" />
		<sx:datetimepicker key="date"  label="日期"  language="UTF-8" displayFormat="yyyy/MM/dd" />
		<s:select key="startStation" label="起程站" list="%{@idv.hsiehpinghan.thsr.enumeration.StationEnum@getEnumMap()}" />
		<s:select key="destinationStation" label="到達站" list="%{@idv.hsiehpinghan.thsr.enumeration.StationEnum@getEnumMap()}" />
		<s:submit value="送出" />
	</s:form>
</div>