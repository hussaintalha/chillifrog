<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function clearText() {
		//alert("yearvalue"+document.getElementById('yearValueId').value);
		document.getElementById('yearValueId').value = 0;
		//alert("yearvalue"+document.getElementById('yearValueId').value);
		//alert("inflationRateId"+document.getElementById('inflationRateId').value);
		document.getElementById('inflationRateId').value = "";
		//alert("inflationRateId"+document.getElementById('inflationRateId').value);
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url var="addInflationAction" value="/inflation/add"></c:url>
	<form:form action="${addInflationAction}" commandName="inflationRate"
		method="POST">
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
				<td><form:label path="inflationRate">
						<spring:message text="InflationRate" />
					</form:label></td>
				<td><form:input path="inflationRate" id="inflationRateId" /> <spring:message
						text="%" /> <form:hidden path="inflationRateID" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save" /></td>
				<td><input type="button" value="Clear" onclick="clearText()" /></td>
			</tr>
		</table>

		<c:if test="${!empty listInflationRate}">
			<table class="tg" border="1" cellpadding="0">
				<tr>
					<th width="80">No</th>
					<th width="120">Year</th>
					<th width="120">Inflation Rate</th>
					<th width="120">Last Updated</th>
					<th width="120">Last Updated By</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listInflationRate}" var="inflation">
					<tr>
						<td>${inflation.inflationRateID}</td>
						<td>${inflation.yearValue}</td>
						<td>${inflation.inflationRate}</td>
						<td>${inflation.updatedDate}</td>
						<td>${inflation.updaterID}</td>
						<td><a
							href="<c:url value='/editInflation/${inflation.inflationRateID}' />">Edit</a></td>
						<td><a
							href="<c:url value='/removeInflation/${inflation.inflationRateID}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</body>

</html>