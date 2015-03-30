<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="contentDiv">
	<s:form action="login">
		<s:token />
		<s:label value="登入" />
		<s:textfield label="身份證字號" key="personalId" />
		<s:password label="密碼" key="password" />
		<s:submit value="送出" />
	</s:form>
</div>