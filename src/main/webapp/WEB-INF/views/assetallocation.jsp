<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>AssetAllocationConfig Page</title>
<style type="text/css">

</style>
</head>
<body>
	<c:if test="${id == 0}">
		<c:url var="addAction" value="/assetAllocationConfig/add"></c:url>
	</c:if>

	<c:if test="${id > 0}">
		<c:url var="addAction" value="/assetAllocationConfig/update/"></c:url>
	</c:if>
	<form:form action="${addAction}" commandName="assetAllocationConfig"
		method="POST">
		<table>
			<tr>
				<td><form:label path="percentageInStock">
						<spring:message text="PercentageInStock" />
					</form:label></td>
				<td><form:input path="percentageInStock" size="8" /> <spring:message
						text="%" /></td>
			</tr>

			<tr>
				<td><form:label path="percentageInCash">
						<spring:message text="PercentageInCash" />
					</form:label></td>
				<td><form:input path="percentageInCash" size="8" /> <spring:message
						text="%" /></td>
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


</body>
</html>