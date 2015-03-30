<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>

<div id="menuDiv">
	<s:if test="%{#session.user==null}">
		<sx:tree label="未登入" id="menu" showRootGrid="true" showGrid="true" />
	</s:if>
	<s:else>
		<sx:tree label="網路訂票系統" id="menu" showRootGrid="true" showGrid="true">
			<sx:treenode id=" thsr" label="台灣高速鐵路">
				<sx:treenode id="queryTimetable" label="<a href='showQueryTimetablePage' >查詢火車時刻表</a>" />
				<sx:treenode id="showOrder" label="<a href='showOrder' >查詢訂票紀錄</a>" />
			</sx:treenode>
		</sx:tree>
	</s:else>
</div>
