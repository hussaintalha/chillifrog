<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Asset Allocation</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/stylesheets1/style.css" />
</head>
<body>

<div class="tabs">
    <ul class="tab-links">
        <li class="active"><a href="/chillifrog/assetallocationconfigs" style="text-decoration: none;">Asset Allocation</a></li>
        <li><a href="/chillifrog/spendingrateconfigs/" style="text-decoration: none;">Spending Rates</a></li>
        <li><a href="/chillifrog/dividenttaxrates" style="text-decoration: none;">Dividend Tax Rate</a></li>
        <li><a href="/chillifrog/incometax" style="text-decoration: none;">IncomeTaxRate</a></li>
         <li> <a href="/chillifrog/capitalgain" style="text-decoration: none;">Capital Gains Tax Rate</a></li>
    </ul>
    <div class="tab-content">
        <div  class="tab active">
        	<jsp:include page="assetallocation.jsp"></jsp:include>
        	<%-- <c:if test="${id == 0}">
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
	</form:form> --%>
        	
        </div>
 
        
    </div>
</div>
</body>
</html>