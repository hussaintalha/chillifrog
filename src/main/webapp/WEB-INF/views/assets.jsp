<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ page session="false"%>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/combodate.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/moment.js"></script>
<title>Assets Page</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 10px;
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
	font-size: 10px;
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
<c:url var="contextPath" value="/" />

<script>
$(function(){
	
    $('#date').combodate({
    	minYear: 1950
    });    
    
});
</script>
</head>
<script type="text/javascript">
function getForexRate(){
	var currencyLocal = $('#currencyFrom').val();
    $.ajax({
        url : "<%=request.getContextPath()%>/assets/fxrate",
        		data:{currency:$("#currencyFrom").val()},
        		dataType : "json",
        		headers: { 
        		    Accept : "application/json"
        		},
	success : function(data) {
			$("#currencyRate").val(data);
			$("#localcurrency").empty();
			$("#localcurrency").append("("+currencyLocal+")");
//			var fxRate = data;
//			var actualValueOfHolding = $("#valueofHolidingLocalCurrency").val();
//			$("#valueofHoldingForeign").val((actualValueOfHolding / fxRate));

			calculateActualValueOfHolding();
	}
    });
}
function calculateActualValueOfHolding(){
	var fxRate = $("#currencyRate").val();
	var actualValueOfHolding = $("#valueofHolidingLocalCurrency").val();
	$("#valueofHoldingForeign").val((actualValueOfHolding / fxRate).toFixed(5));

    $.ajax({
        url : "<%=request.getContextPath()%>/assets/roundingOff",
			data : {
				actualAmount : (actualValueOfHolding)
			},
			dataType : "json",
			headers : {
				Accept : "application/json"
			},
			success : function(data) {
			$("#roundedValueofHolding").val(data);
			}
		});
	}
