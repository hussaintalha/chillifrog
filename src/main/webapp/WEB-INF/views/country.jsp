<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
    <title>Country Page</title>
    <style type="text/css">
        .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
        .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
        .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
        .tg .tg-4eph{background-color:#f9f9f9}
    </style>
</head>
<body>
<h1>
     Add Country
</h1>
 
<c:url var="addAction" value="/country/add" ></c:url>
 
<form:form action="${addAction}" commandName="country">
<table>
    <c:if test="${!empty country.countryName}">
    <tr>
        <td>
            <form:label path="id">
                <spring:message text="ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="id" readonly="true" size="8"  disabled="true" />
            <form:hidden path="id" />
        </td>
    </tr>
       </c:if>
    
    <tr>
        <td>
            <form:label path="countryName">
                <spring:message text="CountryName"/>
            </form:label>
        </td>
            <td>
            <form:input path="countryName" />
        </td>
            </tr>
    <tr>
        <td colspan="2">
            <c:if test="${!empty country.countryName}">
                <input type="submit"
                    value="<spring:message text="Edit Country"/>" />
            </c:if>
            <c:if test="${empty country.countryName}">
                <input type="submit"
                    value="<spring:message text="Add Country"/>" />
            </c:if>
        </td>
    </tr>
</table> 
</form:form>
<br>
<h3>Countries List</h3>
<c:if test="${!empty listCountrys}">
    <table class="tg">
    <tr>
        <th width="80">Country ID</th>
        <th width="120">Country Name</th>
        <th width="120">Version</th>
        <th width="120">IncludeInEthnicityAnnotation</th>
        <th width="120">Capital</th>
        <th width="120">Currency</th>
        <th width="120">ISO</th>
        <th width="120">PrimaryLanguage</th>
        <th width="120">Latitude</th>
        <th width="120">Longitude</th>
        <th width="60">Edit</th>
        <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listCountrys}" var="country">
        <tr>
            <td>${country.id}</td>
            <td>${country.countryName}</td>
            <td>${country.version}</td>
            <td></td>
            <td>${country.capital}</td>
            <td>${country.currency}</td>
            <td>${country.iso}</td>
            <td>${country.primaryLanguage}</td>
            <td>${country.latitude}</td>
            <td>${country.longitude}</td>
            <td><a href="<c:url value='/editCountry/${country.id}' />" >Edit</a></td>
            <td><a href="<c:url value='/removeCountry/${country.id}' />" >Delete</a></td>
        </tr>
    </c:forEach>
    </table>
</c:if>
</body>
</html>