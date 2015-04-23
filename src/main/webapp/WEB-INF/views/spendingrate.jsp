<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SpendingRates page</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/stylesheets1/style.css" />

</head>
<body>
<div class="tabs">	
	<ul class="tab-links">
        <li ><a href="/chillifrog/assetallocationconfigs" style="text-decoration: none;">Asset Allocation</a></li>
        <li class="active"><a href="/chillifrog/spendingrateconfigs/" style="text-decoration: none;">Spending Rates</a></li>
        <li><a href="/chillifrog/dividenttaxrates" style="text-decoration: none;">Dividend Tax Rate</a></li>
        <li><a href="/chillifrog/incometax" style="text-decoration: none;">IncomeTaxRate</a></li>
    </ul>

	<c:if test="${id == 0}">
		<c:url var="addAction" value="/spendingrateconfig/add"></c:url>
	</c:if>

	<c:if test="${id > 0}">
		<c:url var="addAction" value="/spendingrateconfig/update"></c:url>
	</c:if>
	<form:form action="${addAction}" commandName="spendingrate" method="POST">
		<table>
			<tr>
				<td><form:label path="spendingRate0to75">
						<spring:message text="Spending Rate(0 to 75,000)" />
					</form:label></td>
				<td><form:input path="spendingRate0to75" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="spendingRate75001to120000">
						<spring:message text="Spending Rate(75,000 to 120,000)" />
					</form:label></td>
				<td><form:input path="spendingRate75001to120000" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="spendingRate120001to300000">
						<spring:message text="Spending Rate(120,001 to 300,000)" />
					</form:label></td>
				<td><form:input path="spendingRate120001to300000" size="8" />
					<spring:message text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="spendingRate300001to1M">
						<spring:message text="Spending Rate(300,001 to 1,000,000)" />
					</form:label></td>
				<td><form:input path="spendingRate300001to1M" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="spendingRate1M1to5M">
						<spring:message text="Spending Rate(1,000,001 to 5,000,000)" />
					</form:label></td>
				<td><form:input path="spendingRate1M1to5M" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="spendingRate5M1to15M">
						<spring:message text="Spending Rate(5,000,001 to 15,000,000)" />
					</form:label></td>
				<td><form:input path="spendingRate5M1to15M" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="spendingRate15M1to50M">
						<spring:message text="Spending Rate(15,000,001 to 50,000,000)" />
					</form:label></td>
				<td><form:input path="spendingRate15M1to50M" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="spendingRate50M1to500M">
						<spring:message
							text="Spending Rate(50,000,001 to 500,000,000,000)" />
					</form:label></td>
				<td><form:input path="spendingRate50M1to500M" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="unexercisableDiscount">
						<spring:message text="Unexercisable Discount" />
					</form:label></td>
				<td><form:input path="unexercisableDiscount" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="stateIncometaxAddition">
						<spring:message text="State Income Tax Addition" />
					</form:label></td>
				<td><form:input path="stateIncometaxAddition" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="stateIncometaxMarkUp">
						<spring:message text="State Income Tax Mark-Up" />
					</form:label></td>
				<td><form:input path="stateIncometaxMarkUp" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="localandStateTax">
						<spring:message text="local And State Tax" />
					</form:label></td>
				<td><form:input path="localandStateTax" size="8" /> <spring:message
						text="%" /></td>
			</tr>
			<tr>
				<td><form:label path="maximumSpendingAmount">
						<spring:message text="Maximum Spending Amount" />
					</form:label></td>
				<td><form:input path="maximumSpendingAmount" size="8" /></td>
			</tr>
			<tr>
				<td><form:label path="minimumSpendingAmount">
						<spring:message text="MinimumSpending Amount" />
					</form:label></td>
				<td><form:input path="minimumSpendingAmount" size="8" />
			</tr>
			<tr>
				<td><form:label path="pre1985IncomeDiscountFactor">
						<spring:message text="Pre-1985 Income Discount Factor" />
					</form:label></td>
				<td><form:input path="pre1985IncomeDiscountFactor" size="8" />
					<spring:message text="%" /></td>
			</tr>


			<tr>
				<c:if test="${id == 0}">
					<td><input type="submit" value="Save" /></td>
				</c:if>

				<c:if test="${id > 0}">
					<td><input type="submit" value="Update" /></td>
				</c:if>

			</tr>
		</table>

	</form:form>
</div>	
</body>
</html>