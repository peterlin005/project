<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<div id="systemNameDiv" onclick=" window.location = '<s:url action="welcome"  />' " >網路訂票系統</div>
<div id="operationDiv">
	<s:if test="%{#session.user==null}">
		<a href="showLoginPage">登入</a>
		<a href="showRegisterPage">註冊</a>
	</s:if>
	<s:else>
		<a href="logout">登出</a>
	</s:else>
</div>