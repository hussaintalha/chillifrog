<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TaxFormula Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>

<c:url var="addAction" value="/taxFormulaInformation/add" ></c:url>
	<form:form name="taxForm" commandName="taxFormulaInformation"
		method="POST" action="${addAction }">
		
		<form:hidden path="taxFormulId"/>
		
		<table>
			<tr>
				<td><form:label path="yearValue">
						<spring:message text="Year" />
					</form:label></td>
				<td><form:select path="yearValue">
						<form:option value="0" label="--Select Year---" />
						<c:forEach var="year" items="${yearList}">
							<form:option value="${year}" label="${year}"  >
							</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="rangeFrom">
						<spring:message text="Range From" />
					</form:label></td>
				<td><form:input path="rangeFrom" /></td>
			</tr>
			<tr>
				<td><form:label path="rangeTo">
						<spring:message text="Range To" />
					</form:label></td>
				<td><form:input path="rangeTo" /></td>
			</tr>
			<tr>
				<td><form:label path="Formula">
						<spring:message text="Formula" />
					</form:label></td>
				<td><form:textarea path="Formula" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" /></td>
				<td><input type="reset" value="Cancel"  /></td>
			</tr>
		</table>

		<table class="tg" border="1" cellpadding="0">
			<tr>
				<th width="80">No</th>
				<th width="120">Year</th>
				<th width="120">Inflation Rate</th>
				<th width="120">Formula</th>
				<th width="120">Last Updated</th>
				<th width="120">Last Updated By</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listTaxFormulaInformation}" var="taxformulas">
				<tr>
					<td>${taxformulas.taxFormulId}</td>
					<td>${taxformulas.yearValue}</td>
					<td>${taxformulas.rangeFrom} - ${taxformulas.rangeTo}</td>
					<td>${taxformulas.getFormula()}</td>
					<td>${taxformulas.updaterID}</td>
					<td>${taxformulas.updatedDate}</td>
					<td><a
						href="<c:url value='/editTaxFormulaInformation/${taxformulas.taxFormulId}' />">Edit</a></td>
					<td><a
						href="<c:url value='/removeTaxFormulaInformation/${taxformulas.taxFormulId}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</form:form>
</body>
</html>