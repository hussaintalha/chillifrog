<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function clearText() {
		document.getElementById('yearValueId').value = 0;
		document.getElementById('capitalgainstaxRateId').value = "";
	}
</script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/stylesheets1/style.css" />
</head>
<body>
<div class="tabs">	
	<ul class="tab-links">
        <li ><a href="/chillifrog/assetallocationconfigs" style="text-decoration: none;">Asset Allocation</a></li>
        <li ><a href="/chillifrog/spendingrateconfigs/" style="text-decoration: none;">Spending Rates</a></li>
        <li ><a href="/chillifrog/dividenttaxrates" style="text-decoration: none;">Dividend Tax Rate</a></li>
        <li ><a href="/chillifrog/incometax" style="text-decoration: none;">IncomeTaxRate</a></li>
        <li class="active"> ><a href="/chillifrog/capitalgain" style="text-decoration: none;">Capital Gains Tax Rate</a></li>
    </ul>


	<!-- <h1>Add DividentTaxRates</h1> -->

	<c:url var="addCapitalGainsTaxRateAction" value="/capitalgain/add"></c:url>
	<form:form action="${addCapitalGainsTaxRateAction}"
		commandName="capitalGainsTaxRate" method="POST">
		<table>
			<tr>
				<!-- <td><input type="submit" value="Add" /></td> -->
				<td><form:label path="yearValue">
						<spring:message text="Year" />
					</form:label></td>

				<td><form:select path="yearValue" id="yearValueId">
						<form:option value="0" label="--Select Year---" />
						<c:forEach var="year" items="${yearList}">
							<form:option value="${year}" label="${year}" />
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="capitalgainstaxRate">
						<spring:message text="CapitalGainstax Rate" />
					</form:label></td>
				<td><form:input path="capitalgainstaxRate"
						id="capitalgainstaxRateId" />
					<spring:message text="%" /> <form:hidden path="capitalGainrateID" /></td>
			<tr>
				<td><input type="submit" value="Save" /></td>
				<td><input type="button" value="Clear" onclick="clearText()" /></td>
			</tr>
		</table>
		<c:if test="${!empty listCapitalGainsTaxRate}">
			<table class="tg" border="1" cellpadding="0">
				<tr>
					<th width="80">No</th>
					<th width="120">Year</th>
					<th width="120">Capital Gains tax Rate</th>
					<th width="120">Last Updated</th>
					<th width="120">Last Updated By</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listCapitalGainsTaxRate}" var="capitalgain">
					<tr>
						<td>${capitalgain.capitalGainrateID}</td>
						<td>${capitalgain.yearValue}</td>
						<td>${capitalgain.capitalgainstaxRate}</td>
						<td>${capitalgain.updatedDate}</td>
						<td>${capitalgain.updaterID}</td>
						<td><a
							href="<c:url value='/editcapitalgain/${capitalgain.capitalGainrateID}' />">Edit</a></td>
						<td><a
							href="<c:url value='/removecapitalgain/${capitalgain.capitalGainrateID}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</div>
</body>
</html>