</script>
<body>
	<h1>Add new Asset</h1>
	<c:url var="contextPath" value="/" />
	<c:url var="addAction" value="/assets/add"></c:url>

	<sf:form action="${addAction}" commandName="assets">
		<table>
			<c:if test="${!empty assets.assetName}">
				<tr>
					<td><sf:label path="id">
							<spring:message text="ID" />
						</sf:label></td>
					<td><sf:input path="id" readonly="true" size="8"
							disabled="true" /> <sf:hidden path="id" /></td>
				</tr>
			</c:if>

			<tr>
				<td><sf:label path="profileId">
						<spring:message text="Profile Id" />
					</sf:label></td>
				<td><sf:input path="profileId" /></td>
			</tr>

			<tr>
				<td><sf:label path="assetClass">
						<spring:message text="Asset Class" />
					</sf:label></td>
				<td><sf:select path="assetClass">
						<sf:option value="liquidassets">Liquid Assets</sf:option>
						<sf:option value="illliquidassets">Ill Liquid Assets</sf:option>
						<sf:option value="property">property</sf:option>
					</sf:select></td>
			</tr>


			<tr>
				<td><sf:label path="assetTypeID">
						<spring:message text="Asset Type" />
					</sf:label></td>
				<td><sf:select path="assetTypeID">
						<c:forEach var="item" items="${listAssetType}">
							<option value="${item.id}">${item.assetTypeName}</option>
						</c:forEach>
					</sf:select></td>
			</tr>

			<tr>
				<td><sf:label path="assetName">
						<spring:message text="Asset Name" />
					</sf:label></td>
				<td><sf:input path="assetName" /></td>
			</tr>

			<tr>
				<td><sf:label path="assetDescription">
						<spring:message text="Asset Description" />
					</sf:label></td>
				<td><sf:input path="assetDescription" /></td>
			</tr>

			<tr>
				<td><sf:label path="assetRemarks">
						<spring:message text="Asset Remarks" />
					</sf:label></td>
				<td><sf:input path="assetRemarks" /></td>
			</tr>

			<tr>
				<td><sf:label path="currencyFrom">
						<spring:message text="Currency" />
					</sf:label></td>
				<td><sf:select path="currencyFrom" onclick="getForexRate();">
						<c:forEach items="${currency}" var="currency">
							<sf:option value="${currency.iso_currency}">${currency.iso_currency}</sf:option>
						</c:forEach>
					</sf:select> FX Rate <sf:input path="currencyRate" readonly="true" /></td>
			</tr>
			<tr>
				<td><sf:label path="valueofHolidingLocalCurrency">
						<spring:message text="Actual value of holding" />
						<div id="localcurrency"></div>
					</sf:label></td>
				<td><sf:input path="valueofHolidingLocalCurrency"
						onchange="calculateActualValueOfHolding();" /></td>
			</tr>

			<tr>
				<td><sf:label path="valueofHoldingForeign">
						<spring:message text="Actual value of holding USD" />
					</sf:label></td>
				<td><sf:input path="valueofHoldingForeign" readonly="true" /></td>
			</tr>

			<tr>
				<td><sf:label path="roundedValueofHolding">
						<spring:message text="Rounded value of holding" />
					</sf:label></td>
				<td><sf:input path="roundedValueofHolding" readonly="true" /></td>
			</tr>

			<tr>
				<td><sf:label path="">
						<spring:message text="Purchase Date" />
					</sf:label></td>
				<td><input id="date" data-format="DDMMYYYY"
					data-template="D MM YYYY" name="date" value="01012015" type="text"></td>
			</tr>

			<tr>
				<td><sf:label path="includeInAssetSwatch">
						<spring:message text="Include in assets" />
					</sf:label></td>
				<td><sf:checkbox path="includeInAssetSwatch" value="false" /></td>
			</tr>

			<tr>
				<td colspan="2"><c:if test="${!empty assets.assetName}">
						<input type="submit" value="<spring:message text="Edit"/>" />
					</c:if> <c:if test="${empty assets.assetName}">
						<input type="submit" value="<spring:message text="Add Asset"/>" />
					</c:if></td>
			</tr>
		</table>
	</sf:form>
	<br />
	<h3>Liquid Assets</h3>
	<c:if test="${!empty liquidlistAssets}">
		<table class="tg">
			<tr>
				<th width="80">Asset Class</th>
				<th width="120">Asset Type</th>
				<th width="120">Asset Name</th>
				<th width="60">Remarks</th>
				<th width="60">Currency</th>
				<th width="60">Fx Rate</th>
				<th width="60">Actual Value Of Holding</th>
				<th width="60">Actual Value of holding in USD</th>
				<th width="60">Rounded value</th>
				<th width="60" colspan="2">Action</th>
			</tr>
			<c:forEach items="${liquidlistAssets}" var="liquidassets">
				<tr>
					<td>${liquidassets.assetClass}</td>
					<td>${liquidassets.assetTypeID}</td>
					<td>${liquidassets.assetName}</td>
					<td>${liquidassets.assetRemarks}</td>
					<td>${liquidassets.currencyFrom}</td>
					<td>${liquidassets.currencyRate}</td>
					<td>${liquidassets.valueofHolidingLocalCurrency}</td>
					<td>${liquidassets.valueofHoldingForeign}</td>
					<td>${liquidassets.roundedValueofHolding}</td>

					<c:url value="assets/edit" var="editLiquidURL">
						<c:param name="id" value="${liquidassets.id}"></c:param>
						<c:param name="assetClass" value="${liquidassets.assetClass}"></c:param>
					</c:url>
					<td><a href="${editLiquidURL}">Edit ME</a></td>

					<c:url value="assets/remove" var="removeLiquidURL">
						<c:param name="id" value="${liquidassets.id}"></c:param>
						<c:param name="assetClass" value="${liquidassets.assetClass}"></c:param>
					</c:url>
					<td><a href="${removeLiquidURL}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

	<br>
	<h3>Illiquid Assets</h3>
	<c:if test="${!empty illliquidlistAssets}">
		<table class="tg">
			<tr>
				<th width="80">Asset Class</th>
				<th width="120">Asset Type</th>
				<th width="120">Asset Name</th>
				<th width="60">Remarks</th>
				<th width="60">Currency</th>
				<th width="60">Fx Rate</th>
				<th width="60">Actual Value Of Holding</th>
				<th width="60">Actual Value of holding in USD</th>
				<th width="60">Rounded value</th>
				<th width="60" colspan="2">Action</th>
			</tr>
			<c:forEach items="${illliquidlistAssets}" var="illliquidassets">
				<tr>
					<td>${illliquidassets.assetClass}</td>
					<td>${illliquidassets.assetTypeID}</td>
					<td>${illliquidassets.assetName}</td>
					<td>${illliquidassets.assetRemarks}</td>
					<td>${illliquidassets.currencyFrom}</td>
					<td>${illliquidassets.currencyRate}</td>
					<td>${illliquidassets.valueofHolidingLocalCurrency}</td>
					<td>${illliquidassets.valueofHoldingForeign}</td>
					<td>${illliquidassets.roundedValueofHolding}</td>

					<td><c:url value="assets/edit" var="editURL">
							<c:param name="id" value="${illliquidassets.id}"></c:param>
							<c:param name="assetClass" value="${illliquidassets.assetClass}"></c:param>
						</c:url> <a href="${editURL}">Edit ME</a></td>

					<c:url value="assets/remove" var="removeURL">
						<c:param name="id" value="${illliquidassets.id}"></c:param>
						<c:param name="assetClass" value="${illliquidassets.assetClass}"></c:param>
					</c:url>
					<td><a href="${removeURL}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />

	<br>
	<h3>Property Assets</h3>
	<c:if test="${!empty propertylistAssets}">
		<table class="tg">
			<tr>
				<th width="80">Asset Class</th>
				<th width="120">Asset Type</th>
				<th width="120">Asset Name</th>
				<th width="60">Remarks</th>
				<th width="60">Currency</th>
				<th width="60">Fx Rate</th>
				<th width="60">Actual Value Of Holding</th>
				<th width="60">Actual Value of holding in USD</th>
				<th width="60">Rounded value</th>
				<th width="60" colspan="2">Action</th>
			</tr>
			<c:forEach items="${propertylistAssets}" var="assets">
				<tr>
					<td>${assets.assetClass}</td>
					<td>${assets.assetTypeID}</td>
					<td>${assets.assetName}</td>
					<td>${assets.assetRemarks}</td>
					<td>${assets.currencyFrom}</td>
					<td>${assets.currencyRate}</td>
					<td>${assets.valueofHolidingLocalCurrency}</td>
					<td>${assets.valueofHoldingForeign}</td>
					<td>${assets.roundedValueofHolding}</td>

					<td><c:url value="assets/edit" var="editURL">
							<c:param name="id" value="${assets.id}"></c:param>
							<c:param name="assetClass" value="${assets.assetClass}"></c:param>
						</c:url> <a href="${editURL}">Edit ME</a></td>

					<c:url value="assets/remove" var="removeURL">
						<c:param name="id" value="${assets.id}"></c:param>
						<c:param name="assetClass" value="${assets.assetClass}"></c:param>
					</c:url>
					<td><a href="${removeURL}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<br />

</body>
</html>