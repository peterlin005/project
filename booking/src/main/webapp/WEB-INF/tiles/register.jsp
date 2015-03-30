<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="contentDiv">
	<s:form action="register">
		<s:token />
		<s:label value="註冊" />
		<s:textfield name="personalId" label="身份證字號" />
		<s:password name="password" label="密碼" />
		<s:password name="confirmPassword" label="確認密碼" />
		<s:textfield name="mobilePhoneNumber" label="手機" />
		<s:textfield name="email" label="電子信箱" />
		<s:submit value="送出" />
	</s:form>
</div>