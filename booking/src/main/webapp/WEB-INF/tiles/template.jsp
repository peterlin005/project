<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<style type="text/css">
body {
	background-color:CCCCFF;
	font-family: 標楷體;
}

a:LINK,a:VISITed {
	text-decoration: none;
}

a:HOVER  {
	font-weight: bolder;
	cursor: pointer;
}

#systemNameDiv {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 1024px;
 	line-height:80px;
	font-size:  30px;
	font-weight: bolder;
	text-align: center;
	vertical-align:bottom;
	border-bottom:#AAA 1px solid;
}

 #systemNameDiv:HOVER { 
 	font-size:35; 
 	cursor: pointer; 
 } 

#operationDiv {
	position: absolute;
	top: 60px;
	left: 900px;
	width: 124px;
	font-size: 15px;
	text-align: right;
}

#menuDiv {
	position: absolute;
	top: 100px;
	left: 0px;
	width: 200px;
	padding: 10px;
	font-size: 15px;
}

.contentDiv {
	position: absolute;
	top: 100px;
	left: 200px;
	width: 824px;
	padding: 10px;
	font-size: 15px;
}

.trainId {
	text-align: right;
}

.direction,.time , .trainCompartmentClass, .station , .amount {
	text-align: center;
}

.button {
	text-align: right;
}

.tableHeader  th{
	border-bottom:thin solid red;
}

.tableData td{
	border-bottom:thin dotted red;
}

.tableData:hover {
	background: CCFF99;
}

.important{
	font-weight: bolder;
	color: 993333;
}

</style>
<s:head theme="xhtml" />
<sx:head extraLocales="UTF-8"/>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="body" />
</body>
</html>