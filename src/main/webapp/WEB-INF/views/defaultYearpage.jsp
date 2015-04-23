<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<title>Assets Page</title>
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
	<c:if test="${id == 0}">
		<c:url var="addAction" value="/defaultyear/add"></c:url>
	</c:if>

	<c:if test="${id > 0}">
		<c:url var="addAction" value="/defaultyear/update/"></c:url>
	</c:if>
	<form:form action="${addAction}" commandName="defaultYear"
		method="POST">
		<table>
			<tr>
				<td><form:label path="defaultYearID">
						<spring:message text="Default Value" />
					</form:label></td>
				<td><form:input path="defaultYearID" size="8" />
			</tr>
			<tr>
				<td><form:label path="preStartingYear">
						<spring:message text="Prestarting Year" />
					</form:label></td>
				<td><form:input path="preStartingYear" size="8" />
			</tr>
			<tr>
				<td><form:label path="preYearValue">
						<spring:message text="Pre-Year Value" />
					</form:label></td>
				<td><form:input path="preYearValue" size="8" />
			</tr>
			<tr>
				<td><sf:label path="typeID">
						<spring:message text="Type Of Function" />
					</sf:label></td>
				<td><sf:select path="typeID">
						<c:forEach var="item" items="${listAssetType}">
							<option value="${item.id}">${item.assetTypeName}</option>
						</c:forEach>
					</sf:select></td>
			</tr>
			<tr>
				<td><sf:label path="countryID">
						<spring:message text="Country" />
					</sf:label></td>
				<td><sf:select path="countryID">
						<c:forEach var="item" items="${listAssetType}">
							<option value="${item.id}">${item.assetTypeName}</option>
						</c:forEach>
					</sf:select></td>
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
			
			<table class="tg" border="1" cellpadding="0">
				<tr>
					<th width="80">Default Value</th>
					<th width="120">PreStarting Year</th>
					<th width="120">PreYear Value</th>
					<th width="120">Type</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listTaxFormulaInformation}" var="defaultyear">
					<tr>
						<td>${defaultyear.defaultValue}</td>
						<td>${defaultyear.preStartingYear}</td>
						<td>${defaultyear.preYearValue()}</td>
						<td>${defaultyear.typeID}</td>

						<td><a
							href="<c:url value='/editTaxFormulaInformation/${defaultyear.taxFormulId}' />">Edit</a></td>
						<td><a
							href="<c:url value='/removeTaxFormulaInformation/${defaultyear.taxFormulId}' />">Delete</a></td>
					</tr>
				</c:forEach>

			</table>
			</form:form>
</body>
</html>