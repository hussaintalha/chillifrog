<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>DividentTaxRates Page</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/stylesheets1/style.css" />
</head>
<body>

	<div class="tabs">
		<ul class="tab-links">
			<li><a href="/chillifrog/assetallocationconfigs"
				style="text-decoration: none;">Asset Allocation</a></li>
			<li><a href="/chillifrog/spendingrateconfigs/"
				style="text-decoration: none;">Spending Rates</a></li>
			<li class="active"><a href="/chillifrog/dividenttaxrates"
				style="text-decoration: none;">Dividend Tax Rate</a></li>
			<li><a href="/chillifrog/incometax"
				style="text-decoration: none;">IncomeTaxRate</a></li>
			<li><a href="/chillifrog/capitalgain"
				style="text-decoration: none;">Capital Gains Tax Rate</a></li>
		</ul>


		<!-- <h1>Add DividentTaxRates</h1> -->

		<c:url var="addAction" value="/dividenttaxrates/add"></c:url>

		<form:form action="${addAction}" commandName="dividenttaxrates">
			<table>



				<c:if test="${!empty dividentTaxRates.yearValue}">
					<tr>
						<td><form:label path="dividentTaxID">
								<spring:message text="DividentTaxID" />
							</form:label></td>
						<td><form:input path="dividentTaxID" readonly="true" size="8"
								disabled="true" /> <form:hidden path="dividentTaxID" /></td>
					</tr>
				</c:if>


				<tr>
					<td><form:label path="countryID">
							<spring:message text="Country ID" />
						</form:label></td>
					<td><form:input path="countryID" /> <%-- <form:select path="countryID">
    				<c:forEach var="country" items="${countryList}" >
						<form:option value="${country.id}" label="${country.countryName}"/>
					</c:forEach>
    		</form:select> --%></td>
				</tr>


				<tr>
					<td><form:label path="yearValue">
							<spring:message text="Year" />
						</form:label></td>
					<td><form:input path="yearValue" size="8" /> <form:hidden
							path="yearValue" /></td>
				</tr>
				<tr>
					<td><form:label path="dividenttaxRate">
							<spring:message text="Tax Rate" />
						</form:label></td>
					<td><form:input path="dividenttaxRate" size="8" /> <spring:message
							text="%" /> <form:hidden path="dividenttaxRate" /></td>

				</tr>

				<tr>
					<td colspan="2"><c:if
							test="${!empty dividentTaxRates.yearValue}">
							<input type="submit"
								value="<spring:message text="Edit DividentTaxRates"/>" />
						</c:if> <c:if test="${empty dividentTaxRates.yearValue}">
							<input type="submit"
								value="<spring:message text="Add DividentTaxRates"/>" />
						</c:if></td>
				</tr>
			</table>
		</form:form>
		<br>
		<h3>DividentTaxRates List</h3>
		<c:if test="${!empty listDividentTaxRates}">
			<table class="tg">
				<tr>
					<th width="80">DividentTaxID</th>
					<th width="120">YearValue</th>
					<th width="120">DividenttaxRate</th>
					<th width="120">CountryId</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listDividentTaxRates}" var="dividenttaxrates">
					<tr>
						<td>${dividenttaxrates.dividentTaxID}</td>
						<td>${dividenttaxrates.yearValue}</td>
						<td>${dividenttaxrates.dividenttaxRate}</td>
						<td>${dividenttaxrates.countryID}</td>
						<td><a
							href="<c:url value='/editDividentTaxRates/${dividenttaxrates.dividentTaxID}' />">Edit</a></td>
						<td><a
							href="<c:url value='/removeDividentTaxRates/${dividenttaxrates.dividentTaxID}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

</body>
</html>