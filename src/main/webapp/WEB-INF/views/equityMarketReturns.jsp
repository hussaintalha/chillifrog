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
		document.getElementById('equityMarketId').value = "";
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:url var="addEquityAction" value="/equityMarket/add"></c:url>
	<form:form action="${addEquityAction}"
		commandName="equityMarketReturns" method="POST">
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
				<td><form:label path="equityMarketReturnRate">
						<spring:message text="EquityMarketReturnRate" />
					</form:label></td>
				<td><form:input path="equityMarketReturnRate"
						id="equityMarketId" /> <spring:message text="%" />
					<form:hidden path="equityMarketID" /></td>
			</tr>


			<tr>
				<td><input type="submit" value="Save" /></td>
				<td><input type="button" value="Clear" onclick="clearText()" /></td>
			</tr>
		</table>
		<c:if test="${!empty listEquityMarketReturns}">
			<table class="tg" border="1" cellpadding="0">
				<tr>
					<th width="80">No</th>
					<th width="120">Year</th>
					<th width="120">EquityMarket Rate</th>
					<th width="120">Last Updated</th>
					<th width="120">Last Updated By</th>
					<th width="60">Edit</th>
					<th width="60">Delete</th>
				</tr>
				<c:forEach items="${listEquityMarketReturns}" var="equityMarket">
					<tr>
						<td>${equityMarket.equityMarketID}</td>
						<td>${equityMarket.yearValue}</td>
						<td>${equityMarket.equityMarketReturnRate}</td>
						<td>${equityMarket.updatedDate}</td>
						<td>${equityMarket.updaterID}</td>
						<td><a
							href="<c:url value='/editequityMarket/${equityMarket.equityMarketID}' />">Edit</a></td>
						<td><a
							href="<c:url value='/removeequityMarket/${equityMarket.equityMarketID}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</body>
</html>