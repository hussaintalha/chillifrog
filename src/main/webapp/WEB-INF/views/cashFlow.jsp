<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/combodate.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/moment.js"></script>
<title>Cash flow</title>
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
	var currency = $("#baseCurrency").val();
	$.ajax({

        url : "<%=request.getContextPath()%>/cashFlow/fxrate",
			data : {
				currency : $("#baseCurrency").val()
			},
			dataType : "json",
			headers : {
				Accept : "application/json"
			},
			success : function(data) {
				$("#fxRate").val(data);
				$("#currencyLocal").empty();
				$("#currencyLocal").append("("+currency+")");
			}
		});
	}

function calculateActualAmount(){
	var currencyBase = $("#baseCurrency").val();
	var actualAmountforeign = $("#actualAmountforeign").val();
	var foreignCurrency = $("#foreignCurrency").val();
	var fxRate = $("#fxRate").val();
	var totalBaseAmount = (actualAmountforeign /fxRate);
	$.ajax({

        url : "<%=request.getContextPath()%>/cashFlow/actualAmountforeign",
			data : {
				baseCurrency : currencyBase,
				foreignCurrency : foreignCurrency,
				totalAmount : actualAmountforeign
			},
			dataType : "json",
			headers : {
				Accept : "application/json"
			},
			success : function(data) {
				$("#fxAmountforeign").val(data.toFixed(5));
alert ($("#fxAmountforeign").val());				
				$("#actualAmountBase").val(totalBaseAmount.toFixed(5));

			}
		});
	}
</script>
<body>
	<h1>Add New cash flow</h1>

	<c:url var="addAction" value="/cashFlow/add"></c:url>

	<form:form action="${addAction}" commandName="cashFlow">
		<table>
			<tr>
				<td><form:label path="profileId">Profile Id</form:label>
				<form:input path="profileId" /></td>
			</tr>
			<tr>
				<td><form:label path="cashFlowType">Cash Flow Types</form:label>
					<form:select path="cashFlowType">
						<c:forEach items="${cashflowType}" var="items">
							<form:option value="${items.id}">${items.cashflowTypeName}</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="description">Description</form:label> <form:textarea
						path="description" rows="2" cols="20"></form:textarea></td>
			</tr>
			<tr>
				<td><form:label path="baseCurrency">Base Currency </form:label>
					<form:select path="baseCurrency" onclick="getForexRate();">
						<c:forEach items="${currency}" var="currency">
							<form:option value="${currency.iso_currency}">${currency.iso_currency}</form:option>
						</c:forEach>
					</form:select> FX Rate <input type="text" id="fxRate"></td>

			</tr>

			<tr>
				<td><form:label path="foreignCurrency">Foreign Currency</form:label>
					<form:select path="foreignCurrency">
						<c:forEach items="${currency}" var="currency">
							<form:option value="${currency.iso_currency}">${currency.iso_currency}</form:option>
						</c:forEach>
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="actualAmountforeign">Actual Amount</form:label>
					<form:input type="text" path="actualAmountforeign"
						onchange="calculateActualAmount();" />
					<div id="currencyLocal"></div></td>
			</tr>
			<tr>
				<td><form:hidden path="fxAmountforeign" /></td>
			</tr>
			<tr>
				<td><form:label path="actualAmountBase">Actual Amount(Base Currency)</form:label>
					<form:input type="text" path="actualAmountBase" /></td>
			</tr>

			<tr>
				<td><form:label path="">
						<spring:message text="Transaction Date" />
					</form:label> <input id="date" data-format="DDMMYYYY" data-template="D MM YYYY"
					name="date" value="01012015" type="text"></td>
			</tr>
			<tr>

				<td><button name="save">Save</button>
					<button name="cancel">Cancel</button></td>
			</tr>
		</table>
	</form:form>

	<br>
	<h3>Listing</h3>
	<c:if test="${!empty listCashFlow}">
		<table class="tg">
			<tr>
				<th width="80">No.</th>
				<th width="120">Year</th>
				<th width="120">Types</th>
				<th width="60">Description</th>
				<th width="60">Base Currency</th>
				<th width="60">Foreign Currency</th>
				<th width="60">Actual Amount</th>
				<th width="60">Actual Amount(Base Currency)</th>
				<th colspan="2">Action</th>
			</tr>
			<c:forEach items="${listCashFlow}" var="cashFlow">
				<tr>
					<td>${cashFlow.othercashflowID}</td>
					<td>${cashFlow.transactionYear}</td>
					<td>${cashFlow.cashFlowType}</td>
					<td>${cashFlow.description}</td>
					<td>${cashFlow.baseCurrency}</td>
					<td>${cashFlow.foreignCurrency}</td>
					<td>${cashFlow.actualAmountforeign}</td>
					<td>${cashFlow.actualAmountBase}</td>

					<td><a
						href="<c:url value='/cashFlow/edit/${cashFlow.othercashflowID}' />">Edit</a></td>
					<td><a
						href="<c:url value='/cashFlow/remove/${cashFlow.othercashflowID}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

	</c:if>
</body>
</html>