<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:set var="actionName" value="actionName" />
<s:url id="localeTw" namespace="/stock" action="%{actionName}">
	<s:param name="request_locale">zh_TW</s:param>
</s:url>
<s:url id="localeEn" namespace="/stock" action="%{actionName}">
	<s:param name="request_locale">en</s:param>
</s:url>
<style type="text/css">
#navheader {
	margin: 15px;
}
</style>
<nav id="navheader" role="navigation" class="navbar navbar-default">
	<div class="navbar-header">
		<button type="button" data-target="#navContent" data-toggle="collapse" class="navbar-toggle">
			<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a href="companyInfo" class="navbar-brand"><s:property value="companyName" /></a>
	</div>
	<div id="navContent" class="collapse navbar-collapse">
		<ul class="nav navbar-nav">
			<li><a href="transactionInfo"><s:date name="date" format="yyyy/MM/dd" /> &nbsp;&nbsp;&nbsp;&nbsp; <span style="color: black; font-weight: bold;"> <s:number name="closingPrice" />
				</span> ( <s:if test="change > 0">
						<span style="color: red"> <span class="glyphicon glyphicon-arrow-up"></span> <s:number name="change" />
						</span>

					</s:if> <s:elseif test="change < 0">
						<span style="color: green"> <span class="glyphicon glyphicon-arrow-down"></span> <s:number name="change" />
						</span>
					</s:elseif> <s:else>
						<s:number name="change" />
					</s:else> ) </a></li>
		</ul>
		<form role="search" class="navbar-form navbar-left" action='<s:property value="actionName"/>'>
			<div class="row">
				<div class="col-xs-8">
					<input name="criteria.stockCode" value='<s:property value="stockCode"/>' type="text" placeholder='<s:text name="package.stockCode" />' class="form-control">
				</div>
				<div class="col-xs-4">
					<button type="submit" class="btn btn-success">
						<span class="glyphicon glyphicon-search "></span>
					</button>
				</div>
			</div>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a data-toggle="dropdown" class="dropdown-toggle" href="#"><s:text name="package.language"></s:text> <b class="caret"></b></a>
				<ul role="menu" class="dropdown-menu">
					<li><s:a href="%{localeTw}">繁體中文</s:a></li>
					<li><s:a href="%{localeEn}">English</s:a></li>
				</ul></li>
		</ul>
	</div>
</nav>