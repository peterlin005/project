<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/stare-project/javascript/bootstrap-3.3.2-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/stare-project/javascript/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css">
<script src="/stare-project/javascript/jquery-1.11.2/jquery-1.11.2.min.js"></script>
<script src="/stare-project/javascript/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<script src="/stare-project/javascript/jquery-cookie-1.4.1/jquery.cookie.js"></script>
<title><s:text name="action.htmlHeadTitle" /></title>
</head>
<body>
	<s:include value="include/stockHeader.jsp" />
	<div class="container-fluid">
		<div class="row">
			<s:include value="include/stockSidebar.jsp" />
			<div class="col-sm-9 col-md-10 main">
				<ul id="companyInfoTags" class="nav nav-tabs">
					<li><a data-toggle="tab" href="#basicInfo"><b><span class="glyphicon glyphicon-menu-hamburger"></span> <s:text name="action.basicInfo" /></b></a></li>
					<li><a data-toggle="tab" href="#managers"><b><span class="glyphicon glyphicon-user"></span> <s:text name="action.managers" /></b></a></li>
					<li><a data-toggle="tab" href="#communication"><b><span class="glyphicon glyphicon-comment"></span> <s:text name="action.communication" /></b></a></li>
					<li><a data-toggle="tab" href="#accountingInfo"><b><span class="glyphicon glyphicon-file"></span> <s:text name="action.accountingInfo" /></b></a></li>
				</ul>
				<div class="tab-content">
					<div id="basicInfo" class="tab-pane fade in active">
						<div class="container">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.marketType" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="%{companyFamily.marketType.getName(getLocale())}" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.industryType" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="%{companyFamily.industryType.getName(getLocale())}" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.chineseName" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.chineseName" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.englishBriefName" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.englishBriefName" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.unifiedBusinessNumber" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.unifiedBusinessNumber" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.establishmentDate" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.establishmentDate" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.listingDate" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.listingDate" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
							</div>
						</div>
					</div>
					<div id="managers" class="tab-pane fade">
						<div class="container">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.chairman" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.chairman" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.generalManager" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.generalManager" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.spokesperson" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										(
										<s:property value="companyFamily.jobTitleOfSpokesperson" />
										)
										<s:property value="companyFamily.spokesperson" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.actingSpokesman" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.actingSpokesman" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
							</div>
						</div>
					</div>
					<div id="communication" class="tab-pane fade">
						<div class="container">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.faxNumber" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<s:property value="companyFamily.faxNumber" />
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.telephone" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.telephone" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.stockTransferAgency" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.stockTransferAgency" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.telephoneOfStockTransferAgency" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.telephoneOfStockTransferAgency" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.addressOfStockTransferAgency" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-9 col-lg-9">
									<p>
										<s:property value="companyFamily.addressOfStockTransferAgency" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.englishAddress" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-9 col-lg-9">
									<p>
										<s:property value="companyFamily.englishAddress" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.chineseAddress" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-9 col-lg-9">
									<p>
										<s:property value="companyFamily.chineseAddress" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.email" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-9 col-lg-9">
									<p>
										<a href='mailto:<s:property value="companyFamily.email" />'> <s:property value="companyFamily.email" />
										</a>
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.webSite" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-9 col-lg-9">
									<p>
										<a href='<s:property value="companyFamily.webSite" />'> <s:property value="companyFamily.webSite" />
										</a>
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
							</div>
						</div>
					</div>
					<div id="accountingInfo" class="tab-pane fade">
						<div class="container">
							<div class="row">
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.financialReportType" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.financialReportType" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.parValueOfOrdinaryShares" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.parValueOfOrdinaryShares" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.paidInCapital" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.paidInCapital" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.amountOfOrdinaryShares" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.amountOfOrdinaryShares" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.privatePlacementAmountOfOrdinaryShares" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.privatePlacementAmountOfOrdinaryShares" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.amountOfPreferredShares" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.amountOfPreferredShares" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.accountingFirm" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.accountingFirm" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.accountant_1" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.accountant1" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p align="center">
										<b> <s:text name="action.accountant_2" />
										</b>
									</p>
								</div>
								<div class="col-xs-6 col-sm-6 col-md-3 col-lg-3">
									<p>
										<s:property value="companyFamily.accountant2" />
									</p>
								</div>
								<div class="clearfix visible-xs-block"></div>
								<div class="clearfix visible-sm-block"></div>
								<div class="clearfix visible-md-block"></div>
								<div class="clearfix visible-lg-block"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	var COMPANY_INFO_TAG_INDEX = "companyInfoTagIndex";
	var companyInfoTagIndex = $.cookie(COMPANY_INFO_TAG_INDEX) == null ? 0 : $
			.cookie(COMPANY_INFO_TAG_INDEX);
	$("#companyInfoTags li:eq('" + companyInfoTagIndex + "') a").tab("show");
	$("#companyInfoTags > li").on("click", function() {
		$.cookie(COMPANY_INFO_TAG_INDEX, $(this).index());
	});
</script>
</html>